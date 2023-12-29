package com.shoppinglist.backend.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "catalogue")
public class CatalogueItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany
    private List<Unit> unitsAllowed = new ArrayList<>();

    private boolean deleted = false;

    public CatalogueItem(String name, List<Unit> unitsAllowed) {
        this.name = name;
        this.unitsAllowed = unitsAllowed;
    }

    public CatalogueItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JoinTable(
            name = "catalogue_unit",
            joinColumns = @JoinColumn(name = "catalogue_item_id"),
            inverseJoinColumns = @JoinColumn(name = "unit_id")
    )
    public List<Unit> getUnitsAllowed() {
        return unitsAllowed;
    }

    public void setUnitsAllowed(List<Unit> unitsAllowed) {
        this.unitsAllowed = unitsAllowed;
    }

    public void addUnitAllowed(Unit unit) {
        if(!unitsAllowed.contains(unit)) {
            unitsAllowed.add(unit);
        }
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
