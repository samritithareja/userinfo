package com.example.samriti.userinfo;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class help extends AppCompatActivity {
    Button b3;
    TextView t3;
    ImageView i1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        b3 =(Button)findViewById(R.id.button);
        b3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                final String number = "9803200006";
                //final String number = e2.getText().toString();
                AlertDialog.Builder alertdialog2 = new AlertDialog.Builder(help.this);
                //Setting Dialog Box Title
                alertdialog2.setTitle("Confirm Delete");

                //Setting DialogBox Message
                alertdialog2.setMessage("Are u Sure u want to Call...?");
                //Setting Positive "Yes" Btn
                alertdialog2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent1 = new Intent(Intent.ACTION_CALL);
                        intent1.setData(Uri.parse("tel:" + number));
                        if (ActivityCompat.checkSelfPermission(help.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        startActivity(intent1);
                        Toast.makeText(getApplicationContext(), "You Clicked yes", Toast.LENGTH_LONG).show();

                    }
                });

                //Setting Negative "No" Button
                alertdialog2.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "You Clicked No", Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                });
                alertdialog2.show();
            }
        });


    }

    public void old(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bestindiansites.com/for-grown-ups/old-age-homes.html"));
        startActivity(i);

    }


}
