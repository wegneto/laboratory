/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.completeswingapp.dao;

import br.com.devmedia.completeswingapp.entity.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Neto
 */
public class CustomerDAO extends GenericDAO {

    public CustomerDAO() {
    }

    public int addCustomer(Customer ctm) throws SQLException {
        ctm.setId(getNextId("CUSTOMERS"));
        String query = "INSERT INTO APP.CUSTOMERS (ID,NAME,AGE,ADDRESS,TELEPHONE) VALUES (?,?,?,?,?)";
        executeCommand(query, ctm.getId(), ctm.getName(), ctm.getAge(), ctm.getAddress(), ctm.getTelephone());
        return ctm.getId();
    }

    public void removeCustomer(int idCustomer) throws SQLException {
        executeCommand("DELETE FROM APP.CUSTOMERS WHERE ID = ?", idCustomer);
    }

    public void updateCustomer(Customer ctm) throws SQLException {
        String query = "UPDATE APP.CUSTOMERS SET NAME = ?, AGE = ?, ADDRESS = ?, TELEPHONE = ? WHERE ID = ?";
        executeCommand(query, ctm.getName(), ctm.getAge(), ctm.getAddress(), ctm.getTelephone(), ctm.getId());
    }

    public Customer getCustomer(int idCustomer) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM APP.CUSTOMERS WHERE ID = ?", idCustomer);
        Customer ctm = null;
        if (rs.next()) {
            ctm = populateCustomer(rs);
        }
        rs.close();
        return ctm;
    }

    public static Customer populateCustomer(ResultSet rs) throws SQLException {
        Customer ctm = new Customer();
        ctm.setId(rs.getInt("ID"));
        ctm.setName(rs.getString("NAME"));
        ctm.setAge(rs.getInt("AGE"));
        ctm.setAddress(rs.getString("ADDRESS"));
        ctm.setTelephone(rs.getString("TELEPHONE"));
        return ctm;
    }

    public List<Customer> getCustomersByName(String name) throws SQLException {
        List<Customer> toReturn = new LinkedList<Customer>();
        ResultSet rs = executeQuery("SELECT * FROM APP.CUSTOMERS WHERE NAME LIKE ?", "%" + name + "%");
        while (rs.next()) {
            toReturn.add(populateCustomer(rs));
        }
        rs.close();
        return toReturn;
    }

    public List<Customer> getAllCustomers() throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM APP.CUSTOMERS");
        List<Customer> customers = new LinkedList<Customer>();
        while (rs.next()) {
            customers.add(populateCustomer(rs));
        }
        rs.close();
        return customers;
    }
}
