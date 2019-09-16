// TicTacToe game from Michael Fudge's Java tutorials
 
package tictactoegame;

import java.util.Scanner;
import tictactoe.*;
import java.util.InputMismatchException;

public class TicTacToeGameRun {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Board b = new Board(); 
        int row, col;
        boolean winner = false;
        Marker currentPlayer = Marker.X;
        System.out.printf("Let's Play Tic-Tac-Toe!!!\n\n");
        while(true) {

            // Draw Board
            b.Draw();
            
            // Get input for row and column
            System.out.printf("%s's turn! Enter Row : ",currentPlayer);
            row = input.nextInt();
            System.out.printf("%s's turn! Enter Col : ",currentPlayer);
            col = input.nextInt();            

            // place marker of current player on board at row and col
            while (true){
                try{
                    b.Place(currentPlayer, row, col);
                    break;
                } catch (ArrayIndexOutOfBoundsException ex){
                        System.out.println("That is not a valid space. Choose again.");
                        System.out.printf("%s's turn! Enter Row : ",currentPlayer);
                        row = input.nextInt();
                        System.out.printf("%s's turn! Enter Col : ",currentPlayer);
                        col = input.nextInt();  
                } catch (SpaceNotAvailableException ex) {
                        System.out.println("That space is already occupied. Choose again.");
                        System.out.printf("%s's turn! Enter Row : ",currentPlayer);
                        row = input.nextInt();
                        System.out.printf("%s's turn! Enter Col : ",currentPlayer);
                        col = input.nextInt(); 
                    }
                }
            winner = b.Winner(currentPlayer); // check for winner, 
            if (winner || b.Full()) { // exit loop if winner or board full
                 break;
            }
            // Switch Players
            currentPlayer = currentPlayer == Marker.X ? Marker.O : Marker.X;
            

        } // end while
        
        b.Draw();
        // check again for winner, if not it's a tie.
        if (winner) {            
            System.out.printf("GAME OVER. %s WINS!\n", currentPlayer);
        } else {
            System.out.printf("GAME OVER. It's a TIE!\n");
        }

    }
}
