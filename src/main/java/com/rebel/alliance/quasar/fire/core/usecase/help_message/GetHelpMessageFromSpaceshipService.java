package com.rebel.alliance.quasar.fire.core.usecase.help_message;

import com.rebel.alliance.quasar.fire.core.entity.help_message.HelpMessage;
import com.rebel.alliance.quasar.fire.core.entity.help_message.HelpMessageFromSpaceship;
import com.rebel.alliance.quasar.fire.core.entity.satellite.Satellite;
import com.rebel.alliance.quasar.fire.core.usecase.location.LocationService;
import com.rebel.alliance.quasar.fire.core.usecase.message.MessageService;
import com.rebel.alliance.quasar.fire.repository.database.satellite.SatelliteDatabaseRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


import java.util.List;
import java.util.stream.DoubleStream;

@Service
public class GetHelpMessageFromSpaceshipService implements GetHelpMessageService {

    private final LocationService locationService;
    private final MessageService messageService;
    private final SatelliteDatabaseRepository satelliteDatabaseRepository;

    public GetHelpMessageFromSpaceshipService(LocationService locationService, MessageService messageService, SatelliteDatabaseRepository satelliteDatabaseRepository) {
        this.locationService = locationService;
        this.messageService = messageService;
        this.satelliteDatabaseRepository = satelliteDatabaseRepository;
    }

    @Override
    public Mono<HelpMessage> execute(HelpMessageFromSpaceship helpMessageFromSpaceship) {
        List<Satellite> satellites = helpMessageFromSpaceship.getSatellites();
        double[] distances = satellites.stream().map(Satellite::getDistance).flatMapToDouble(DoubleStream::of).toArray();
        List<List<String>> messages = satellites.stream().map(Satellite::getMessage).toList();

        satellites.forEach(satelliteDatabaseRepository::save);

        return Mono.just(
                HelpMessage.builder()
                        .position(locationService.getLocation(distances))
                        .message(messageService.getMessage(messages))
                        .build()
        );
    }
}
