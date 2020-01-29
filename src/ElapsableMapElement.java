abstract class ElapsableMapElement extends MapElement{
    public final Vector2d position;
    int lengthOfLife;
    Map map;

    public ElapsableMapElement(Vector2d position, Map map) {
        this.position = position;
        this.map = map;
    }

    void justAnotherDay()
    {
        lengthOfLife--;
    };

    int timeToDeath()
    {
        return lengthOfLife;
    };

    void putIntoRemoved() {
        map.removedElements.push(position);
    }
}
