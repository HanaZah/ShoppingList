package com.shoppinglist.backend.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @OneToMany
    private List<ShoppingList> listsCreated =  new ArrayList<>();

    private boolean deleted = false;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ShoppingList> getListsCreated() {
        return listsCreated;
    }

    public void setListsCreated(List<ShoppingList> listsCreated) {
        this.listsCreated = listsCreated;
    }

    public void addListCreated(ShoppingList newList) {
        if(!listsCreated.contains(newList)) {
            listsCreated.add(newList);
        }
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
