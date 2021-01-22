package companies.valtech.gameoflife;

/**
 * Game of Life Solution
 */
public class GOLSolution {
    public static void main(String[] args) {
        int[][] seed = new int[10][5];

        seed[2][2] = 1;
        seed[3][2] = 1;
        seed[3][3] = 1;
        seed[4][1] = 1;
        seed[4][2] = 1;
        seed[6][1] = 1;

        GOLSolution GOLSolution = new GOLSolution();
        System.out.println("Initial Seed");
        GOLSolution.printArray(seed);

        //final next gen
        for(int i=1; i < 6; i++){
            System.out.println("After Gen Cycle - printing array = " + i);
            int[][] nextGen =   GOLSolution.gameOfLife(seed);
            GOLSolution.gameOfLife(nextGen);
        }

    }


    private int[][] gameOfLife(int[][] cellBoard){
        int mMax = cellBoard.length; //5
        int nMax = cellBoard[0].length; //10

        int[][] nextGenCellBoard = new int[mMax][nMax];

        //Rows & column go through
        for(int i=0; i<mMax; i++){
            for(int j=0; j<nMax; j++){
                //System.out.println("Current Cell i,j, val " + i + " " + j + " "+cellBoard[i][j]);
                int neighbours = getNeighbours(i,j,mMax,nMax,cellBoard,1);
                //System.out.println("neighbours " + neighbours);

                if(cellBoard[i][j] == 1){
                    if(liveCellCheck(neighbours)){
                        nextGenCellBoard[i][j] = 1;
                        //System.out.println("liveCellCheck returned true - Next Cell Location lives");
                    }else {
                        //System.out.println("liveCellCheck returned false - Next Cell Location Dead");
                    }
                }else {
                    if(deadCellCheck(neighbours)){
                        nextGenCellBoard[i][j] = 1;
                        //System.out.println("deadCellCheck returned true - Next Cell Location reproduces");
                    }else {
                        //System.out.println("deadCellCheck returned false - Next Cell Location Dead");
                    }
                }
            }
        }

        //System.out.println("After Gen Cycle - printing array");
        //final next gen
        printArray(nextGenCellBoard);
        return nextGenCellBoard;
    }


    /**
     * get Live Neighbours - pass => value - 1 (Live)
     *
     * @param m Cell Row Location
     * @param n Cell Column Location
     * @param mMax Cell Row Max Location
     * @param nMax Cell Column Max Location
     * @param cellBoard CellBoard
     * @param value => 1 - Live
     *              => 0 - Dead
     * @return No of Neighbours
     */
    private int getNeighbours(int m, int n, int mMax, int nMax,
                              int[][] cellBoard, int value){
        int neighboursCount = 0;
        //System.out.println("");
        //System.out.println("getNeighbours - m, n " + m + " " + n);
        //System.out.println("getNeighbours - m, n, mMax, nMax " + m + " " + n + " " + mMax + " " + nMax);
        //Left
        if(m-1 >= 0){
            //System.out.println("Left: m-1, n, val " + (m-1) + " " + (n) + " = " + cellBoard[m-1][n]);
            if(cellBoard[m-1][n] == value){
                neighboursCount++;
            }
        }

        //bottom
        if(m+1 < mMax){
            //System.out.println("bottom: m+1, n, val " + (m+1) + " " + (n) + " = " + cellBoard[m+1][n]);
            if(cellBoard[m+1][n] == value){
                neighboursCount++;
            }
        }

        //top
        if(n-1 >= 0){
            //System.out.println("Top: m, n, val " + (m) + " " + (n-1) + " = " + cellBoard[m][n-1]);
            if(cellBoard[m][n-1] == value){
                neighboursCount++;
            }
        }

        //Right
        if(n+1 < nMax){
            //System.out.println("Right: m, n+1, val " + (m) + " " + (n+1) + " = " + cellBoard[m][n+1]);
            if(cellBoard[m][n+1] == value){
                neighboursCount++;
            }
        }

        //diagonal right top
        if(m+1 < mMax & n-1 >=0){
            //System.out.println("diagonal right top: m+1, n-1, val " + (m+1) + " " + (n-1) + " = " + cellBoard[m+1][n-1]);
            if(cellBoard[m+1][n-1] == value){
                neighboursCount++;
            }
        }

        //diagonal right bottom
        if(m+1 < mMax & n+1 < nMax){
            //System.out.println("diagonal right bottom: m+1, n+1, val " + (m+1) + " " + (n+1) + " = " + cellBoard[m+1][n+1]);
            if(cellBoard[m+1][n+1] == value){
                neighboursCount++;
            }
        }

        //diagonal left top
        if(m-1 >= 0 & n-1 >= 0){
            //System.out.println("diagonal left top: m+1, n-1, val " + (m+1) + " " + (n-1) + " = " + cellBoard[m-1][n-1]);
            if(cellBoard[m-1][n-1] == value){
                neighboursCount++;
            }
        }
        //diagonal left bottom
        if(m-1 >= 0 & n+1 < nMax){
            //System.out.println("diagonal left bottom: m+1, n+1, val " + (m+1) + " " + (n+1) + " = " + cellBoard[m-1][n+1]);
            if(cellBoard[m-1][n+1] == value){
                neighboursCount++;
            }
        }

        return neighboursCount;
    }

    /**
     * liveCellCheck
     * @param neighbours Live Cells surrounding
     * @return true - lives in next gen
     *          false - dead for the next gen
     */
    private boolean liveCellCheck(int neighbours){
        //System.out.println("liveCellCheck with neighbours" + neighbours);
        if(neighbours < 2 ){
            return false; //dead cell in next generation
        }else if(neighbours > 3){
            return false; //dead cell in next generation
        }else { // ==2 or ==3
            return true;
        }
    }

    /**
     * deadCellCheck
     * @param neighbours Live Cells surrounding
     * @return true - lives in next gen
     *          false - dead for the next gen
     */
    private boolean deadCellCheck(int neighbours){
        if(neighbours == 3){
            return true; //reproduces
        }else {
            return false;
        }
    }

    private void printArray(int[][] cellBoard){
        // Loop through all rows
        for (int i = 0; i < cellBoard.length; i++) {
            // Loop through all elements of current row
            for (int j = 0; j < cellBoard[i].length; j++) {
                System.out.print(cellBoard[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
