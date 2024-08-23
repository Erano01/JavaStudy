package me.erano.com.example4.product;

//ASCIIText as the Product
public class ASCIIText {

	private StringBuilder text = new StringBuilder();
	
	public ASCIIText() {
		System.out.println("ASCIIText Created");
	}
	
	public void append(char c) {
        text.append(c);
    }

    public void appendParagraph() {
        text.append("\n");
    }

    @Override
    public String toString() {
        return text.toString();
    }
}
