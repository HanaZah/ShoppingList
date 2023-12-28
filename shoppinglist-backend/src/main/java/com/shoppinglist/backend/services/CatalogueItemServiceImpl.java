package com.shoppinglist.backend.services;

import com.shoppinglist.backend.repositories.CatalogueItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogueItemServiceImpl implements CatalogueItemService{

    private final CatalogueItemRepository catalogueRepository;

    @Autowired
    public CatalogueItemServiceImpl(CatalogueItemRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }
}
