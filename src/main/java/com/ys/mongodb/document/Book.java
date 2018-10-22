package com.ys.mongodb.document;

/**
 * @author HD
 * @date 2018/10/22 16:22
 */
public class Book {

    /**
     * 书名
     */ 
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 喜欢人数
     */
    private Integer likes;

    /**
     * 作者
     */
    private String author;

    /**
     * 名字
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book() {
    }

    public Book(String title, String description, Integer likes, String author) {

        this.title = title;
        this.description = description;
        this.likes = likes;
        this.author = author;
    }

    public Book(String title, String description, Integer likes, String author, String name) {

        this.title = title;
        this.description = description;
        this.likes = likes;
        this.author = author;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
