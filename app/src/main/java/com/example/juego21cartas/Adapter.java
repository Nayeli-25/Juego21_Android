package com.example.juego21cartas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder> {
    private List<Carta> listCartas;

    public Adapter(List<Carta> listCartas){
        this.listCartas = listCartas;
    }
    @NonNull
    @Override
    public Adapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCarta = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cartas, parent, false);
        return new MyHolder(viewCarta);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyHolder holder, int position) {
        Carta modelCarta = listCartas.get(position);
        holder.setData(modelCarta);
    }

    @Override
    public int getItemCount() {
        return listCartas.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private ImageView carta;
        private TextView numeroCarta;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            carta = itemView.findViewById(R.id.imgCarta);
            numeroCarta = itemView.findViewById(R.id.txtCarta);
        }

        public void setData(Carta modelCarta) {
            numeroCarta.setText(String.valueOf(modelCarta.getNum()));
            switch (modelCarta.getNum()) {
                case 1:
                    carta.setImageResource(R.drawable.carta1);
                    break;
                case 2:
                    carta.setImageResource(R.drawable.carta2);
                    break;
                case 3:
                    carta.setImageResource(R.drawable.carta3);
                    break;
                case 4:
                    carta.setImageResource(R.drawable.carta4);
                    break;
                case 5:
                    carta.setImageResource(R.drawable.carta5);
                    break;
                case 6:
                    carta.setImageResource(R.drawable.carta6);
                    break;
                case 7:
                    carta.setImageResource(R.drawable.carta7);
                    break;
                case 8:
                    carta.setImageResource(R.drawable.carta8);
                    break;
                case 9:
                    carta.setImageResource(R.drawable.carta9);
                    break;
                case 10:
                    carta.setImageResource(R.drawable.carta10);
                    break;
                case 11:
                    carta.setImageResource(R.drawable.carta11);
                    break;
            }
        }
    }
}
