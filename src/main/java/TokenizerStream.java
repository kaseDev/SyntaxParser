import java.io.InputStream;
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

    public TokenizerStream() {

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
        return null; // implement later
    }

}
