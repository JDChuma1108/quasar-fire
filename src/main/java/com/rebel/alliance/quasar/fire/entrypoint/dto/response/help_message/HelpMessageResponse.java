package com.rebel.alliance.quasar.fire.entrypoint.dto.response.help_message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.geom.Point2D;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelpMessageResponse {
    private Point2D position;
    private String message;
}
