public class SnakeBody extends ElapsableMapElement implements Deadly {

    SnakeBody(int lengthOfLife,Vector2d position, Map map) {
        super(position, map);
        this.lengthOfLife = lengthOfLife;
    }


}
