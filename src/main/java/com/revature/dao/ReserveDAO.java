package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.exception.DBException;
import com.revature.model.Reserve;
import com.revature.util.ConnectionUtil;

public class ReserveDAO implements ReserveInterface {

	public void addReserve(Reserve rev, int Reservecans) throws DBException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into Reserve_Details(User_id,User_name,Mobile_no,Reserve_cans ) values ( ?,?,?,?)";

		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, rev.getRUId());
			pst.setString(2, rev.getRUName());
			pst.setLong(3, rev.getRUMobileno());
			pst.setInt(4, Reservecans);

			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to Reserve", e);
		}

	}

	public Reserve getReserveId(Reserve rev) throws DBException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from Reserve_Details";

		PreparedStatement pst = null;
		Reserve r = new Reserve();
		try {
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				r.setRId(rs.getInt("Reserve_id"));
				r.setRUId(rs.getInt("User_id"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Reserve", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

		return r;

	}

	public Reserve findByReserveId(int Rid) throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from Reserve_Details where Reserve_id = ? ";
		PreparedStatement pst = null;
		Reserve rev = new Reserve();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, Rid);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				rev.setRId(rs.getInt("Reserve_id"));
				rev.setRUId(rs.getInt("User_id"));
				rev.setRUName(rs.getString("User_name"));
				rev.setRUMobileno(rs.getLong("Mobile_no"));
				rev.setReservecans(rs.getInt("Reserve_cans"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Reserve", e);
		} finally {

			ConnectionUtil.close(con, pst);
		}

		return rev;
	}

	public void updateReserve(int ordercans, int Rid) throws DBException {

		Connection con = ConnectionUtil.getConnection();

		String sql = "update Reserve_Details set Status ='Ordered',Ordered_cans=? where Reserve_id = ? ";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, ordercans);
			pst.setInt(2, Rid);

			pst.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to Reserve", e);
		}

		finally {

			ConnectionUtil.close(con, pst);
		}

	}

	public List<Reserve> viewReserve() throws DBException {

		Connection con = ConnectionUtil.getConnection();
		String sql = "select * from Reserve_Details";
		PreparedStatement pst;
		ResultSet rs;
		List<Reserve> list = new ArrayList<Reserve>();
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Reserve user = new Reserve();
				user.setRId(rs.getInt("Reserve_id"));
				user.setRUId(rs.getInt("User_id"));
				user.setRUName(rs.getString("User_name"));
				user.setRUMobileno(rs.getLong("Mobile_no"));
				user.setRstatus(rs.getString("Status"));
				user.setReservecans(rs.getInt("Reserve_cans"));
				user.setROrdercans(rs.getInt("Ordered_cans"));
				Date date = rs.getDate("Date_time");
				user.setDate(date.toLocalDate());
				list.add(user);
			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to find", e);
		}

		return list;

	}
}

