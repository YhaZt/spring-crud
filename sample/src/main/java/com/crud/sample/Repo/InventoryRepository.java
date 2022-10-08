package com.crud.sample.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.sample.Model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {}

