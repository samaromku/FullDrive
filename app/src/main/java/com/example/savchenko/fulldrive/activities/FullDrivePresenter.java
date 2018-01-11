package com.example.savchenko.fulldrive.activities;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FullDrivePresenter {
    private static final String TAG = FullDrivePresenter.class.getSimpleName();
    private FullDriveView view;
    private FullDriveInterActor interActor;

    public FullDrivePresenter(FullDriveView view, FullDriveInterActor interActor) {
        this.view = view;
        this.interActor = interActor;
    }

    void getNews() {
        interActor.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> view.setListToAdapter(list), Throwable::printStackTrace);
    }

    void getFeedNews(){
        interActor.getNewsFeed()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> view.setListToAdapter(list), Throwable::printStackTrace);
    }
}
