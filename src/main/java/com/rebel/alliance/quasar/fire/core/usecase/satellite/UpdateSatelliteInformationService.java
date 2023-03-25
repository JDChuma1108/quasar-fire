package com.rebel.alliance.quasar.fire.core.usecase.satellite;

import com.rebel.alliance.quasar.fire.core.entity.satellite.Satellite;
import com.rebel.alliance.quasar.fire.repository.database.satellite.SatelliteDatabaseRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateSatelliteInformationService {

    private final SatelliteDatabaseRepository satelliteDatabaseRepository;

    public UpdateSatelliteInformationService(SatelliteDatabaseRepository satelliteDatabaseRepository) {
        this.satelliteDatabaseRepository = satelliteDatabaseRepository;
    }

    public void execute(Satellite satellite){
        satelliteDatabaseRepository.save(satellite);
    }
}
