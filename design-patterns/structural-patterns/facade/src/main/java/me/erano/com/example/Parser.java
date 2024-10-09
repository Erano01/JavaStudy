package me.erano.com.example;

//subsystem component
public class Parser {

    public ProgramNode parse(String[] tokens) {
        // Parse tokens and build a syntax tree (simplified for this example)
        System.out.println("Parsing tokens...");
        ProgramNode rootNode = new ProgramNode("Program");
        for (String token : tokens) {
            rootNode.addChild(new ProgramNode(token));
        }
        return rootNode;
    }
}
