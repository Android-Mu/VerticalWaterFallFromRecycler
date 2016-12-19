package com.example.mjj.verticalwaterfallfromrecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Description：RecyclerView适配器
 * <p>
 * Created by Mjj on 2016/12/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ListHolder> {

    Context context;
    int iconsV[] = {R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5, R.drawable.p6, R.drawable.p7, R.drawable.p9,
            R.drawable.p10, R.drawable.p11, R.drawable.p12, R.drawable.p13, R.drawable.p14, R.drawable.p15, R.drawable.p16, R.drawable.p17, R.drawable.p18, R.drawable.p19,
            R.drawable.p20, R.drawable.p21, R.drawable.p22, R.drawable.p23, R.drawable.p24, R.drawable.p25, R.drawable.p26, R.drawable.p27, R.drawable.p28, R.drawable.p29,
            R.drawable.p30, R.drawable.p31, R.drawable.p32, R.drawable.p33, R.drawable.p34, R.drawable.p35, R.drawable.p36, R.drawable.p37, R.drawable.p38, R.drawable.p39,
            R.drawable.p40, R.drawable.p41, R.drawable.p42, R.drawable.p43, R.drawable.p44};

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.staggered_grid_item, null);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    class ListHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;

        public ListHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.pic);
            name = (TextView) itemView.findViewById(R.id.name);
        }

        public void setData(int position) {
            icon.setImageResource(iconsV[position % iconsV.length]);
            name.setText("This is position " + position);
        }
    }

}
