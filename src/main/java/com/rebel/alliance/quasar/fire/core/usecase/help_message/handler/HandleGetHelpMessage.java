package com.rebel.alliance.quasar.fire.core.usecase.help_message.handler;

import com.rebel.alliance.quasar.fire.core.entity.help_message.HelpMessageFromSpaceship;
import com.rebel.alliance.quasar.fire.core.entity.satellite.Satellite;
import com.rebel.alliance.quasar.fire.core.usecase.help_message.GetHelpMessageService;
import com.rebel.alliance.quasar.fire.core.usecase.help_message.converter.ConvertHelpMessageRequestToHelpMessageFromSpaceship;
import com.rebel.alliance.quasar.fire.core.usecase.help_message.validator.ValidateHelpMessageFromSpaceship;
import com.rebel.alliance.quasar.fire.entrypoint.dto.response.help_message.HelpMessageResponse;
import com.rebel.alliance.quasar.fire.repository.database.satellite.SatelliteDatabaseRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.rebel.alliance.quasar.fire.core.entity.constants.SatelliteEnum.*;

@Component
public class HandleGetHelpMessage {

    private final GetHelpMessageService getHelpMessageService;
    private final SatelliteDatabaseRepository satelliteDatabaseRepository;
    private final ValidateHelpMessageFromSpaceship validateHelpMessageFromSpaceship;

    public HandleGetHelpMessage(GetHelpMessageService getHelpMessageService, ConvertHelpMessageRequestToHelpMessageFromSpaceship convertHelpMessageRequestToHelpMessageFromSpaceship, SatelliteDatabaseRepository satelliteDatabaseRepository, ValidateHelpMessageFromSpaceship validateHelpMessageFromSpaceship) {
        this.getHelpMessageService = getHelpMessageService;
        this.satelliteDatabaseRepository = satelliteDatabaseRepository;
        this.validateHelpMessageFromSpaceship = validateHelpMessageFromSpaceship;
    }

    public Mono<HelpMessageResponse> execute() throws Exception {
        HelpMessageFromSpaceship helpMessageFromSpaceship = new HelpMessageFromSpaceship();
        List<Satellite> satellites = new ArrayList<>();
        Optional<Satellite> kenobiSatellite = satelliteDatabaseRepository.findById(KENOBI.name());
        Optional<Satellite> skywalkerSatellite = satelliteDatabaseRepository.findById(SKYWALKER.name());
        Optional<Satellite> satoSatellite = satelliteDatabaseRepository.findById(SATO.name());

        kenobiSatellite.ifPresent(satellites::add);
        skywalkerSatellite.ifPresent(satellites::add);
        satoSatellite.ifPresent(satellites::add);

        helpMessageFromSpaceship.setSatellites(satellites);

        validateHelpMessageFromSpaceship.execute(helpMessageFromSpaceship);

        return  getHelpMessageService.execute(helpMessageFromSpaceship)
                .flatMap( helpMessage ->
                      Mono.just(
                              HelpMessageResponse.builder()
                                      .position(helpMessage.getPosition())
                                      .message(helpMessage.getMessage())
                                      .build()
                      )
                );

    }
}
