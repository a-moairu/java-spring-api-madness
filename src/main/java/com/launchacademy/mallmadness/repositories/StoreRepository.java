package com.launchacademy.mallmadness.repositories;

import com.launchacademy.mallmadness.models.Store;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends PagingAndSortingRepository<Store, Integer> {
  List<Store> findAll();
}
