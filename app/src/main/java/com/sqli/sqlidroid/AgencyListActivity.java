package com.sqli.sqlidroid;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class AgencyListActivity extends Activity {


    private ListView agencyView;

    private AgencyRepository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_agency_list);

        agencyView = (ListView)findViewById(R.id.agencylistview);
        agencyView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                itemViewClicked(i);
            }
        });

        repo = new AgencyRepository(this);

        init();
    }


    private void init() {
        Cursor agencies = repo.getAllAgencies();

        String[] from = {"name", "label"};
        int [] to = {R.id.titre, R.id.description};

        final SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_agency_item, agencies, from, to );

        agencyView.setAdapter(adapter);

        // On se décharge de la gestion du cycle de vie du Cursor en appelant
        // startManagingCursor().  La destruction du cursor (l'appel au close()) sera
        // lié à la destruction de l'activity.
        startManagingCursor(agencies);
    }


    private void itemViewClicked(int position) {

        final Intent t = new Intent(this, AgencyDetailActivity.class);
        t.putExtra("selectedAgencyId", (int)agencyView.getItemIdAtPosition(position));

        startActivity(t);
    }

}