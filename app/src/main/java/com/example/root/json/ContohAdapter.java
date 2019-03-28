package com.example.root.json;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ContohAdapter extends RecyclerView.Adapter<ContohAdapter.ContohViewHolder> {
    private Context mContex;
    private ArrayList<ContohItem> mContohItemList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public ContohAdapter(Context context, ArrayList<ContohItem> contohList) {
        mContex = context;
        mContohItemList = contohList;
    }

    @NonNull
    @Override
    public ContohViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContex).inflate(R.layout.item, parent, false);
        return new ContohViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContohViewHolder holder, int position) {
        ContohItem currentItem = mContohItemList.get(position);

        String imageUrl = currentItem.getmImageUrl();
        String creatorName = currentItem.getmCreator();
        int likeCount = currentItem.getmLikes();

        holder.mTextViewCreator.setText(creatorName);
        holder.mTextViewLikes.setText("likes " + likeCount);
        Picasso.with(mContex).load(imageUrl).fit().centerInside().into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mContohItemList.size();
    }

    public class ContohViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewCreator;
        public TextView mTextViewLikes;

        public ContohViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes = itemView.findViewById(R.id.text_view_likes);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
