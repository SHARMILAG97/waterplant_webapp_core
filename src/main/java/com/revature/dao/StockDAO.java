package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.exception.DBException;
import com.revature.model.Stock;
import com.revature.util.ConnectionUtil;

public class StockDAO implements StockInterface {
	

	public int findOne() throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from Stock_Details";
		PreparedStatement pst;
		int Availcans = 0;
		ResultSet rs;
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Availcans = rs.getInt("Available_cans");
			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to find", e);
		}
		return Availcans;
	}

	public Stock getStock() throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from Stock_Details ";
		PreparedStatement pst;
		Stock stock = new Stock();
		try {
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				stock.setSUpdatedcans(rs.getInt("Updated_cans"));
				stock.setSOrderedcans(rs.getInt("Ordered_cans"));
				stock.setSReservedcans(rs.getInt("Reserved_cans"));
				Date date = rs.getDate("Date_time");
				stock.setDate(date.toLocalDate());

			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Error", e);
		}
		return stock;

	}

	public void updateStock(int updatecans, int newcans) throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "update Stock_Details set Available_cans=?,Updated_cans=?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, updatecans);
			pst.setInt(2, newcans);
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Update", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

	}

	public List<Stock> viewStock() throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from Stock_Details";
		PreparedStatement pst;
		ResultSet rs;
		List<Stock> list = new ArrayList<Stock>();
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Stock stock = new Stock();
				stock.setSAvailablecans(rs.getInt("Available_cans"));
				stock.setSUpdatedcans(rs.getInt("Updated_cans"));
				stock.setSOrderedcans(rs.getInt("Ordered_cans"));
				stock.setSReservedcans(rs.getInt("Reserved_cans"));
				Date date = rs.getDate("Date_time");
				stock.setDate(date.toLocalDate());
				list.add(stock);
			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to find", e);
		}

		return list;
	}

	public void addStock(int newcans, int updatecans) throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into Stock_Details (Updated_cans,Available_cans) values (?,?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, newcans);
			pst.setInt(2, updatecans);
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Update", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

	}

	public void addStockOrder(int ordercans, int updatecans) throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into Stock_Details (Ordered_cans,Available_cans) values (?,?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, ordercans);
			pst.setInt(2, updatecans);
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Update", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

	}

	public void addStockReserve(int reservecans, int updatecans) throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into Stock_Details (Reserved_cans,Available_cans) values (?,?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, reservecans);
			pst.setInt(2, updatecans);
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Update", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

	}

	public void updateStockOrder(int availcans, int ordercan) throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "update Stock_Details set Available_cans=?,Ordered_cans=?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, availcans);
			pst.setInt(2, ordercan);
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Update", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

	}

	public void updateStockReserve(int availcans, int reservecan) throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "update Stock_Details set Available_cans=?,Reserved_cans=?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, availcans);
			pst.setInt(2, reservecan);
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Update", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

	}

	public void updateOrderReserve(int updatecan, int stockordercan, int stockreservecan) throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "update Stock_Details set Available_cans=?,Ordered_cans=?,Reserved_cans=?";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, updatecan);
			pst.setInt(2, stockordercan);
			pst.setInt(3, stockreservecan);
			pst.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Update", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

		
	}

}
