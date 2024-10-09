package me.erano.com.example1;

import java.util.ArrayList;
import java.util.List;

public class ProgramNode {
    private String name;
    private List<ProgramNode> children = new ArrayList<>();

    public ProgramNode(String name) {
        this.name = name;
    }

    public void addChild(ProgramNode node) {
        children.add(node);
    }

    public void traverse() {
        System.out.println("Node: " + name);
        for (ProgramNode child : children) {
            child.traverse();
        }
    }
}
