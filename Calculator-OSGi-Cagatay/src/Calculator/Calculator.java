package Calculator;

public interface Calculator {

	public long wordToNumEn(String input) throws RuntimeException;
	public long wordToNumTR(String input) throws RuntimeException;
	public String numToWordEn(long num);
	public String numToWordTr(long num);
	
}
