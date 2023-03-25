package com.rebel.alliance.quasar.fire.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

public class SatelliteNotFoundException extends ClassNotFoundException{
    public SatelliteNotFoundException(final String message) { super(message); }
}
