package companies.Thoughtworks;

public class Jail extends Cell{
    private final int fineAmount = -150;
    @Override
    public boolean isHotelBooked() {
        return false;
    }

    @Override
    public int payFine(int playerAmount) {
        return playerAmount + fineAmount;
    }

    @Override
    public int getTreasure(int playerAmount) {
        return 0;
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
