package me.erano.com.example1;

public class CloseCommand implements Command{
    private Document document;

    public CloseCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.close();
    }
}
