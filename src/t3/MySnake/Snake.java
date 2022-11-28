package t3.MySnake;

import java.util.LinkedList;

public class Snake {
    private LinkedList<Note>body;
    private Direction direction=Direction.LEFT;
    private Boolean isLiving=true;

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public Snake() {
       initSnake();
    }
    public void move(){
        if(isLiving)
        {
            Note head=body.getFirst();
            switch (direction)
            {
                case UP:
                    body.addFirst(new Note(head.getX(), head.getY()-1));
                    break;
                case LEFT:
                    body.addFirst(new Note(head.getX()-1, head.getY()));
                    break;
                case DOWM:
                    body.addFirst(new Note(head.getX(), head.getY()+1));
                    break;
                case RIGHT:
                    body.addFirst(new Note(head.getX()+1, head.getY()));
                    break;
            }
            body.removeLast();
            head=body.getFirst();
            if(head.getX()<0||head.getX()>=39||head.getY()<0||head.getY()>=39)
            {
                isLiving=false;
            }
            for(int i=1;i<body.size();i++)
            {
                Note note=body.get(i);
                if(head.getY()==note.getY()&&head.getX()==note.getX())
                {
                    isLiving=false;
                }
            }
            //吃食物

        }

    }

    public void initSnake() {
        body=new LinkedList<>();
        body.add(new Note(16,22));
        body.add(new Note(17,22));
        body.add(new Note(18,22));
        body.add(new Note(19,22));
        body.add(new Note(20,22));
        body.add(new Note(21,22));

    }

    public LinkedList<Note> getBody() {
        return body;
    }

    public void setBody(LinkedList<Note> body) {
        this.body = body;
    }

    public void eat(Note food) {
        Note head=body.getFirst();
        switch (direction)
        {
            case UP:
                body.addFirst(new Note(head.getX(), head.getY()-1));
                break;
            case LEFT:
                body.addFirst(new Note(head.getX()-1, head.getY()));
                break;
            case DOWM:
                body.addFirst(new Note(head.getX(), head.getY()+1));
                break;
            case RIGHT:
                body.addFirst(new Note(head.getX()+1, head.getY()));
                break;
        }
    }
}
