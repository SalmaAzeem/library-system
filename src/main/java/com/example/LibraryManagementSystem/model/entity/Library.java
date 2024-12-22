package com.example.librarymanagementsystem.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Table(name="library")
@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @Column(name="name")
    private String name;
    @Column(name="location")
    private String location;
    //add booklist, userlist, currentborrowedlist
    public Library() {}

    public Integer getID() { return ID; }
    public void setID(Integer ID) { this.ID = ID; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
}
