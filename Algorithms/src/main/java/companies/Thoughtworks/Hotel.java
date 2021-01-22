package companies.Thoughtworks;

public class Hotel extends Cell{
    private final int hotelRent = -50;
    private final int hotelWorth = 200;
    private boolean hotelBooked = false;

    @Override
    public boolean isHotelBooked() {
        return hotelBooked;
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
    public int buyHotel(int playerAmount){
        if(playerAmount >= hotelWorth){
            playerAmount = playerAmount - hotelWorth;
            setHotelBookedTrue();
        }

        return playerAmount;
    }

    @Override
    public int payHotelRent(int playerAmount) {
        if(isHotelBooked()){
            return playerAmount + hotelRent;
        }else {
            return 0;
        }
    }

    private void setHotelBookedTrue() {
        hotelBooked = true;
    }



}
