package com.example.savchenko.fulldrive.activities.di;

import dagger.Subcomponent;

import com.example.savchenko.fulldrive.di.base.ComponentBuilder;
import com.example.savchenko.fulldrive.di.base.BaseComponent;
import com.example.savchenko.fulldrive.activities.FullDriveActivity;

@Subcomponent(modules = FullDriveModule.class)
@FullDriveScope
public interface FullDriveComponent extends BaseComponent<FullDriveActivity> {
    @Subcomponent.Builder
    interface Builder extends ComponentBuilder<FullDriveComponent, FullDriveModule> {
    }
}
