package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.MedicalDevices;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalDevicesRepository extends CrudRepository<MedicalDevices, Long> {

}
