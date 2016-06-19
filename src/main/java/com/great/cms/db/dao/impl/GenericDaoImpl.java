package com.great.cms.db.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.great.cms.db.dao.GenericDao;
import com.great.cms.db.entity.DomainObject;

/**
 * @author sknabil
 * @version 1.0.0
 *
 */
public class GenericDaoImpl<T extends DomainObject, ID extends Serializable> implements GenericDao<T, ID> {

	SessionFactory sessionFactory;

    protected Class<T> type;
    
    @PersistenceContext(type=PersistenceContextType.EXTENDED)
    protected EntityManager em;

    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    /**
     * Find all objects
     */
    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<T> findAll() throws RuntimeException {
        List<T> list = null;
        
        try{
        	list = em.createQuery("select o from " + type.getName() + " o").getResultList();
        }
        catch(Exception e){
        	
        }
    	return list;
    }

    /**
     * Find object by id
     * @return Object
     */
    @Override
    @Transactional(readOnly = true)
    public T findById(ID id) throws RuntimeException {
    	T ret = null;
    	

    	try{
        

    		ret = findByIdNativeType(id);
    	}
    	catch(Exception e){  
        	System.out.println("ID NOT FOUND-----3");

    	}
    	
        return ret;
    }

    /**
     * Save object
     */
    @Override
    @Transactional(readOnly = false)
    public void save(T object) throws RuntimeException {
       em.persist(object);
        
    }

    /**
     * Update object
     */
    @Override
    @Transactional(readOnly = false)
    public void update(T object)throws RuntimeException {
    	em.merge(object);
        /*try{
        	
        }
        catch(Exception e){
			e.printStackTrace();
        }*/
    }

    @Override
    @Transactional
    public void updateNative(String sql) {
        Query query = em.createNativeQuery(sql);
    	query.executeUpdate();
    }

    /**
     * Delete object
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(T object) throws RuntimeException {
    	em.remove(em.contains(object) ? object : em.merge(object));

    	//em.remove(object);
    }
    
    /**
     * Delete object by id(Long)
     */
    @Override
    @Transactional(readOnly = false)
    public void deleteById(ID id) throws RuntimeException {
    	T object =  findByIdNativeType(id);
		em.remove(object);
    }
    
    /**
     * Find object by id
     * @return Object
     */
    @Transactional(readOnly = true)
    protected T findByIdNativeType(Object id) throws RuntimeException {
        if (id == null) {
        	System.out.println("ID NOT FOUND");
            return null;
        } else {
            return em.find(type, id);
        }
    }
    
}
