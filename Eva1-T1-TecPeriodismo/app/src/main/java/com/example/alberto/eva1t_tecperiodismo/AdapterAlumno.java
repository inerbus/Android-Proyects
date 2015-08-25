package com.example.alberto.eva1t_tecperiodismo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by alberto on 25/08/2015.
 */
public class AdapterAlumno extends ArrayAdapter<Alumnos>{
    Context context;
    ArrayList<Alumnos> alumnosArrayList;

    public AdapterAlumno(Context context,ArrayList<Alumnos> alumnosArrayList) {
        super(context,R.layout.itemmenu, alumnosArrayList);
        this.context = context;
        this.alumnosArrayList = alumnosArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.itemmenu,parent,false);

        TextView name=(TextView)convertView.findViewById(R.id.name);
        TextView carnet=(TextView)convertView.findViewById(R.id.carnet);
        ImageView image=(ImageView) convertView.findViewById(R.id.user);

        name.setText(alumnosArrayList.get(position).getNombre());
        carnet.setText(alumnosArrayList.get(position).getCarnet());
        image.setImageResource(alumnosArrayList.get(position).getImage());
        return convertView;
    }
}
