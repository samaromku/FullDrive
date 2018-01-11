package com.example.savchenko.fulldrive.network;

import com.example.savchenko.fulldrive.entities.Rss;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by savchenko on 10.01.18.
 */

public interface LifeHackerService {
    @GET("/rss")
    Observable<Rss>getNews();
}
