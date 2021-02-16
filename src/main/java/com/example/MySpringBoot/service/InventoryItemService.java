package com.example.MySpringBoot.service;

import com.example.MySpringBoot.exception.ResourceNotFoundException;
import com.example.MySpringBoot.exception.ValueOutOfRangeException;
import com.example.MySpringBoot.model.InventoryItem;
import com.example.MySpringBoot.repository.IInventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InventoryItemService implements IInventoryItemService {

    @Autowired
    public IInventoryItemRepository repository;

    @Override
    public List<InventoryItem> getAllInventoryItems() {
        return repository.findAll();
    }

    @Override
    public InventoryItem getInventoryItemById(long id) {

        Optional<InventoryItem> inventoryItemDb = repository.findById(id);

        if(inventoryItemDb.isPresent()) {
            return inventoryItemDb.get();
        } else {
            throw new ResourceNotFoundException(id);
        }
    }

    @Override
    public InventoryItem addInventoryItem(InventoryItem inventoryItem) {
        if(inventoryItem.getAmount()>=0) {
            return repository.save(inventoryItem);
        } else {
            throw new ValueOutOfRangeException();
        }
    }

    @Override
    public InventoryItem updateInventoryItem(InventoryItem inventoryItem) {
        Optional<InventoryItem> inventoryItemDb = repository.findById(inventoryItem.getItemNo());

        if(inventoryItemDb.isPresent()) {
            InventoryItem inventoryItemUpdate = inventoryItemDb.get();

            if(inventoryItem.getAmount() >= 0) {
                inventoryItemUpdate.setName(inventoryItem.getName());
                inventoryItemUpdate.setAmount(inventoryItem.getAmount());
                inventoryItemUpdate.setInventoryCode(inventoryItem.getInventoryCode());
                repository.save(inventoryItemUpdate);

                return inventoryItemUpdate;
            }
            else {
                throw new ValueOutOfRangeException();
            }
        } else {
            throw new ResourceNotFoundException(inventoryItem.getItemNo());
        }
    }

//    @Override
//    public InventoryItem depositQuantityOfInventoryItem(long depositQuantity, InventoryItem inventoryItem) {
//        Optional<InventoryItem> inventoryItemDb = repository.findById(inventoryItem.getItemNo());
//
//        if(inventoryItemDb.isPresent()) {
//            InventoryItem inventoryItemUpdate = inventoryItemDb.get();
//
//            if(!inventoryItem.getName().equals(null))
//                inventoryItemUpdate.setName(inventoryItem.getName());
//            if(!inventoryItem.getInventoryCode().equals(null))
//                inventoryItemUpdate.setInventoryCode(inventoryItem.getInventoryCode());
//
//            long amount = inventoryItemUpdate.getAmount()+inventoryItem.getAmount();
//            inventoryItemUpdate.setAmount(amount);
//
//            repository.save(inventoryItemUpdate);
//            return inventoryItemUpdate;
//        } else {
//            throw new ResourceNotFoundException("Inventory item not found with id: "+inventoryItem.getItemNo());
//        }
//    }

    @Override
    public void deleteInventoryItem(long id) {

        Optional<InventoryItem> inventoryItemDb = repository.findById(id);

        if(inventoryItemDb.isPresent()) {
            repository.delete(inventoryItemDb.get());
        } else {
            throw new ResourceNotFoundException(id);
        }
    }
}
