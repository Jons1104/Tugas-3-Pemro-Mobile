package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPahlawan;
    private ArrayList<ModelPahlawan> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Mode Card View");

        rvPahlawan = findViewById(R.id.rv_pahlawan);
        rvPahlawan.setHasFixedSize(true);
        data.addAll(DataPahlawan.ambilDataPahlawan());
        tampilDataCard();
    }

    private void tampilDataCard() {
        rvPahlawan.setLayoutManager(new
                LinearLayoutManager(this));
        AdapterCard colokanCard = new AdapterCard(data);
        rvPahlawan.setAdapter(colokanCard);
    }

    private void tampilDataGrid() {
        rvPahlawan.setLayoutManager(new
                GridLayoutManager(this, 2));
        AdapterGrid colokanGrid = new AdapterGrid(data);
        rvPahlawan.setAdapter(colokanGrid);
        colokanGrid.setOnItemClickCallBack(new AdapterGrid.OnItemClickCallBack() {
            @Override
            public void onItemClicked(ModelPahlawan data) {
                Toast.makeText(MainActivity.this, "Pahlawan : " + data.getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tampilan,
                menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem
                                                 item) {
        ubahModeTampilan(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void ubahModeTampilan(int modeYangDipilih) {
        switch (modeYangDipilih) {
            case R.id.menu_card:
                getSupportActionBar().setTitle("Mode Card View");
                tampilDataCard();
                break;
            case R.id.menu_grid:
                getSupportActionBar().setTitle("Mode Grid View");
                        tampilDataGrid();
                break;
        }
    }
}