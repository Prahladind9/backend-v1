package companies.Thoughtworks;

public class Empty extends Cell{
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
