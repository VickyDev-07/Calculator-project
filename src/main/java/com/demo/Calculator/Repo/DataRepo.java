package com.demo.Calculator.Repo;

import com.demo.Calculator.Entity.DataStore;
import org.springframework.data.repository.CrudRepository;

public interface DataRepo extends CrudRepository<DataStore, Integer> {
}
