/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.devmedia.completeswingapp.entity;

/**
 *
 * @author Neto
 */
public enum AnimalType {

    DOG("Dog"),CAT("Cat");

    private String description;

    AnimalType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
