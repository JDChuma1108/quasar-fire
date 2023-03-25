package com.rebel.alliance.quasar.fire.core.usecase.message;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.util.Strings.isBlank;
import static org.apache.logging.log4j.util.Strings.isNotBlank;

@Service
public class MessageService {

    public String getMessage(List<List<String>> messages){
        List<Integer> messagesSize = new ArrayList<>();
        Integer messageWords;

        messages.forEach(message ->  messagesSize.add(message.size()) );
        messageWords = Collections.min(messagesSize);
        String messagePart;
        final List<String> mergedMessage = new LinkedList<>();

        for(int i=0; i<3;i++){
            List<String> actualMessage = messages.get(i);
            for(int j=0; j<actualMessage.size(); j++){
                messagePart = actualMessage.get(j);
                if(isBlank(messagePart)){
                    for (int k = i + 1; k < 3; k++) {
                        messagePart = messages.get(k).get(j);
                        if (isNotBlank(messagePart))
                            break;
                    }
                }
                mergedMessage.add(messagePart);
            }
            if (mergedMessage.size() == messageWords)
                break;
        }
        if (mergedMessage.stream().anyMatch(Strings::isBlank))
            throw new IllegalArgumentException();

        return mergedMessage.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(" "));
    }


}
