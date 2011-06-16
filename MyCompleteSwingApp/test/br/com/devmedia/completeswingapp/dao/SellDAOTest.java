/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.devmedia.completeswingapp.dao;

import br.com.devmedia.completeswingapp.entity.Product;
import br.com.devmedia.completeswingapp.entity.User;
import br.com.devmedia.completeswingapp.entity.Sell;
import br.com.devmedia.completeswingapp.entity.SellItem;
import java.sql.Date;
import java.util.Calendar;
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
public class SellDAOTest {

    private static Integer idOfSell = 0;
    private static Integer idOfSellItem1 = 0;
    private static Integer idOfUser = 0;
    private static Integer idOfProduct = 0;

    public SellDAOTest() {
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
    public void testAddSell() throws Exception {
        System.out.println("addSell");

        User user = new User();
        user.setName("Test User");
        user.setLogin("test");
        user.setPassword("1234");
        idOfUser = (new UserDAO()).addUser(user);

        Product prod = new Product();
        prod.setName("Product test");
        prod.setPrice(10f);
        prod.setStock(20);
        idOfProduct = (new ProductDAO()).addProduct(prod);

        Sell sell = new Sell();
        sell.setVendor(user);
        sell.setDateOfSale(new Date(Calendar.getInstance().getTime().getTime()));

        SellItem sellItem = new SellItem();
        sellItem.setQnt(10);
        sellItem.setSell(sell);
        sellItem.setProduct(prod);

        sell.getItems().add(sellItem);
        
        SellDAO instance = new SellDAO();
        idOfSell = instance.addSell(sell, true);
        assertTrue(idOfSell > 0);
    }

    @Test
    public void testGetSell() throws Exception {
        System.out.println("getSell");
        SellDAO instance = new SellDAO();
        Sell result = instance.getSell(idOfSell, true);
        assertEquals(result.getId(), idOfSell);
        idOfSellItem1 = result.getItems().get(0).getId();
    }

    @Test
    public void testGetSellItem() throws Exception {
        System.out.println("getSellItem");
        SellDAO instance = new SellDAO();
        SellItem result = instance.getSellItem(idOfSellItem1);
        assertEquals(idOfSellItem1, result.getId());
    }

    @Test
    public void testGetSellItems() throws Exception {
        System.out.println("getSellItems");
        SellDAO instance = new SellDAO();
        List result = instance.getSellItems(instance.getSell(idOfSell, false));
        assertTrue(result.size() > 0);
    }

    @Test
    public void testUpdateSell() throws Exception {
        System.out.println("updateSell");
        SellDAO instance = new SellDAO();
        Sell sell = instance.getSell(idOfSell, true);
        sell.getItems().get(0).setQnt(222);
        instance.updateSell(sell, true);
        Sell sell2 = instance.getSell(idOfSell, true);
        assertTrue(sell.getTotal() != sell2.getTotal());
        assertTrue(sell2.getTotal() == 222*sell.getItems().get(0).getProduct().getPrice());
    }

    @Test
    public void testUpdateSellItem() throws Exception {
        System.out.println("updateSellItem");
        SellDAO instance = new SellDAO();
        SellItem item = instance.getSellItem(idOfSellItem1);
        item.setQnt(1);
        instance.updateSellItem(item);
        SellItem item2 = instance.getSellItem(idOfSellItem1);
        assertEquals(item.getQnt(), item2.getQnt());
    }

    @Test
    public void testRemoveSellItem() throws Exception {
        System.out.println("removeSellItem");
        SellDAO instance = new SellDAO();
        instance.removeSellItem(idOfSellItem1);
        assertNull(instance.getSellItem(idOfSellItem1));
    }

    @Test
    public void testRemoveSell() throws Exception {
        System.out.println("removeSell");
        SellDAO instance = new SellDAO();
        
        instance.removeSell(idOfSell);
        (new ProductDAO()).removeProduct(idOfProduct);
        (new UserDAO()).removeUser(idOfUser);

        assertNull(instance.getSell(idOfSell, false));
        
    }

}