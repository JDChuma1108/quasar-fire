package com.rebel.alliance.quasar.fire.core.usecase.location;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import com.rebel.alliance.quasar.fire.core.entity.constants.SatelliteEnum;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.geom.Point2D;

@Service
public class LocationService {

    public Point2D getLocation(double[] distances){
        double[][] satellitePositions = SatelliteEnum.getPositions();
        TrilaterationFunction trilaterationFunction = new TrilaterationFunction(satellitePositions,distances);
        NonLinearLeastSquaresSolver nonLinearLeastSquaresSolver = new NonLinearLeastSquaresSolver(trilaterationFunction, new LevenbergMarquardtOptimizer());
        return new Point2D.Double(nonLinearLeastSquaresSolver.solve().getPoint().toArray()[0], nonLinearLeastSquaresSolver.solve().getPoint().toArray()[1]);
    }
}
