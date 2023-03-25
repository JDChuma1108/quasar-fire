package com.rebel.alliance.quasar.fire.entrypoint.dto.request.help_message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelpMessageSatelliteRequest {
    public String name;
    public double distance;
    public List<String> message;
}
