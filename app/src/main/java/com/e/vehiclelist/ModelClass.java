package com.e.vehiclelist;

import android.graphics.Bitmap;

public class ModelClass {
    private String vehicletypeMC,vehicleNumberMC,vehiclecompanyMC,vehicledescriptionMC;
    private Bitmap image;

    public ModelClass(String vehicletypeMC,String vehicleNumberMC,String vehiclecompanyMC,String vehicledescriptionMC,Bitmap image) {
        this.vehicletypeMC = vehicletypeMC;
        this.vehicleNumberMC = vehicleNumberMC;
        this.vehiclecompanyMC = vehiclecompanyMC;
        this.vehicledescriptionMC = vehicledescriptionMC;
        this.image = image;
    }

    public String getVehicletypeMC() {
        return vehicletypeMC;
    }

    public void setVehicletypeMC(String vehicletypeMC) {
        this.vehicletypeMC = vehicletypeMC;
    }

    public String getVehicleNumberMC() {
        return vehicleNumberMC;
    }

    public void setVehicleNumberMC(String vehicleNumberMC) {
        this.vehicleNumberMC = vehicleNumberMC;
    }

    public String getVehiclecompanyMC() {
        return vehiclecompanyMC;
    }

    public void setVehiclecompanyMC(String vehiclecompanyMC) {
        this.vehiclecompanyMC = vehiclecompanyMC;
    }

    public String getVehicledescriptionMC() {
        return vehicledescriptionMC;
    }

    public void setVehicledescriptionMC(String vehicledescriptionMC) {
        this.vehicledescriptionMC = vehicledescriptionMC;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
