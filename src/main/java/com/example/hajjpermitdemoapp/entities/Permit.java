package com.example.hajjpermitdemoapp.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="HAJ_PERMIT")
public class Permit {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PK_PERMIT_ID")
    private long id;

    @Column(name="START_DATE")
    private Date startDate;

    @Column(name="END_DATE")
    private Date endDate;

    @OneToOne
    @JoinColumn(name = "FK_USER_ID")
    private User user;

    public Permit() {
    }

    public Permit(User user) {
        this.startDate = new Date();
        this.endDate = new Date();
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Permit{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", user=" + user +
                '}';
    }
}
