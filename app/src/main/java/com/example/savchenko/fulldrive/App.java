package com.example.savchenko.fulldrive;

import android.app.Application;

import com.example.savchenko.fulldrive.di.ComponentManager;

/**
 * Created by savchenko on 10.01.18.
 */

public class App extends Application {
    private static ComponentManager componentManager;

    public static ComponentManager getComponentManager() {
        return componentManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        componentManager = new ComponentManager();
        componentManager.init();
    }
}
