/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.completeswingapp.dao;

import br.com.devmedia.completeswingapp.entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Neto
 */
public class UserDAO extends GenericDAO {

    public int addUser(User user) throws SQLException {
        user.setId(this.getNextId("USERS"));
        String query = "INSERT INTO APP.USERS (ID, NAME, LOGIN, PASSWORD) VALUES (?,?,?,?)";
        executeCommand(query, user.getId(), user.getName(), user.getLogin(), user.getPassword());
        return user.getId();
    }

    public void removeUser(int idUser) throws SQLException {
        executeCommand("DELETE FROM APP.USERS WHERE ID = ?", idUser);
    }

    public void updateUser(User usr) throws SQLException {
        String query = "UPDATE APP.USERS SET NAME=?, LOGIN=?, PASSWORD=? WHERE ID = ?";
        executeCommand(query, usr.getName(), usr.getLogin(), usr.getPassword(), usr.getId());
    }

    public User getUser(int idUser) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM APP.USERS WHERE ID = ?", idUser);
        User usr = null;
        if (rs.next()) {
            usr = populateUserInfo(rs);
        }
        rs.close();
        return usr;
    }

    public List<User> getAllUsers() throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM APP.USERS");
        List<User> allUsers = new LinkedList<User>();
        while (rs.next()) {
            allUsers.add(populateUserInfo(rs));
        }
        rs.close();
        return allUsers;
    }

    public static User populateUserInfo(ResultSet rs) throws SQLException {
        User usr = new User();
        usr.setId(rs.getInt("ID"));
        usr.setLogin(rs.getString("LOGIN"));
        usr.setName(rs.getString("NAME"));
        usr.setPassword(rs.getString("PASSWORD"));
        return usr;
        
    }
    
    public boolean isValidUserAndPassword(String user, String password) throws SQLException  {
        boolean result = false;
        String query =  "SELECT * FROM APP.USERS WHERE LOGIN = ? AND PASSWORD = ?";
        ResultSet rs = executeQuery(query, user, password);
        if (rs.next()) {
            result = true;
        }
        rs.close();
        return result;
        
    }
    
}
