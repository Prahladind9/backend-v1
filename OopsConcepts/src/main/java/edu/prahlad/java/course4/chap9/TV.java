package edu.prahlad.java.course4.chap9;

public class TV {

    public static void main(String[] args) {
        TV tv1 = new TV();
        tv1.turnOn();
        tv1.setChannel(30);
        tv1.setVolume(3);

        System.out.println(tv1.toString());
    }

    int channel = 1;
    int volumeLevel = 1;
    boolean on = false;

    public TV() {}

    public void turnOn(){
        on = true;
    }

    public void turnOff(){
        on = false;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void setVolume(int newVolumeLevel) {
        this.volumeLevel = newVolumeLevel;
    }

    public void channelUp(){
        if(on && channel < 120)
            channel++;
    }

    public void channelDown(){
        if(on && channel > 1)
            channel--;
    }

    public void volumeUp(){
        if(on && volumeLevel < 7)
            volumeLevel++;
    }

    public void volumeDown(){
        if(on && volumeLevel > 1)
            volumeLevel--;
    }

    @Override
    public String toString() {
        return "TV{" +
                "channel=" + channel +
                ", volumeLevel=" + volumeLevel +
                ", on=" + on +
                '}';
    }
}
