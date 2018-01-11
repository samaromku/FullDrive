package com.example.savchenko.fulldrive.network;



import com.example.savchenko.fulldrive.entities.Rss;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by savchenko on 11.01.18.
 */

public interface FeedBurnerService {
    @GET("/TechCrunch")
    Observable<Rss> getNews();
}
