package me.erano.com.example1;

//Concrete Product
public class PDFDocument implements Document {

	public PDFDocument() {
		System.out.println("PDFDocument Created!");
	}

	@Override
	public void open() {
		System.out.println("PDFDocument Opened!");
	}

	@Override
	public void close() {
		System.out.println("PDFDocument Closed!");
	}

	@Override
	public void save() {
		System.out.println("PDFDocument Saved!");
	}

	@Override
	public void revert() {
		System.out.println("PDFDocument Reverted!");
	}

}
