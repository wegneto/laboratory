/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.completeswingapp.dao;

import br.com.devmedia.completeswingapp.entity.User;
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
public class UserDAOTest {

    private static Integer userId = 0;

    public UserDAOTest() {
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
    public void testAddUser() throws Exception {
        System.out.println("addUser");
        User user = new User();
        user.setName("Test User");
        user.setLogin("test");
        user.setPassword("1234");
        UserDAO instance = new UserDAO();
        userId = instance.addUser(user);
        User result = instance.getUser(userId);
        assertEquals(userId, result.getId());
    }

    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        int idUser = userId;
        UserDAO instance = new UserDAO();
        Integer expResult = userId;
        User result = instance.getUser(idUser);
        assertEquals(expResult, result.getId());
    }

    @Test
    public void testUpdateUser() throws Exception {
        System.out.println("updateUser");
        UserDAO instance = new UserDAO();
        User usr = instance.getUser(userId);
        usr.setName("Test User Updated");
        instance.updateUser(usr);
        usr = instance.getUser(userId);
        assertEquals(usr.getName(), "Test User Updated");
    }

    @Test
    public void testRemoveUser() throws Exception {
        System.out.println("removeUser");
        UserDAO instance = new UserDAO();
        instance.removeUser(userId);
    }
}
