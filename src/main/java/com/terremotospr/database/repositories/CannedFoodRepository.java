package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.CannedFood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@Repository
public interface CannedFoodRepository extends CrudRepository<CannedFood,Long> {
}