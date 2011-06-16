/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.completeswingapp.dao;

import br.com.devmedia.completeswingapp.entity.Customer;
import br.com.devmedia.completeswingapp.entity.Animal;
import br.com.devmedia.completeswingapp.entity.AnimalType;
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
public class AnimalDAOTest {

    private static Integer animalId = 0;
    private static Integer customerId = 0;

    public AnimalDAOTest() {
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
    public void testAddAnimal() throws Exception {
        System.out.println("addAnimal");

        Customer ctm = new Customer();
        ctm.setName("Test customer");
        ctm.setAge(30);
        ctm.setAddress("Rua x");
        ctm.setTelephone("555-5555");
        ctm.setId((new CustomerDAO()).addCustomer(ctm));
        customerId = ctm.getId();

        Animal animal = new Animal();
        animal.setAge(5);
        animal.setBreed("breed");
        animal.setName("Test animal");
        animal.setType(AnimalType.DOG);
        animal.setOwner(ctm);

        AnimalDAO instance = new AnimalDAO();
        animalId = instance.addAnimal(animal);
        assertTrue(animalId > 0);

    }

    @Test
    public void testGetAnimal() throws Exception {
        System.out.println("getAnimal");
        AnimalDAO instance = new AnimalDAO();
        Animal result = instance.getAnimal(animalId);
        assertEquals(animalId, result.getId());
    }

    @Test
    public void testUpdateAnimal() throws Exception {
        System.out.println("updateAnimal");
        AnimalDAO instance = new AnimalDAO();
        Animal animal = instance.getAnimal(animalId);
        animal.setName("Test animal updated");
        instance.updateAnimal(animal);
        animal = instance.getAnimal(animalId);
        assertEquals("Test animal updated", animal.getName());
    }

    @Test
    public void testGetAnimalByName() throws Exception {
        System.out.println("getAnimalByName");
        String name = "Test animal updated";
        AnimalDAO instance = new AnimalDAO();
        List result = instance.getAnimalByName(name);
        assertTrue(result.size() == 1);
    }

    @Test
    public void testRemoveAnimal() throws Exception {
        System.out.println("removeAnimal");
        AnimalDAO instance = new AnimalDAO();
        instance.removeAnimal(animalId);
        (new CustomerDAO()).removeCustomer(customerId);
        assertNull(instance.getAnimal(animalId));
    }
}
