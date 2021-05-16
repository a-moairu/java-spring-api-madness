package com.launchacademy.mallmadness.controllers;

import com.launchacademy.mallmadness.models.Store;
import com.launchacademy.mallmadness.repositories.StoreRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/{id}")
  public Store getIndividualStore(@PathVariable Integer id) {
    return storeRepo.findById(id).orElseThrow(() -> new StoreNotFoundException());
  }

  @NoArgsConstructor
  private class StoreNotFoundException extends RuntimeException{
  }

  @ControllerAdvice
  private class StoreNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(StoreNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String storeNotFoundHandler(StoreNotFoundException ex) {
      return ex.getMessage();
    }
  }
}
