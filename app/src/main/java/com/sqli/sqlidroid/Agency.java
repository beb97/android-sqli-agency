package com.sqli.sqlidroid;

import android.database.Cursor;

import lombok.Data;
import lombok.experimental.Builder;
import lombok.val;

@Data
@Builder // TEST COMMENT
public class Agency {

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
        Agency agency = Agency.builder().build();
//        Agency agency = new Agency();
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

