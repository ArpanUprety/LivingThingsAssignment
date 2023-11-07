import java.util.ArrayList;
public class Board {
    private int gazzoRow;
    private int gazzoCol;
    private  int maxrow;
    private int maxcol;
    ArrayList<ArrayList<Space>> Board = new ArrayList<ArrayList<Space>>();
    LivingThing player = new LivingThing("Gazoo", 20, ConsoleColors.GREEN);
    private int rows = 0;
    private   int columns = 0;
    public Board(){
        this(4,4);
    }
    public Board(int rows, int columns){
        Board = new ArrayList<>();
        this.columns = columns;
        this.rows = rows;
        buildBoard();

        gazzoRow = 0;
        gazzoCol = 0;
        Board.get(gazzoRow).get(gazzoCol).setOccupant(player);
    }

    private void buildBoard(){
        maxrow = rows -1;
       maxcol = columns -1;
        for(int i = 0; i < rows; i++){
            ArrayList<Space> row = new ArrayList<>();
            for(int n = 0; n < columns; n++){
                row.add(new Space());
            }Board.add(row);
        }
    }

    public  void  printBoard() {

            String result = "";
            for (int i = 0; i < Board.size(); i++) {
                for (int j = 0; j < Board.get(i).size(); j++) {
                    result += Board.get(i).get(j).getConsoleStr();
                }
                result += System.lineSeparator();
            }
            System.out.println(result);



    }
public  boolean move(char m){


        switch (m){
            case 'a' :
                if (validSpace(gazzoRow  ,gazzoCol -1)){
                    Board.get(gazzoRow).get(gazzoCol).setOccupant(null);
                    gazzoCol -=1;
                    Board.get(gazzoRow ).get(gazzoCol).setOccupant(player);

                }
break;


            case 'w':
                if (validSpace(gazzoRow -1 ,gazzoCol)){
                    Board.get(gazzoRow).get(gazzoCol).setOccupant(null);
                    gazzoRow -=1;
                    Board.get(gazzoRow ).get(gazzoCol).setOccupant(player);

                }
                break;
            case 's':
    if (validSpace(gazzoRow +1 ,gazzoCol)){
        Board.get(gazzoRow).get(gazzoCol).setOccupant(null);
        gazzoRow +=1;
        Board.get(gazzoRow ).get(gazzoCol).setOccupant(player);

    }
                break;
            case 'd':
              if (validSpace(gazzoRow,gazzoCol + 1)){
                  Board.get(gazzoRow).get(gazzoCol).setOccupant(null);
                  gazzoCol +=1;
                  Board.get(gazzoRow ).get(gazzoCol).setOccupant(player);
            }
                break;
            default:
                return false;

        }

    return false;
}


public boolean validSpace(int row, int col){
        return row >= 0 && row < Board.size() && col >= 0 && col < Board.get(row).size();
}

public boolean validSpaceL(int row){
        if (gazzoRow != 0 ) {

         return true;
        }else {
            System.out.println("can't move in this direction ");
            return false;
        }
}
    public boolean validSpaceR(int col){
        if ( gazzoCol >= maxcol-1) {
            System.out.println("can't move in this direction ");
            return false;
        }else {

            return true;
        }
    }



    public boolean validSpaceW( int col){
        if (gazzoCol != 0 ) {

            return true;
        }else {
            System.out.println("can't move in this direction ");
            return false;
        }
    }


    public boolean validSpaceS(int rows){
        if ( gazzoCol >= maxrow -1) {
            System.out.println("can't move in this direction ");
            return false;
        }else {

            return true;
        }
    }

}