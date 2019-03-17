import java.util.ArrayList;

public class TokenStack {

    private ArrayList<Token> array;

    public TokenStack() {
        array = new ArrayList<Token>();
    }

    public void push(Token token) {
        array.add(token);
    }

    public Token[] peek(int count) {
        if (count <= 0 || count > array.size())
            throw new ArrayIndexOutOfBoundsException("Tried to access " + count + " elements, but there is only "
                    + array.size() + " elements in the stack");
        Token[] tokens = new Token[count];
        for (int i = 0; i < count; i++)
            tokens[i] = array.get(array.size() - 1 - i);
        return tokens;
    }

    public Token[] pop(int count) {
        int size = array.size();
        if (count <= 0 || count > size)
            throw new ArrayIndexOutOfBoundsException("Tried to access " + count + " elements, but there is only "
                    + array.size() + " elements in the stack");
        Token[] tokens = new Token[count];
        for (int i = 0; i < count; i++) {
            tokens[i] = array.get(size - count);
            array.remove(size - count);
        }
        return tokens;
    }

//    /**
//     * Returns one of the following:
//     * the index of the first successful ProductionRule if there is a
//     * successful ProductionRule,
//     * -1 if there is not a successful ProductionRules but there is at least
//     * 1 pending ProductionRule,
//     * or -2 if there are no successful or pending ProductionRules, resulting
//     * in all ProductionRules failing. -2 should result in the throwing of an
//     * exception.
//     */
//    public int checkProductionRules(ProductionRule[] productionRules) {
//        boolean pending = false;
//        for (int i = 0; i < productionRules.length; i++) {
//            for (int j = 1; j <= Math.min(productionRules[i].getPattern().length, array.size()); i++) {
//                int testResult = productionRules[i].testAgainstPattern(peek(j));
//                if (testResult == 1)
//                    return i;
//                else if (!pending && testResult == 0)
//                    pending = true;
//            }
//        }
//        return (pending) ? -1 : -2;
//    }
}
