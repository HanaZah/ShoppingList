package com.shoppinglist.backend.repositories;

import com.shoppinglist.backend.models.ListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListItemRepository extends JpaRepository<ListItem, Long> {
}
