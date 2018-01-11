package com.example.savchenko.fulldrive.activities.di;

import dagger.Module;
import dagger.Provides;

import com.example.savchenko.fulldrive.di.base.BaseModule;
import com.example.savchenko.fulldrive.activities.FullDriveView;
import com.example.savchenko.fulldrive.activities.FullDrivePresenter;
import com.example.savchenko.fulldrive.activities.FullDriveInterActor;
import com.example.savchenko.fulldrive.network.FeedBurnerService;
import com.example.savchenko.fulldrive.network.LifeHackerService;

@Module
public class FullDriveModule implements BaseModule {
    private FullDriveView view;

    public FullDriveModule(FullDriveView view) {
        this.view = view;
    }

    @FullDriveScope
    @Provides
    public FullDrivePresenter presenter(FullDriveInterActor interActor) {
        return new FullDrivePresenter(view, interActor);
    }

    @FullDriveScope
    @Provides
    FullDriveInterActor interActor(LifeHackerService techService, FeedBurnerService feedBurnerService) {
        return new FullDriveInterActor(techService, feedBurnerService);
    }
}

