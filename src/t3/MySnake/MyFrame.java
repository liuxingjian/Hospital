package t3.MySnake;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class MyFrame extends JFrame {
    private Snake  snake;
    private JPanel jp;
    private Note food;
    public MyFrame() throws HeadlessException {
        initfame();
        initGamePanel();
        initSnake();
        initTimer();
        setKeyListener();
        setFood();
    }

    private void setFood() {
        food=new Note();
        food.random();
    }

    private void setKeyListener() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if(snake.getDirection()!=Direction.DOWM)
                        {
                            snake.setDirection(Direction.UP);
                            break;
                        }
                    case KeyEvent.VK_DOWN:
                        if(snake.getDirection()!=Direction.UP)
                        {
                            snake.setDirection(Direction.DOWM);
                            break;
                        }
                    case KeyEvent.VK_LEFT:
                        if(snake.getDirection()!=Direction.RIGHT)
                        {
                            snake.setDirection(Direction.LEFT);
                            break;
                        }
                    case KeyEvent.VK_RIGHT:
                        if(snake.getDirection()!=Direction.LEFT)
                        {
                            snake.setDirection(Direction.RIGHT);
                            break;
                        }
                }
            }
        });
    }



    private void initTimer() {
        Timer timer = new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                snake.move();
                Note head=snake.getBody().getFirst();
                try{
                    if(head.getX()==food.getX()&&head.getY()==food.getY())
                    {
                        snake.eat(food);
                        food.random();
                    }
                }catch (NullPointerException e){

                }

                jp.repaint();
            }
        };
        timer.scheduleAtFixedRate(timerTask,0,100);

    }

    private void initSnake() {
        snake=new Snake();
    }


    private void initGamePanel() {
           jp=new JPanel(){
            public void paint(Graphics g)
            {
                g.clearRect(0,0,600,600);
                for(int i=0;i<=40;i++){
                    g.drawLine(0,15*i,600,i*15);
                }
                for(int i=0;i<=40;i++){
                    g.drawLine(15*i,0,15*i,600);
                }
                //绘制蛇

                LinkedList<Note>body=snake.getBody();
                for(Note note:body)
                {
                    g.fillRect(note.getX()*15,note.getY()*15,15,15);
                }
                //绘制food
                g.fillRect(food.getX()*15, food.getY()*15,15,15 );
            }

        };

        add(jp);

    }


    private void initfame() {
        setSize(618,640);
        setLocation(400,50);
    }

//    public static void main(String[] args) {
//        new MyFrame().setVisible(true);
//    }
}
