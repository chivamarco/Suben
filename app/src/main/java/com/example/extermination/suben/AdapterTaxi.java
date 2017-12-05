package com.example.extermination.suben;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by EXtermination on 24/11/2017.
 */


public class AdapterTaxi extends RecyclerView.Adapter<AdapterTaxi.TaxisViewHolder>{

    public interface Callbacks {
        public void onButtonClicked(int idkey);
    }

    private Callbacks mCallbacks;
    private Context mCtx;
    private List<Taxis> rutasList;
    public TextView selr;
    int idruta;


    public AdapterTaxi(Context mCtx, List<Taxis> rutaList) {
        this.mCtx = mCtx;
        this.rutasList = rutaList;
    }

    @Override
    public TaxisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.taxis_list, null);
        return new TaxisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaxisViewHolder holder, int position) {
        Taxis sruta = rutasList.get(position);

        holder.textViewTitle.setText(sruta.getrNombre());


    }
    @Override
    public int getItemCount() {
        return rutasList.size();
    }

    class TaxisViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;

        public TaxisViewHolder(View itemView) {
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
                       Taxis clickedDataItem = rutasList.get(pos);
                        if (mCallbacks != null) {
                            mCallbacks.onButtonClicked(clickedDataItem.getrIDtaxista());
                            idruta = clickedDataItem.getrIDtaxista();
                        }
                        //Toast.makeText(v.getContext(), "Clicked "+ clickedDataItem.getrIDruta(), Toast.LENGTH_SHORT).show();
                        final Intent i;
                        i = new Intent(mCtx, MapActivity.class);
                        i.putExtra("idRuta", clickedDataItem.getrIDtaxista());
                        i.putExtra("nameRuta", clickedDataItem.getrNombre());
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
