package main;

public class ConversionContext {
	private String conversionQues = "";
	private String conversionResponse = "";
	private String fromConversion = "";
	private String toConversion = "";
	
	private double quantity;
	
	String[] partsOfQues;
	
	public ConversionContext(String input) {
		this.conversionQues = input;
		partsOfQues = getInput().split(" ");
		
		fromConversion = getCapitalized(partsOfQues[1]);
		
		toConversion = getLowercase(partsOfQues[3]);
		
		quantity = Double.valueOf(partsOfQues[0]);
		conversionResponse = partsOfQues[0] + " " + partsOfQues[1] +
				" equals";
		
		
		
	}
	
	private String getLowercase(String wordToLowercase) {
		return wordToLowercase.toLowerCase();
	}

	public String getInput() { return conversionQues; }
	public String getFromConversion() { return fromConversion; }
	public String getToConversion() { return toConversion; }
	public String getResponse() { return conversionResponse; }
	public double getQuantity() { return quantity; }
	
	
	public String getCapitalized(String wordToCapitalize) {
		wordToCapitalize = wordToCapitalize.toLowerCase();
		wordToCapitalize = Character.toUpperCase(wordToCapitalize.charAt(0)) + 
				wordToCapitalize.substring(1);
		
		int lenOfWord = wordToCapitalize.length();
		if(wordToCapitalize.charAt(lenOfWord - 1) != 's') {
			wordToCapitalize = new StringBuffer(wordToCapitalize).insert(lenOfWord, "s").toString();
		}
		return wordToCapitalize;
		
	}
	
}