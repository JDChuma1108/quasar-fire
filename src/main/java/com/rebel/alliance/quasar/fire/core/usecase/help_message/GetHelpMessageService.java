package com.rebel.alliance.quasar.fire.core.usecase.help_message;

import com.rebel.alliance.quasar.fire.core.entity.help_message.HelpMessage;
import com.rebel.alliance.quasar.fire.core.entity.help_message.HelpMessageFromSpaceship;
import reactor.core.publisher.Mono;

public interface GetHelpMessageService {

    Mono<HelpMessage> execute(HelpMessageFromSpaceship helpMessageFromSpaceship);
}
