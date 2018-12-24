package com.test.jdk8;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Article {
    private Integer id;
    private String title;
    private String author;
    private List<String> tags;
    private Date publishDate;

    public Article(Integer id, String title, String author, List<String> tags, Date publishDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.tags = tags;
        this.publishDate = publishDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishDate=" + sdf.format(publishDate) +
                '}';
    }
}
