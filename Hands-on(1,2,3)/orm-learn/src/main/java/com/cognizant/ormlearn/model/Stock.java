package com.cognizant.ormlearn.model;





import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {

	@Id
	@Column(name="st_id")
	Integer id;
	
	@Column(name="st_code")
	String code;
	
	@Column(name="st_date")
	Date date;
	
	@Column(name="st_open", columnDefinition="decimal", precision=2)
	Double open;
	
	@Column(name="st_close",columnDefinition="decimal", precision=2)
	Double close;
	
	@Column(name="st_volume",columnDefinition="decimal", precision=0)
	Double volume;
	
	
	
	public Stock() {
		super();
	}

	

	public Stock(Integer id, String code, Date date, Double open, Double close, Double volume) {
		super();
		this.id = id;
		this.code = code;
		this.date = date;
		this.open = open;
		this.close = close;
		this.volume = volume;
	}


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Double getOpen() {
		return open;
	}



	public void setOpen(Double open) {
		this.open = open;
	}



	public Double getClose() {
		return close;
	}



	public void setClose(Double close) {
		this.close = close;
	}



	public Double getVolume() {
		return volume;
	}



	public void setVolume(Double volume) {
		this.volume = volume;
	}

	


	
	
	
}
