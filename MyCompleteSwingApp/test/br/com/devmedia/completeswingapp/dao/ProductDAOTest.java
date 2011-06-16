/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.devmedia.completeswingapp.dao;

import br.com.devmedia.completeswingapp.entity.Product;
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
public class ProductDAOTest {

    private static Integer productId = 0;


    public ProductDAOTest() {
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
    public void testGetProduct() throws Exception {
        System.out.println("getProduct");
        int idProduct = productId;
        ProductDAO instance = new ProductDAO();
        Product expResult = null;
        Product result = instance.getProduct(idProduct);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddProduct() throws Exception {
        System.out.println("addProduct");
        Product prod = new Product();
        prod.setName("Product test");
        prod.setPrice(10f);
        prod.setStock(20);
        ProductDAO instance = new ProductDAO();
        productId = instance.addProduct(prod);
        assertTrue(productId > 0);
    }

    @Test
    public void testUpdateProduct() throws Exception {
        System.out.println("updateProduct");
        ProductDAO instance = new ProductDAO();
        Product prod = instance.getProduct(productId);
        prod.setName("Product test updated");
        instance.updateProduct(prod);
        prod = instance.getProduct(productId);
        assertEquals(prod.getName(), "Product test updated");
    }

    @Test
    public void testGetAllProducts() throws Exception {
        System.out.println("getAllProducts");
        ProductDAO instance = new ProductDAO();
        List result = instance.getAllProducts();
        assertTrue(result.size() > 0);
    }

    @Test
    public void testRemoveProduct() throws Exception {
        System.out.println("removeProduct");
        ProductDAO instance = new ProductDAO();
        instance.removeProduct(productId);
        assertNull(instance.getProduct(productId));
    }

}