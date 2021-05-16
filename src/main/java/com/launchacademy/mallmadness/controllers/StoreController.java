package com.launchacademy.mallmadness.controllers;

import com.launchacademy.mallmadness.models.Store;
import com.launchacademy.mallmadness.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stores")
public class StoreController {

  private StoreRepository storeRepository;

  @Autowired
  public StoreController(StoreRepository storeRepository) {
    this.storeRepository = storeRepository;
  }

  @GetMapping
  public String getListOfStores(Model model, Pageable pageable) {
    model.addAttribute("stores", storeRepository.findAll(pageable));
    return "stores/index";
  }

  @GetMapping("/new")
  public String getNewForm(@ModelAttribute Store store) {
    return "stores/new";
  }
}
