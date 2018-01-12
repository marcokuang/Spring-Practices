package org.marco.common.service.impl;

import org.marco.common.data.repository.InventoryItemRepository;
import org.marco.common.domain.Product;
import org.marco.common.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryItemRepository inventoryItemRepository;

    @Autowired
    public InventoryServiceImpl(InventoryItemRepository inventoryItemRepository){
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public Map<Product, Long> getTotalInventoryOnHand() {
        return null;
    }

    public long getQuantityOnHand(String itemId) {
        return 0;
    }

    public void adjustInventory(String itemId, long quantity) {

    }
}
