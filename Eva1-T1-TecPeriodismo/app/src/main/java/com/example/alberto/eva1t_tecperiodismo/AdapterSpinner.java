package com.example.alberto.eva1t_tecperiodismo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alberto on 24/08/2015.
 */
public class AdapterSpinner extends ArrayAdapter<Ciclo> {

    Context context;
    ArrayList<Ciclo> ciclos;
    public AdapterSpinner(Context context, ArrayList<Ciclo> ciclos) {
        super(context,R.layout.spinneritem, ciclos);
        this.context=context;
        this.ciclos=ciclos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return getCustomView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

       return getCustomView(position,convertView,parent);
    }

    //Se define dicho metodo para llenar las dos vistas del spinner, vista normal y vista desplegable
    public View getCustomView(int position,View row,ViewGroup parent){
        //Infla el layout personalizado
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        row = inflater.inflate(R.layout.spinneritem, parent, false);

        //Accediendo a los controles del layout personalizado
        TextView name=(TextView)row.findViewById(R.id.nameciclo);
        ImageView img=(ImageView)row.findViewById(R.id.imageciclo);

        //Enviando datos a los controladores del layout personalizado
        name.setText(ciclos.get(position).getName());
        img.setImageResource(ciclos.get(position).getImg());

        return row;

    }

}
