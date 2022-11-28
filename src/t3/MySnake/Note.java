package t3.MySnake;

import java.util.Random;

public class Note {
    private int x;
    private int y;

    public Note(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Note(){

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void random(){
        Random r=new Random();
        this.x=r.nextInt(40);
         this.y=r.nextInt(40);
    }
}
