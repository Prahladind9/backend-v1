package companies.Thoughtworks;

public abstract class Cell {

//    public abstract int doProcess(int playerAmount);

    public abstract boolean isHotelBooked();
    public abstract int payFine(int playerAmount);

    public abstract int getTreasure(int playerAmount);

    public abstract int buyHotel(int playerAmount);
    public abstract int payHotelRent(int playerAmount);

    public void cellOperation(Player player){
        isHotelBooked();
        payFine(player.getPlayerAmount());
        getTreasure(player.getPlayerAmount());
        buyHotel(player.getPlayerAmount());
        payHotelRent(player.getPlayerAmount());
    }

}
