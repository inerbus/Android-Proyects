package com.example.alberto.eva1t_tecperiodismo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creando Spinner
        final Spinner spinner=(Spinner)findViewById(R.id.spinner);
        //Creando ListView Materias
        final ListView listView=(ListView)findViewById(R.id.listView);
        //Creando listview alumnos
        ListView menuList=(ListView)findViewById(R.id.menu);

        //Obteniendo Recursos
        final String[] materias=getResources().getStringArray(R.array.Materias);//Array de nombres de materia
        final String[] codigos=getResources().getStringArray(R.array.Codigos);//Array de codigos de materia
        final String[] pre=getResources().getStringArray(R.array.Prerequisitos);//Array de prerequisito
        String[] alumno=getResources().getStringArray(R.array.nombres);
        String[] carnet=getResources().getStringArray(R.array.carnets);
        String[] list=getResources().getStringArray(R.array.Ciclos);

        //Llenando ArrayList de Alumnos con los nombres y carnet
        ArrayList<Alumnos> alumnosArrayList = new ArrayList<>();
        alumnosArrayList.add(new Alumnos(alumno[0],carnet[0],R.mipmap.alberto));
        alumnosArrayList.add(new Alumnos(alumno[1],carnet[1],R.mipmap.martin1));
        alumnosArrayList.add(new Alumnos(alumno[2],carnet[2],R.mipmap.rebeca1));

        //Cargando datos de alumnos en la lsita de menu
        menuList.setAdapter(new AdapterAlumno(this,alumnosArrayList));

        //Llenando ArrayList de ciclo para el Spinner
        ArrayList<Ciclo> ciclos= new ArrayList<>();
        ciclos.add(new Ciclo(list[0],R.mipmap.b1));
        ciclos.add(new Ciclo(list[1],R.mipmap.b2));
        ciclos.add(new Ciclo(list[2],R.mipmap.b3));
        ciclos.add(new Ciclo(list[3], R.mipmap.b4));



        //Cargando datos de ciclo en el Spinner principal.
        spinner.setAdapter(new AdapterSpinner(MainActivity.this, ciclos));

        //Manejando eventos del spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //Cuando se selecciona un item.
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Se crea un nuevo ArrayList de Materias cuando el evento se despliega
                ArrayList<Materias> materiasArrayList =new ArrayList<>();

                //Segun el item seleccionado del Spinner se llena el Array list de Materias
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

                //Se cargan los datos en la lista de Materias
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
