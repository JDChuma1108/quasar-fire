package com.rebel.alliance.quasar.fire.core.entity.help_message;

import com.rebel.alliance.quasar.fire.core.entity.satellite.Satellite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelpMessageFromSpaceship {

    private List<Satellite> satellites;
}
