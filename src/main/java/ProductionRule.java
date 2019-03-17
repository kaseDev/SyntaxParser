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

    public boolean testAgainstFrontOfPattern(List<Token> tokens) {
        for (int i = 0; i < tokens.size(); i++)
            if (!pattern[i].equals(tokens.get(i)))
                return false;
        return true;
    }
}
