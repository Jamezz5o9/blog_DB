package data.models;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
    private int id;
    private String body;
    private LocalDateTime date;
    private String title;
    private List<Comment> post;

    public List<Comment> getPost() {
        return post;
    }

    public void setPost(List<Comment> post) {
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}