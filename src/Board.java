import java.util.ArrayList;
public class Board {
    ArrayList<ArrayList<Space>> Board = new ArrayList<ArrayList<Space>>();

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
        LivingThing player = new LivingThing("Gazoo", 20, ConsoleColors.GREEN);
        Board.get(0).get(0).setOccupant(player);
    }

    private void buildBoard(){
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
}