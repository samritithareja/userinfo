package com.example.samriti.userinfo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class connect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
    }
    public void fb(View view) {
        Intent browserintent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/?stype=lo&jlou=Affvf1pqdf6oF9YJlqqnibvG_G_gAUnaavX9Ka8JPlCIH7b9SJ_J8oOmv1U8RKy_DeVcO2vcOBCzmjlZEyO_k2h0kbfIyaMYh5_a4i54b8WHzA&smuh=41087&lh=Ac-EylkkOkj83FP_"));
        startActivity(browserintent1);
    }

    public void twitter(View view) {
        Intent browserintent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/login/"));
        startActivity(browserintent2);
    }
    public void instagram(View view){
        Intent browserintent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/accounts/login/"));
        startActivity(browserintent3);
    }

}
