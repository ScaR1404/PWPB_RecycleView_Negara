package com.scar.tugasrecycleview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;



public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder>{
    private ArrayList<Negara> listNegara;

    public  ListAdapter (ArrayList<Negara> list){
        this.listNegara= list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Negara negara = listNegara.get(position);

        Glide.with(holder.itemView.getContext()).load(negara.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(negara.getName());
        holder.tvDeskripsi.setText(negara.getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return listNegara.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDeskripsi;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName =  itemView.findViewById(R.id.tv_item_name);
            tvDeskripsi=  itemView.findViewById(R.id.tv_item_deskripsi);
        }
    }
}
