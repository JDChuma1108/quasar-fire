package com.rebel.alliance.quasar.fire.repository.database.satellite;

import com.rebel.alliance.quasar.fire.core.entity.satellite.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatelliteDatabaseRepository extends JpaRepository<Satellite, String> {
}
