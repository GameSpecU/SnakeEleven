import java.util.HashMap;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;

public class Map {

    final int height;
    final int width;
    final Vector2d lowerLeft;
    final Vector2d upperRight;
    SnakeHead head;

    java.util.Map<Vector2d, iMapElement> fields = new HashMap<>();
    Stack<Vector2d> removedElements = new Stack<>();

    Map(int height, int width) {
        this.height = height;
        this.width = width;
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width, height);
        this.head = new SnakeHead(new Vector2d(width / 2, height / 2), this);
        newFruit();
    }

    public Vector2d getRandomEmptyField() {
        Random random = new Random();
        int x;
        int y;
        do {

            x = random.nextInt(width);
            y = random.nextInt(width);
        } while (fields.containsKey(new Vector2d(x, y)));

        return new Vector2d(x, y);
    }

    public void treeOfKnowledgeOfGoodAndEvil() {
        Random random = new Random();
        if (random.nextBoolean())
            newFruit();
        else
            newForbiddenFruit();
    }

    public void newFruit() {
        Vector2d pos = getRandomEmptyField();
        fields.put(pos, new Fruit(pos, this));
    }

    public void newForbiddenFruit() {
        Vector2d pos = getRandomEmptyField();
        fields.put(pos, new ForbiddenFruit(pos, this));
    }

}
