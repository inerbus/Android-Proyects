package com.example.alberto.eva1t_tecperiodismo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creando Spinner
        final Spinner spinner=(Spinner)findViewById(R.id.spinner);
        //Creando ListView
        final ListView listView=(ListView)findViewById(R.id.listView);
        //Obteniendo Recursos
        final String[] materias=getResources().getStringArray(R.array.Materias);
        final String[] codigos=getResources().getStringArray(R.array.Codigos);
        final String[] pre=getResources().getStringArray(R.array.Prerequisitos);


        final String[] list=getResources().getStringArray(R.array.Ciclos);
        //Llenando Array spinner
        ArrayList<Ciclo> ciclos= new ArrayList<>();
        ciclos.add(new Ciclo(list[0],R.mipmap.n1));
        ciclos.add(new Ciclo(list[1],R.mipmap.n2));
        ciclos.add(new Ciclo(list[2],R.mipmap.n3));
        ciclos.add(new Ciclo(list[3], R.mipmap.n4));

        //Declarando arrays materias

        //Enviando Adaptador
        spinner.setAdapter(new AdapterSpinner(MainActivity.this, ciclos));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<Materias> materiasArrayList =new ArrayList<>();
                listView.setAdapter(null);
                switch (position){
                    case 0:

                        for(int i=0;i<4;i++){
                            materiasArrayList.add(new Materias(materias[i],pre[i],codigos[i],R.mipmap.n1));
                        }

                        break;
                    case 1:

                        for(int i=4;i<8;i++){
                            materiasArrayList.add(new Materias(materias[i],pre[i],codigos[i],R.mipmap.n2));
                        }
                        break;
                    case 2:

                        for(int i=8;i<12;i++){
                            materiasArrayList.add(new Materias(materias[i],pre[i],codigos[i],R.mipmap.n3));
                        }
                        break;
                    case 3:

                        for(int i=12;i<=15;i++){
                            materiasArrayList.add(new Materias(materias[i],pre[i],codigos[i],R.mipmap.n4));
                        }
                        break;
                }
                listView.setAdapter(new AdapterMaterias(MainActivity.this, materiasArrayList));


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
