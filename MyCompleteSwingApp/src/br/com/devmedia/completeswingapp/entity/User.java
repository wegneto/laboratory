/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.completeswingapp.entity;

import br.com.devmedia.completeswingapp.frames.SwingColumn;
import java.io.Serializable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Neto
 */
public class User implements Serializable {

    @SwingColumn(description = "Id", colorOfBackgound = "")
    private Integer id;
    @SwingColumn(description = "Name", colorOfBackgound = "")
    private String name;
    @SwingColumn(description = "Login", colorOfBackgound = "")
    private String login;
    private String password;

    public User() {
    }

    public User(Integer id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return this.name;
    }
        
}
