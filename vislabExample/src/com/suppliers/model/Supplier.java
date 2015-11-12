package com.suppliers.model;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class Supplier {

	private String sno;
	private String sname;
	private String city;
	private int status;
	
	public Supplier() {}
	public Supplier(String sno, String sname, String city, int status) {
		this.sno = sno;
		this.sname = sname;
		this.city = city;
		this.status = status;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
