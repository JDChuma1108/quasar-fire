package com.rebel.alliance.quasar.fire.repository.rest.help_message;

import com.rebel.alliance.quasar.fire.core.usecase.help_message.handler.HandleHelpMessageToSatellites;
import com.rebel.alliance.quasar.fire.entrypoint.dto.request.help_message.HelpMessageRequest;
import com.rebel.alliance.quasar.fire.entrypoint.dto.response.help_message.HelpMessageResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class SendHelpMessageToSatellitesRestRepository {

    private final HandleHelpMessageToSatellites handleHelpMessageToSatellites;

    public SendHelpMessageToSatellitesRestRepository(HandleHelpMessageToSatellites handleHelpMessageToSatellites) {
        this.handleHelpMessageToSatellites = handleHelpMessageToSatellites;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE, value = "/topsecret/")
    @ResponseStatus(OK)
    public Mono<HelpMessageResponse> execute(@Valid @RequestBody HelpMessageRequest helpMessageRequest) throws Exception {

            return handleHelpMessageToSatellites.execute(helpMessageRequest);

    }


}
