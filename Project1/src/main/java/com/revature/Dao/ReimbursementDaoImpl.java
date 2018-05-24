package com.revature.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.revature.Util.ConnectionUtil;
import com.revature.base.Employee;
import com.revature.base.Reimbursement;

public class ReimbursementDaoImpl implements ReimbursementDao {

	private String filename = "connection.properties";
	
	public static ReimbursementDao reim = new ReimbursementDaoImpl();

	@Override
	public List<Reimbursement> getAllReimbursements() throws IOException, SQLException {

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			List<Reimbursement> rl = new LinkedList<Reimbursement>();
			String sql = "SELECT * FROM REIM";

			int reim_id;
			String req;
			String img;
			String status;
			int man_id;
			int emp_id;
			double amt;

			Reimbursement r;

			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				reim_id = resultSet.getInt("REIM_ID");
				req = resultSet.getString("REIM_REQ");
				img = resultSet.getString("REIM_String");
				status = resultSet.getString("REIM_STATUS");
				man_id = resultSet.getInt("REIM_MAN");
				emp_id = resultSet.getInt("REIM_EMP");
				amt = resultSet.getDouble("REIM_AMT");

				r = new Reimbursement(reim_id, req, img, status, man_id, emp_id, amt);

				rl.add(r);
			}

			con.close();

			return rl;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Reimbursement getReimbursement(int id) throws IOException, SQLException {
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			Reimbursement r;

			String sql = "SELECT * FROM REIM WHERE REIM_ID = ?";

			int reim_id;
			String req;
			String img;
			String status;
			int man_id;
			int emp_id;
			double amt;

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {

				reim_id = resultSet.getInt("REIM_ID");
				req = resultSet.getString("REIM_REQ");
				img = resultSet.getString("REIM_IMG");
				status = resultSet.getString("REIM_STATUS");
				man_id = resultSet.getInt("REIM_MAN");
				emp_id = resultSet.getInt("REIM_EMP");
				amt = resultSet.getDouble("REIM_AMT");

				r = new Reimbursement(reim_id, req, img, status, man_id, emp_id, amt);

				return r;
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean insertReimbursement(String req, String img, int emp_id, double amt) {

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "INSERT INTO REIM (REIM_REQ, REIM_EMP, REIM_AMT, REIM_IMG) VALUES (?,?,?,?)";

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, req);
			statement.setInt(2, emp_id);
			statement.setDouble(3, amt);
			statement.setString(4, img);
			statement.executeQuery();
			con.close();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean approveReimbursement(Reimbursement r, int man_id) throws IOException, SQLException {

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "UPDATE REIM SET REIM_STATUS = 'APPROVED', REIM_MAN = ? WHERE REIM_ID = ?";

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setInt(1, man_id);
			statement.setInt(2, reim.getReimbursementId(r));
			statement.executeQuery();
			con.close();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean denyReimbursement(Reimbursement r, int man_id) throws IOException, SQLException {

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "UPDATE REIM SET REIM_STATUS = 'DENIED', REIM_MAN = ? WHERE REIM_ID = ?";

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setInt(1,  man_id);
			statement.setInt(2, reim.getReimbursementId(r));
			statement.executeQuery();
			con.close();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Reimbursement> getReimForEmp(Employee emp) {

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			List<Reimbursement> rl = new LinkedList<Reimbursement>();
			String sql = "SELECT * FROM REIM WHERE REIM_EMP = ?";

			int reim_id;
			String req;
			String b;
			String status;
			int man_id;
			int emp_id;
			double amt;

			Reimbursement r;

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, emp.getEmp_id());
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				reim_id = resultSet.getInt("REIM_ID");
				req = resultSet.getString("REIM_REQ");
				b = resultSet.getString("REIM_IMG");
				status = resultSet.getString("REIM_STATUS");
				man_id = resultSet.getInt("REIM_MAN");
				emp_id = resultSet.getInt("REIM_EMP");
				amt = resultSet.getDouble("REIM_AMT");

				r = new Reimbursement(reim_id, req, b, status, man_id, emp_id, amt);

				rl.add(r);
			}

			con.close();
			
			return rl;

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getReimbursementId(Reimbursement r) throws IOException, SQLException {

		return r.getReim_id();
	}

	@Override
	public String getReimbursementStatus(Reimbursement r) throws IOException, SQLException {

		return r.getStatus();
	}

	@Override
	public List<Reimbursement> getDeniedReimbursements() throws IOException, SQLException {

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			List<Reimbursement> rl = new LinkedList<Reimbursement>();
			String sql = "SELECT * FROM REIM WHERE REIM_STATUS = 'DENIED'";

			int reim_id;
			String req;
			String img;
			String status;
			int man_id;
			int emp_id;
			double amt;

			Reimbursement r;

			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				reim_id = resultSet.getInt("REIM_ID");
				req = resultSet.getString("REIM_REQ");
				img = resultSet.getString("REIM_IMG");
				status = resultSet.getString("REIM_STATUS");
				man_id = resultSet.getInt("REIM_MAN");
				emp_id = resultSet.getInt("REIM_EMP");
				amt = resultSet.getDouble("REIM_AMT");

				r = new Reimbursement(reim_id, req, img, status, man_id, emp_id, amt);

				rl.add(r);
			}

			con.close();

			return rl;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Reimbursement> getApprovedReimbursements() throws IOException, SQLException {

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			List<Reimbursement> rl = new LinkedList<Reimbursement>();
			String sql = "SELECT * FROM REIM WHERE REIM_STATUS = 'APPROVED'";

			int reim_id;
			String req;
			String b;
			String status;
			int man_id;
			int emp_id;
			double amt;

			Reimbursement r;

			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				reim_id = resultSet.getInt("REIM_ID");
				req = resultSet.getString("REIM_REQ");
				b = resultSet.getString("REIM_IMG");
				status = resultSet.getString("REIM_STATUS");
				man_id = resultSet.getInt("REIM_MAN");
				emp_id = resultSet.getInt("REIM_EMP");
				amt = resultSet.getDouble("REIM_AMT");

				r = new Reimbursement(reim_id, req, b, status, man_id, emp_id, amt);

				rl.add(r);
			}

			con.close();

			return rl;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Reimbursement> getPendingReimbursements() throws IOException, SQLException {

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			List<Reimbursement> rl = new LinkedList<Reimbursement>();
			String sql = "SELECT * FROM REIM WHERE REIM_STATUS = 'PENDING'";

			int reim_id;
			String req;
			String b;
			String status;
			int man_id;
			int emp_id;
			double amt;

			Reimbursement r;

			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				reim_id = resultSet.getInt("REIM_ID");
				req = resultSet.getString("REIM_REQ");
				b = resultSet.getString("REIM_IMG");
				status = resultSet.getString("REIM_STATUS");
				man_id = resultSet.getInt("REIM_MAN");
				emp_id = resultSet.getInt("REIM_EMP");
				amt = resultSet.getDouble("REIM_AMT");

				r = new Reimbursement(reim_id, req, b, status, man_id, emp_id, amt);

				rl.add(r);
			}

			con.close();

			return rl;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
