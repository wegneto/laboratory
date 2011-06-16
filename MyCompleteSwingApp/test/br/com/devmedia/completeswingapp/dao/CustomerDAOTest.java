/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.devmedia.completeswingapp.dao;

import br.com.devmedia.completeswingapp.entity.Customer;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Neto
 */
public class CustomerDAOTest {

    private static Integer customerId = 0;

    public CustomerDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetCustomer() throws Exception {
        System.out.println("getCustomer");
        CustomerDAO instance = new CustomerDAO();
        Customer result = instance.getCustomer(customerId);
        assertNull(result);
    }

    @Test
    public void testAddCustomer() throws Exception {
        System.out.println("addCustomer");
        Customer ctm = new Customer();
        ctm.setName("Test customer");
        ctm.setAddress("Rua x");
        ctm.setAge(30);
        ctm.setTelephone("555-5555");
        CustomerDAO instance = new CustomerDAO();
        customerId = instance.addCustomer(ctm);
        assertTrue(customerId > 0);
    }

    @Test
    public void testUpdateCustomer() throws Exception {
        System.out.println("updateCustomer");
        CustomerDAO instance = new CustomerDAO();
        Customer ctm = instance.getCustomer(customerId);
        ctm.setName("Test customer updated");
        instance.updateCustomer(ctm);
        ctm = instance.getCustomer(customerId);
        assertEquals(ctm.getName(), "Test customer updated");
    }

    @Test
    public void testGetCustomersByName() throws Exception {
        System.out.println("getCustomersByName");
        String name = "customer";
        CustomerDAO instance = new CustomerDAO();
        List result = instance.getCustomersByName(name);
        assertTrue(result.size() > 0);
    }

    @Test
    public void testRemoveCustomer() throws Exception {
        System.out.println("removeCustomer");
        CustomerDAO instance = new CustomerDAO();
        instance.removeCustomer(customerId);
        Customer ctm = instance.getCustomer(customerId);
        assertNull(ctm);
    }

}