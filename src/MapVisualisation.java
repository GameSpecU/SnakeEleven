import javax.swing.*;
import java.awt.*;

public class MapVisualisation extends JPanel {

    Map map;
    JPanel[][] grid;
    int width;
    int height;

    public MapVisualisation(Map map) {
        this.map = map;
        this.width = map.width + 1;
        this.height = map.height + 1;
        this.grid = new JPanel[this.width][this.height];
        this.setLayout(new GridLayout(this.width, this.height));
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                grid[i][j] = new JPanel();
                grid[i][j].setVisible(true);
                grid[i][j].repaint();
                this.add(grid[i][j]);
            }
        }
        setVisible(true);
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                grid[i][j].setBackground(Color.darkGray);
            }
        }
        update();
    }


    void update() {

        while (!map.removedElements.empty()){
            Vector2d toGray = map.removedElements.pop();
            grid[toGray.x][toGray.y].setBackground(Color.darkGray);
        }

        for (iMapElement field : map.fields.values()
        ) {
            if (field instanceof SnakeBody)
                grid[((SnakeBody) field).position.x][((SnakeBody) field).position.y].setBackground(Color.black);
            if (field instanceof Fruit)
                grid[((Fruit) field).position.x][((Fruit) field).position.y].setBackground(Color.green);
            if (field instanceof ForbiddenFruit)
                grid[((ForbiddenFruit) field).position.x][((ForbiddenFruit) field).position.y].setBackground(Color.red);

        }
        grid[map.head.position.x][map.head.position.y].setBackground(Color.CYAN);

    }
}
