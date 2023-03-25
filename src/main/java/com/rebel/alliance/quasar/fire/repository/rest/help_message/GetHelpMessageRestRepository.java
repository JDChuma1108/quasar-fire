package com.rebel.alliance.quasar.fire.repository.rest.help_message;

import com.rebel.alliance.quasar.fire.core.usecase.help_message.handler.HandleGetHelpMessage;
import com.rebel.alliance.quasar.fire.entrypoint.dto.response.help_message.HelpMessageResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class GetHelpMessageRestRepository {

    private final HandleGetHelpMessage handleGetHelpMessage;

    public GetHelpMessageRestRepository(HandleGetHelpMessage handleGetHelpMessage) {
        this.handleGetHelpMessage = handleGetHelpMessage;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/topsecret/")
    @ResponseStatus(OK)
    public Mono<HelpMessageResponse> execute() throws Exception {
        return handleGetHelpMessage.execute();
    }


}
