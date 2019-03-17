import java.util.Arrays;
import java.util.List;

public class ProductionRule {

    private TokenType[] pattern;
    private TokenType result;

    public ProductionRule(TokenType[] pattern, TokenType result) {
        this.pattern = pattern;
        this.result = result;
    }

    public TokenType[] getPattern() {
        return pattern;
    }

    public TokenType getResult() {
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
    public int testAgainstPattern(TokenType[] tokens) {
        System.out.println(Arrays.toString(tokens));
        if (tokens.length == 0)
            throw new IllegalStateException("Stack checked is empty");
        if (Arrays.equals(tokens, pattern))
            return 1;
        for (int i = 0; i < tokens.length; i++) {
            for (int j = pattern.length - 1; j >= - 1 - i; j--) {
                if (Arrays.equals(Arrays.copyOfRange(tokens, i, tokens.length), Arrays.copyOfRange(pattern, 0, tokens.length - i)))
                    return 0;
            }
        }
        return -1;
    }
}
