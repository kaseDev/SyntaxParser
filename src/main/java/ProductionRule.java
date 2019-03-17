import java.util.List;

public class ProductionRule {

    private Token[] pattern;
    private Token result;

    public ProductionRule(Token[] pattern, Token result) {
        this.pattern = pattern;
        this.result = result;
    }

    public Token[] getPattern() {
        return pattern;
    }

    public Token getResult() {
        return result;
    }

    /**
     * Returns one of the following:
     * 1 if the production rule is matched by the input tokens
     * 0 if the production rule is matched to an extent but is incomplete
     * -1 if the production rule is violated.
     * @param tokens
     * @return
     */
    public int testAgainstPattern(Token[] tokens) {
        for (int i = 0; i < tokens.length; i++)
            if (!pattern[i].equals(tokens[i]))
                return -1;
        return (tokens.length == pattern.length) ? 1 : 0;
    }
}
