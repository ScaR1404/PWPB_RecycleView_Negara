package com.scar.tugasrecycleview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvSepatu;
    private ArrayList<Negara> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSepatu = findViewById(R.id.rv_negara);
        rvSepatu.setHasFixedSize(true);

        list.addAll(NegaraData.getListData());
        showRecyclerList();
    }
    private void showRecyclerList(){
        rvSepatu.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(list);
        rvSepatu.setAdapter(listAdapter);
    }


    private void showRecyclerCardView(){
        rvSepatu.setLayoutManager(new LinearLayoutManager(this));
        CardViewAdapter cardViewAdapter= new CardViewAdapter(list);
        rvSepatu.setAdapter(cardViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        setMode(item.getItemId());
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    private void setMode(int selectedMode){
        switch (selectedMode){
            case R.id.action_list:
                showRecyclerList();
                break;
            case R.id.action_cardview:
                showRecyclerCardView();
                break;
        }
    }
}
