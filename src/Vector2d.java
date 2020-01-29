import java.util.Objects;

public class Vector2d {

    int x;
    int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;

    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public boolean precedes(Vector2d other) {
        return (this.x <= other.x && this.y <= other.y);
    }

    boolean follows(Vector2d other) {
        return (this.x >= other.x && this.y >= other.y);

    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
    }

    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }


    public Vector2d opposite() {
        return new Vector2d(-1 * (this.x), -1 * (this.y));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return x == vector2d.x &&
                y == vector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Vector2d randomVector(Vector2d lowerLeft, Vector2d upperRight) {
        int x = (int) ((Math.random() * ((upperRight.x - lowerLeft.x) + 1)) + lowerLeft.x);
        int y = (int) ((Math.random() * ((upperRight.y - lowerLeft.y) + 1)) + lowerLeft.y);
        return new Vector2d(x, y);
    }

    public Vector2d movedIntoDirection(int direction) {
        int x = 0;
        int y = 0;
        switch (direction) {
            case 0:
                y = 1;
                break;
            case 1:
                x = 1;
                break;
            case 2:
                y = -1;
                break;
            case 3:
                x = -1;
                break;
        }
        return this.add(new Vector2d(x, y));
    }

    public boolean between(Vector2d lowerLeft, Vector2d upperRight) {
        if (this.follows(lowerLeft))// czy nie przekroczy granicy
            if (this.precedes(upperRight))
                return true;

        return false;
    }

    Vector2d borderTeleport(Vector2d lowerLeft, Vector2d upperRight) {
        if (this.x < 0)
            this.x = upperRight.x;
        if (this.y < 0)
            this.y = upperRight.y;
        Vector2d vector2d = new Vector2d((this.x % (upperRight.x+1)), (this.y % (upperRight.y+1)));
        return vector2d;
    }


}

