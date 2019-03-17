import java.io.InputStream;
import java.util.Scanner;

public class Parser {

    private ProductionRule[] productionRules;
    private TokenizerStream tokenStream;
    private TokenStack stack;

    public Parser(ProductionRule[] productionRules, String inputText) {
        this.productionRules = productionRules;
        this.tokenStream = new TokenizerStream();
        this.tokenStream.setInput(inputText);
        this.stack = new TokenStack();
    }

    public Parser(ProductionRule[] productionRules, InputStream inputStream) {
        this.productionRules = productionRules;
        this.tokenStream = new TokenizerStream();
        this.tokenStream.setInput(inputStream);
        this.stack = new TokenStack();
    }

    public Parser(ProductionRule[] productionRules, Scanner inputScanner) {
        this.productionRules = productionRules;
        this.tokenStream = new TokenizerStream();
        this.tokenStream.setInput(inputScanner);
        this.stack = new TokenStack();
    }

    
}
