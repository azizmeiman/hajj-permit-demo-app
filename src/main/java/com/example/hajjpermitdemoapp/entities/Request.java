package com.example.hajjpermitdemoapp.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="HAJ_PERMIT_REQUEST")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PK_REQUEST_ID")
    private long id;

    @Column(name="REQUEST_DATE")
    private Date requestDate;

    @Column(name="REQUEST_STATUS")
    private int status; // (Default) 0 not accepted or rejected, 1 accepted and 2 rejected

    @OneToOne
    @JoinColumn(name = "FK_USER_ID")
    private User user;

    public Request() {
    }

    public Request( User user) {
        this.requestDate = new Date();
        this.status = 0;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", requestDate=" + requestDate +
                ", status=" + status +
                ", user=" + user +
                '}';
    }
}
