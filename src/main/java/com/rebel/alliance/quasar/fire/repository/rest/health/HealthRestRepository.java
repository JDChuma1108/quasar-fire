package com.rebel.alliance.quasar.fire.repository.rest.health;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthRestRepository {

    @GetMapping("/health")
    @ResponseBody
    public ResponseEntity<String> function(){
        return new ResponseEntity<>("Quásar Fire Operation by Rebel Alliance V1.0.0", HttpStatus.OK);
    }
}
