package course1.oop;

public class MotorBike {

    public MotorBike(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    /*public void setSpeed(int speed) {
        if (speed <0)
            this.speed = 0;
        this.speed = speed;
    }*/

    public void increaseSpeed(int howMuch) {
        this.speed += howMuch;
    }


    public void decreaseSpeed(int howMuch) {
        if(this.speed - howMuch > 0) {
            this.speed -= howMuch;
        }else {
            this.speed = 0;
        }
    }

    //state
    private int speed;

    //behaviour
    void start(){
        System.out.println("Bike Started");
    }
}
