/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.devmedia.completeswingapp.entity;

/**
 *
 * @author Neto
 */
public enum ScheduleType {

    SHOWER("Taje a Shower"), CUTTING("Take a Cut");

    private String description;

    ScheduleType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
