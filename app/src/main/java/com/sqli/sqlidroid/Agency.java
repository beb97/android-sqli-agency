package com.sqli.sqlidroid;

import android.database.Cursor;

public class Agency {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private int id;

    private String name;

    private String label;

    private String address;

    private double longitude;

    private double latitude;

    private String phone;

    /**
     * Méthode utilitaire permettant de mapper le résultat d'un curseur avec l'objet métier
     * @param c Cursor
     * @return l'objet Agency
     */
    public static Agency fromCursor(Cursor c) {
        Agency agency = new Agency();
        agency.id      = c.getInt(c.getColumnIndex("_id"));
        agency.name = c.getString(c.getColumnIndex("name"));
        agency.label = c.getString(c.getColumnIndex("label"));
        agency.address = c.getString(c.getColumnIndex("address"));
        agency.longitude = c.getDouble(c.getColumnIndex("longitude"));
        agency.latitude = c.getDouble(c.getColumnIndex("latitude"));
        agency.phone = c.getString(c.getColumnIndex("phone"));

        // gère les retours à la ligne récupérés en base.
        agency.address = agency.address.replaceAll("<br>", "\n");

        return agency;
    }

}

