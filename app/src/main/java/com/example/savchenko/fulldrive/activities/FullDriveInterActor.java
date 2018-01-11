package com.example.savchenko.fulldrive.activities;

import android.util.Log;

import com.example.savchenko.fulldrive.entities.Item;
import com.example.savchenko.fulldrive.entities.Rss;
import com.example.savchenko.fulldrive.network.FeedBurnerService;
import com.example.savchenko.fulldrive.network.LifeHackerService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

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
                .debounce(1000, TimeUnit.MILLISECONDS)
                .map(rss -> {
                    for (Item item : rss.getChannel().itemList) {
                        String[] parts = item.getDescription().split("<img src=\"");
                        if (parts.length > 1) {
                            //есть картинка
                            String partStartImage = parts[1];
                            item.setImageUrl(partStartImage.substring(0, partStartImage.indexOf("\" />")));
                            item.setText(partStartImage.substring(partStartImage.indexOf("\" />") + 4, partStartImage.length()));
                        } else {
                            //новость без картинки
                            item.setText(parts[0]);
                        }
                        item.setDate(parseDateFromData(item));
                    }
                    return rss.getChannel().itemList;
                });
    }

    private Date parseDateFromData(Item item) throws ParseException {
        String cut = item.getPubDate().substring(4, item.getPubDate().length() - 3);
        SimpleDateFormat sp = new SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.US);
        sp.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sp.parse(cut);
    }

    Observable<List<Item>> getNewsFeed() {
        return feedBurnerService.getNews()
                .debounce(1500, TimeUnit.MILLISECONDS)
                .map(rss -> {
                    for (Item item : rss.getChannel().itemList) {
                        String desc = item.getDescription();
                        if (desc.indexOf(" class=\"attachment-large size-large wp-post-image\"") > 0) {
                            String imagePath = desc.substring(
                                    desc.indexOf(" src=\"") + 6,
                                    desc.indexOf(" class=\"attachment-large size-large wp-post-image\"") - 1);
                            String cutDesc = desc.substring(desc.indexOf(" />") +4, desc.length());
                            item.setText(cutDesc);
                            item.setImageUrl(imagePath);
                        }else {
                            item.setText(desc);
                        }
                    item.setDate(parseDateFromData(item));
                    }
                    return rss.getChannel().itemList;
                });
    }
}
