package com.airbooking.da.repositories;

import com.airbooking.da.entities.AirplaneSeatsInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneSeatsInfoRepository extends CrudRepository<AirplaneSeatsInfo, Long> {
}
