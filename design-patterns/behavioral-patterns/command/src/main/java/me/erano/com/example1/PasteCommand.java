package me.erano.com.example1;

public class PasteCommand implements Command{

    private Document document;

    public PasteCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        System.out.println("Pasting: "+document.paste());
    }
}
