package com.example.projetv2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RcycleViewAdapter extends RecyclerView.Adapter <RcycleViewAdapter.MyViewHolder>{


    ArrayList<Activite> Activites =new ArrayList<>();

    public RcycleViewAdapter(ArrayList<Activite> Activites) {
        this.Activites = Activites;
    }

    @NonNull
    @Override
    //cette methode va etre apple seulement au premier fois fach ghancreyiw hadok l holders b 9
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item,null,false);
        MyViewHolder myViewHolder=new MyViewHolder(v);
        return myViewHolder;//ce view holder et preni par la methode onbindviewholder
    }

    //hai bach t affecter l values l holdeer li tcreya;
    // lvalues kaynin f array list
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Activite c= Activites.get(position);
        holder.iv_image.setImageResource(c.getImg());
        holder.tv_name.setText(c.getNom());
        holder.tv_description.setText(c.getDesc());
    }

    @Override
    public int getItemCount() {
        return Activites.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        ImageView iv_image;
        TextView tv_description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.custom_tv);
            iv_image=itemView.findViewById(R.id.custom_iv);
            tv_description=itemView.findViewById(R.id.description);
        }
    }
}
