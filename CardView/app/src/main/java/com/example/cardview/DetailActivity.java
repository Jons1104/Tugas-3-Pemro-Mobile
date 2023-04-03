package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private ImageView ivFoto;
    private TextView tvNama, tvTentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivFoto = findViewById(R.id.iv_foto);
        tvNama = findViewById(R.id.tv_nama);
        tvTentang = findViewById(R.id.tv_tentang);
        Intent terima = getIntent();
        String nama = terima.getStringExtra("varNama");
        String tentang = terima.getStringExtra("varTentang");
        String foto = terima.getStringExtra("varFoto");
        getSupportActionBar().setTitle(nama);

        tvNama.setText(nama);
        tvTentang.setText(tentang);
        Glide.with(DetailActivity.this)
                .load(foto)
                .into(ivFoto);
    }
}