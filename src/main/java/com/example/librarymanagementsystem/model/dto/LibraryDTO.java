package com.example.librarymanagementsystem.model.dto;

import com.example.librarymanagementsystem.model.entity.Library;

public class LibraryDTO {
    private Integer ID;
    private String name;
    private String location;

    public LibraryDTO() {}
    public LibraryDTO(Integer ID, String name, String location) {
        this.ID = ID;
        this.name = name;
        this.location = location;
    }
    public static LibraryDTO toDto(Library entity) {
        return new LibraryDTO(entity.getID(), entity.getName(), entity.getLocation());
    }
    public Integer getID() { return ID; }
    public void setID(Integer ID) { this.ID = ID; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
}
