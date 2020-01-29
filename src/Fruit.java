public class Fruit extends ElapsableMapElement {
    int energy =1;
    public Fruit(Vector2d position, Map map) {
        super(position, map);
        this.lengthOfLife = 1000;

    }
}
