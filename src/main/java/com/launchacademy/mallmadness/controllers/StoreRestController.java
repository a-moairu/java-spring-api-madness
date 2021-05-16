package com.launchacademy.mallmadness.controllers;

import com.launchacademy.mallmadness.models.Store;
import com.launchacademy.mallmadness.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stores")
public class StoreRestController {
  private StoreRepository storeRepo;

  @Autowired
  public StoreRestController(StoreRepository storeRepo) {
    this.storeRepo = storeRepo;
  }

  @GetMapping
  public Page<Store> getStores(Pageable pageable) {
    return this.storeRepo.findAll(pageable);
  }

}
