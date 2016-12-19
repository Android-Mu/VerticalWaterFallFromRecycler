package com.example.mjj.verticalwaterfallfromrecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Description：使用RecyclerView+CardView实现竖向的瀑布流效果
 * <p>
 * Created by Mjj on 2016/12/18.
 */

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private StaggeredGridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn_veretical);
        btn2 = (Button) findViewById(R.id.btn_horizontal);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_main);

        layoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(MainActivity.this, true);
        recyclerView.setAdapter(adapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
                adapter = new RecyclerViewAdapter(MainActivity.this, true);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(layoutManager);
                adapter = new RecyclerViewAdapter(MainActivity.this, false);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });

        //调用方法,传入一个接口回调
        adapter.setItemClickListener(new RecyclerViewAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
