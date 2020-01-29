public class ForbiddenFruit extends ElapsableMapElement implements Deadly {
    public ForbiddenFruit(Vector2d position, Map map) {
        super(position, map);
        this.lengthOfLife = 4000;
    }


}
