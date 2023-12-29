package com.shoppinglist.backend.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "units")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shortcut;

    @ManyToMany(mappedBy = "unitsAllowed")
    private List<CatalogueItem> catalogueItems = new ArrayList<>();

    public Unit(String shortcut) {
        this.shortcut = shortcut;
    }

    public Unit() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public List<CatalogueItem> getCatalogueItems() {
        return catalogueItems;
    }

    public void setCatalogueItems(List<CatalogueItem> catalogueItems) {
        this.catalogueItems = catalogueItems;
    }
}
