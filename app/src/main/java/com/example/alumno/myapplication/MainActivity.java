package com.example.alumno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.alumno.myapplication.helpers.CallBack;
import com.example.alumno.myapplication.helpers.MonitorObservable;
import com.example.alumno.myapplication.helpers.ObserverBind;
import com.example.alumno.myapplication.models.client;

import java.util.Observable;

public class MainActivity extends AppCompatActivity {
    Button btnEdad;
    MonitorObservable monitorObservable;
    ObserverBind observerBind;
    client clientObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientObject = new client();
        clientObject.setAnios(19);




        //aqui bindramos con un observado
        observerBind = new ObserverBind();
        monitorObservable = new MonitorObservable(clientObject);
        observerBind.setCallBack(new CallBack(){
                @Override
                public void doThis(Observable o, Object x){
                // Tofo lo que yo quiera
                Log.v("martinez", "blabal");
                Toast.makeText(MainActivity.this, clientObject.getAnios()+" ",Toast.LENGTH_SHORT).show();
            }
        });
        monitorObservable.addObserver(observerBind);




        btnEdad = (Button)findViewById(R.id.btnEdad);
        btnEdad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            clientObject.setAnios(clientObject.getAnios()+1 );
            monitorObservable.setWachedValue(clientObject);
            }
        });
    }
}
