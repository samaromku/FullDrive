package com.example.savchenko.fulldrive.di;

import com.example.savchenko.fulldrive.activities.FullDriveActivity;
import com.example.savchenko.fulldrive.activities.di.FullDriveComponent;
import com.example.savchenko.fulldrive.di.base.ComponentBuilder;
import com.example.savchenko.fulldrive.network.FeedBurnerService;
import com.example.savchenko.fulldrive.network.LifeHackerService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Andrey on 06.10.2017.
 */
@Module(subcomponents = {
    FullDriveComponent.class
})
class AppModule {
    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String TECH_CRUNCH = "http://feeds.feedburner.com";
    private static final String LIFE_HACKER = "http://lifehacker.com";

    @Provides
    @IntoMap
    @ClassKey(FullDriveActivity.class)
    ComponentBuilder provideFullDrive(FullDriveComponent.Builder builder){
        return builder;
    }

    @Singleton
    @Provides
    LifeHackerService lifeHackerService(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        return new Retrofit.Builder()
                .baseUrl(LIFE_HACKER)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
                .create(LifeHackerService.class);
    }

    @Singleton
    @Provides
    FeedBurnerService feedBurnerService(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        return new Retrofit.Builder()
                .baseUrl(TECH_CRUNCH)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
                .create(FeedBurnerService.class);
    }
}
