package companies.Thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final int MAX_CHANCES = 10;
    private int chances;
    private int currentPosition;
    private int playerAmount; //as not need for the Double calc for now

    private List<Integer> hotelList = new ArrayList<>();

    public Player(int amount){
        chances=0;
        playerAmount = amount;
        currentPosition = 0;
    }



    public void movePlayerPosition(int position){
        currentPosition = position;
    }

    public int getPlayerAmount(){
        return playerAmount;
    }

    public void setPlayerAmount(int playerCurrentAmount){
        playerAmount = playerAmount;
    }

    public void setHotelPosition(int hotelPosition){
        hotelList.add(hotelPosition);
    }
    public List<Integer>  getHotelList(){
        return hotelList;
    }

    /*public void playerOperation(Cell cell){
        cell.cellOperation();
    }*/


}
