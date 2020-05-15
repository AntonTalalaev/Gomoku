/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package goproject;

/**
 *
 * @author am.talalaev
 */
class MapChecker {
    
    private int size;
    private int[] map;
    private int x;
    private int y;
   
    MapChecker(int size, int[] map) {
        this.size = size;
        this.map = map;
    }
    
    int checkMap(int step, int x, int y){
        int playerNumber = map[step];
        int counter = 0;
        int tmp;
        this.x = x;
        this.y = y;
        
        System.out.println("checkMap  y = " + y + " x = " + x);
        tmp = checkHorizontal(step, playerNumber);
        if (tmp > counter)
            counter = tmp;
        tmp = checkVertical(step, playerNumber);
        if (tmp > counter)
            counter = tmp;
        tmp = checkLeftDiagonal(step, playerNumber);
        if (tmp > counter)
            counter = tmp;
        tmp = checkRightDiagonal(step, playerNumber);
        if (tmp > counter)
            counter = tmp;
        return counter;
    }
    
    private int checkRightDiagonal(int step, int playerNumber){
        int counter = 1;
        int i = step;
        int y = this.y;
        int x = this.x;
        
        while(++y < this.size && --x >= 0){
            i += this.size;
            i--;
            if (this.map[i] == playerNumber)
                counter++;
            else
                break;
        }
        y = this.y;
        x = this.x;
        i = step;
        while(--y >= 0 && ++x < this.size){
            i -= this.size; 
            i++;
            if (this.map[i] == playerNumber)
                counter++;
            else
                break;
        }
        return counter;
    }
    
    private int checkLeftDiagonal(int step, int playerNumber){
        int counter = 1;
        int i = step;
        int y = this.y;
        int x = this.x;
        
        while(--y >= 0 && --x >= 0){
            i -= size;
            i--;
            if (this.map[i] == playerNumber)
                counter++;
            else
                break;
        }
        y = this.y;
        x = this.x;
        i = step;
        while(++y < this.size && ++x < this.size){
            i += this.size; 
            i++;
            if (this.map[i] == playerNumber)
                counter++;
            else
                break;
        }
        return counter;
    }  

    private int checkVertical(int step, int playerNumber){
        int counter = 1;
        int i = step;
        int y = this.y;
        
        while(--y >= 0){
            i -= size;
            if (this.map[i] == playerNumber)
                counter++;
            else
                break;
        }
        y = this.y;
        i = step;
        while(++y < this.size){
            i += this.size; 
            if (this.map[i] == playerNumber)
                counter++;
            else
                break;
        }
        return counter;
    }
    
    private int checkHorizontal(int step, int playerNumber){
        int counter = 1;
        int i = step;
        int x = this.x;
        
        while(--x >= 0){
            if (this.map[--i] == playerNumber)
                counter++;
            else
                break;
        }
        x = this.x;
        i = step;
        while(++x < this.size){
            if (this.map[++i] == playerNumber)
                counter++;
            else
                break;
        }
        return counter;
    }
}