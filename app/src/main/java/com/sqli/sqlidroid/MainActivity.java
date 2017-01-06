package com.sqli.sqlidroid;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mapButton = (ImageView) findViewById(R.id.imageMap);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapButtonClicked();
            }
        });
    }

    private void mapButtonClicked() {
        // lance une nouvelle activity
        final Intent t = new Intent(this, AgencyListActivity.class);
        startActivity(t);
    }

}
