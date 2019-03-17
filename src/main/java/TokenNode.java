public class TokenNode implements SyntaxTreeNode {

    private Token token;

    public TokenNode(Token token) {
        this.token = token;
    }

    public TokenType getTokenType() {
        return token.getTokenType();
    }

    public String getValue() {
        return token.getValue();
    }
}
