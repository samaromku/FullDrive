package com.example.savchenko.fulldrive.entities;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (title != null ? !title.equals(item.title) : item.title != null) return false;
        if (link != null ? !link.equals(item.link) : item.link != null) return false;
        if (description != null ? !description.equals(item.description) : item.description != null)
            return false;
        if (author != null ? !author.equals(item.author) : item.author != null) return false;
        if (enclosure != null ? !enclosure.equals(item.enclosure) : item.enclosure != null)
            return false;
        if (guid != null ? !guid.equals(item.guid) : item.guid != null) return false;
        if (pubDate != null ? !pubDate.equals(item.pubDate) : item.pubDate != null) return false;
        if (source != null ? !source.equals(item.source) : item.source != null) return false;
        if (imageUrl != null ? !imageUrl.equals(item.imageUrl) : item.imageUrl != null)
            return false;
        if (text != null ? !text.equals(item.text) : item.text != null) return false;
        return date != null ? date.equals(item.date) : item.date == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (enclosure != null ? enclosure.hashCode() : 0);
        result = 31 * result + (guid != null ? guid.hashCode() : 0);
        result = 31 * result + (pubDate != null ? pubDate.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}