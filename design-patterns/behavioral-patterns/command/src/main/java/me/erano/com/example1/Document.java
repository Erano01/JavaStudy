package me.erano.com.example1;

import java.util.List;

//receiver
public class Document {

    private List<String> documentContent;

    private String copiedContent;

    public void open(){
        String content = String.join(" ", documentContent);
        System.out.println("Document Content: " + content);
    }
    public void close(){
        System.out.println("Document closed.");
    }
    public String cut(String selection){
        //find selection and copy it after that remove it from documentContent
        String text = copy(selection);
        documentContent.remove(text);
        return text;
    }
    public String copy(String selection){
        this.copiedContent = documentContent
                .stream()
                .filter(line -> line.equals(selection))
                .findFirst()
                .orElse(null);
        return this.copiedContent;
    }
    public String paste(){
        return copiedContent;
    }

}
