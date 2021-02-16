package com.example.MySpringBoot.repository;

import com.example.MySpringBoot.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventoryItemRepository extends JpaRepository<InventoryItem, Long> {

}
