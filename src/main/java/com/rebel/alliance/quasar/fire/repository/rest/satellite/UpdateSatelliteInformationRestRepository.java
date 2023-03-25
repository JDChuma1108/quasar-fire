package com.rebel.alliance.quasar.fire.repository.rest.satellite;

import com.rebel.alliance.quasar.fire.core.usecase.satellite.handler.HandleUpdateSatelliteInformation;
import com.rebel.alliance.quasar.fire.entrypoint.dto.request.help_message.HelpMessageSatelliteRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.web.bind.annotation.*;

import static jakarta.validation.constraints.Pattern.Flag.CASE_INSENSITIVE;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UpdateSatelliteInformationRestRepository {

    private final HandleUpdateSatelliteInformation handleUpdateSatelliteInformation;


    public UpdateSatelliteInformationRestRepository(HandleUpdateSatelliteInformation handleUpdateSatelliteInformation) {
        this.handleUpdateSatelliteInformation = handleUpdateSatelliteInformation;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE, value = "/topsecret_split/{satellite_name}")
    @ResponseStatus(OK)
    public void execute(
            @PathVariable(value = "satellite_name")
            @Pattern(regexp = "kenobi|skywalker|sato", message = "{field.must.match}", flags = CASE_INSENSITIVE)
            final String satelliteName,
            @Valid @RequestBody HelpMessageSatelliteRequest helpMessageSatelliteRequest){
        helpMessageSatelliteRequest.setName(satelliteName);
        handleUpdateSatelliteInformation.execute(helpMessageSatelliteRequest);
    }
}
