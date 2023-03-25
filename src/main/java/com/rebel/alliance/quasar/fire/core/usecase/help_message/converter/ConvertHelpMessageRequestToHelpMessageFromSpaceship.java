package com.rebel.alliance.quasar.fire.core.usecase.help_message.converter;

import com.rebel.alliance.quasar.fire.core.entity.help_message.HelpMessageFromSpaceship;
import com.rebel.alliance.quasar.fire.core.entity.satellite.Satellite;
import com.rebel.alliance.quasar.fire.entrypoint.dto.request.help_message.HelpMessageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConvertHelpMessageRequestToHelpMessageFromSpaceship {

    public Mono<HelpMessageFromSpaceship> execute(HelpMessageRequest helpMessageRequest) {
        HelpMessageFromSpaceship helpMessageFromSpaceship = new HelpMessageFromSpaceship();
        List<Satellite> satellites = new ArrayList<>();

        helpMessageRequest.getSatellites().forEach(satellite ->
                        satellites.add(
                            Satellite.builder()
                            .name(satellite.name.toUpperCase())
                            .distance(satellite.distance)
                            .message(satellite.message)
                                    .build()
                    )
                );

        helpMessageFromSpaceship.setSatellites(satellites);

        return Mono.just(helpMessageFromSpaceship);
    }

}
