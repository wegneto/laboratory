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
public class Customer implements Serializable {

    @SwingColumn(description="Id", colorOfBackgound="")
    private Integer id;
    @SwingColumn(description="Name", colorOfBackgound="")
    private String name;
    @SwingColumn(description="Age", colorOfBackgound="")
    private int age;
    @SwingColumn(description="Address", colorOfBackgound="")
    private String address;
    @SwingColumn(description="Telephone", colorOfBackgound="")
    private String telephone;

    public Customer() {
    }

    public Customer(Integer id, String name, int age, String address, String telephone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.telephone = telephone;
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }



}
