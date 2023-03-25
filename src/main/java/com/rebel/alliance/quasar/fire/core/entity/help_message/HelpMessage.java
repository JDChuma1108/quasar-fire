package com.rebel.alliance.quasar.fire.core.entity.help_message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.awt.geom.Point2D;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelpMessage {
    private Point2D position;
    private String message;
}
