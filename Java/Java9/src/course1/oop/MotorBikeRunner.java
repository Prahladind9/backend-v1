package course1.oop;

public class MotorBikeRunner {

    public static void main(String[] args) {
//        MotorBike ducati = new MotorBike();
        MotorBike ducati = new MotorBike(90);
        MotorBike honda = new MotorBike(100);

        ducati.start();
        honda.start();

        //ducati.setSpeed(100);
        System.out.println(ducati.getSpeed());
        ducati.increaseSpeed(10);
        System.out.println(ducati.getSpeed());

        //honda.setSpeed(80);
        honda.decreaseSpeed(20);
        System.out.println(honda.getSpeed());
    }
}
