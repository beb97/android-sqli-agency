package com.sqli.sqlidroid;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class AgencyRepository {

    private DataBaseHelper helper;

    private Context context;

    public AgencyRepository(Context context) {
        this.context = context;
        helper = new DataBaseHelper(context);
    }

    /**
     * La bonne pratique est de ne pas charger "tous" les objets en mémoire, mais seulement
     * ceux pour lesquels on travaille a un instant t.
     * On retourne donc un Cursor, c'est à dire un pointeur vers un enregistrement de la base.
     * On pourra itérer sur le curseur pour récupérer un enregistrement
     * @return Cursor curseur de l'agence
     */
    public Cursor getAllAgencies() {

        SQLiteDatabase database = helper.getReadableDatabase();

        // possibilité de récupérer tous les résultats en passant directement par une requête SQL
        // avec un rawQuery
        Cursor cursor = database.rawQuery("select * from agency", null);

        return cursor;
    }

    /**
     * R�cup�re le curseur sur l'agence dont l'ID est passé en paramêtre.
     * @param id
     * @return
     */
    public Cursor getAgencyById(int id) {
        //
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor c = database.rawQuery("select * from agency where _id = ?", new String[] { ""+id });
        // positionne le curseur
        c.moveToFirst();
        return c;
    }

}