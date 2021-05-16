package com.launchacademy.mallmadness.seeders;

import com.launchacademy.mallmadness.models.Store;
import com.launchacademy.mallmadness.repositories.StoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreSeeder implements CommandLineRunner {
  private StoreRepository storeRepository;

  @Autowired
  private StoreSeeder(StoreRepository storeRepository) {
    this.storeRepository = storeRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Store storeOne = new Store();
    storeOne.setName("JAVA");
    storeOne.setType("Coffee");
    storeOne.setAverage_cost(10);
    storeOne.setOperating_status(true);

    Store storeTwo =  new Store();
    storeTwo.setName("Molokai");
    storeTwo.setType("Bakery");
    storeTwo.setAverage_cost(12);
    storeTwo.setOperating_status(true);

    List<Store> stores = (List<Store>) storeRepository.findAll();

    if (stores.size() == 0) {
      storeRepository.save(storeOne);
      storeRepository.save(storeTwo);
    }

  }
}
