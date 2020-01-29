public class SnakeHead extends MapElement implements iMapElement {
    int direction;
    int snakeLength;
    Vector2d position;
    Map map;


    SnakeHead(Vector2d position, Map map) {
        this.position = position;
        this.map = map;
        this.snakeLength=5;
    }

    int eat(Fruit fruit)
    {
        snakeLength += fruit.energy;
        map.fields.remove(fruit.position);
        return fruit.energy;
    }
    Vector2d move(){
        position = position.movedIntoDirection(direction).borderTeleport(map.lowerLeft, map.upperRight);
        return position;
    }

    void changeDirection(int direction) {
        if(Math.abs(direction-this.direction) != 2)
            this.direction = direction;
    }
}
