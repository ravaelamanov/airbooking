package com.airbooking.da.repositories;

import com.airbooking.da.entities.Airplane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends CrudRepository<Airplane, Long> {
        Airplane findByName(String name);
}
