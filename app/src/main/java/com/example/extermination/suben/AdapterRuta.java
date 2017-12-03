package com.example.extermination.suben;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.Toast;

import java.util.List;

/**
 * Created by EXtermination on 24/11/2017.
 */


public class AdapterRuta extends RecyclerView.Adapter<AdapterRuta.RutaViewHolder>{

    public interface Callbacks {
        public void onButtonClicked(int idkey);
    }

    private Callbacks mCallbacks;

    private Context mCtx;
    private List<Rutas> rutasList;
    public TextView selr;
    int idruta;


    public AdapterRuta(Context mCtx, List<Rutas> rutaList) {
        this.mCtx = mCtx;
        this.rutasList = rutaList;
    }

    @Override
    public RutaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.rutas_list, null);
        return new RutaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RutaViewHolder holder, int position) {
        Rutas sruta = rutasList.get(position);

        holder.textViewTitle.setText(sruta.getrName());


    }
    @Override
    public int getItemCount() {
        return rutasList.size();
    }

    class RutaViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;

        public RutaViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            selr = itemView.findViewById(R.id.rutasel);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    //get position
                    int pos = getAdapterPosition();

                    // check if item still exists
                    if (pos != RecyclerView.NO_POSITION){
                        Rutas clickedDataItem = rutasList.get(pos);
                        if (mCallbacks != null) {
                            mCallbacks.onButtonClicked(clickedDataItem.getrIDruta());
                            idruta = clickedDataItem.getrIDruta();
                        }
                        //Toast.makeText(v.getContext(), "Clicked "+ clickedDataItem.getrIDruta(), Toast.LENGTH_SHORT).show();
                        final Intent i;
                        i = new Intent(mCtx, MapActivity.class);
                        i.putExtra("idRuta", clickedDataItem.getrIDruta());
                        i.putExtra("nameRuta", clickedDataItem.getrName());
                        mCtx.startActivity(i);
                        //selr.setText("Seleción: "+clickedDataItem.getrIDruta());
                    }
                }
            });


        }

    }
    public void setCallbacks(Callbacks callbacks) {
        this.mCallbacks = callbacks;
    }

}
