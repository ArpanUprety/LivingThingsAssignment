import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Board {
    private int gazzoRow;
    private int gazzoCol;
    private int maxrow;
    private int maxcol;
    private Random r = new Random();

    ArrayList<ArrayList<Space>> Board = new ArrayList<ArrayList<Space>>();
    Explorer player = new Explorer("Gazoo", 20, ConsoleColors.GREEN);
    ArrayList<Treasure> remainingTreasures = new ArrayList<>();
    private int rows = 0;
    private int columns = 0;

    public Board() {
        this(4, 4);


    }

    public Board(int rows, int columns) {
        Board = new ArrayList<>();
        this.columns = columns;
        this.rows = rows;
        buildBoard();


        gazzoRow = 0;
        gazzoCol = 0;
        Board.get(gazzoRow).get(gazzoCol).setOccupant(player);
        placeCharacters();
        placeTreasures();

    }

    private void placeTreasures() {
        for (int i = 0; i < 5; i++) {
            remainingTreasures.add(new Treasure());
        }
        for (Treasure t : remainingTreasures) {
            int targetrow;
            int targetcol;
            do {
                targetrow = r.nextInt(maxrow);
                targetcol = r.nextInt(maxcol);
            } while (checkIfoccupied(Board.get(targetrow).get(targetcol)));
            Board.get(targetrow).get(targetcol).setCache(t);
        }
    }

    private void placeCharacters() {
        Monster m1 = new Monster("Razorclaw", 3, ConsoleColors.RED, 9);
        Monster m2 = new Monster("Gloomfury", 3, ConsoleColors.RED, 8);
        Monster m3 = new Monster("Fangsnarl", 3, ConsoleColors.RED, 7);
        Monster m4 = new Monster("Vilespike", 3, ConsoleColors.RED, 6);
        Monster m5 = new Monster("Grimscowl", 3, ConsoleColors.RED, 5);
        int targetrow;
        int targetcol;
        do {
            targetrow = r.nextInt(maxrow);
            targetcol = r.nextInt(maxcol);
        } while (checkIfoccupied(Board.get(targetrow).get(targetcol)));
        Board.get(targetrow).get(targetcol).setOccupant(m1);

        do {
            targetrow = r.nextInt(maxrow);
            targetcol = r.nextInt(maxcol);
        } while (checkIfoccupied(Board.get(targetrow).get(targetcol)));
        Board.get(targetrow).get(targetcol).setOccupant(m2);

        do {
            targetrow = r.nextInt(maxrow);
            targetcol = r.nextInt(maxcol);
        } while (checkIfoccupied(Board.get(targetrow).get(targetcol)));
        Board.get(targetrow).get(targetcol).setOccupant(m3);

        do {
            targetrow = r.nextInt(maxrow);
            targetcol = r.nextInt(maxcol);
        } while (checkIfoccupied(Board.get(targetrow).get(targetcol)));
        Board.get(targetrow).get(targetcol).setOccupant(m4);


        do {
            targetrow = r.nextInt(maxrow);
            targetcol = r.nextInt(maxcol);
        } while (checkIfoccupied(Board.get(targetrow).get(targetcol)));
        Board.get(targetrow).get(targetcol).setOccupant(m5);


        Healer h = new Healer("Healer", 1, ConsoleColors.BLUE, 5);
        do {
            targetrow = r.nextInt(maxrow);
            targetcol = r.nextInt(maxcol);
        } while (checkIfoccupied(Board.get(targetrow).get(targetcol)));
        Board.get(targetrow).get(targetcol).setOccupant(h);
    }

    private void buildBoard() {
        maxrow = rows - 1;
        maxcol = columns - 1;
        for (int i = 0; i < rows; i++) {
            ArrayList<Space> row = new ArrayList<>();
            for (int n = 0; n < columns; n++) {
                row.add(new Space());
            }
            Board.add(row);
        }
    }

    public void printBoard(boolean showContents) {

        String result = "";
        for (int i = 0; i < Board.size(); i++) {
            for (int j = 0; j < Board.get(i).size(); j++) {
                result += Board.get(i).get(j).getConsoleStr(showContents);
            }
            result += System.lineSeparator();
        }
        System.out.println(result);
    }


    public void applyActions(int row, int col) {
        if (checkIfoccupied(Board.get(row).get(col)).equals(true)) {
            if (Board.get(row).get(col).getOccupant() instanceof Monster) {
                Monster mon = ((Monster) Board.get(row).get(col).getOccupant());
                mon.Hurt(player);
                System.out.println(mon.getName() + " Hurt " + player.getName() + " dealing " + mon.getDamage() + " damage ");
                System.out.println(player.getName() + " has " + player.getHealth() + " health remaining");
            } else if (Board.get(row).get(col).getOccupant() instanceof Healer) {
                Healer he = ((Healer) Board.get(row).get(col).getOccupant());
                he.Heal(player);
                System.out.println(he.getName() + " has healed " + player.getName() + " by " + he.getHealValue() + " health points :)");
                System.out.println(player.getName() + " has " + player.getHealth() + " health now");
                Board.get(row).get(col).setOccupant(null);

            } else if (Board.get(row).get(col).getCache() != null){
                player.addTreasure(Board.get(row).get(col).getCache());
                System.out.println(player.getName() + " has found Treasure and took the pieces of gold");
                System.out.println((remainingTreasures.size()-1) + " more Treasure(s) of Gold remain!");
                remainingTreasures.remove(Board.get(row).get(col).getCache());
                Board.get(row).get(col).setCache(null);
            }
        }
    }

    public void checkIfDone() {
        if (player.getHealth() <= 0) {
            System.out.println(player.getName() + " has died :(, \n" + player.getTreasures().size() + " Treasures out of 5 were found");
        } else if (remainingTreasures.size() == 0) {
            System.out.println(player.getName() + " has collected all " + player.getTreasureValue() + " pieces of gold. They Have WON!! :)");
        }
    }

    public boolean move(char m) {
        if ((player.getHealth()) <= 0) {
            return false;
        } else {
            switch (m) {
                case 'a':
                    if (validSpace(gazzoRow, gazzoCol - 1)) {
                        applyActions(gazzoRow, gazzoCol - 1);

                        Board.get(gazzoRow).get(gazzoCol).setOccupant(null);
                        gazzoCol -= 1;
                        Board.get(gazzoRow).get(gazzoCol).setOccupant(player);
                        checkIfDone();
                    } else {
                        System.out.println("can't move in this direction ");
                    }
                    break;


                case 'w':
                    if (validSpace(gazzoRow - 1, gazzoCol)) {
                        applyActions(gazzoRow - 1, gazzoCol);
                        Board.get(gazzoRow).get(gazzoCol).setOccupant(null);
                        gazzoRow -= 1;
                        Board.get(gazzoRow).get(gazzoCol).setOccupant(player);
                        checkIfDone();

                    } else {
                        System.out.println("can't move in this direction ");
                    }
                    break;
                case 's':
                    if (validSpace(gazzoRow + 1, gazzoCol)) {
                        applyActions(gazzoRow + 1, gazzoCol);
                        Board.get(gazzoRow).get(gazzoCol).setOccupant(null);
                        gazzoRow += 1;
                        Board.get(gazzoRow).get(gazzoCol).setOccupant(player);
                        checkIfDone();

                    } else {
                        System.out.println("can't move in this direction ");
                    }
                    break;
                case 'd':
                    if (validSpace(gazzoRow, gazzoCol + 1)) {
                        applyActions(gazzoRow, gazzoCol + 1);
                        Board.get(gazzoRow).get(gazzoCol).setOccupant(null);
                        gazzoCol += 1;
                        Board.get(gazzoRow).get(gazzoCol).setOccupant(player);
                        checkIfDone();
                    } else {
                        System.out.println("can't move in this direction ");
                    }

                    case 'r' :
                   printBoard(true);
break;
                case 'i' :
                    System.out.println(player.getName() + " has found " + player.getTreasures() + " totaling " + player.getTreasureValue() + " gold, so far");
                     {
                        System.out.println("can't move in this direction ");
                    }
                    break;
                default:
                    System.out.println("Not a vaild input! ");
                    return false;


            }

            return false;
        }


    }


    public boolean validSpace(int row, int col) {
        return row >= 0 && row < Board.size() && col >= 0 && col < Board.get(row).size();

    }

    public boolean validSpaceL(int row) {
        if (gazzoRow != 0) {

            return true;
        } else {
            System.out.println("can't move in this direction ");
            return false;
        }
    }

    public boolean validSpaceR(int col) {
        if (gazzoCol >= maxcol - 1) {
            System.out.println("can't move in this direction ");
            return false;
        } else {

            return true;
        }
    }


    public boolean validSpaceW(int col) {
        if (gazzoCol != 0) {

            return true;
        } else {
            System.out.println("can't move in this direction ");
            return false;
        }
    }


    public boolean validSpaceS(int rows) {
        if (gazzoCol >= maxrow - 1) {
            System.out.println("can't move in this direction ");
            return false;
        } else {

            return true;
        }
    }

    public Boolean checkIfoccupied(Space l) {
        if (l.getOccupant() != null || l.getCache() != null) {
            return true;

        } else {
            return false;
        }

    }

}