package com.e.vehiclelist;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FinalProduct extends AppCompatActivity {
    TextView txType,txNumber,txCompany,txDescription;
    ImageView IMGV;
    Bitmap bitmap;
    ArrayList<ModelClass> objectModelClassList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_product);
        txType=findViewById(R.id.typeReceived);
        txNumber=findViewById(R.id.Numberretrieve);
        txCompany=findViewById(R.id.companyReceive);
        txDescription=findViewById(R.id.descriptionReceive);
        IMGV=findViewById(R.id.imageretrieve);
        //int getPosition=getIntent().getIntExtra("position",0);
        //Toast.makeText(this, getPosition, Toast.LENGTH_LONG).show();
        //ModelClass objectModelclass=objectModelClassList.get(getPosition);
       // IMGV.setImageBitmap(objectModelclass.getImage());
        //txType.setText(objectModelclass.getVehicletypeMC());
       // txNumber.setText(getPosition);
        //txCompany.setText(objectModelclass.getVehiclecompanyMC());
        //txDescription.setText(objectModelclass.getVehicledescriptionMC());

       /* byte[] byteArray=getIntent().getByteArrayExtra("Image");
        bitmap= BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
        IMGV.setImageBitmap(bitmap);
        txType.setText(getIntent().getExtras().getInt("Type"));
        txNumber.setText(getIntent().getExtras().getInt("number"));
        txCompany.setText(getIntent().getExtras().getInt("company"));
        txDescription.setText(getIntent().getExtras().getInt("Description"));*/
    }
}
