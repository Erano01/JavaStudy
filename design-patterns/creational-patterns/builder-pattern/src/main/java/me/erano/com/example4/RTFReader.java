package me.erano.com.example4;

//Director class
public class RTFReader {

	private TextConverter converter;

	public RTFReader(TextConverter converter) {
		this.converter = converter;
	}

	public void parseRTF(String rtfText) {
		// Simulating token extraction from the RTF text
		String[] tokens = rtfText.split("\\s+"); // Split by whitespace to simulate tokens

		for (String token : tokens) {
			switch (getTokenType(token)) {
			case "CHAR":
				converter.convertCharacter(token.charAt(0)); // Assumes CHAR token is a single character
				break;
			case "FONT":
				converter.convertFontChange(token.substring(1)); // Assumes FONT token is prefixed with 'F'
				break;
			case "PARAGRAPH":
				converter.convertParagraph();
				break;
			default:
				throw new IllegalArgumentException("Unexpected token: " + token);
			}
		}
	}

	// Dummy method to determine token type
	private String getTokenType(String token) {
		if (token.startsWith("F")) {
			return "FONT"; // Font token starts with 'F'
		} else if (token.equals("P")) {
			return "PARAGRAPH"; // Paragraph token is 'P'
		} else {
			return "CHAR"; // Everything else is considered a character token
		}
	}
}
