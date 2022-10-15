package com.example.eventhandler;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventhandler.adapter.KontakAdapter;
import com.example.eventhandler.model.Kontak;

import java.util.ArrayList;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    KontakAdapter kontakRecyclerAdapter;
    ArrayList<Kontak> _kontakList;
    Button _btAddData;
    int[] foto  = {R.drawable.ava_boy, R.drawable.ava_man, R.drawable.ava_woman};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_item);

        _btAddData = findViewById(R.id.btAddDT);
        _btAddData.setOnClickListener(this);

        
        loadData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.rv_kontak);
        kontakRecyclerAdapter = new KontakAdapter(_kontakList, this);
        recyclerView.setAdapter(kontakRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void addData(){
        Random random = new Random();
        int choose = random.nextInt(4);
        _kontakList.add(new Kontak("newData "+(_kontakList.size()-1), "0823409876"+(_kontakList.size()-1), foto[choose]));
    }

    private void loadData() {
        _kontakList = new ArrayList<>();
        _kontakList.add(new Kontak("Helga", "085123456", foto[2]));
        _kontakList.add(new Kontak("Khalish", "0857213457", foto[1]));
        _kontakList.add(new Kontak("Nauval", "0812345677", foto[0]));
    }


    @Override
    public void onClick(View view) {
        if (view.getId()==_btAddData.getId()){
            addData();
            kontakRecyclerAdapter.notifyDataSetChanged();
        }
    }
}
