package com.rebel.alliance.quasar.fire.core.usecase.satellite.handler;

import com.rebel.alliance.quasar.fire.core.entity.satellite.Satellite;
import com.rebel.alliance.quasar.fire.core.usecase.satellite.UpdateSatelliteInformationService;
import com.rebel.alliance.quasar.fire.entrypoint.dto.request.help_message.HelpMessageSatelliteRequest;
import org.springframework.stereotype.Component;

@Component
public class HandleUpdateSatelliteInformation {

    private final UpdateSatelliteInformationService updateSatelliteInformationService;


    public HandleUpdateSatelliteInformation(UpdateSatelliteInformationService updateSatelliteInformationService) {
        this.updateSatelliteInformationService = updateSatelliteInformationService;
    }

    public void execute(HelpMessageSatelliteRequest helpMessageSatelliteRequest){
        updateSatelliteInformationService.execute(
                Satellite.builder()
                        .name(helpMessageSatelliteRequest.getName().toUpperCase())
                        .distance(helpMessageSatelliteRequest.getDistance())
                        .message(helpMessageSatelliteRequest.getMessage())
                        .build()
        );
    }
}
