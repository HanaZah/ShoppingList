package com.shoppinglist.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class ListItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CatalogueItem item;

    private String unit;

    private double amount;

    private boolean resolved = false;

    private boolean deleted = false;

    public ListItem(CatalogueItem item, String unit, double amount) {
        this.item = item;
        this.unit = unit;
        this.amount = amount;
    }

    public ListItem() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public CatalogueItem getItem() {
        return item;
    }

    public void setItem(CatalogueItem item) {
        this.item = item;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
