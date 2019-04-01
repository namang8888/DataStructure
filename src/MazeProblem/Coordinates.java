package MazeProblem;

import java.util.Objects;

public class Coordinates {

    int x;
    int y;

    Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static Coordinates[] getMoves(){
        Coordinates[] moves = new Coordinates[8];

        Coordinates n = new Coordinates(-1,0);
        Coordinates ne = new Coordinates(-1,1);
        Coordinates e = new Coordinates(0,1);
        Coordinates se = new Coordinates(1,1);
        Coordinates s = new Coordinates(1,0);
        Coordinates sw = new Coordinates(1,-1);
        Coordinates w = new Coordinates(0,-1);
        Coordinates nw = new Coordinates(-1,-1);

        moves[0] = n;
        moves[1] = ne;
        moves[2] = e;
        moves[3] = se;
        moves[4] = s;
        moves[5] = sw;
        moves[6] = w;
        moves[7] = nw;

        return moves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + '}';
    }
}
