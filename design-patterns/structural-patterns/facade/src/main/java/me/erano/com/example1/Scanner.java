package me.erano.com.example1;

//subsystem component
public class Scanner {

    public String[] scan(String sourceCode) {
        // Tokenize the input source code
        System.out.println("Scanning source code...");
        return sourceCode.split("\\s+");
    }
}
