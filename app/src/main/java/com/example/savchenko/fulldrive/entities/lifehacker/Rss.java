package com.example.savchenko.fulldrive.entities.lifehacker;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by savchenko on 11.01.18.
 */
@Root
public class Rss {

    @Attribute
    private String version;

    @Element
    private Channel channel;


    public Channel getChannel() {
        return channel;
    }

    @Override
    public String toString() {
        return "RSS{" +
                "version='" + version + '\'' +
                ", channel=" + channel +
                '}';
    }
}