package waterplant_webapp_core.model;

import java.time.LocalDate;

public class Stock {
	
	private LocalDate Date;
	private int Stockid;
	private int SUpdatedcans;
	private int SOrderedcans;
	private int SReservedcans;
	private int SAvailablecans;
	
	public int getSAvailablecans() {
		return SAvailablecans;
	}
	public void setSAvailablecans(int sAvailablecans) {
		this.SAvailablecans = sAvailablecans;
	}
	public LocalDate getDate() {
		return Date;
	}
	public void setDate(LocalDate date) {
		this.Date = date;
	}
	public int getStockid() {
		return Stockid;
	}
	public void setStockid(int stockid) {
		this.Stockid = stockid;
	}
	public int getSUpdatedcans() {
		return SUpdatedcans;
	}
	public void setSUpdatedcans(int sUpdatedcans) {
		this.SUpdatedcans = sUpdatedcans;
	}
	public int getSOrderedcans() {
		return SOrderedcans;
	}
	public void setSOrderedcans(int sOrderedcans) {
		this.SOrderedcans = sOrderedcans;
	}
	public int getSReservedcans() {
		return SReservedcans;
	}
	public void setSReservedcans(int sReservedcans) {
		this.SReservedcans = sReservedcans;
	}
	
	

}
