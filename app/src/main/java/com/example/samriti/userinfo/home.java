package com.example.samriti.userinfo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Vector;

public class home extends AppCompatActivity {
    private DrawerLayout d1;
    RecyclerView recyclerView;
    Vector<YoutubeVideo> youtubeVideos = new Vector<YoutubeVideo>();

    private ActionBarDrawerToggle abdt;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        youtubeVideos.add( new YoutubeVideo("<iframe width=\"100%\" height=\"120%\" src=\"https://www.youtube.com/embed/kDPxDvYxTxo\" frameborder=\"5\" gesture=\"media\" allow=\"encrypted-media\" allowfullscreen></iframe>"));
        youtubeVideos.add( new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/lHLTZJKgrYE\" frameborder=\"5\" gesture=\"media\" allow=\"encrypted-media\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/k5RkbNOx2ic\" frameborder=\"5\" gesture=\"media\" allow=\"encrypted-media\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/-tx1k5HSPIE\" frameborder=\"5\" gesture=\"media\" allow=\"encrypted-media\" allowfullscreen></iframe>\n") );
        youtubeVideos.add( new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/VssRl_dFM-4\" frameborder=\"5\" gesture=\"media\" allow=\"encrypted-media\" allowfullscreen></iframe>") );

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);

        recyclerView.setAdapter(videoAdapter);

        d1 = (DrawerLayout) findViewById(R.id.d1);
        abdt = new ActionBarDrawerToggle(this, d1, R.string.open, R.string.close);
        abdt.setDrawerIndicatorEnabled(true);
        d1.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_profile) {
                    Toast.makeText(home.this, "Welcome to your profile", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(home.this, ProfileActivity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_home) {
                    Toast.makeText(home.this, "Welcome to Home", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(home.this, first.class);
                    startActivity(intent);
                }

                if (id == R.id.nav_chat) {
                    Toast.makeText(home.this, "Chat with us", Toast.LENGTH_LONG).show();
                    Intent n=new Intent(home.this,connection.class);
                    startActivity(n);}
                if (id == R.id.nav_contact) {
                    Toast.makeText(home.this, "Rate Us", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(home.this, rate.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_logout) {
                    Toast.makeText(home.this, "Logout", Toast.LENGTH_LONG).show();
                    FirebaseAuth.getInstance().signOut();
                    finish();
                    Intent intent = new Intent(home.this, LoginActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
        String[] arraySpinner = new String[] {
                "Please select state","Andhra pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chattisgarhjh" ,"Goa","Gujarat","Haryana","Himachal pradesh","Jammu & Kashmir","Jharkhand","Karnataka","Kerala","Madhya pradesh","Maharasthra","Manipur","Meghalaya",
                "Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttarakhand","Uttar praddesh","West bengal"
        };
        Spinner myspinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(adapter);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(adapter);
        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i==1){
                    Intent andhra = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+andhra+pradesh/@16.3251209,76.4739047,6z/data=!3m1!4b1"));
                    startActivity(andhra);
                }else if (i==2){
                    Intent arunachal = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+andhra+pradesh/@16.3251209,76.4739047,6z/data=!3m1!4b1"));
                    startActivity(arunachal);
                }else if (i==3){
                    Intent assam = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+assam/@25.8930986,91.2948743,8z/data=!3m1!4b1"));
                    startActivity(assam);
                }else if (i==4){
                    Intent bihar = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+bihar/@25.9728261,84.4098601,8z/data=!3m1!4b1"));
                    startActivity(bihar);
                }else if (i==5){
                    Intent chhattisgarh = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+Chhattisgarh/@25.8990833,81.0359468,6z/data=!3m1!4b1"));
                    startActivity(chhattisgarh);
                }else if (i==6){
                    Intent goa = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+goa/@15.4369844,73.7625329,11z/data=!3m1!4b1"));
                    startActivity(goa);
                }else if (i==7){
                    Intent gujarat = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+gujarat/@15.3916607,69.4049746,6z/data=!3m1!4b1"));
                    startActivity(gujarat);
                }else if (i==8){
                    Intent haryana = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+haryana/@29.5559514,75.3959768,8z/data=!3m1!4b1"));
                    startActivity(haryana);
                }else if (i==9){
                    Intent himachal = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+himachal/@29.5465365,75.395941,8z/data=!3m1!4b1"));
                    startActivity(himachal);
                }else if (i==10){
                    Intent jk = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+Jammu+and+Kashmir/@29.4662067,72.0230583,6z/data=!3m1!4b1"));
                    startActivity(jk);
                }else if (i==11){
                    Intent jharkhand = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+jharkhand/@29.315338,72.0224574,6z/data=!3m1!4b1"));
                    startActivity(jharkhand);
                }else if (i==12){
                    Intent karnataka = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+karnataka/@14.3046416,75.034823,8z/data=!3m1!4b1"));
                    startActivity(karnataka);
                }else if (i==13){
                    Intent kerala = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+kerala/@14.2597675,71.6583286,6z/data=!3m1!4b1"));
                    startActivity(kerala);
                }else if (i==14){
                    Intent mp = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+madhya+pradesh/@24.1359396,75.9913425,7z/data=!3m1!4b1"));
                    startActivity(mp);
                }else if (i==15){
                    Intent maharashtra = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+maharashtra/@23.854274,69.207561,5z/data=!3m1!4b1"));
                    startActivity(maharashtra);
                }else if (i==16){
                    Intent manipur = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+manipur/@25.2561462,91.8820865,8z/data=!3m1!4b1"));
                    startActivity(manipur);
                }else if (i==17){
                    Intent meghalaya = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+meghalaya/@25.2476789,91.8820493,8z/data=!3m1!4b1"));
                    startActivity(meghalaya);
                }else if (i==18){
                    Intent mizoram = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+mizoram/@24.031394,92.4289075,10z/data=!3m1!4b1"));
                    startActivity(mizoram);
                }else if (i==19){
                    Intent nagaland = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+nagaland/@25.7925409,93.7721009,11z/data=!3m1!4b1"));
                    startActivity(nagaland);
                }else if (i==20){
                    Intent odisha = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+odisha/@25.723385,89.4169531,6z/data=!3m1!4b1"));
                    startActivity(odisha);
                }else if (i==21){
                    Intent punjab = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+punjab/@30.8512396,75.1541648,9z/data=!3m1!4b1"));
                    startActivity(punjab);
                }else if (i==22){
                    Intent rajasthan = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+rajasthan/@30.8306875,73.4707197,7z/data=!3m1!4b1"));
                    startActivity(rajasthan);
                }else if (i==23){
                    Intent sikkim = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/place/AG+Church,+Oldage+Home/@27.0587855,88.174864,17z/data=!3m1!4b1!4m5!3m4!1s0x39e42caf9df4e3e7:0x794fb8adbe4c9b02!8m2!3d27.0587855!4d88.1770527"));
                    startActivity(sikkim);
                }else if (i==24){
                    Intent tn = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+tamil+nadu/@11.5454831,77.4333423,8z/data=!3m1!4b1"));
                    startActivity(tn);
                }else if (i==25){
                    Intent telangana = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+telangana/@17.8782561,78.373563,9z/data=!3m1!4b1"));
                    startActivity(telangana);
                }else if (i==26){
                    Intent tripura = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/place/Abhoy+Mission/@23.8346706,91.2655216,17z/data=!3m1!4b1!4m5!3m4!1s0x3753f41f00000001:0xa9f27bc85eb2c6e!8m2!3d23.8346706!4d91.2677103"));
                    startActivity(tripura);
                }else if (i==27){
                    Intent uttarakhand = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+uttarakhand/@30.1992879,78.0765844,10z/data=!3m1!4b1"));
                    startActivity(uttarakhand);
                }else if (i==28){
                    Intent up = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+uttar+pradesh/@30.1942202,77.2355057,8z/data=!3m1!4b1"));
                    startActivity(up);
                }else if (i==29){
                    Intent bengal = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/maps/search/old+age+homes+in+west+bengal/@22.652674,87.9262408,10z/data=!3m1!4b1"));
                    startActivity(bengal);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public void day(View view){
        Intent day = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.un.org/en/events/olderpersonsday/"));
        startActivity(day);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.about:
                Intent i = new Intent(home.this, aboutus.class);
                startActivity(i);
                return true;
        }
        switch (item.getItemId()) {
            case R.id.credit:
                Intent i = new Intent(home.this, credits.class);
                startActivity(i);
                return true;
        }

        switch (item.getItemId()) {
            case R.id.help:
                Intent i = new Intent(home.this, help.class);

                startActivity(i);
                return true;

        }
        switch (item.getItemId()) {
            case R.id.feed:
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/forms/ugB7tahKdVsT1AtW2"));
                startActivity(i);
                return true;
        }
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
