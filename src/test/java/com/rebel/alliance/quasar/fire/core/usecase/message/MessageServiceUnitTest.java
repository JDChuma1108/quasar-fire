package com.rebel.alliance.quasar.fire.core.usecase.message;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceUnitTest {

    MessageService messageService;

    @BeforeEach
    public void before() {
        messageService = spy(MessageService.class);
    }

    @Test
    public void getMessage(){
        // Given
        List<List<String>> givenMessages = new ArrayList<>();
        List<String> kenobiMessage = new ArrayList<>(
                List.of("este",
                        "",
                        "",
                        "mensaje",
                        "")
        );
        List<String> skywalkerMessage = new ArrayList<>(
                List.of("",
                        "es",
                        "",
                        "",
                        "secreto")
        );
        List<String> satoMessage = new ArrayList<>(
                List.of("este",
                        "",
                        "un",
                        "",
                        "")
        );
        givenMessages.add(kenobiMessage);
        givenMessages.add(skywalkerMessage);
        givenMessages.add(satoMessage);

        // When
        String result = messageService.getMessage(givenMessages);

        // Then
        String expectedResult = "este es un mensaje secreto";
        assertThat(result, equalTo(expectedResult));
    }

    @Test
    public void getMessageFail(){
        // Given
        List<List<String>> givenMessages = new ArrayList<>();
        List<String> kenobiMessage = new ArrayList<>(
                List.of("este",
                        "",
                        "",
                        "",
                        "")
        );
        List<String> skywalkerMessage = new ArrayList<>(
                List.of("",
                        "es",
                        "",
                        "",
                        "")
        );
        List<String> satoMessage = new ArrayList<>(
                List.of("este",
                        "",
                        "un",
                        "",
                        "")
        );
        givenMessages.add(kenobiMessage);
        givenMessages.add(skywalkerMessage);
        givenMessages.add(satoMessage);

        // When
        String result = messageService.getMessage(givenMessages);

        // Then
        String expectedResult = "este es un mensaje secreto";
        assertThat(result, equalTo(expectedResult));
    }
}
