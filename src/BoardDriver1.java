import java.util.Scanner;

public class BoardDriver1 {



    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
         char i;
        Board b2 = new Board(8, 9);
        do {
            b2.printBoard();
            System.out.print("To move Gazoo, type the character w to move up, a to move left, s to move down, or d to move right! ->  ");
            i = input.next().charAt(0);
            b2.move(i);
            //prompt the user for w s
            // w a s d
            //pass that as a char to move
        } while (true);




    }

}
