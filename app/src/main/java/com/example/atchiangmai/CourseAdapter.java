package com.example.atchiangmai;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView titleTxt,ownerTxt,priceTxT;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt=itemView.findViewById(R.id.)
        }
    }

}
