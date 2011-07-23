/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.devmedia.completeswingapp.entity;

import br.com.devmedia.completeswingapp.frames.SwingColumn;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Neto
 */
public class Schedule implements Serializable {

    private Integer id;
    @SwingColumn(description="Pet", colorOfBackgound="")
    private Animal animal;
    @SwingColumn(description="Date", colorOfBackgound="")
    private Date date;
    private float total;
    @SwingColumn(description="Type", colorOfBackgound="")
    private ScheduleType type;

    public Schedule() {
    }

    public Schedule(Integer id) {
        this.id = id;
    }

    public Schedule(Integer id, Animal animal, Date date, float total, ScheduleType type) {
        this.id = id;
        this.animal = animal;
        this.date = date;
        this.total = total;
        this.type = type;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public ScheduleType getType() {
        return type;
    }

    public void setType(ScheduleType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Schedule other = (Schedule) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    

}
