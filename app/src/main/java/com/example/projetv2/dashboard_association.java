package com.example.projetv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class dashboard_association extends AppCompatActivity {
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_association);
        rv=findViewById(R.id.rv_main);
        ArrayList<Activite> Activites=new ArrayList<>();
        Activites.add(new Activite(R.drawable.convoi_cindh,"12/12/2020","Convoi cindh","date","status"));
        Activites.add(new Activite(R.drawable.convoi_cindh,"12/12/2020","Convoi cindh","date","status"));
        Activites.add(new Activite(R.drawable.convoi_cindh,"12/12/2020","Convoi cindh","date","status"));
        Activites.add(new Activite(R.drawable.convoi_cindh,"12/12/2020","Convoi cindh","date","status"));
        Activites.add(new Activite(R.drawable.convoi_cindh,"12/12/2020","Convoi cindh","date","status"));
        Activites.add(new Activite(R.drawable.convoi_cindh,"12/12/2020","Convoi cindh","date","status"));

        RcycleViewAdapter rcycleViewAdapter=new RcycleViewAdapter(Activites);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(rcycleViewAdapter);
    }
}