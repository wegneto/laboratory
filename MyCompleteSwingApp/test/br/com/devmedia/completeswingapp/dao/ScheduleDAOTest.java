/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.completeswingapp.dao;

import br.com.devmedia.completeswingapp.entity.Animal;
import br.com.devmedia.completeswingapp.entity.AnimalType;
import br.com.devmedia.completeswingapp.entity.Customer;
import br.com.devmedia.completeswingapp.entity.Schedule;
import br.com.devmedia.completeswingapp.entity.ScheduleType;
import java.sql.Date;
import java.sql.ResultSet;
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
public class ScheduleDAOTest {

    private static Integer scheduleId = 0;
    private static Integer customerId = 0;
    private static Integer animalId = 0;

    public ScheduleDAOTest() {
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
    public void testAddSchedule() throws Exception {
        System.out.println("addSchedule");

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
        animalId = (new AnimalDAO()).addAnimal(animal);

        Schedule schedule = new Schedule();
        schedule.setDate(new Date(Calendar.getInstance().getTime().getTime()));
        schedule.setTotal(10f);
        schedule.setType(ScheduleType.SHOWER);
        schedule.setAnimal(animal);

        ScheduleDAO instance = new ScheduleDAO();
        scheduleId = instance.addSchedule(schedule);
        assertTrue(scheduleId > 0);
    }

    @Test
    public void testUpdateSchedule() throws Exception {
        System.out.println("updateSchedule");
        ScheduleDAO instance = new ScheduleDAO();
        Schedule schedule = instance.getSchedule(scheduleId);
        schedule.setTotal(15f);
        instance.updateSchedule(schedule);
        Schedule schedule2 = instance.getSchedule(scheduleId);
        assertTrue(schedule.getTotal() == schedule2.getTotal());
    }

    @Test
    public void testGetSchedules() throws Exception {
        System.out.println("getSchedules");
        ScheduleDAO instance = new ScheduleDAO();
        List result = instance.getSchedules();
        assertTrue(result.size() > 0);
    }

    @Test
    public void testGetSchedule() throws Exception {
        System.out.println("getSchedule");
        ScheduleDAO instance = new ScheduleDAO();
        Schedule result = instance.getSchedule(scheduleId);
        assertEquals(scheduleId, result.getId());
    }

    @Test
    public void testRemoveSchedule() throws Exception {
        System.out.println("removeSchedule");
        ScheduleDAO instance = new ScheduleDAO();
        instance.removeSchedule(scheduleId);
        (new AnimalDAO()).removeAnimal(animalId);
        (new CustomerDAO()).removeCustomer(customerId);
        assertNull(instance.getSchedule(scheduleId));
    }
}
