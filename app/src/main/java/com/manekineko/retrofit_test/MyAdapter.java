package com.manekineko.retrofit_test;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
//import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private final static int TYPE1 = 0;

    public interface OnClickListener {
        void click(Info info);
        void insert();
        void delete();
    }

    public class MyViewHolder0 extends RecyclerView.ViewHolder {
        TextView tvPostId;
        TextView tvId;
        TextView tvTitle;
        TextView tvBody;

        // ArrayList<Info> al = new ArrayList<Info>();

        MyViewHolder0(View view){
            super(view);
            tvPostId = view.findViewById(R.id.tv_postid);
            tvId = view.findViewById(R.id.tv_id);
            tvTitle = view.findViewById(R.id.tv_title);
            tvBody = view.findViewById(R.id.tv_body);
        }

        void bind(final Info info) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.click(info);
                }
            });
        }

    }


    public int getItemViewType(int position) {
        return infoArrayList.get(position).type; //position의 type를 빼오는 것
    }

    private ArrayList<Info> infoArrayList;
    private OnClickListener listener;

    MyAdapter(OnClickListener listener) {
        this.listener = listener;
        this.infoArrayList = new ArrayList<>();
    }

    public void update(Info InfoArrayList) {
        this.infoArrayList.add(InfoArrayList);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        switch(viewType) {
//            case Info.TYPE1:
//                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);
//                return new MyViewHolder0(view);
//            case Info.TYPE2:
//            default:
//                View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row2,parent,false);
//                return new MyViewHolder2(view2);
//        }
       // if(viewType == Info.TYPE1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row, parent, false);
                return new MyViewHolder0(view);
        //}
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        //***********************************************************************************************************************************
        switch(getItemViewType(position)) {
            case Info.TYPE1:
                Info info = infoArrayList.get(position);
                MyViewHolder0 myViewHolder0 = (MyViewHolder0) holder;
                myViewHolder0.bind(info);

                myViewHolder0.tvPostId.setText(infoArrayList.get(position).postId+"");
                myViewHolder0.tvId.setText(infoArrayList.get(position).id+"");
                myViewHolder0.tvTitle.setText(infoArrayList.get(position).title);
                myViewHolder0.tvBody.setText(infoArrayList.get(position).body);
                break;
//            case Info.TYPE2:
//                Info info2 = infoArrayList.get(position);
//                MyViewHolder2 myViewHolder2 = (MyViewHolder2) holder;
//                myViewHolder2.bind(info2);
//                myViewHolder2.ivPicture.setImageResource(infoArrayList.get(position).drawableId);
//                myViewHolder2.tvName.setText(infoArrayList.get(position).name);
//                myViewHolder2.tvNumber.setText(infoArrayList.get(position).number);

        }
    }

    @Override
    public int getItemCount() {
        return infoArrayList.size();
    }
}
