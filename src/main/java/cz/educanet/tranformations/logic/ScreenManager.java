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

        ArrayList<Coordinate> list = new ArrayList<>(selectedPoints);
        if (list.size() == 3)
            return (isInside(list.get(2), list.get(1), list.get(0), coordinate) || isInside(list.get(0), list.get(1), list.get(2), coordinate)) && (isInside(list.get(2), list.get(0), list.get(1), coordinate) || isInside(list.get(1), list.get(0), list.get(2), coordinate));
        return false;
    }

    public static boolean isInside(Coordinate a, Coordinate b, Coordinate c, Coordinate point) {
        return (((a.getX() - point.getX()) * (b.getY() - point.getY()) - (a.getY() - point.getY()) * (b.getX() - point.getX())) > 0) && !(((a.getX() - point.getX()) * (c.getY() - point.getY()) - (a.getY() - point.getY()) * (c.getX() - point.getX())) > 0);
    }
}
