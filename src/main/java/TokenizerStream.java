import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Given a Scanner and a Map of Regex to TokenTypes, this
 * class acts as a stream of Tokens that returns the next
 * matched Token from the Scanner. If there is a syntax error
 * from the input scanner then it will be thrown upon calling
 * next() when the scanner reaches that portion of the input.
 */
public class TokenizerStream {

    private Scanner scan;

    private List<Token> dummyTestData = new LinkedList<>();
    private int place = 0;

    public TokenizerStream() {
        dummyTestData.add(new Token(TokenType.LPAREN, "0: ("));
        dummyTestData.add(new Token(TokenType.VAR, "1: a"));
        dummyTestData.add(new Token(TokenType.BINOP, "2: &&"));
        dummyTestData.add(new Token(TokenType.VAR, "3: b"));
        dummyTestData.add(new Token(TokenType.RPAREN, "4: )"));
        dummyTestData.add(new Token(TokenType.BINOP, "5: ||"));
        dummyTestData.add(new Token(TokenType.LPAREN, "6: ("));
        dummyTestData.add(new Token(TokenType.VAR, "7: c"));
//        dummyTestData.add(new Token(TokenType.BINOP, "8: &&"));
//        dummyTestData.add(new Token(TokenType.UNIOP, "9: !"));
//        dummyTestData.add(new Token(TokenType.VAR, "10: d"));
//        dummyTestData.add(new Token(TokenType.RPAREN, "11: )"));
    }

    public void setInput(Scanner scan) {
        this.scan = scan;
    }

    public void setInput(InputStream stream) {
        scan = new Scanner(stream);
    }

    public void setInput(String string) {
        scan = new Scanner(string);
    }

    public Token next() {
        return dummyTestData.get(place++);
    }

    public boolean hasNext() {
        return place < dummyTestData.size();
    }

}
