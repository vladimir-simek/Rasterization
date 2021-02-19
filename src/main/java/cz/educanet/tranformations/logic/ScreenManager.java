package cz.educanet.tranformations.logic;

import cz.educanet.tranformations.logic.models.Coordinate;
import cz.educanet.tranformations.logic.models.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ScreenManager {

    private Set<Coordinate> selectedPoints = new HashSet<>();

    public void select(Coordinate coordinate) {
        selectedPoints.add(coordinate);
    }

    public void unselect(Coordinate coordinate) {
        selectedPoints.remove(coordinate);
    }

    public boolean isSelected(Coordinate coordinate) {
        return selectedPoints.contains(coordinate);
    }

    public Set<Coordinate> getSelectedPoints() {
        return selectedPoints;
    }

    public boolean isFilledIn(Coordinate coordinate) { // TODO: Implement this

        if (selectedPoints.size() < 3) {
            return false;
        } else {
            Coordinate[] coords = selectedPoints.toArray(new Coordinate[]{});


            Coordinate point1 = coords[0];
            Coordinate point2 = coords[1];
            Coordinate point3 = coords[2];

            double a1,b1,a2,b2,a3,b3,y = 0;

            double y1 = point1.getY();
            double x1 = point1.getX();
            double y2 = point2.getY();
            double x2 = point2.getX();
            double y3 = point3.getY();
            double x3 = point3.getX();

            a1 = (y1 - y2) / (x2 - x1);
            b1 = y1 - (a1 * x1);
            y = a1 * x1 + b1;


            boolean equation1,equation2,equation3 = false;

            if (equation1 && equation2 && equation3) {
                return true;
            }

        }
    }
}