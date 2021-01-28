package com.airbooking.da.repositories;

import com.airbooking.da.entities.SeatsPriceList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatsPriceListRepository extends CrudRepository<SeatsPriceList, Long> {
}
