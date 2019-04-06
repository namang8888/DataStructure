package Tree;

public enum Traversal {

    INORDER("InOrder"),PREORDER("PreOrder"),POSTORDER("PostOrder"),BREADTHFIRST("BreadthFirst");

    private String traversalType;

    Traversal(String traversalType) {
        this.traversalType = traversalType;
    }

    public String getTraversalType() {
        return traversalType;
    }
}
