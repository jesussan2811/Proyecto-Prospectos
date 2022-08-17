package com.example.pruebaprospectos;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebaprospectos.entidades.ModeloProspectos;

import java.util.List;

public class AdapterProspectos extends RecyclerView.Adapter<AdapterProspectos.ViewHolder> {

    private List<ModeloProspectos> Prospectos;
    private Activity activity;

    public AdapterProspectos(Activity activity, List<ModeloProspectos> Prospectos) {
        this.Prospectos = Prospectos;
        this.activity = activity;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_prospectos,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(Prospectos.get(position).getNombre());
        holder.apellidoPat.setText(Prospectos.get(position).getApellidoPat());
        holder.apellidoMat.setText(Prospectos.get(position).getApellidoMat());
        holder.estatus.setText(Prospectos.get(position).getEstatus());
        //Se agrega el evento click al item seleccionado de la lista
        //para mostrar el detalle
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity,EvaluarActivity.class);
                intent.putExtra("Prospecto",Prospectos.get(position));
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Prospectos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre, apellidoPat, apellidoMat, estatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            apellidoPat = itemView.findViewById(R.id.tvApellidoPat);
            apellidoMat = itemView.findViewById(R.id.tvApellidoMat);
            estatus = itemView.findViewById(R.id.tvEstatus);

        }
    }
}
