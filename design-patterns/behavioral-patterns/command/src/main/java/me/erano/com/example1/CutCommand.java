package me.erano.com.example1;

public class CutCommand implements Command{

    private Document document;

    private String selection;

    public CutCommand(Document document,String selection) {
        this.document = document;
        this.selection = selection;
    }

    @Override
    public void execute() {
        document.cut(selection);
    }
}

