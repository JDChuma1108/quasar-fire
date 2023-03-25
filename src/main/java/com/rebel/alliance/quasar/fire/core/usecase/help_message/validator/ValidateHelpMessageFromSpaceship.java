package com.rebel.alliance.quasar.fire.core.usecase.help_message.validator;

import com.rebel.alliance.quasar.fire.core.entity.constants.SatelliteEnum;
import com.rebel.alliance.quasar.fire.core.entity.help_message.HelpMessageFromSpaceship;
import com.rebel.alliance.quasar.fire.exception.SatelliteNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ValidateHelpMessageFromSpaceship {

    public void execute(HelpMessageFromSpaceship helpMessageFromSpaceship) throws Exception {

        if(helpMessageFromSpaceship.getSatellites().size() != 3){
            throw new Exception();
        }

        helpMessageFromSpaceship.getSatellites().forEach( satellite ->
                {
                    try {
                        SatelliteEnum.getByName(satellite.getName());
                    } catch (SatelliteNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

    }
}
