import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CompleteSyntaxTree {

    private List<SyntaxTreeNode> roots;
    private ProductionRule[] startRules;
    private ProductionRule[] productionRules;

    public CompleteSyntaxTree(ProductionRule[] startRules, ProductionRule[] productionRules) {
        roots = new LinkedList<>();
        this.startRules = startRules;
        this.productionRules = productionRules;
    }

    /**
     * returns 0 if there are possible pending production rules
     * returns -1 if there is a syntax error
     * @param token
     * @return
     */
    public int push(Token token) {
        return push(new TokenNode(token));
    }

    private int push(SyntaxTreeNode node) {
        roots.add(node);
        int patternCheck = checkProductionRules();
        if (patternCheck >= 0) {
            return push(new SyntaxTree(productionRules[patternCheck].getResult(), pop(productionRules[patternCheck])));
        }
        return patternCheck + 1;
    }

    private TokenType[] peek(int count) {
        if (count <= 0)
            throw new ArrayIndexOutOfBoundsException("Tried to access " + count + "... which makes no sense.");
        TokenType[] tokenTypes;
        if (count >= roots.size()) {
            tokenTypes = new TokenType[roots.size()];
            for (int i = 0; i < roots.size(); i++) {
                tokenTypes[i] = roots.get(i).getTokenType();
            }
        } else {
            tokenTypes = new TokenType[count];
            for (int i = 0; i < count; i++)
                tokenTypes[i] = roots.get(roots.size() - 1 - i).getTokenType();
        }
        return tokenTypes;
    }

    private SyntaxTreeNode[] pop(ProductionRule rule) {
        int removeIndex = roots.size() - rule.getPattern().length;
        SyntaxTreeNode[] tokens = new SyntaxTreeNode[rule.getPattern().length];
        for (int i = 0; i < tokens.length; i++)
            tokens[i] = roots.remove(removeIndex);
        return tokens;
    }

    /**
     * Returns one of the following:
     * the index of the first successful ProductionRule if there is a
     * successful ProductionRule,
     * -1 if there is not a successful ProductionRules but there is at least
     * 1 pending ProductionRule,
     * or -2 if there are no successful or pending ProductionRules, resulting
     * in all ProductionRules failing. -2 should result in the throwing of an
     * exception.
     */
    private int checkProductionRules() {
        boolean pending = false;
        for (int prodRuleIndex = 0; prodRuleIndex < productionRules.length; prodRuleIndex++) {
            int checkResult = productionRules[prodRuleIndex]
                    .testAgainstPattern(peek(productionRules[prodRuleIndex].getPattern().length));
//            System.out.println(Arrays.toString(productionRules[prodRuleIndex].getPattern()) + ": " + checkResult);
            if (checkResult == 1) {
                return prodRuleIndex;
            }
            else if (checkResult == 0)
                pending = true;
        }
        return (pending) ? -1 : -2;
    }

    public boolean checkStartRules() {
        for (ProductionRule startRule : startRules) {
            if (startRule.testAgainstPattern(peek(startRule.getPattern().length)) >= 0)
                return true;
        }
        return false;
    }
}
