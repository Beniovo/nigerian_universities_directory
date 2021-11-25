package com.example.universitytest2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class School_Details extends AppCompatActivity {

    private  String schoolname;
    TextView tv_schoolname, tv_statename, tv_website;
    Button bt_schooldetailhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_details);
        tv_schoolname = findViewById(R.id.tv_schoolName);
        tv_statename = findViewById(R.id.tv_statename);
        tv_website = findViewById(R.id.tv_website);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b != null){
            schoolname = (String) b.getString("sname");
        }

        DBHelper dbHelper = new DBHelper(this, null,null, 1);

        String website = dbHelper.getWebsite(schoolname);
       String schoolstate = dbHelper.getState(schoolname);

        tv_schoolname.setText(schoolname);
        tv_website.setText(website);
        tv_statename.setText(schoolstate);

        // access school website
        tv_website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://" + website;
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(urlintent);

            }
        });






    }
}