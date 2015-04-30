
import java.awt.Component;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Drew Jenney
 */
public class Main {
    
    public static void main(String args[]) {
        int input;
        BattleshipGame game;
        
        /*
        try{
            BattleshipServerInterface conn = new BattleshipServerInterface();
        }catch(IOException ex) {
            ex.printStackTrace();
        }
        */
                
        //run games until player says no
        do{
            game = new BattleshipGame();

            input = JOptionPane.showConfirmDialog(
                    (Component)null, 
                    "Would you like to play again?", 
                    "Battleship", 
                    JOptionPane.YES_NO_OPTION);
        } while(input == JOptionPane.YES_OPTION);
    }
}
