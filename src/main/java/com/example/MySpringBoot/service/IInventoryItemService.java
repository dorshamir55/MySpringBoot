package com.example.MySpringBoot.service;

import com.example.MySpringBoot.model.InventoryItem;

import java.util.List;

public interface IInventoryItemService {
    InventoryItem addInventoryItem(InventoryItem inventoryItem);
    InventoryItem updateInventoryItem(InventoryItem inventoryItem);
    List<InventoryItem> getAllInventoryItems();
    InventoryItem getInventoryItemById(long inventoryItemId);
//    InventoryItem depositQuantityOfInventoryItem(long depositQuantity, InventoryItem inventoryItem);
    void deleteInventoryItem(long inventoryItemId);
}
