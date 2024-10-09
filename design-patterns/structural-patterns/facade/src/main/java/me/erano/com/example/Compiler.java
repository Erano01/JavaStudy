package me.erano.com.example;

//facade
public class Compiler {
    private Scanner scanner = new Scanner();
    private Parser parser = new Parser();

    public void compile(String sourceCode) {
        System.out.println("Starting compilation...");
        String[] tokens = scanner.scan(sourceCode);
        ProgramNode programNode = parser.parse(tokens);
        System.out.println("Compilation finished. Syntax tree:");
        programNode.traverse();
    }
}
