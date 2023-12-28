package com.shoppinglist.backend.repositories;

import com.shoppinglist.backend.models.CatalogueItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogueItemRepository extends JpaRepository<CatalogueItem, Long> {
}
