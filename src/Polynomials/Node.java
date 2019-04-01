package Polynomials;

public class Node {

    private int coef;

    private int expo;

    public Node(int coef, int expo) {
        this.coef = coef;
        this.expo = expo;
    }

    public int getCoef() {
        return coef;
    }

    public int getExpo() {
        return expo;
    }

    @Override
    public String toString() {
        return "Node{" +
                "coef=" + coef +
                ", expo=" + expo +
                '}';
    }
}
