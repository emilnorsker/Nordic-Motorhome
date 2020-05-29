package rme.project.Models;

import java.time.LocalDate;

/**
 * Model for a vans state, updated by mechanic after reservation is over
 * Might not be implemented in time
 *
 * @author Mikkel Åxman
 * @version 1.0
 */
public class ServiceState {
    private int serviceState_id;
    private String damages;
    private float oil;
    private float water;
    private LocalDate date;
    private int motorhome_id;

    /**
     *
     * @param serviceState_id
     * @param damages
     * @param oil
     * @param water
     * @param date
     * @param motorhome_id
     */
    public ServiceState(int serviceState_id, String damages, float oil, float water, LocalDate date, int motorhome_id) {
        this.serviceState_id = serviceState_id;
        this.damages = damages;
        this.oil = oil;
        this.water = water;
        this.date = date;
        this.motorhome_id = motorhome_id;
    }

    /**************************************
     GETTERS AND SETTERS BELOW
     **************************************/
    public int getServiceState_id() {
        return serviceState_id;
    }

    public void setServiceState_id(int serviceState_id) {
        this.serviceState_id = serviceState_id;
    }

    public String getDamages() {
        return damages;
    }

    public void setDamages(String damages) {
        this.damages = damages;
    }

    public float getOil() {
        return oil;
    }

    public void setOil(float oil) {
        this.oil = oil;
    }

    public float getWater() {
        return water;
    }

    public void setWater(float water) {
        this.water = water;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMotorhome_id() {
        return motorhome_id;
    }

    public void setMotorhome_id(int motorhome_id) {
        this.motorhome_id = motorhome_id;
    }
}
