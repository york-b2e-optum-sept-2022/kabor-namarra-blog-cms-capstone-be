package net.yorksolutions.kabornamarrablogcmscapstone.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String body;

    private Date createdDate;

    private Date updatedDate;

    @ManyToOne
    private Account author;

    @ElementCollection
    private Set<Long> viewerID;

    public Blog() {
    }

    public Blog(String title, String body, Date createdDate, Account author) {
        this.title = title;
        this.body = body;
        this.createdDate = createdDate;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }

    public Set<Long> getViewerID() {
        return viewerID;
    }

    public void setViewerID(Set<Long> viewerID) {
        this.viewerID = viewerID;
    }
}
