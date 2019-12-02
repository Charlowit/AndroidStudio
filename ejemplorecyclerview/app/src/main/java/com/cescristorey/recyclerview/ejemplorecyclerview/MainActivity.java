package com.cescristorey.recyclerview.ejemplorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicialización de la lista de datos de ejemplo
        ArrayList<Coche> datos = new ArrayList<Coche>();
        for(int i=0; i<50; i++)
            datos.add(new Coche("Seat DAM " + i, "" + i +"AAA", "Josegras" ));

        //Inicialización RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.RecView);
        //recyclerView.setHasFixedSize(false);

        //Crea el adaptador, pasándole como parámetro los datos
        final CocheAdapter adaptador = new CocheAdapter(datos);

        //Asocia a recylerView el adaptador
        recyclerView.setAdapter(adaptador);

        //Fija un layout linear al recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}
