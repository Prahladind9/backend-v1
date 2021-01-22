package companies.Thoughtworks;

public class Treasure extends Cell{

    private final int treasureValue = 200;

    @Override
    public boolean isHotelBooked() {
        return false;
    }

    @Override
    public int payFine(int playerAmount) {
        return 0;
    }

    @Override
    public int getTreasure(int playerAmount) {
        return playerAmount + treasureValue ;
    }

    @Override
    public int buyHotel(int playerAmount) {
        return 0;
    }
    @Override
    public int payHotelRent(int playerAmount) {
        return 0;
    }
}
