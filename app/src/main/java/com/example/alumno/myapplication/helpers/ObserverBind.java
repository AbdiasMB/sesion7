package com.example.alumno.myapplication.helpers;
import android.util.Log;
import java.util.Observable;

import java.util.Observer;

public class ObserverBind implements Observer {
    private CallBack callBack;

    @Override
    public void update(Observable o, Object arg){
        Log.v("MARTINEZ", "UPDATE <<<<");
        if (this.callBack!= null){
            this.callBack.doThis(o,arg);
        }
    }
    public void setCallBack(CallBack callBack){
        if (callBack == null){
            return;
        }
        this.callBack=callBack;
    }
}
