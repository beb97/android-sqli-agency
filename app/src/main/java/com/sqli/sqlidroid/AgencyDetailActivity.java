package com.sqli.sqlidroid;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class AgencyDetailActivity extends Activity {

    private AgencyRepository repo;
    private TextView agencyName;
    private TextView agencyLabel;
    private TextView agencyAddress;
    private TextView agencyPhone;
    private ImageButton callBtn;
    private ImageButton mapBtn;

    private Agency currentAgency;

    private int selectedAgencyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_agency_detail);

        agencyName = (TextView) findViewById(R.id.detail_name);
        agencyLabel = (TextView) findViewById(R.id.detail_label);
        agencyAddress = (TextView) findViewById(R.id.detail_address);
        agencyPhone = (TextView) findViewById(R.id.detail_phone);
        callBtn = (ImageButton) findViewById(R.id.detail_call_btn);
        mapBtn = (ImageButton) findViewById(R.id.detail_map_btn);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                selectedAgencyId = 0;
            } else {
                selectedAgencyId= extras.getInt("selectedAgencyId");
            }
        } else {
            selectedAgencyId = (Integer) savedInstanceState.getSerializable("STRING_I_NEED");
        }


        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCall();
            }
        });

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMap();
            }
        });

        repo = new AgencyRepository(this);

        init();

    }

    private void init() {
        currentAgency = Agency.fromCursor(repo.getAgencyById(selectedAgencyId));

        agencyName.setText(currentAgency.getName());
        agencyLabel.setText(currentAgency.getLabel());
        agencyAddress.setText(currentAgency.getAddress());
        agencyPhone.setText(currentAgency.getPhone());
    }

    void startCall() {
        Uri dialUri = Uri.parse("tel:" + currentAgency.getPhone());
        Intent intent = new Intent(Intent.ACTION_DIAL, dialUri);

        startActivity(intent);
    }

    void startMap() {

        Locale.setDefault(Locale.US);

        // affiche un Label
        String str = "http://maps.google.com/maps?q=SQLI@" + currentAgency.getLatitude() + "," + currentAgency.getLongitude();

        Uri uri = Uri.parse(str);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        startActivity(intent);
    }

}
