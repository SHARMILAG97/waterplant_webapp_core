package com.revature.dao;

import java.util.List;

import com.revature.exception.DBException;
import com.revature.model.Reserve;

public interface ReserveInterface {
	
	public void addReserve(Reserve rev, int Reservecans) throws DBException;
	public Reserve getReserveId(Reserve rev) throws DBException;
	public Reserve findByReserveId(int Rid) throws DBException ;
	public void updateReserve(int ordercans, int Rid) throws DBException;
	public List<Reserve> viewReserve() throws DBException ;

}
