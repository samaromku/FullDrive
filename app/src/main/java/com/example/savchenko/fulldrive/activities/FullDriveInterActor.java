package com.example.savchenko.fulldrive.activities;

import com.example.savchenko.fulldrive.entities.feedburner.Rss;
import com.example.savchenko.fulldrive.entities.lifehacker.Item;
import com.example.savchenko.fulldrive.network.FeedBurnerService;
import com.example.savchenko.fulldrive.network.LifeHackerService;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import io.reactivex.Observable;

public class FullDriveInterActor {
    private static final String TAG = FullDriveInterActor.class.getSimpleName();
    private LifeHackerService lifeHackerService;
    private FeedBurnerService feedBurnerService;

    public FullDriveInterActor(LifeHackerService techService, FeedBurnerService feedBurnerService) {
        this.lifeHackerService = techService;
        this.feedBurnerService = feedBurnerService;
    }

    Observable<List<Item>> getNews() {
        return lifeHackerService.getNews()
                .map(rss -> {
                    for (Item item : rss.getChannel().itemList) {
                        String[] parts = item.getDescription().split("<img src=\"");
                        if (parts.length > 1) {
                            //есть картинка
                            String partStartImage = parts[1];
                            item.setImageUrl(partStartImage.substring(0, partStartImage.indexOf("\" />")));
                            item.setText(partStartImage.substring(partStartImage.indexOf("\" />")+4, partStartImage.length()));
                        } else {
                            //новость без картинки
                            item.setText(parts[0]);
                        }
                        String cut = item.getPubDate().substring(4, item.getPubDate().length()-3);
                        SimpleDateFormat sp = new SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.US);
                        sp.setTimeZone(TimeZone.getTimeZone("GMT"));
                        item.setDate(sp.parse(cut));
                    }
                    return rss.getChannel().itemList;
                })
                .map(items -> {
                    Collections.sort(items, (item, t1) -> item.getDate().compareTo(t1.getDate()));
                    return items;
                });
    }

    Observable<Rss>getNewsFeed(){
        return feedBurnerService.getNews();
    }
}
