package companies.Thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Cell> cellList = new ArrayList<>();
    public void assignCell(Cell cell){
        cellList.add(cell);
    }

    public Cell getCellDetails(int cellIndex){
        return cellList.get(cellIndex);
    }

}
