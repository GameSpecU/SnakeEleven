import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import static java.util.stream.Collectors.toCollection;

public class Simulation implements KeyListener {
    int points;
    int speed;
    Map map;
    int numberOfDay;
    boolean isDead;

    public Simulation(Map map) {
        this.points = 0;
        this.map = map;
        this.speed=1000;
        this.numberOfDay = 0;
        this.isDead=false;
    }

    void day() {
        for (iMapElement body :
                map.fields.values().stream()
                        .filter(x -> x instanceof ElapsableMapElement)
                        .collect(toCollection(LinkedList::new))) {
            ((ElapsableMapElement) body).justAnotherDay();
        }

        map.fields.values().stream().filter(x->x instanceof ElapsableMapElement && ((ElapsableMapElement)x).timeToDeath() <=0).forEach(t -> ((ElapsableMapElement)t).putIntoRemoved());
        map.fields.values().removeIf(x -> x instanceof ElapsableMapElement && ((ElapsableMapElement) x).timeToDeath() <= 0);

        map.fields.put(map.head.position, new SnakeBody(map.head.snakeLength, map.head.position, map));

        Vector2d newHeadPosition = map.head.move();
        if (map.fields.containsKey(newHeadPosition)) {
            iMapElement elementThatSnakeHeadMeet = map.fields.get(newHeadPosition);
            if (elementThatSnakeHeadMeet instanceof Deadly)
                this.death();
            if (elementThatSnakeHeadMeet instanceof Fruit) {
                map.head.eat((Fruit) elementThatSnakeHeadMeet);
                points += speed/10;
                map.newFruit();
            }
        }
        speed*=1.002;
        if(numberOfDay%1000 == 0)
            map.treeOfKnowledgeOfGoodAndEvil();
        numberOfDay++;
    }


    void death() {
        isDead = true;
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {
//donothing
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getExtendedKeyCode())
        {
            case KeyEvent.VK_UP:
                map.head.changeDirection(3);
                break;
            case KeyEvent.VK_RIGHT:
                map.head.changeDirection(0);
                break;
            case KeyEvent.VK_DOWN:
                map.head.changeDirection(1);
                break;
            case KeyEvent.VK_LEFT:
                map.head.changeDirection(2);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
//donothing

    }
}
