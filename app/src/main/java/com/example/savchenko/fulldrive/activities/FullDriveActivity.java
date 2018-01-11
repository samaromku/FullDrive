package com.example.savchenko.fulldrive.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.savchenko.fulldrive.App;
import com.example.savchenko.fulldrive.R;
import com.example.savchenko.fulldrive.activities.adapter.NewsAdapter;
import com.example.savchenko.fulldrive.activities.di.FullDriveComponent;
import com.example.savchenko.fulldrive.activities.di.FullDriveModule;
import com.example.savchenko.fulldrive.entities.lifehacker.Item;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FullDriveActivity extends AppCompatActivity implements FullDriveView {
    private static final String TAG = FullDriveActivity.class.getSimpleName();
    @Inject
    FullDrivePresenter presenter;

    @BindView(R.id.rvNews)
    RecyclerView rvNews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_drive);
        ((FullDriveComponent) App.getComponentManager()
                .getPresenterComponent(getClass(), new FullDriveModule(this))).inject(this);
        ButterKnife.bind(this);
        presenter.getNews();
        presenter.getFeedNews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getComponentManager().releaseComponent(getClass());
        }
    }

    @Override
    public void setListToAdapter(List<Item> listToAdapter) {
        NewsAdapter adapter = new NewsAdapter(this);
        adapter.setDataList(listToAdapter);
        adapter.setClickListener(position -> {
            String url = listToAdapter.get(position).getLink();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        rvNews.setLayoutManager(new LinearLayoutManager(this));
        rvNews.setAdapter(adapter);
    }
}
