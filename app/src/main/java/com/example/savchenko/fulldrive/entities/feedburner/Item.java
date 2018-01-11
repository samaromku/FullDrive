package com.example.savchenko.fulldrive.entities.feedburner;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.Date;

/**
 * Created by savchenko on 11.01.18.
 */

@Root(name = "item", strict = false)
public class Item {

    @Element(name = "title", required = true)
    private String title;
    @Element(name = "link", required = true)
    private String link;
    @Element(name = "description", required = true)
    private String description;
    @Element(name = "author", required = false)
    private String author;
//    @Element(name = "comments", required = false)
//    private String comments;
    @Element(name = "enclosure", required = false)
    private String enclosure;
    @Element(name = "guid", required = false)
    private String guid;
    @Element(name = "pubDate", required = false)
    private String pubDate;
    @Element(name = "source", required = false)
    private String source;
    private String imageUrl;
    private String text;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    public String getComments() {
//        return comments;
//    }

//    public void setComments(String comments) {
//        this.comments = comments;
//    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
//                    ", category='" + category + '\'' +
//                ", comments='" + comments + '\'' +
                ", enclosure='" + enclosure + '\'' +
                ", guid='" + guid + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}