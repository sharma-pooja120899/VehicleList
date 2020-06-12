package com.e.vehiclelist;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ShowAllActivity extends AppCompatActivity {
    DatabaseHandler objectDatabaseHandler;
    RecyclerView objectRV;
    RecyclerViewAdapter objectRVadapter;
    Button viewbtn;
    private onClickInterface onclickInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        getSupportActionBar().hide();
        objectRV=findViewById(R.id.imagesRV);
        objectDatabaseHandler=new DatabaseHandler(this);
        viewbtn=findViewById(R.id.view);
        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData(v);
            }
        });
        onclickInterface = new onClickInterface() {
            @Override
            public void setClick(int abc) {
                int position=abc;
                //Intent intent=new Intent(ShowAllActivity.this,FinalProduct.class);
               // Intent intent=new Intent(context,FinalProduct.class);
                //intent.putExtra("position",position);
                //Toast.makeText(ShowAllActivity.this,"Position is"+abc, Toast.LENGTH_LONG).show();
                objectRVadapter.notifyDataSetChanged();
            }
        };


    }
    public void getData(View v){
        objectRVadapter=new RecyclerViewAdapter(objectDatabaseHandler.getallImagesData(),this,onclickInterface);
        objectRV.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,RecyclerView.VERTICAL,false);

        objectRV.setLayoutManager(gridLayoutManager);
        objectRV.setAdapter(objectRVadapter);
    }

}
