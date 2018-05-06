package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.BankAccount;
import com.revature.domain.Transaction;
import com.revature.util.ConnectionUtil;

public class BankAccountDaoImpl implements BankAccountDao {
	private String filename = "connection.properties";

	public boolean insertBankAccount(String type, int accountId) {

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// using a Statement - beware SQL injection
			String sql = "INSERT INTO BANKACCOUNT (BALANCE, ACCOUNT_TYPE, CUSTOMER_ID) VALUES (?, ?,?)";

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setFloat(1, 0);
			statement.setString(2, type);
			statement.setInt(3, accountId);
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

	public boolean deleteBankAccount(int bankAccountId) {
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// using a Statement - beware SQL injection
			String sql1 = "SELECT BALANCE FROM BANKACCOUNT WHERE BANKACCOUNT_NUM = ?";
			PreparedStatement statement = con.prepareStatement(sql1);
			statement.setInt(1, bankAccountId);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				float balance = resultSet.getFloat("BALANCE");
				if (balance == 0) {

					String sql2 = "DELETE FROM BANKACCOUNT WHERE BANKACCOUNT_NUM = ?";

					statement = con.prepareStatement(sql2);
					statement.setInt(1, bankAccountId);
					statement.executeQuery();
					System.out.println("Bank Account sucessfully deleted");
					return true;

				} else if (balance != 0) {
					System.out.println("Balance not negative! Balance: " + balance);
					return false;
				}
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean SuperUserDeleteBankAccount(int bankAccountId) {
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "DELETE FROM BANKACCOUNT WHERE BANKACCOUNT_NUM = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement = con.prepareStatement(sql);
			statement.setInt(1, bankAccountId);
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

	/*public boolean updateBankAccount(int bankAccountId, float difference) {
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT * FROM BANKACCOUNT WHERE BANKACCOUNT_NUM = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bankAccountId);
			ResultSet resultSet = pstmt.executeQuery();

			// do something with result
			if (resultSet.next()) {
				int balance = resultSet.getInt("BALANCE");
				String sql2 = "UPDATE BANKACCOUNT SET BALANCE = ? WHERE BANKACCOUNT_NUM = ?";
				pstmt = con.prepareStatement(sql2);
				pstmt.setFloat(1, (balance + difference));
				pstmt.setInt(2, bankAccountId);
				pstmt.executeQuery();
				System.out.println("New Balance: " + (balance + difference));
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
	*/
	public boolean updateBankAccount(int bankAccountId, float difference) {
        
		CallableStatement cs = null;
        
        try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
            String sql = "{call PROC_CHANGE_BALANCE(?, ?)}";
            cs = con.prepareCall(sql);
            cs.setInt(1, bankAccountId);
            cs.setFloat(2, difference);
            cs.execute();
            con.close();
            TransactionDao t = new TransactionDaoImpl();
            t.insertTransaction(bankAccountId,  difference);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

	public List<BankAccount> getBankAccounts() {
		List<BankAccount> bankAccountList = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "SELECT * FROM BANKACCOUNT";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			// move through result set
			while (resultSet.next()) {
				int id = resultSet.getInt("BANKACCOUNT_NUM");
				int balance = resultSet.getInt("BALANCE");
				String accountType = resultSet.getString("ACCOUNT_TYPE");
				bankAccountList.add(new BankAccount(id, balance, accountType));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bankAccountList;
	}
/*
	public List<BankAccount> getBankAccountsByUserAccount(int accountId) {
		List<BankAccount> bankAccountList = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "SELECT * FROM BANKACCOUNT";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			// move through result set
			while (resultSet.next()) {
				int id = resultSet.getInt("BANKACCOUNT_NUM");
				int balance = resultSet.getInt("BALANCE");
				String accountType = resultSet.getString("ACCOUNT_TYPE");
				bankAccountList.add(new BankAccount(id, balance, accountType));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bankAccountList;
	}

*/
	public BankAccount getBankAccountById(int accountId) {

		BankAccount c = null;

		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT * FROM BANKACCOUNT WHERE BANKACCOUNT_NUM = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountId);
			ResultSet resultSet = pstmt.executeQuery();

			// do something with result
			if (resultSet.next()) {
				int id = resultSet.getInt("BANKACCOUNT_NUM");
				int balance = resultSet.getInt("BALANCE");
				String accountType = resultSet.getString("ACCOUNT_TYPE");
				c = new BankAccount(id, balance, accountType);
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return c;
	}

	public float getBankAccountBalance(int bankAccountId) {

		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT * FROM BANKACCOUNT WHERE BANKACCOUNT_NUM = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bankAccountId);
			ResultSet resultSet = pstmt.executeQuery();

			// do something with result
			if (resultSet.next()) {
				int balance = resultSet.getInt("BALANCE");
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
	public List<BankAccount> getBankAccountsByUserAccount(int customerId) {
		
		PreparedStatement pstmt = null;
		
		List<BankAccount> al = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "SELECT * FROM BANKACCOUNT WHERE CUSTOMER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			
			// move through result set
			while (rs.next()) {
				int accountId = rs.getInt("BANKACCOUNT_NUM");
				float balance = rs.getFloat("BALANCE");
				String type  = rs.getString("ACCOUNT_TYPE");
				int custId = rs.getInt("CUSTOMER_ID");
				al.add(new BankAccount(accountId, balance, type, custId));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return al;
	}

	@Override
	public int getBankAccountOwner(int accountId) {
		
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT CUSTOMER_ID FROM BANKACCOUNT WHERE BANKACCOUNT_NUM = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountId);
			ResultSet resultSet = pstmt.executeQuery();

			// do something with result
			if (resultSet.next()) {
				int custId = resultSet.getInt("CUSTOMER_ID");
				return custId;
			}

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}
}
