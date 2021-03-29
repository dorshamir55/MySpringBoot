package com.example.MySpringBoot.controller;

import com.example.MySpringBoot.exception.ValueOutOfRangeException;
import com.example.MySpringBoot.model.InventoryItem;
import com.example.MySpringBoot.service.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/")
public class InventoryItemController {

    @Autowired
    InventoryItemService service;

    @GetMapping("/items")
    public ResponseEntity<List<InventoryItem>> getAllInventoryItems() {
        return ResponseEntity.ok().body(service.getAllInventoryItems());
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<InventoryItem> getInventoryItemById(@PathVariable long id) {
        return ResponseEntity.ok().body(service.getInventoryItemById(id));
    }

    @PostMapping("/items")
    public ResponseEntity<InventoryItem> addInventoryItem(@RequestBody InventoryItem inventoryItem) {
        return ResponseEntity.ok().body(service.addInventoryItem(inventoryItem));
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<InventoryItem> updateInventoryItem(@PathVariable long id,@RequestBody InventoryItem inventoryItem) {
        inventoryItem.setItemNo(id);
        return ResponseEntity.ok().body(service.updateInventoryItem(inventoryItem));
    }

//    @PutMapping("/items")
//    public ResponseEntity<InventoryItem> depositQuantityInventoryItem(long depositQuantity, InventoryItem inventoryItem) {
//        return ResponseEntity.ok().body(service.depositQuantityOfInventoryItem(depositQuantity, inventoryItem));
//    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteInventoryItem(@PathVariable long id) {
        service.deleteInventoryItem(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return ResponseEntity.ok(response);
    }
}
