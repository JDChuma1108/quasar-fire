package com.rebel.alliance.quasar.fire.core.usecase.help_message.handler;

import com.rebel.alliance.quasar.fire.core.entity.help_message.HelpMessageFromSpaceship;
import com.rebel.alliance.quasar.fire.core.usecase.help_message.GetHelpMessageService;
import com.rebel.alliance.quasar.fire.core.usecase.help_message.converter.ConvertHelpMessageRequestToHelpMessageFromSpaceship;
import com.rebel.alliance.quasar.fire.core.usecase.help_message.validator.ValidateHelpMessageFromSpaceship;
import com.rebel.alliance.quasar.fire.entrypoint.dto.request.help_message.HelpMessageRequest;
import com.rebel.alliance.quasar.fire.entrypoint.dto.response.help_message.HelpMessageResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class HandleHelpMessageToSatellites {

    private final GetHelpMessageService getHelpMessageService;
    private final ConvertHelpMessageRequestToHelpMessageFromSpaceship convertHelpMessageRequestToHelpMessageFromSpaceship;
    private final ValidateHelpMessageFromSpaceship validateHelpMessageFromSpaceship;

    public HandleHelpMessageToSatellites(GetHelpMessageService getHelpMessageService, ConvertHelpMessageRequestToHelpMessageFromSpaceship convertHelpMessageRequestToHelpMessageFromSpaceship, ValidateHelpMessageFromSpaceship validateHelpMessageFromSpaceship) {
        this.getHelpMessageService = getHelpMessageService;
        this.convertHelpMessageRequestToHelpMessageFromSpaceship = convertHelpMessageRequestToHelpMessageFromSpaceship;
        this.validateHelpMessageFromSpaceship = validateHelpMessageFromSpaceship;
    }

    public Mono<HelpMessageResponse> execute(HelpMessageRequest helpMessageRequest) throws Exception {

        HelpMessageFromSpaceship helpMessageFromSpaceship = convertHelpMessageRequestToHelpMessageFromSpaceship.execute(helpMessageRequest).block();
        assert helpMessageFromSpaceship != null;
        validateHelpMessageFromSpaceship.execute(helpMessageFromSpaceship);

        return getHelpMessageService.execute(helpMessageFromSpaceship)
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
