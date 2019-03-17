public class SyntaxTree implements SyntaxTreeNode {

    private TokenType type;
    private SyntaxTreeNode[] children;

    public SyntaxTree(TokenType type, SyntaxTreeNode[] children) {
        this.type = type;
        this.children = children;
    }

    public TokenType getType() {
        return type;
    }

    public SyntaxTreeNode[] getChildren() {
        return children;
    }
}
