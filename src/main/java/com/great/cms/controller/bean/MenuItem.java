
package com.great.cms.controller.bean;

import java.io.Serializable;

/**
 * 
 * @author ahsan
 * 
 */
public class MenuItem implements Serializable {

	private static final long serialVersionUID = 2083447098222803247L;
	
	private String id;
	
	private String label;
	
	private String url;
	
	private String modulecode;

	public MenuItem() {
		super();
	}

	public MenuItem(String id, String label, String url) {
		super();
		this.id = id;
		this.label = label;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getModulecode() {
		return modulecode;
	}

	public void setModulecode(String modulecode) {
		this.modulecode = modulecode;
	}

}
