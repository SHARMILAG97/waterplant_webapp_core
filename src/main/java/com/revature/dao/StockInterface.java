package com.revature.dao;

import java.util.List;

import com.revature.exception.DBException;
import com.revature.model.Stock;

public interface StockInterface {

	public int findOne() throws DBException;
	public Stock getStock() throws DBException;
	public void updateStock(int updatecans, int newcans) throws DBException ;
	public List<Stock> viewStock() throws DBException ;
	public void addStock(int newcans, int updatecans) throws DBException;
	public void addStockOrder(int ordercans, int updatecans) throws DBException;
	public void addStockReserve(int reservecans, int updatecans) throws DBException;
	public void updateStockOrder(int availcans, int ordercan) throws DBException;
	public void updateStockReserve(int availcans, int reservecan) throws DBException;
	public void updateOrderReserve(int updatecan, int stockordercan, int stockreservecan) throws DBException;
	
}
