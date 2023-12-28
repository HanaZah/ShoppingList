package com.shoppinglist.backend.services;

import com.shoppinglist.backend.repositories.ListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListItemServiceImpl implements ListItemService{

    private final ListItemRepository itemRepository;

    @Autowired
    public ListItemServiceImpl(ListItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
}
