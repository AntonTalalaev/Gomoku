/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package goproject;

/**
 *
 * @author am.talalaev
 */
class ConsolPrint {

     private int[] map;
     private int size;
    
    
ConsolPrint(int[] map, int size){
    this.map = map;
    this.size = size;
    
}

  // print in consol
  void printMap(int[] map){
        int x = 0;
        int y = 0;
        int i = 0;

        printLine();
        printAlphabet();
        while (y < size){
            System.out.printf("%02d|", y + 1);
            x = 0;
            while (x < size){
                System.out.print(((map[i] == 0) ? (" ") : 
                        ((map[i] == 1) ? "X" : "O")) + "|");
                i++;
                x++;
            }
            System.out.println();
            y++;
        }
        printLine();
    }

    private void printLine(){
        int x = 0;

        System.out.print("   ");
        while (x < size * 2 - 1){
            System.out.print("-");
            x++;
        }
        System.out.println();
    }

    private void printAlphabet(){
        int x = 1;
        char c = 'a';

        System.out.print("  |");
        while (x <= size){
            System.out.print(c + "|");
            x++;
            c++;
        }
        System.out.println();
    }
}