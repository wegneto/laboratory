/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmedia.completeswingapp.dao;

import br.com.devmedia.completeswingapp.entity.Schedule;
import br.com.devmedia.completeswingapp.entity.ScheduleType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Neto
 */
public class ScheduleDAO extends GenericDAO {

    public ScheduleDAO() {
    }

    public int addSchedule(Schedule schedule) throws SQLException {
        schedule.setId(getNextId("SCHEDULE"));
        String query = "INSERT INTO APP.SCHEDULE (ID, ID_ANIMAL, DATE, TYPE, TOTAL) VALUES (?, ?, ?, ?, ?)";
        executeCommand(query, schedule.getId(), schedule.getAnimal().getId(), schedule.getDate(), schedule.getType().toString(), schedule.getTotal());
        return schedule.getId();
    }

    public void removeSchedule(int idSchedule) throws SQLException {
        executeCommand("DELETE FROM APP.SCHEDULE WHERE ID = ?", idSchedule);
    }

    public void updateSchedule(Schedule schedule) throws SQLException {
        String query = "UPDATE APP.SCHEDULE SET ID_ANIMAL = ?, DATE = ?, TYPE = ?, TOTAL = ? WHERE ID = ?";
        executeCommand(query, schedule.getAnimal().getId(), schedule.getDate(), schedule.getType().toString(), schedule.getTotal(), schedule.getId());
    }

    public Schedule getSchedule(int idSchedule) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM APP.SCHEDULE WHERE ID = ?", idSchedule);
        Schedule schedule = null;
        if (rs.next()) {
            schedule = populateSchedule(rs);
        }
        rs.close();
        return schedule;
    }

    public static Schedule populateSchedule(ResultSet rs) throws SQLException {
        Schedule schedule = new Schedule();
        schedule.setId(rs.getInt("ID"));
        schedule.setDate(rs.getDate("DATE"));
        schedule.setTotal(rs.getFloat("TOTAL"));
        schedule.setType(ScheduleType.valueOf(rs.getString("TYPE")));
        schedule.setAnimal((new AnimalDAO()).getAnimal(rs.getInt("ID_ANIMAL")));
        return schedule;
    }

    public List<Schedule> getSchedules() throws SQLException {
        List<Schedule> list = new LinkedList<Schedule>();
        ResultSet rs = executeQuery("SELECT * FROM APP.SCHEDULE");
        while (rs.next()) {
            list.add(populateSchedule(rs));
        }
        rs.close();
        return list;
    }

}
