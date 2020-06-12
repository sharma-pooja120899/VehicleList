package com.e.vehiclelist;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class VehicleRegister extends AppCompatActivity {
     private ImageView imgv;
    private EditText edvehicleType,edvehiclenumber,edvehiclecompany,edvehicledescription;
    private Button btupload,btviewall;
    private static int PASS=1;
    private Uri imageFilePath;
    private Bitmap imagetoStore;
    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_register);
        getSupportActionBar().setTitle("Upload Vehicle Details");
        edvehicleType=findViewById(R.id.vehicleType);
        edvehiclenumber=findViewById(R.id.VehicleNumber);
        edvehiclecompany=findViewById(R.id.companyName);
        edvehicledescription=findViewById(R.id.description);
        btupload=findViewById(R.id.upload);
        btviewall=findViewById(R.id.Showuploaded);
        imgv=findViewById(R.id.image);
        databaseHandler=new DatabaseHandler(this);
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage(v);
            }
        });
        btupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeImage(v);
                startActivity(new Intent(VehicleRegister.this,ShowAllActivity.class));
            }
        });
        btviewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VehicleRegister.this,ShowAllActivity.class));
            }
        });
    }
    private void chooseImage(View view) {
        Intent objectintent=new Intent();
        objectintent.setType("image/*");
        objectintent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(objectintent,PASS);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PASS&& resultCode==RESULT_OK&&data!=null&&data.getData()!=null){
            imageFilePath=data.getData();

            try {
                imagetoStore= MediaStore.Images.Media.getBitmap(getContentResolver(),imageFilePath);
            } catch (IOException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            imgv.setImageBitmap(imagetoStore);

        }
    }

    public void storeImage(View v){
        final String t_type=edvehicleType.getText().toString().trim();
        final String t_number=edvehicleType.getText().toString().trim();
        final String t_company=edvehicleType.getText().toString().trim();
        final String t_description=edvehicleType.getText().toString().trim();


        if(t_type.equals(""))
        {
            edvehicleType.setError("Enter the vehicle Type");
            edvehicleType.requestFocus();
            return;
        }
        if(t_number.equals(""))
        {
            edvehiclenumber.setError("Enter the vehicle Number");
            edvehiclenumber.requestFocus();
            return;
        }
        if(t_company.equals(""))
        {
            edvehiclecompany.setError("Enter the vehicle Company");
            edvehiclecompany.requestFocus();
            return;
        }
        if(t_description.equals(""))
        {
            edvehicledescription.setError("Enter the vehicle Description");
            edvehicledescription.requestFocus();
            return;
        }
        if(imgv.getDrawable()==null)
        {
            Toast.makeText(this, "Select Image", Toast.LENGTH_SHORT).show();
        }
        if(!(edvehicleType.getText().toString().isEmpty())&&!(edvehiclenumber.getText().toString().isEmpty())&&!(edvehiclecompany.getText().toString().isEmpty())&&!(edvehicledescription.getText().toString().isEmpty())&&imgv.getDrawable()!=null&&imagetoStore!=null){
            databaseHandler.storeImage(new ModelClass(edvehicleType.getText().toString(),edvehiclenumber.getText().toString(),edvehiclecompany.getText().toString(),edvehicledescription.getText().toString(),imagetoStore));}



    }
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(VehicleRegister.this);
        builder.setTitle(R.string.app_name);

        builder.setIcon(R.drawable.vehiclelogo);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
