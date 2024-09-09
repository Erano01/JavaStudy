package me.erano.com.example5;

//Joshua Bloch's way factory method.
public class Document {

	private String name;

    protected Document(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Document{" + "name='" + name + '\'' + '}';
    }

    //factory method for WordDocuments
    public static Document createWordDocument(String name) {
        return new WordDocument(name);
    }
    //factory method for PDFDocuments
    public static Document createPdfDocument(String name) {
        return new PDFDocument(name);
    }
    //factory method for ExcelDocuments
    public static Document createExcelDocument(String name) {
        return new ExcelDocument(name);
    }
    
    static class WordDocument extends Document {
        private WordDocument(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "WordDocument{" + "name='" + getName() + '\'' + '}';
        }
    }
    static class PDFDocument extends Document {
        private PDFDocument(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "PDFDocument{" + "name='" + getName() + '\'' + '}';
        }
    }
    static class ExcelDocument extends Document {
        private ExcelDocument(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "ExcelDocument{" + "name='" + getName() + '\'' + '}';
        }
    }

}

