
package com.great.cms.controller.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author ahsan
 * 
 */
public class MenuGroup implements Serializable {

	private static final long serialVersionUID = -3255107061409915055L;
	
	private String id;
	
	private String label;
	
	private String modulecode;
	
	private List<MenuItem> menuItems;

	public MenuGroup() {
		super();
	}

	public MenuGroup(String id, String label, String moduleCode, List<MenuItem> menuItems) {
		super();
		this.id = id;
		this.label = label;
		this.modulecode = moduleCode;
		this.menuItems = menuItems;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getModulecode() {
		return modulecode;
	}

	public void setModulecode(String modulecode) {
		this.modulecode = modulecode;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

}
