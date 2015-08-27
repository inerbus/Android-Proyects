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
 * Created by alberto on 24/08/2015.
 */
public class AdapterMaterias extends ArrayAdapter<Materias> {
    Context context;
    ArrayList<Materias> list;

    public AdapterMaterias(Context context, ArrayList<Materias> list) {
        super(context, R.layout.itemlist, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Inflando la vista con el layout personalizado
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.itemlist,parent,false);

        // Accediendo a los controladores del layout personalizado
        TextView cod=(TextView)convertView.findViewById(R.id.codigo);
        TextView mat=(TextView)convertView.findViewById(R.id.materia);
        TextView pre=(TextView)convertView.findViewById(R.id.prerequisito);
        ImageView image=(ImageView)convertView.findViewById(R.id.imageView);

        //Enviando datos segun la position a cada controlador
        cod.setText(list.get(position).getCodigo());
        mat.setText(list.get(position).getMateria());
        pre.setText(list.get(position).getPrer());
        image.setImageResource(list.get(position).getImg());

        return convertView;
    }
}
