package com.e.vehiclelist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RVViewholderclass> {

   ArrayList<ModelClass> objectModelClassList;
   Context context;
    onClickInterface onClickInterface;
    public RecyclerViewAdapter(ArrayList<ModelClass> objectModelClassList,Context context,onClickInterface onClickInterface) {
        this.objectModelClassList = objectModelClassList;
        this.context=context;
        this.onClickInterface=onClickInterface;
    }

    @NonNull
    @Override
    public RVViewholderclass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RVViewholderclass(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RVViewholderclass rvViewholderclass, final int i) {
        ModelClass objectModelclass=objectModelClassList.get(i);
        rvViewholderclass.vhType.setText(objectModelclass.getVehicletypeMC());
        rvViewholderclass.vhNumber.setText(objectModelclass.getVehicleNumberMC());
        rvViewholderclass.vhCompany.setText(objectModelclass.getVehiclecompanyMC());
        rvViewholderclass.vhDescription.setText(objectModelclass.getVehicledescriptionMC());
        rvViewholderclass.image.setImageBitmap(objectModelclass.getImage());



               /* ByteArrayOutputStream bStream=new ByteArrayOutputStream();
                Bitmap bitmap=objectModelClassList.get(i).getImage();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,bStream);
                byte[] byteArray=bStream.toByteArray();
                intent.putExtra("Type",objectModelClassList.get(i).getVehicletypeMC());
                intent.putExtra("number",objectModelClassList.get(i).getVehicleNumberMC());
                intent.putExtra("company",objectModelClassList.get(i).getVehiclecompanyMC());
                intent.putExtra("Description",objectModelClassList.get(i).getVehicledescriptionMC());
                intent.putExtra("Image",byteArray);*/




        
    }

    @Override
    public int getItemCount() {
        return objectModelClassList.size();
    }

    public static class RVViewholderclass extends RecyclerView.ViewHolder{
         TextView vhType,vhNumber,vhCompany,vhDescription;
         ImageView image;

        public RVViewholderclass(View itemView){
            super(itemView);

            vhType=itemView.findViewById(R.id.vehicleTypeRV);
            vhNumber=itemView.findViewById(R.id.vehicleNumberRV);
            vhCompany=itemView.findViewById(R.id.vehiclecompanyRV);
            vhDescription=itemView.findViewById(R.id.vehicleDescriptionRV);
            image=itemView.findViewById(R.id.imageRV);

        }
    }
}
