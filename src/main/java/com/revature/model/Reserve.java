package com.revature.model;

import java.time.LocalDate;

public class Reserve {
	
	private LocalDate Date ;
	private int RId;
	private int RUId;
	private String RUName;
	private String RUAddress;
	private int Reservecans;
	private String Rstatus;
	private Long RUMobileno;
	private int ROrdercans;
	
	
	public int getROrdercans() {
		return ROrdercans;
	}
	public void setROrdercans(int rOrdercans) {
		this.ROrdercans = rOrdercans;
	}
	public Long getRUMobileno() {
		return RUMobileno;
	}
	public void setRUMobileno(Long rUMobileno) {
		this.RUMobileno = rUMobileno;
	}
	public LocalDate getDate() {
		return Date;
	}
	public void setDate(LocalDate date) {
		this.Date = date;
	}
	public int getRId() {
		return RId;
	}
	public void setRId(int rId) {
		this.RId = rId;
	}
	public int getRUId() {
		return RUId;
	}
	public void setRUId(int rUId) {
		this.RUId = rUId;
	}
	public String getRUName() {
		return RUName;
	}
	public void setRUName(String rUName) {
		this.RUName = rUName;
	}
	public String getRUAddress() {
		return RUAddress;
	}
	public void setRUAddress(String rUAddress) {
		this.RUAddress = rUAddress;
	}
	public int getReservecans() {
		return Reservecans;
	}
	public void setReservecans(int reservecans) {
		this.Reservecans = reservecans;
	}
	public String getRstatus() {
		return Rstatus;
	}
	public void setRstatus(String rstatus) {
		this.Rstatus = rstatus;
	}
	

}
