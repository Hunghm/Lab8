package com.example.lab8.mediaPlayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.lab8.MainActivity;
import com.example.lab8.Music;
import com.example.lab8.R;
import com.example.lab8.model.ListMusicModle;

import java.util.ArrayList;
import java.util.List;

public class ListMusic extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Music> listMusic = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_music);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_list_music);

        listMusic.add(new Music("Từ bỏ","ERIK",R.raw.tu_bo));
        listMusic.add(new Music("Tự tâm","ERIK",R.raw.tu_tam));
        listMusic.add(new Music("Trong trí nhớ của anh","ERIK",R.raw.trong_tri_nho_cua_anh));
        listMusic.add(new Music("Đừng xin lỗi nữa","ERIK",R.raw.dung_xin_loi_nua));

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(ListMusic.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ListMusicModle adapter =new ListMusicModle(this, listMusic);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new ListMusicModle.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent( ListMusic.this, MainActivity2.class);
                intent.putExtra("parth",listMusic.get(position).getParth());
                startActivity(intent);
            }
        });
    }
}