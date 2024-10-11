package me.erano.com;

import me.erano.com.example1.BorderDecorator;
import me.erano.com.example1.ScrollDecorator;
import me.erano.com.example1.TextView;
import me.erano.com.example1.VisualComponent;
import me.erano.com.example2.Base64EncodedMessage;
import me.erano.com.example2.HtmlEncodedMessage;
import me.erano.com.example2.Message;
import me.erano.com.example2.TextMessage;

public class Application {
    public static void main(String[] args) {

//        ex1
        VisualComponent textView = new TextView();
        VisualComponent borderedTextView = new BorderDecorator(textView, 5);
        VisualComponent scrollableBorderedTextView = new ScrollDecorator(borderedTextView);
        scrollableBorderedTextView.draw();

//        ex2
        Message m = new TextMessage("The <FORCE> is strong with this one!");
        System.out.println(m.getContent());
        Message decorator = new HtmlEncodedMessage(m);
        System.out.println(decorator.getContent());
        decorator = new Base64EncodedMessage(decorator);
        System.out.println(decorator.getContent());

        //classes in java's  I/O package are great examples of decorator pattern
        // For example java.io.BufferedOutputStream class decorates any java.io.OutputStream object  and
        //adds buffering to file writing operation. This improves the disk i/o performance by reducing number of writes.

    }
}
