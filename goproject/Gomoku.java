package goproject;

import java.util.Scanner;

class Gomoku {

    private int size;
    private int[] map; // map to store game steps
    private boolean playerX;
    private Scanner scanner = new Scanner(System.in);
    private int x;
    private int y;

    Gomoku(int size) {
        this.size = size < 5 ? 5 : size;
        this.map = new int[this.size * this.size];
        this.playerX = true;
        this.x = 0;
        this.y = 0;
    }

    void run() {
        int step;
        int stepCounter = 0;
        ConsolPrint consol = new ConsolPrint(map, size);
        MapChecker checker = new MapChecker(size, map);
        
        while(true){
            if (++stepCounter > this.size * this.size){
                System.out.println("Game over");
                return ;              
            }
            consol.printMap(map);
            step = getStep();
            if (!addStep(step))
                continue;
            if (checker.checkMap(step, this.x, this.y) == 5) // returns max number of blocks in line
                break;
            this.playerX = !this.playerX;
        }
        scanner.close();
        consol.printMap(map);
        System.out.println("Winner is Player " + (this.playerX ? "X" : "O"));
        System.out.println("He won in " + stepCounter + " steps");
    }

    private boolean addStep(int step){
        if (this.map[step] != 0){
            System.out.println("Error: Entered ceil is not empty! Please enter another ceil.");
            return false;
        }
        if (playerX)
            this.map[step] = 1;
        else
            this.map[step] = 2;
        return true;
    }

    // scanning Players move
    private int getStep(){
        int step = 0;
        String line;

        System.out.print("Enter your move ");
        System.out.println("Player " + (playerX ? "X:" : "O:"));
        while (true)
        {
            if (scanner.hasNextLine())
            {
                line = scanner.nextLine();
                if (line.matches("[a-zA-Z]\\d+"))
                {
                    step += (line.charAt(0) - 'a');
                    this.x = step;
                    line = line.replaceAll("[a-zA-Z]", "");
                    step = (this.y = (Integer.parseInt(line) - 1)) * size + step;
                    if (step >= 0 && step < map.length)
                        break;
                }
            }
            System.out.println("Enter your move (chose ceil) in "
                    + "appropriate format: i12, A9, o10");
        }
        return step;
    }
}
