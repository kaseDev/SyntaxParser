import java.io.InputStream;
import java.util.Scanner;

public class Parser {

    private ProductionRule[] startRules;
    private ProductionRule[] productionRules;
    private TokenizerStream tokenStream;
    private CompleteSyntaxTree completeSyntaxTree;

    public Parser(ProductionRule[] startRules, ProductionRule[] productionRules, String inputText) {
        this.startRules = startRules;
        this.productionRules = productionRules;
        this.tokenStream = new TokenizerStream();
        this.tokenStream.setInput(inputText);
        this.completeSyntaxTree = new CompleteSyntaxTree(startRules, productionRules);
    }

    public Parser(ProductionRule[] startRules, ProductionRule[] productionRules, InputStream inputStream) {
        this.startRules = startRules;
        this.productionRules = productionRules;
        this.tokenStream = new TokenizerStream();
        this.tokenStream.setInput(inputStream);
        this.completeSyntaxTree = new CompleteSyntaxTree(startRules, productionRules);
    }

    public Parser(ProductionRule[] startRules, ProductionRule[] productionRules, Scanner inputScanner) {
        this.startRules = startRules;
        this.productionRules = productionRules;
        this.tokenStream = new TokenizerStream();
        this.tokenStream.setInput(inputScanner);
        this.completeSyntaxTree = new CompleteSyntaxTree(startRules, productionRules);
    }

    public CompleteSyntaxTree parse() {
        while (tokenStream.hasNext()) {
            Token token = tokenStream.next();
            int productionMatch = completeSyntaxTree.push(token);
            if (productionMatch == -1)
                throw new IllegalStateException(token.getValue());
        }
        System.out.println(completeSyntaxTree.checkStartRules());
        return completeSyntaxTree;
    }
}
