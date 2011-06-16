/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.completeswingapp.dao;

import br.com.devmedia.completeswingapp.entity.Animal;
import br.com.devmedia.completeswingapp.entity.AnimalType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Neto
 */
public class AnimalDAO extends GenericDAO {

    public AnimalDAO() {
    }

    public int addAnimal(Animal animal) throws SQLException {
        animal.setId(getNextId("ANIMALS"));
        String query = "INSERT INTO APP.ANIMALS (ID, ID_CUSTOMER, NAME, TYPE, BREED, AGE) VALUES (?, ?, ?, ?, ?, ?)";
        executeCommand(query, animal.getId(), animal.getOwner().getId(), animal.getName(), animal.getType().toString(),
                animal.getBreed(), animal.getAge());
        return animal.getId();
    }

    public void removeAnimal(int idAnimal) throws SQLException {
        executeCommand("DELETE FROM APP.ANIMALS WHERE ID = ?", idAnimal);
    }

    public void updateAnimal(Animal animal) throws SQLException {
        String query = "UPDATE APP.ANIMALS SET ID_CUSTOMER = ?, NAME = ?, TYPE = ?, BREED = ?, AGE = ? WHERE ID = ?";
        executeCommand(query, animal.getOwner().getId(), animal.getName(), animal.getType().toString(),
                animal.getBreed(), animal.getAge(), animal.getId());
    }

    public Animal getAnimal(int idAnimal) throws SQLException {
        ResultSet rs = executeQuery("select * from APP.ANIMALS WHERE ID = ?", idAnimal);
        Animal animal = null;
        if (rs.next()) {
            animal = populateAnimal(rs);
        }
        rs.close();
        return animal;
    }

    public List<Animal> getAnimalByName(String name) throws SQLException {
        List<Animal> animals = new LinkedList<Animal>();
        ResultSet rs = executeQuery("SELECT * FROM APP.ANIMALS WHERE NAME LIKE ?", name + "%");
        while (rs.next()) {
            animals.add(populateAnimal(rs));
        }
        rs.close();
        return animals;
    }

    private Animal populateAnimal(ResultSet rs) throws SQLException {
        CustomerDAO customerDAO = new CustomerDAO();
        Animal animal = new Animal();
        animal.setId(rs.getInt("ID"));
        animal.setOwner(customerDAO.getCustomer(rs.getInt("ID_CUSTOMER")));
        animal.setName(rs.getString("NAME"));
        animal.setType(AnimalType.valueOf(rs.getString("TYPE")));
        animal.setBreed(rs.getString("BREED"));
        animal.setAge(rs.getInt("AGE"));
        return animal;
    }
}
