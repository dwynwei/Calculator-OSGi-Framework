package Calculator;

import java.math.BigInteger;
import java.util.Locale;

public interface Calculator {

	/*public Integer wordToNumEn(String input) throws RuntimeException;
	public Integer wordToNumTR(String input) throws RuntimeException;
	public String numToWordEn(Integer num);
	public String numToWordTr(Integer num);*/
	
	public BigInteger convertEn(String input) throws RuntimeException;
	public BigInteger convertTr(String input) throws RuntimeException;
	public String convertEnWord(BigInteger number);
	public String convertTrWord(BigInteger number);
	public String isValid(String input, Locale locale);
	
}
