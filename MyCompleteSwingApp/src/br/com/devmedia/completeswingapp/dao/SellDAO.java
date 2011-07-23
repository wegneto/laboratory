/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.completeswingapp.dao;

import br.com.devmedia.completeswingapp.entity.Sell;
import br.com.devmedia.completeswingapp.entity.SellItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Neto
 */
public class SellDAO extends GenericDAO {

    public SellDAO() {
    }

    public int addSell(Sell sell, boolean cascade) throws SQLException {
        sell.setId(getNextId("SELLS"));
        String query = "INSERT INTO APP.SELLS (ID, ID_VENDOR, DATEOFSALE, TOTAL) VALUES (?, ?, ?, ?)";
        //Sum the total of sell
        float totalOfSale = 0f;
        for (SellItem item : sell.getItems()) {
            totalOfSale += (item.getProduct().getPrice() * item.getQnt());
        }
        //create sell in database
        executeCommand(query, sell.getId(), sell.getVendor().getId(), sell.getDateOfSale(), totalOfSale);
        if (cascade) {
            //persist the items
            for (SellItem item : sell.getItems()) {
                addSellItem(item);
            }
        }
        return sell.getId();
    }

    public int addSellItem(SellItem item) throws SQLException {
        item.setId(getNextId("SELLSITEM"));
        String query = "INSERT INTO APP.SELLSITEM (ID, ID_PRODUCT, QNT, ID_SELL) VALUES (?, ?, ?, ?)";
        executeCommand(query, item.getId(), item.getProduct().getId(), item.getQnt(), item.getSell().getId());
        return item.getId();
    }

    public void updateSell(Sell sell, boolean cascade) throws SQLException {
        String query = "UPDATE APP.SELLS SET ID_VENDOR = ?, TOTAL = ? WHERE ID = ?";
        float totalOfSale = 0f;
        for (SellItem item : sell.getItems()) {
            totalOfSale += (item.getProduct().getPrice() * item.getQnt());
        }
        executeCommand(query, sell.getVendor().getId(), totalOfSale, sell.getId());
        if (cascade) {
            for (SellItem item : sell.getItems()) {
                updateSellItem(item);
            }
        }

    }

    public void updateSellItem(SellItem item) throws SQLException {
        String query = "UPDATE APP.SELLSITEM SET ID_PRODUCT = ?, QNT = ? WHERE ID = ?";
        executeCommand(query, item.getProduct().getId(), item.getQnt(), item.getId());
    }

    public void removeSell(int idSell) throws SQLException {
        executeCommand("DELETE FROM APP.SELLSITEM WHERE ID_SELL = ?", idSell);
        executeCommand("DELETE FROM APP.SELLS WHERE ID = ?", idSell);
    }

    public void removeSellItem(int idSellItem) throws SQLException {
        executeCommand("DELETE FROM APP.SELLSITEM WHERE ID = ?", idSellItem);
    }

    public Sell getSell(int idSell, boolean populateItems) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM APP.SELLS WHERE ID = ?", idSell);
        Sell sell = null;
        if (rs.next()) {
            sell = populateSell(rs, populateItems);
        }
        rs.close();
        return sell;
    }
    
    public List<Sell> getAllSells() throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM APP.SELLS");
        List<Sell> sells = new LinkedList<Sell>();
        while (rs.next()) {
            sells.add(populateSell(rs, true));
        }
        rs.close();
        return sells;
    }

    private Sell populateSell(ResultSet rs, boolean populateItems) throws SQLException {
        Sell sell = new Sell();
        sell.setId(rs.getInt("ID"));
        sell.setVendor((new UserDAO()).getUser(rs.getInt("ID_VENDOR")));
        sell.setDateOfSale(rs.getDate("DATEOFSALE"));
        sell.setTotal(rs.getFloat("TOTAL"));
        if (populateItems) {
            sell.setItems(getSellItems(sell));
        }
        return sell;
    }

    public SellItem getSellItem(int idSellItem) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM APP.SELLSITEM WHERE ID = ?", idSellItem);
        SellItem sellItem = null;
        if (rs.next()) {
            sellItem = populateSellItem(rs);
        }
        rs.close();
        return sellItem;
    }

    public List<SellItem> getSellItems(Sell sell) throws SQLException {
        List<SellItem> sellItems = new LinkedList<SellItem>();
        ResultSet rs = executeQuery("SELECT * FROM APP.SELLSITEM WHERE ID_SELL = ?", sell.getId());
        while (rs.next()) {
            sellItems.add(populateSellItem(rs, sell));
        }
        rs.close();
        return sellItems;
    }

    private SellItem populateSellItem(ResultSet rs, Sell... sell) throws SQLException {
        SellItem sellItem = new SellItem();
        sellItem.setId(rs.getInt("ID"));
        sellItem.setQnt(rs.getInt("QNT"));
        sellItem.setProduct((new ProductDAO()).getProduct(rs.getInt("ID_PRODUCT")));
        if (sell != null && sell.length > 0) {
            sellItem.setSell(sell[0]);
        } else {
            sellItem.setSell(getSell(rs.getInt("ID_SELL"), false));
        }
        return sellItem;
    }

}
