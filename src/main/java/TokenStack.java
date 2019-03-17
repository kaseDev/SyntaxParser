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
}
