/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.completeswingapp.dao;

import br.com.devmedia.completeswingapp.entity.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Neto
 */
public class ProductDAO extends GenericDAO {

    public ProductDAO() {
    }

    public int addProduct(Product prod) throws SQLException {
        prod.setId(getNextId("PRODUCTS"));
        String query = "INSERT INTO APP.PRODUCTS (ID, NAME, PRICE, STOCK) VALUES (?,?,?,?)";
        executeCommand(query, prod.getId(), prod.getName(), prod.getPrice(), prod.getStock());
        return prod.getId();
    }

    public void removeProduct(int idProduct) throws SQLException {
        executeCommand("DELETE FROM APP.PRODUCTS WHERE ID = ?", idProduct);
    }

    public void updateProduct(Product prod) throws SQLException {
        String query = "UPDATE APP.PRODUCTS SET NAME = ?, PRICE = ?, STOCK = ? WHERE ID = ?";
        executeCommand(query, prod.getName(), prod.getPrice(), prod.getStock(), prod.getId());
    }

    public Product getProduct(int idProduct) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM APP.PRODUCTS WHERE ID = ?", idProduct);
        Product prod = null;
        if (rs.next()) {
            prod = populateProduct(rs);
        }
        rs.close();
        return prod;
    }

    public static Product populateProduct(ResultSet rs) throws SQLException {
        Product toReturn = new Product();
        toReturn.setId(rs.getInt("ID"));
        toReturn.setName(rs.getString("NAME"));
        toReturn.setPrice(rs.getFloat("PRICE"));
        toReturn.setStock(rs.getInt("STOCK"));
        return toReturn;
    }

    public List<Product> getAllProducts() throws SQLException {
        List<Product> toReturn = new LinkedList<Product>();
        ResultSet rs = executeQuery("SELECT * FROM APP.PRODUCTS");
        while (rs.next()) {
            toReturn.add(populateProduct(rs));
        }
        rs.close();
        return toReturn;
    }
}
