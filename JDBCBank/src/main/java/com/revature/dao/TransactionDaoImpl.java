package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.BankAccount;
import com.revature.domain.Transaction;
import com.revature.util.ConnectionUtil;

public class TransactionDaoImpl implements TransactionDao {

	private String filename = "connection.properties";

	public boolean insertTransaction(int bankAccountId, float difference) {
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// using a Statement - beware SQL injection
			String sql = "INSERT INTO XACT (DIFFERENCE, BANKACCOUNT_NUM) VALUES (?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setFloat(1, difference);
			statement.setInt(2, bankAccountId);
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

	public boolean deleteTransaction(int transactionId) {
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "DELETE FROM XACT WHERE XACT_ID = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement = con.prepareStatement(sql);
			statement.setInt(1, transactionId);
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

	public boolean updateTransactionDifference(int transactionId, float newDifference) {
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT * FROM XACT WHERE XACT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, transactionId);
			ResultSet resultSet = pstmt.executeQuery();

			// do something with result
			if (resultSet.next()) {
				String sql2 = "UPDATE XACT SET DIFFERENCE = ? WHERE XACT_ID = ?";
				pstmt = con.prepareStatement(sql2);
				pstmt.setFloat(1, newDifference);
				pstmt.setInt(2, transactionId);
				pstmt.executeQuery();
				return true;

			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public Transaction getTransactionById(int transactionId) {
		Transaction c = null;

		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT * FROM XACT WHERE XACT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, transactionId);
			ResultSet resultSet = pstmt.executeQuery();

			// do something with result
			if (resultSet.next()) {
				int id = resultSet.getInt("XACT_ID");
				float difference = resultSet.getFloat("DIFFERENCE");
				c = new Transaction(id, difference);
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return c;
	}

	public float getTransactionDifference(int transactionId) {
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT DIFFERENCE FROM XACT WHERE XACT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, transactionId);
			ResultSet resultSet = pstmt.executeQuery();

			// do something with result
			if (resultSet.next()) {
				int balance = resultSet.getInt("DIFFERENCE");
				return balance;
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public List<Transaction> getAllTransactionsByAccount(int bankaccountId) {
		
		List<Transaction> transList = new ArrayList<>();
		
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "SELECT * FROM XACT WHERE BANKACCOUNT_NUM = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bankaccountId);
			ResultSet resultSet = pstmt.executeQuery();

			// do something with result
			while (resultSet.next()) {
				int xactId = resultSet.getInt("XACT_ID");
				float difference = resultSet.getFloat("DIFFERENCE");
				int accountNum = resultSet.getInt("BANKACCOUNT_NUM");
				transList.add(new Transaction(xactId, difference, accountNum));
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return transList;
	}
}
