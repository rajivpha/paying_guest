package com.assignment.payingguest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.assignment.payingguest.R;
import com.assignment.payingguest.model.HotelModel;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {
List<HotelModel> hotelModelList;
Context context;

    public HotelAdapter(List<HotelModel> hotelModelList, Context context) {
        this.hotelModelList = hotelModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemrows,
                viewGroup,false);

        return new HotelViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder hotelViewHolder, int i) {

        final HotelModel hotelModel =hotelModelList.get(i);
        hotelViewHolder.name.setText(hotelModelList.get(i).getName());
        hotelViewHolder.imageView.setImageResource(hotelModelList.get(i).getImage());
        hotelViewHolder.price.setText(hotelModelList.get(i).getPrice());
        hotelViewHolder.rating.setText(hotelModelList.get(i).getRating());
        hotelViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, hotelModel.getName(), Toast.LENGTH_LONG).show();
            }
            });
    }

    @Override
    public int getItemCount() {
        return hotelModelList.size();
    }

    public  class HotelViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView name, price, rating;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
            rating=itemView.findViewById(R.id.rating);
        }
    }

}

