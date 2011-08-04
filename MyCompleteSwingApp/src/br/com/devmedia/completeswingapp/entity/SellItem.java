/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.devmedia.completeswingapp.entity;

import br.com.devmedia.completeswingapp.frames.SwingColumn;
import java.io.Serializable;

/**
 *
 * @author Neto
 */
public class SellItem implements Serializable {

    private Integer id;
    @SwingColumn(description="Product")
    private Product product;
    private Sell sell;
    @SwingColumn(description="Quantity")
    private int qnt;
    @SwingColumn(description="Total")
    private float itemTotal;

    public SellItem() {
    }

    public SellItem(Integer id) {
        this.id = id;
    }

    public SellItem(Integer id, Product product, Sell sell, int qnt) {
        this.id = id;
        this.product = product;
        this.sell = sell;
        this.qnt = qnt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public Sell getSell() {
        return sell;
    }

    public void setSell(Sell sell) {
        this.sell = sell;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SellItem other = (SellItem) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    public float getItemTotal() {
        if (getProduct() != null) {
            return getProduct().getPrice() * qnt;
        }
        return itemTotal;
    }

    public void setItemTotal(float itemTotal) {
        this.itemTotal = itemTotal;
    }
    
}
