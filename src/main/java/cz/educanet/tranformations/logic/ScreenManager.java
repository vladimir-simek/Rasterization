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
        }

        Coordinate[] coords = selectedPoints.toArray(new Coordinate[]{});

        Coordinate bod1 = coords[0];
        Coordinate bod2 = coords[1];
        Coordinate bod3 = coords[2];

        double a1,b1,a2,b2,a3,b3 = 0;



        double Y1 = bod1.getY();
        double X1 = bod1.getX();
        double Y2 = bod2.getY();
        double X2 = bod2.getX();
        double Y3 = bod3.getY();
        double X3 = bod3.getX();

        boolean equation = false,equation2 = false,equation3 = false;


        a1 = (Y2 - Y1) / (X2 - X1); // a1 += magic
        b1 = Y1 - (a1 * X1); // b1 += magic

        a2 = (Y3 - Y2) / (X3 - X2); // a2 += magic
        b2 = Y2 - (a2 * X2); // b2 += magic

        a3 = (Y1 - Y3) / (X1 - X3); // a3 += magic
        b3 = Y3 - (a3 * X3); // b3 += magic

        //if 1
        if (Y3 > a1 * X3 + b1) {
            if (coordinate.getY() > a1 * coordinate.getX() + b1)
                equation = true;
            else
                equation = false;
        }

        if (Y3 < a1 * X3 + b1) {
            if (coordinate.getY() < a1 * coordinate.getX() + b1)
                equation = true;
            else
                equation = false;
        }
        // konec if1

        // if2
        if (Y1 > a2 * X1 + b2) {
            if (coordinate.getY() > a2 * coordinate.getX() + b2)
                equation2 = true;
            else
                equation2 = false;
        }

        if (Y1 < a2 * X1 + b2) {
            if (coordinate.getY() < a2 * coordinate.getX() + b2)
                equation2 = true;
            else
                equation2 = false;
        }
        //konec if 2

        //if3
        if (Y2 > a3 * X2 + b3) {
            if (coordinate.getY() > a3 * coordinate.getX() + b3)
                equation3 = true;
            else
                equation3 = false;
        }

        if (Y2 < a3 * X2 + b3) {
            if (coordinate.getY() < a3 * coordinate.getX() + b3)
                equation3 = true;
            else
                equation3 = false;
        }
        //konec if3

        //konecni if
        if (equation && equation2 && equation3) {
            return true;
        }

        return false;


        //Credits: Jakub Tesař vysvětloval přes hodinu jak to udělat xd
        //Zkoušel jsem to udělat aby to fungovalo i vertikalne ale nemam tucha jak
        //Chci umrit

    }
}