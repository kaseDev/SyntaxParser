import java.io.InputStream;
import java.util.Scanner;

public class Parser {

    private ProductionRule[] startRules;
    private ProductionRule[] productionRules;
    private TokenizerStream tokenStream;
    private TokenStack tokenStack;

    public Parser(ProductionRule[] startRules, ProductionRule[] productionRules, String inputText) {
        this.startRules = startRules;
        this.productionRules = productionRules;
        this.tokenStream = new TokenizerStream();
        this.tokenStream.setInput(inputText);
        this.tokenStack = new TokenStack();
    }

    public Parser(ProductionRule[] startRules, ProductionRule[] productionRules, InputStream inputStream) {
        this.startRules = startRules;
        this.productionRules = productionRules;
        this.tokenStream = new TokenizerStream();
        this.tokenStream.setInput(inputStream);
        this.tokenStack = new TokenStack();
    }

    public Parser(ProductionRule[] startRules, ProductionRule[] productionRules, Scanner inputScanner) {
        this.startRules = startRules;
        this.productionRules = productionRules;
        this.tokenStream = new TokenizerStream();
        this.tokenStream.setInput(inputScanner);
        this.tokenStack = new TokenStack();
    }

    public SyntaxTree parse() {
        SyntaxTree tree;
        while (tokenStream.hasNext()) {
            tokenStack.push(tokenStream.next());
            int productionMatch = tokenStack.checkProductionRules(productionRules);
            if (productionMatch >= 0)
                ;
            else if (productionMatch == -1)
                ;
            else
                throw new IllegalStateException("There is a syntax error");
        }
        if (tokenStack.checkProductionRules(startRules) >= 0)
            return new SyntaxTree(null, null);
        else
            throw new IllegalStateException("There is a syntax error");
    }
}
