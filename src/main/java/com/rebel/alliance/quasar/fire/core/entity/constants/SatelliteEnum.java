package com.rebel.alliance.quasar.fire.core.entity.constants;

import com.rebel.alliance.quasar.fire.exception.SatelliteNotFoundException;

public enum SatelliteEnum{
    KENOBI(new double[]{-500.0, -200.0}),
    SKYWALKER(new double[]{100.0, -100.0}),
    SATO(new double[]{500.0, 100.0});

    private static double[][] POSITIONS = new double[3][3];

    static {
        POSITIONS[0] = KENOBI.coordinates;
        POSITIONS[1] = SKYWALKER.coordinates;
        POSITIONS[2] = SATO.coordinates;
    }
    public final double[] coordinates;

    private SatelliteEnum( double[] coordinates
    ){
        this.coordinates = coordinates;
    }

    public static double[][] getPositions(){
        return POSITIONS;
    }

    public static SatelliteEnum getByName(String satelliteName) throws SatelliteNotFoundException {
        try{
            return valueOf(satelliteName.toUpperCase());
        }catch (IllegalArgumentException error){
            throw new SatelliteNotFoundException(String.format("The satellite %s does not exists in SatelliteEnum", satelliteName));
        }
    }

}
