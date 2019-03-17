import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ProductionRule[] starterRules = new ProductionRule[1];
        ProductionRule[] productionRules = new ProductionRule[4];

        starterRules[0] = new ProductionRule(new TokenType[]{TokenType.TERM}, TokenType.S);

        productionRules[0] = new ProductionRule(new TokenType[]{TokenType.VAR}, TokenType.TERM);
        productionRules[1] = new ProductionRule(new TokenType[]
                {TokenType.UNIOP, TokenType.TERM}, TokenType.TERM);
        productionRules[2] = new ProductionRule(new TokenType[]
                {TokenType.TERM, TokenType.BINOP, TokenType.TERM}, TokenType.TERM);
        productionRules[3] = new ProductionRule(new TokenType[]
                {TokenType.LPAREN, TokenType.TERM, TokenType.RPAREN}, TokenType.TERM);

        String boolExpression = "a";

        Parser parser = new Parser(starterRules, productionRules, boolExpression);

        File file = new File("test.txt");
        try {
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(new GsonBuilder().setPrettyPrinting().create().toJson(parser.parse()));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
