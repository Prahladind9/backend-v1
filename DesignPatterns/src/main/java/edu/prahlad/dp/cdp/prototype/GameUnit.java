package edu.prahlad.dp.cdp.prototype;

import javafx.geometry.Point3D;

/**
 * This class represents an abstract prototype & defines the clone method
 *
 * https://openjfx.io/openjfx-docs/#gradle
 */
public abstract class GameUnit implements Cloneable{

    private Point3D position;

    public GameUnit() {
        position = Point3D.ZERO;
    }

    @Override
    public GameUnit clone() throws CloneNotSupportedException {
        GameUnit gameUnit = (GameUnit) super.clone(); //shallow copy
        gameUnit.initialize();
        return gameUnit;
    }

    protected void initialize  (){
        this.position = Point3D.ZERO;
        reset();
    }

    protected abstract void reset();

    public GameUnit(float x, float y, float z) {
        position = new Point3D(x, y, z);
    }

    public void move(Point3D direction, float distance) {
        Point3D finalMove = direction.normalize();
        finalMove = finalMove.multiply(distance);
        position = position.add(finalMove);
    }

    public Point3D getPosition() {
        return position;
    }
}
