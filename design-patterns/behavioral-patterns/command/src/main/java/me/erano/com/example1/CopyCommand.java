package me.erano.com.example1;

public class CopyCommand implements Command{

    private Document document;

    private String selection;

    public CopyCommand(Document document,String selection) {
        this.document = document;
        this.selection = selection;
    }

    @Override
    public void execute() {
        document.copy(selection);
    }
}
