package com.example.molika.joulptes;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Locale;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder>{

    private ArrayList<Item> mItemsDataSet;
    private Context mContext;
    private RequestOptions option;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ItemClickListener itemClickListener;

        public ImageView mItemImage;
        public TextView mItemName;
        public TextView mItemPrice;
        public TextView mItemReviewsNum;

        public ViewHolder(View itemView) {
            super(itemView);
            this.mItemImage = (ImageView) itemView.findViewById(R.id.ptes_img_cover);
            this.mItemName = (TextView) itemView.findViewById(R.id.ptes_name_cover);
            this.mItemPrice = (TextView) itemView.findViewById(R.id.ptes_price_cover);
            this.mItemReviewsNum = (TextView) itemView.findViewById(R.id.ptes_reviews_num);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(v , getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener itemClick) {
            this.itemClickListener = itemClick;
        }
    }

    public ItemsAdapter(Context mContext, ArrayList<Item> itemsDataSet) {
        this.mContext = mContext;
        this.mItemsDataSet = itemsDataSet;
        //Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.img_place_holder).error(R.drawable.img_place_holder);
    }


    @NonNull
    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vh = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_ptes_cardview_item, null);

        return new ViewHolder(vh);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ViewHolder holder, int position) {
        Item p = mItemsDataSet.get(position);

        //bind data to the view
        Glide.with(mContext).load(p.getItemImage()).apply(option).into(holder.mItemImage);
        holder.mItemImage.setImageURI(Uri.parse(p.getItemImage()));
        holder.mItemName.setText(p.getItemName());
        holder.mItemPrice.setText(String.format(Locale.US,"%d$", p.getItemPrice()));
        holder.mItemReviewsNum.setText(String.format(Locale.US,"%d $", p.getItemReviewsNum()));

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                String itemImage = mItemsDataSet.get(position).getItemImage();
                String itemName = mItemsDataSet.get(position).getItemName();
                Integer itemPrice = mItemsDataSet.get(position).getItemPrice();
                String itemDesc = mItemsDataSet.get(position).getItemDesc();

                Intent intent = new Intent(mContext, ItemDetailActivity.class);

                intent.putExtra("iImage", itemImage);
                intent.putExtra("iName", itemName);
                intent.putExtra("iPrice", itemPrice);
                intent.putExtra("iDesc", itemDesc);

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemsDataSet.size();
    }
}
