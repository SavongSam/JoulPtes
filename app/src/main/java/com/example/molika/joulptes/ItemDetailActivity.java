package com.example.molika.joulptes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ItemDetailActivity extends AppCompatActivity {

    public TextView mItemName, mItemDesc, mItemPhysicalAddress, mItemPrice;
    public ImageView mItemImage, mIteamMapImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptes_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_action_backward);

        mItemImage = (ImageView) findViewById(R.id.ptes_detail_img);
        mItemPrice = (TextView) findViewById(R.id.ptes_detail_price);
        mItemDesc = (TextView) findViewById(R.id.ptes_detail_description);
        mItemPhysicalAddress = (TextView) findViewById(R.id.ptes_detail_physical_address);
        mIteamMapImage = (ImageView) findViewById(R.id.ptes_detail_map_img);

        Intent intent = getIntent();
        String mImage = intent.getStringExtra("iImage");
        String mName = intent.getStringExtra("iName");
        Integer nPrice = intent.getIntExtra("iPrice", 0);
        String mDesc = intent.getStringExtra("iDesc");

        actionBar.setTitle(mName);

        Glide.with(this).load(mImage).into(mItemImage);
        mItemPrice.setText(String.format("%d", nPrice));
        mItemDesc.setText(mDesc);

        mIteamMapImage.setOnClickListener(new ImageMapClick());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void imageMapClicked() {
        Intent intent = new Intent(this, MapActivity.class);

        Double lat = 11.545024;
        Double lng = 104.926121;

        intent.putExtra("iLatitude", lat);
        intent.putExtra("iLongitude", lng);

        this.startActivity(intent);
    }

    public class ImageMapClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            imageMapClicked();
        }


    }

}
