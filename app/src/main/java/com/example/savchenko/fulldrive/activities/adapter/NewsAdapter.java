package com.example.savchenko.fulldrive.activities.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.savchenko.fulldrive.R;
import com.example.savchenko.fulldrive.base.BaseAdapter;
import com.example.savchenko.fulldrive.base.BaseViewHolder;
import com.example.savchenko.fulldrive.entities.Item;
import com.example.savchenko.fulldrive.interfaces.OnItemClickListener;
import com.example.savchenko.fulldrive.view.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter extends BaseAdapter<Item> {
    private Context context;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    public void addNews(List<Item>items){
        this.dataList.addAll(items);
        Collections.sort(items, (item, t1) -> item.getDate().compareTo(t1.getDate()));
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder<Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    class NewsViewHolder extends BaseViewHolder<Item> {
        @BindView(R.id.ivImage)ImageView ivImage;
        @BindView(R.id.tvTitle)TextView tvTitle;
        @BindView(R.id.tvText)TextView tvText;

        NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bind(Item item, OnItemClickListener clickListener) {
            super.bind(item, clickListener);
            tvTitle.setText(item.getTitle());
            tvText.setText(Html.fromHtml(item.getText()));
            if(item.getImageUrl()!=null) {
                ivImage.setVisibility(View.VISIBLE);
                Picasso.with(context)
                        .load(item.getImageUrl())
                        .transform(new CircleTransform())
                        .into(ivImage);
            }else {
                ivImage.setVisibility(View.GONE);
            }
        }
    }
}
