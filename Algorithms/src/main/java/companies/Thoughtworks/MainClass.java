package companies.Thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        Board board = new Board();
        int noOfPlayers = 3;
        int maxRoles = 30;
        Player player1 = new Player(1000);
        Player player2 = new Player(1500);
        Player player3 = new Player(5000);

        //0,1,2
        //3,4,5
        List<Integer> indexList = new ArrayList<>();

        for(int i=0; i < indexList.size(); i++){
            if(i%noOfPlayers == 0){
                //derive Player current position
                //set the current position
                //for the position get the cell
                //cellOperation() - player --> player amount reduced/increased - hotel booked

            }else if(i%noOfPlayers == 1){

            }else if(i%noOfPlayers == 2){

            }else{
                //no be implemented
            }
        }

        //player amount
        //palyer hotel booked amount
        // player 1 sum


        //compare players

    }


}
