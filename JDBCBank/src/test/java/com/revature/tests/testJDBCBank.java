package com.revature.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.TransactionDao;
import com.revature.dao.TransactionDaoImpl;


public class testJDBCBank {

    public static final CustomerDao customerTest = new CustomerDaoImpl();
    public static final BankAccountDao bankAccountTest = new BankAccountDaoImpl();
    public static final TransactionDao transactionTest = new TransactionDaoImpl();

    @Test
    public void testInsertCustomer() {
        assertTrue(customerTest.insertCustomer("testUser", "testPassword"));
        customerTest.deleteCustomer(customerTest.getCustomerId("testUser", "testPassword"));
    }

    @Test
    public void testCheckCustomerPassword() {
        assertTrue(customerTest.checkCustomerPassword("getIdTestUser", "getIdTestPassword"));
    }


    @Test
    public void testGetCustomers() {
        assertNotNull(customerTest.getCustomers());
    }

    @Test
    public void testUpdateCustomerPassword() {
        assertTrue(customerTest.updateCustomerPassword(
                customerTest.getCustomerId("checkAdminTestUser", "checkAdminTestPassword"), "checkAdminTestPassword"));
    }

    @Test
    public void testDeleteCustomer() {
        assertTrue(customerTest.deleteCustomer(customerTest.getCustomerId("deleteTestUser", "deleteTestPassword")));
        customerTest.insertCustomer("deleteTestUser", "deleteTestPassword");
    }

    @Test
    public void testCheckAdmin() {
        assertFalse(
                customerTest.checkAdmin(customerTest.getCustomerId("checkAdminTestUser", "checkAdminTestPassword")));
    }

    @Test
    public void testGetCustomerId() {
        int idCheck = 41;
        assertTrue(idCheck == customerTest.getCustomerId("getIdTestUser", "getIdTestPassword"));

    }

    @Test
    public void testInsertBankAccount() {
        assertTrue(bankAccountTest.insertBankAccount("TestInsertAccount", 1));
        bankAccountTest.deleteBankAccount(bankAccountTest.getBankAccountOwner(1));
    }

    @Test
    public void testUpdateBankAccount() {
        assertTrue(bankAccountTest.updateBankAccount(61, 300));
    }

    @Test
    public void testGetBankAccounts() {
        assertNotNull(bankAccountTest.getBankAccounts());
    }

    @Test
    public void testGetBankAccountsByUserAccount() {
        assertNotNull(bankAccountTest.getBankAccountsByUserAccount(37));
    }

    @Test
    public void testGetBankAccountBalance() {
        assertNotNull(bankAccountTest.getBankAccountBalance(37));
    }


    @Test
    public void testGetBankAccountOwner() {
        int userId = 37;
        assertNotNull(bankAccountTest.getBankAccountOwner(54));
    }

    @Test
    public void testUpdateTransactionDifference() {
        assertTrue(transactionTest.updateTransactionDifference(4, 300));
    }

    @Test
    public void testGetTransactionById() {
        assertNotNull(transactionTest.getTransactionById(4));
    }

    @Test
    public void testGetTransactionDifference() {
        assertNotNull(transactionTest.getTransactionDifference(4));
    }

    @Test
    public void testGetAllTransactionsByAccount() {
        assertNotNull(transactionTest.getAllTransactionsByAccount(4));
    }

}