package com.heroku.ventaOnLine.heroku.ventaOnLine;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CouponXml {

	@XmlElement
	private Integer id;
	@XmlElement
	private String number;
	@XmlElement
	private Boolean used;
	
	public CouponXml() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}

	public CouponXml(Integer id, String number, Boolean used) {
		super();
		this.id = id;
		this.number = number;
		this.used = used;
	}
	
}
