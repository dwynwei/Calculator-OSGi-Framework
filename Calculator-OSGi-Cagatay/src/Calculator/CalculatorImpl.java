package Calculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public class CalculatorImpl implements Calculator {

	private static final HashMap<String, BigInteger> numberMap = new HashMap<>();
	static {
		numberMap.put("sıfır", BigInteger.ZERO);
		numberMap.put("bir", BigInteger.ONE);
		numberMap.put("iki", BigInteger.valueOf(2));
		numberMap.put("üç", BigInteger.valueOf(3));
		numberMap.put("dört", BigInteger.valueOf(4));
		numberMap.put("beş", BigInteger.valueOf(5));
		numberMap.put("altı", BigInteger.valueOf(6));
		numberMap.put("yedi", BigInteger.valueOf(7));
		numberMap.put("sekiz", BigInteger.valueOf(8));
		numberMap.put("dokuz", BigInteger.valueOf(9));
		numberMap.put("on", BigInteger.TEN);
		numberMap.put("yirmi", BigInteger.valueOf(20));
		numberMap.put("otuz", BigInteger.valueOf(30));
		numberMap.put("kırk", BigInteger.valueOf(40));
		numberMap.put("elli", BigInteger.valueOf(50));
		numberMap.put("altmış", BigInteger.valueOf(60));
		numberMap.put("yetmiş", BigInteger.valueOf(70));
		numberMap.put("seksen", BigInteger.valueOf(80));
		numberMap.put("doksan", BigInteger.valueOf(90));
		numberMap.put("yüz", BigInteger.valueOf(100));
		numberMap.put("bin", BigInteger.valueOf(1000));
		numberMap.put("milyon", BigInteger.valueOf(1000000));
		numberMap.put("milyar", BigInteger.valueOf(1000000000));
		numberMap.put("trilyon", BigInteger.valueOf(1000000000000L));
		numberMap.put("katrilyon", new BigInteger("1000000000000000"));
		numberMap.put("kentilyon", new BigInteger("1000000000000000000"));
		numberMap.put("sekstilyon", new BigInteger("1000000000000000000000"));
		numberMap.put("septilyon", new BigInteger("1000000000000000000000000"));
		numberMap.put("oktilyon", new BigInteger("1000000000000000000000000000"));
		numberMap.put("nonilyon", new BigInteger("1000000000000000000000000000000"));
		numberMap.put("desilyon", new BigInteger("1000000000000000000000000000000000"));
	}

	private static final HashMap<BigInteger, String> wordMap = new HashMap<>();
	static {
		wordMap.put(BigInteger.ZERO, "sıfır");
		wordMap.put(BigInteger.ONE, "bir");
		wordMap.put(BigInteger.valueOf(2), "iki");
		wordMap.put(BigInteger.valueOf(3), "üç");
		wordMap.put(BigInteger.valueOf(4), "dört");
		wordMap.put(BigInteger.valueOf(5), "beş");
		wordMap.put(BigInteger.valueOf(6), "altı");
		wordMap.put(BigInteger.valueOf(7), "yedi");
		wordMap.put(BigInteger.valueOf(8), "sekiz");
		wordMap.put(BigInteger.valueOf(9), "dokuz");
		wordMap.put(BigInteger.valueOf(10), "on");
		wordMap.put(BigInteger.valueOf(20), "yirmi");
		wordMap.put(BigInteger.valueOf(30), "otuz");
		wordMap.put(BigInteger.valueOf(40), "kırk");
		wordMap.put(BigInteger.valueOf(50), "elli");
		wordMap.put(BigInteger.valueOf(60), "altmış");
		wordMap.put(BigInteger.valueOf(70), "yetmiş");
		wordMap.put(BigInteger.valueOf(80), "seksen");
		wordMap.put(BigInteger.valueOf(90), "doksan");
		wordMap.put(BigInteger.valueOf(100), "yüz");
		wordMap.put(BigInteger.valueOf(1000), "bin");
		wordMap.put(BigInteger.valueOf(1000000), "milyon");
		wordMap.put(BigInteger.valueOf(1000000000), "milyar");
		wordMap.put(BigInteger.valueOf(1000000000000L), "trilyon");
		wordMap.put(BigInteger.valueOf(1000000000000000L), "katrilyon");
		wordMap.put(BigInteger.valueOf(1000000000000000000L), "kentilyon");
		wordMap.put(new BigInteger("1000000000000000000000"), "sekstilyon");
		wordMap.put(new BigInteger("1000000000000000000000000"), "septilyon");
		wordMap.put(new BigInteger("1000000000000000000000000000"), "oktilyon");
		wordMap.put(new BigInteger("1000000000000000000000000000000"), "nonilyon");
		wordMap.put(new BigInteger("1000000000000000000000000000000000"), "desilyon");
	}

	private static final HashMap<String, BigInteger> WORDS_TO_NUMBERS = new HashMap<>();

	static {
		WORDS_TO_NUMBERS.put("zero", BigInteger.ZERO);
		WORDS_TO_NUMBERS.put("one", BigInteger.ONE);
		WORDS_TO_NUMBERS.put("two", BigInteger.valueOf(2));
		WORDS_TO_NUMBERS.put("three", BigInteger.valueOf(3));
		WORDS_TO_NUMBERS.put("four", BigInteger.valueOf(4));
		WORDS_TO_NUMBERS.put("five", BigInteger.valueOf(5));
		WORDS_TO_NUMBERS.put("six", BigInteger.valueOf(6));
		WORDS_TO_NUMBERS.put("seven", BigInteger.valueOf(7));
		WORDS_TO_NUMBERS.put("eight", BigInteger.valueOf(8));
		WORDS_TO_NUMBERS.put("nine", BigInteger.valueOf(9));
		WORDS_TO_NUMBERS.put("ten", BigInteger.TEN);
		WORDS_TO_NUMBERS.put("eleven", BigInteger.valueOf(11));
		WORDS_TO_NUMBERS.put("twelve", BigInteger.valueOf(12));
		WORDS_TO_NUMBERS.put("thirteen", BigInteger.valueOf(13));
		WORDS_TO_NUMBERS.put("fourteen", BigInteger.valueOf(14));
		WORDS_TO_NUMBERS.put("fifteen", BigInteger.valueOf(15));
		WORDS_TO_NUMBERS.put("sixteen", BigInteger.valueOf(16));
		WORDS_TO_NUMBERS.put("seventeen", BigInteger.valueOf(17));
		WORDS_TO_NUMBERS.put("eighteen", BigInteger.valueOf(18));
		WORDS_TO_NUMBERS.put("nineteen", BigInteger.valueOf(19));
		WORDS_TO_NUMBERS.put("twenty", BigInteger.valueOf(20));
		WORDS_TO_NUMBERS.put("thirty", BigInteger.valueOf(30));
		WORDS_TO_NUMBERS.put("forty", BigInteger.valueOf(40));
		WORDS_TO_NUMBERS.put("fifty", BigInteger.valueOf(50));
		WORDS_TO_NUMBERS.put("sixty", BigInteger.valueOf(60));
		WORDS_TO_NUMBERS.put("seventy", BigInteger.valueOf(70));
		WORDS_TO_NUMBERS.put("eighty", BigInteger.valueOf(80));
		WORDS_TO_NUMBERS.put("ninety", BigInteger.valueOf(90));
		WORDS_TO_NUMBERS.put("hundred", BigInteger.valueOf(100));
		WORDS_TO_NUMBERS.put("thousand", BigInteger.valueOf(1000));
		WORDS_TO_NUMBERS.put("million", BigInteger.valueOf(1000000));
		WORDS_TO_NUMBERS.put("billion", BigInteger.valueOf(1000000000));
		WORDS_TO_NUMBERS.put("trillion", BigInteger.valueOf(1000000000000L));
		WORDS_TO_NUMBERS.put("quadrillion", BigInteger.valueOf(1000000000000000L));
		WORDS_TO_NUMBERS.put("quintillion", BigInteger.valueOf(1000000000000000000L));
		WORDS_TO_NUMBERS.put("sextillion", new BigInteger("1000000000000000000000"));
		WORDS_TO_NUMBERS.put("septillion", new BigInteger("1000000000000000000000000"));
		WORDS_TO_NUMBERS.put("octillion", new BigInteger("1000000000000000000000000000"));
		WORDS_TO_NUMBERS.put("nonillion", new BigInteger("1000000000000000000000000000000"));
		WORDS_TO_NUMBERS.put("decillion", new BigInteger("1000000000000000000000000000000000"));
	}

	private static final HashMap<BigInteger, String> wordMapEn = new HashMap<>();
	static {
		wordMapEn.put(BigInteger.ZERO, "zero");
		wordMapEn.put(BigInteger.ONE, "one");
		wordMapEn.put(BigInteger.valueOf(2), "two");
		wordMapEn.put(BigInteger.valueOf(3), "three");
		wordMapEn.put(BigInteger.valueOf(4), "four");
		wordMapEn.put(BigInteger.valueOf(5), "five");
		wordMapEn.put(BigInteger.valueOf(6), "six");
		wordMapEn.put(BigInteger.valueOf(7), "seven");
		wordMapEn.put(BigInteger.valueOf(8), "eight");
		wordMapEn.put(BigInteger.valueOf(9), "nine");
		wordMapEn.put(BigInteger.valueOf(10), "ten");
		wordMapEn.put(BigInteger.valueOf(20), "twenty");
		wordMapEn.put(BigInteger.valueOf(30), "thirty");
		wordMapEn.put(BigInteger.valueOf(40), "forty");
		wordMapEn.put(BigInteger.valueOf(50), "fifty");
		wordMapEn.put(BigInteger.valueOf(60), "sixty");
		wordMapEn.put(BigInteger.valueOf(70), "seventy");
		wordMapEn.put(BigInteger.valueOf(80), "eighty");
		wordMapEn.put(BigInteger.valueOf(90), "ninety");
		wordMapEn.put(BigInteger.valueOf(100), "hundred");
		wordMapEn.put(BigInteger.valueOf(1000), "thousand");
		wordMapEn.put(BigInteger.valueOf(1000000), "million");
		wordMapEn.put(BigInteger.valueOf(1000000000), "billion");
		wordMapEn.put(BigInteger.valueOf(1000000000000L), "trillion");
		wordMapEn.put(BigInteger.valueOf(1000000000000000L), "quadrillion");
		wordMapEn.put(BigInteger.valueOf(1000000000000000000L), "quintillion");
		wordMapEn.put(new BigInteger("1000000000000000000000"), "sextillion");
		wordMapEn.put(new BigInteger("1000000000000000000000000"), "septillion");
		wordMapEn.put(new BigInteger("1000000000000000000000000000"), "octillion");
		wordMapEn.put(new BigInteger("1000000000000000000000000000000"), "nonillion");
		wordMapEn.put(new BigInteger("1000000000000000000000000000000000"), "decillion");
	}

	@Override
	public BigInteger convertEn(String input) throws RuntimeException {
		final String isMinus = "minus";
		boolean minusFlag = false;
		
		if(input.contains(isMinus)) {
			minusFlag = true;
			input = input.substring(6,input.length());
		}
		
		if (input.isEmpty()) {
			return BigInteger.ZERO;
		}
		if (input.contains(" decillion")) {
			String[] parts = input.split(" decillion");
			BigInteger left = convertEn(parts[0].trim());
			BigInteger right = convertEn(parts[1].trim());
			return left.multiply(WORDS_TO_NUMBERS.get("decillion")).add(right);
		}
		if (input.contains(" nonillion")) {
			String[] parts = input.split(" nonillion");
			BigInteger left = convertEn(parts[0].trim());
			BigInteger right = convertEn(parts[1].trim());
			return left.multiply(WORDS_TO_NUMBERS.get("nonillion")).add(right);
		}
		if (input.contains(" octillion")) {
			String[] parts = input.split(" octillion");
			BigInteger left = convertEn(parts[0].trim());
			BigInteger right = convertEn(parts[1].trim());
			return left.multiply(WORDS_TO_NUMBERS.get("octillion")).add(right);
		}
		if (input.contains(" septillion")) {
			String[] parts = input.split(" septillion");
			BigInteger left = convertEn(parts[0].trim());
			BigInteger right = convertEn(parts[1].trim());
			return left.multiply(WORDS_TO_NUMBERS.get("septillion")).add(right);
		}
		if (input.contains(" sextillion")) {
			String[] parts = input.split(" sextillion");
			BigInteger left = convertEn(parts[0].trim());
			BigInteger right = convertEn(parts[1].trim());
			return left.multiply(WORDS_TO_NUMBERS.get("sextillion")).add(right);
		}
		if (input.contains(" quintillion")) {
			String[] parts = input.split(" quintillion");
			BigInteger left = convertEn(parts[0].trim());
			BigInteger right = convertEn(parts[1].trim());
			return left.multiply(WORDS_TO_NUMBERS.get("quintillion")).add(right);
		}
		if (input.contains(" quadrillion")) {
			String[] parts = input.split(" quadrillion");
			BigInteger left = convertEn(parts[0].trim());
			BigInteger right = convertEn(parts[1].trim());
			return left.multiply(WORDS_TO_NUMBERS.get("quadrillion")).add(right);
		}
		if (input.contains(" trillion")) {
			String[] parts = input.split(" trillion");
			BigInteger left = convertEn(parts[0].trim());
			BigInteger right = convertEn(parts[1].trim());
			return left.multiply(WORDS_TO_NUMBERS.get("trillion")).add(right);
		}
		if (input.contains(" billion")) {
			String[] parts = input.split(" billion");
			BigInteger left = convertEn(parts[0].trim());
			BigInteger right = convertEn(parts[1].trim());
			return left.multiply(WORDS_TO_NUMBERS.get("billion")).add(right);
		}
		if (input.contains(" million")) {
			String[] parts = input.split(" million");
			BigInteger left = convertEn(parts[0].trim());
			BigInteger right = convertEn(parts[1].trim());
			return left.multiply(WORDS_TO_NUMBERS.get("million")).add(right);
		}
		if (input.contains(" thousand")) {
			String[] parts = input.split(" thousand");
			BigInteger left = convertEn(parts[0].trim());
			BigInteger right = convertEn(parts[1].trim());
			return left.multiply(WORDS_TO_NUMBERS.get("thousand")).add(right);
		}
		List<String> parts = Arrays.stream(input.split(" ")).collect(Collectors.toList());
		BigInteger result = BigInteger.ZERO;
		BigInteger temp = BigInteger.ZERO;
		for (String part : parts) {
			BigInteger number = WORDS_TO_NUMBERS.get(part);
			if (number == null) {
				return BigInteger.ZERO;
			}
			if (number.compareTo(BigInteger.valueOf(100)) < 0) {
				temp = temp.add(number);
			} else {
				if (temp.compareTo(BigInteger.ZERO) != 0) {
					temp = temp.multiply(number);
					result = result.add(temp);
					temp = BigInteger.ZERO;
				} else {
					temp = number;
				}
			}
		}
		result = result.add(temp);
		
		if(minusFlag) {
			result = result.negate();
		}
		
		return result;
	}

	@Override
	public BigInteger convertTr(String input) throws RuntimeException {
		String isMinus = "eksi";
		boolean minusFlag = false;
		
		if(input.startsWith(isMinus)) {
			minusFlag = true;
			input = input.substring(5,input.length());
		}				
		
		if (input.isEmpty()) {
			return BigInteger.ZERO;
		}
		if (input.contains(" desilyon")) {
			String[] parts = input.split(" desilyon");
			BigInteger left = convertTr(parts[0].trim());
			BigInteger right = convertTr(parts[1].trim());
			return left.multiply(numberMap.get("desilyon")).add(right);
		}
		if (input.contains(" nonilyon")) {
			String[] parts = input.split(" nonilyon");
			BigInteger left = convertTr(parts[0].trim());
			BigInteger right = convertTr(parts[1].trim());
			return left.multiply(numberMap.get("nonilyon")).add(right);
		}
		if (input.contains(" oktilyon")) {
			String[] parts = input.split(" oktilyon");
			BigInteger left = convertTr(parts[0].trim());
			BigInteger right = convertTr(parts[1].trim());
			return left.multiply(numberMap.get("oktilyon")).add(right);
		}
		if (input.contains(" septilyon")) {
			String[] parts = input.split(" septilyon");
			BigInteger left = convertTr(parts[0].trim());
			BigInteger right = convertTr(parts[1].trim());
			return left.multiply(numberMap.get("septilyon")).add(right);
		}
		if (input.contains(" sekstilyon")) {
			String[] parts = input.split(" sekstilyon");
			BigInteger left = convertTr(parts[0].trim());
			BigInteger right = convertTr(parts[1].trim());
			return left.multiply(numberMap.get("sekstilyon")).add(right);
		}
		if (input.contains(" kentilyon")) {
			String[] parts = input.split(" kentilyon");
			BigInteger left = convertTr(parts[0].trim());
			BigInteger right = convertTr(parts[1].trim());
			return left.multiply(numberMap.get("kentilyon")).add(right);
		}
		if (input.contains(" katrilyon")) {
			String[] parts = input.split(" katrilyon");
			BigInteger left = convertTr(parts[0].trim());
			BigInteger right = convertTr(parts[1].trim());
			return left.multiply(numberMap.get("katrilyon")).add(right);
		}
		if (input.contains(" trilyon")) {
			String[] parts = input.split(" trilyon");
			BigInteger left = convertTr(parts[0].trim());
			BigInteger right = convertTr(parts[1].trim());
			return left.multiply(numberMap.get("trilyon")).add(right);
		}
		if (input.contains(" milyar")) {
			String[] parts = input.split(" milyar");
			BigInteger left = convertTr(parts[0].trim());
			BigInteger right = convertTr(parts[1].trim());
			return left.multiply(numberMap.get("milyar")).add(right);
		}
		if (input.contains(" milyon")) {
			String[] parts = input.split(" milyon");
			BigInteger left = convertTr(parts[0].trim());
			BigInteger right = convertTr(parts[1].trim());
			return left.multiply(numberMap.get("milyon")).add(right);
		}
		if (input.contains(" bin")) {
			if (input.endsWith("bin")) {
				int lastIndex = input.lastIndexOf(" ");
				String firstElement = input.substring(0, lastIndex);
				String secondElement = input.substring(lastIndex);
				BigInteger left = firstElement.isEmpty() ? BigInteger.ONE : convertTr(firstElement.trim());
				BigInteger right = secondElement.isEmpty() ? BigInteger.ZERO : convertTr(secondElement.trim());
				return left.multiply(numberMap.get("bin"));
			} else {
				String[] parts = input.split(" bin");
				BigInteger left = parts[0].isEmpty() ? BigInteger.ONE : convertTr(parts[0].trim());
				BigInteger right = parts[1].isEmpty() ? BigInteger.ZERO : convertTr(parts[1].trim());
				return left.multiply(numberMap.get("bin")).add(right);
			}
		}
		if (input.contains("bin ")) {
			String[] parts = input.split("bin ");
			BigInteger left = parts[0].isEmpty() ? BigInteger.ONE : convertTr(parts[0].trim());
			BigInteger right = parts[1].isEmpty() ? BigInteger.ZERO : convertTr(parts[1].trim());
			return left.multiply(numberMap.get("bin")).add(right);
		}
		List<String> parts = Arrays.stream(input.split(" ")).collect(Collectors.toList());
		BigInteger result = BigInteger.ZERO;
		BigInteger temp = BigInteger.ZERO;
		for (String part : parts) {
			BigInteger number = numberMap.get(part);
			if (number == null) {
				return BigInteger.ZERO;
			}
			if (number.compareTo(BigInteger.valueOf(100)) < 0) {
				temp = temp.add(number);
			} else {
				if (temp.compareTo(BigInteger.ZERO) != 0) {
					temp = temp.multiply(number);
					result = result.add(temp);
					temp = BigInteger.ZERO;
				} else {
					temp = number;
				}
			}
		}
		result = result.add(temp);
		
		if(minusFlag)
		{
			return result.negate();
		}
		
		return result;
	}

	@Override
	public String convertEnWord(BigInteger number) {
		if (number.signum() == -1) {
	        return "minus " + convertEnWord(number.negate());
	    }
		
		if(number.compareTo(new BigInteger("100")) < 0)
		{
			if (wordMapEn.containsKey(number)) {
				return wordMapEn.get(number);
			}
		}		

		if (number.compareTo(BigInteger.valueOf(100)) < 0) {
			// Tens
			BigInteger tens = number.divide(BigInteger.TEN).multiply(BigInteger.TEN);
			BigInteger ones = number.mod(BigInteger.TEN);
			return convertEnWord(tens) + " " + convertEnWord(ones);
		}
		if (number.compareTo(BigInteger.valueOf(1000)) < 0) {
			// Hundreds
			BigInteger hundreds = number.divide(BigInteger.valueOf(100));
			BigInteger remainder = number.mod(BigInteger.valueOf(100));
			String hundredsStr = convertEnWord(hundreds) + " " + wordMapEn.get(BigInteger.valueOf(100));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertEnWord(remainder);
			return hundredsStr + remainderStr;
		}
		if (number.compareTo(BigInteger.valueOf(1000000)) < 0) {
			// Thousands
			BigInteger thousands = number.divide(BigInteger.valueOf(1000));
			BigInteger remainder = number.mod(BigInteger.valueOf(1000));
			String thousandsStr = convertEnWord(thousands) + " " + wordMapEn.get(BigInteger.valueOf(1000));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertEnWord(remainder);
			return thousandsStr + remainderStr;
		}
		if (number.compareTo(BigInteger.valueOf(1000000000)) < 0) {
			// Millions
			BigInteger millions = number.divide(BigInteger.valueOf(1000000));
			BigInteger remainder = number.mod(BigInteger.valueOf(1000000));
			String millionsStr = convertEnWord(millions) + " " + wordMapEn.get(BigInteger.valueOf(1000000));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertEnWord(remainder);
			return millionsStr + remainderStr;
		}
		if (number.compareTo(BigInteger.valueOf(1000000000000L)) < 0) {
			// Billions
			BigInteger billions = number.divide(BigInteger.valueOf(1000000000));
			BigInteger remainder = number.mod(BigInteger.valueOf(1000000000));
			String billionsStr = convertEnWord(billions) + " " + wordMapEn.get(BigInteger.valueOf(1000000000));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertEnWord(remainder);
			return billionsStr + remainderStr;
		}
		if (number.compareTo(BigInteger.valueOf(1000000000000000L)) < 0) {
			// Trillions
			BigInteger trillions = number.divide(BigInteger.valueOf(1000000000000L));
			BigInteger remainder = number.mod(BigInteger.valueOf(1000000000000L));
			String trillionsStr = convertEnWord(trillions) + " " + wordMapEn.get(BigInteger.valueOf(1000000000000L));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertEnWord(remainder);
			return trillionsStr + remainderStr;
		}
		if (number.compareTo(BigInteger.valueOf(1000000000000000000L)) < 0) {
			// Quadrillions
			BigInteger trillions = number.divide(BigInteger.valueOf(1000000000000000L));
			BigInteger remainder = number.mod(BigInteger.valueOf(1000000000000000L));
			String trillionsStr = convertEnWord(trillions) + " " + wordMapEn.get(BigInteger.valueOf(1000000000000000L));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertEnWord(remainder);
			return trillionsStr + remainderStr;
		}
		if (number.compareTo(new BigInteger("1000000000000000000000")) < 0) {
			// Quintrillions
			BigInteger trillions = number.divide(BigInteger.valueOf(1000000000000000000L));
			BigInteger remainder = number.mod(BigInteger.valueOf(1000000000000000000L));
			String trillionsStr = convertEnWord(trillions) + " " + wordMapEn.get(BigInteger.valueOf(1000000000000000000L));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertEnWord(remainder);
			return trillionsStr + remainderStr;
		}
		if (number.compareTo(new BigInteger("1000000000000000000000000")) < 0) {
			// Sextillions
			BigInteger trillions = number.divide(new BigInteger("1000000000000000000000"));
			BigInteger remainder = number.mod(new BigInteger("1000000000000000000000"));
			String trillionsStr = convertEnWord(trillions) + " " + wordMapEn.get(new BigInteger("1000000000000000000000"));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertEnWord(remainder);
			return trillionsStr + remainderStr;
		}
		if (number.compareTo(new BigInteger("1000000000000000000000000000")) < 0) {
			// Septillions
			BigInteger trillions = number.divide(new BigInteger("1000000000000000000000000"));
			BigInteger remainder = number.mod(new BigInteger("1000000000000000000000000"));
			String trillionsStr = convertEnWord(trillions) + " " + wordMapEn.get(new BigInteger("1000000000000000000000000"));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertEnWord(remainder);
			return trillionsStr + remainderStr;
		}
		if (number.compareTo(new BigInteger("1000000000000000000000000000000")) < 0) {
			// Octillions
			BigInteger trillions = number.divide(new BigInteger("1000000000000000000000000000"));
			BigInteger remainder = number.mod(new BigInteger("1000000000000000000000000000"));
			String trillionsStr = convertEnWord(trillions) + " "
					+ wordMapEn.get(new BigInteger("1000000000000000000000000000"));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertEnWord(remainder);
			return trillionsStr + remainderStr;
		}
		if (number.compareTo(new BigInteger("1000000000000000000000000000000000")) < 0) {
			// Nonillions
			BigInteger trillions = number.divide(new BigInteger("1000000000000000000000000000000"));
			BigInteger remainder = number.mod(new BigInteger("1000000000000000000000000000000"));
			String trillionsStr = convertEnWord(trillions) + " "
					+ wordMapEn.get(new BigInteger("1000000000000000000000000000000"));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertEnWord(remainder);
			return trillionsStr + remainderStr;
		}
		// Decillions
		BigInteger trillions = number.divide(new BigInteger("1000000000000000000000000000000000"));
		BigInteger remainder = number.mod(new BigInteger("1000000000000000000000000000000000"));
		String trillionsStr = convertEnWord(trillions) + " "
				+ wordMapEn.get(new BigInteger("1000000000000000000000000000000000"));
		String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertEnWord(remainder);
		return trillionsStr + remainderStr;
	}

	@Override
	public String convertTrWord(BigInteger number) {
		if (number.signum() == -1) {
	        return "eksi " + convertTrWord(number.negate());
	    }
		
		if (number.compareTo(BigInteger.valueOf(1000000)) < 0) {
			if (wordMap.containsKey(number)) {
				return wordMap.get(number);
			}
		}

		if (number.compareTo(BigInteger.valueOf(100)) < 0) {
			// Tens
			BigInteger tens = number.divide(BigInteger.TEN).multiply(BigInteger.TEN);
			BigInteger ones = number.mod(BigInteger.TEN);
			return convertTrWord(tens) + " " + convertTrWord(ones);
		}
		if (number.compareTo(BigInteger.valueOf(1000)) < 0) {
			// Hundreds
			BigInteger hundreds = number.divide(BigInteger.valueOf(100));
			BigInteger remainder = number.mod(BigInteger.valueOf(100));
			String hundredsStr = hundreds.equals(BigInteger.ONE) ? wordMap.get(BigInteger.valueOf(100))
					: convertTrWord(hundreds) + " " + wordMap.get(BigInteger.valueOf(100));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertTrWord(remainder);
			return hundredsStr + remainderStr;
		}
		if (number.compareTo(BigInteger.valueOf(1000000)) < 0) {
			// Thousands
			BigInteger thousands = number.divide(BigInteger.valueOf(1000));
			BigInteger remainder = number.mod(BigInteger.valueOf(1000));
			String thousandsStr = thousands.equals(BigInteger.ONE) ? wordMap.get(BigInteger.valueOf(1000))
					: convertTrWord(thousands) + " " + wordMap.get(BigInteger.valueOf(1000));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertTrWord(remainder);
			return thousandsStr + remainderStr;
		}
		if (number.compareTo(BigInteger.valueOf(1000000000)) < 0) {
			// Millions
			BigInteger millions = number.divide(BigInteger.valueOf(1000000));
			BigInteger remainder = number.mod(BigInteger.valueOf(1000000));
			String millionsStr = convertTrWord(millions) + " " + wordMap.get(BigInteger.valueOf(1000000));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertTrWord(remainder);
			return millionsStr + remainderStr;
		}
		if (number.compareTo(BigInteger.valueOf(1000000000000L)) < 0) {
			// Billions
			BigInteger billions = number.divide(BigInteger.valueOf(1000000000));
			BigInteger remainder = number.mod(BigInteger.valueOf(1000000000));
			String billionsStr = convertTrWord(billions) + " " + wordMap.get(BigInteger.valueOf(1000000000));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertTrWord(remainder);
			return billionsStr + remainderStr;
		}
		if (number.compareTo(BigInteger.valueOf(1000000000000000L)) < 0) {
			// Trillions
			BigInteger trillions = number.divide(BigInteger.valueOf(1000000000000L));
			BigInteger remainder = number.mod(BigInteger.valueOf(1000000000000L));
			String trillionsStr = convertTrWord(trillions) + " " + wordMap.get(BigInteger.valueOf(1000000000000L));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertTrWord(remainder);
			return trillionsStr + remainderStr;
		}
		if (number.compareTo(BigInteger.valueOf(1000000000000000000L)) < 0) {
			// Quadrillions
			BigInteger trillions = number.divide(BigInteger.valueOf(1000000000000000L));
			BigInteger remainder = number.mod(BigInteger.valueOf(1000000000000000L));
			String trillionsStr = convertTrWord(trillions) + " " + wordMap.get(BigInteger.valueOf(1000000000000000L));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertTrWord(remainder);
			return trillionsStr + remainderStr;
		}
		if (number.compareTo(new BigInteger("1000000000000000000000")) < 0) {
			// Quintrillions
			BigInteger trillions = number.divide(BigInteger.valueOf(1000000000000000000L));
			BigInteger remainder = number.mod(BigInteger.valueOf(1000000000000000000L));
			String trillionsStr = convertTrWord(trillions) + " " + wordMap.get(BigInteger.valueOf(1000000000000000000L));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertTrWord(remainder);
			return trillionsStr + remainderStr;
		}
		if (number.compareTo(new BigInteger("1000000000000000000000000")) < 0) {
			// Sextillions
			BigInteger trillions = number.divide(new BigInteger("1000000000000000000000"));
			BigInteger remainder = number.mod(new BigInteger("1000000000000000000000"));
			String trillionsStr = convertTrWord(trillions) + " " + wordMap.get(new BigInteger("1000000000000000000000"));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertTrWord(remainder);
			return trillionsStr + remainderStr;
		}
		if (number.compareTo(new BigInteger("1000000000000000000000000000")) < 0) {
			// Septillions
			BigInteger trillions = number.divide(new BigInteger("1000000000000000000000000"));
			BigInteger remainder = number.mod(new BigInteger("1000000000000000000000000"));
			String trillionsStr = convertTrWord(trillions) + " " + wordMap.get(new BigInteger("1000000000000000000000000"));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertTrWord(remainder);
			return trillionsStr + remainderStr;
		}
		if (number.compareTo(new BigInteger("1000000000000000000000000000000")) < 0) {
			// Octillions
			BigInteger trillions = number.divide(new BigInteger("1000000000000000000000000000"));
			BigInteger remainder = number.mod(new BigInteger("1000000000000000000000000000"));
			String trillionsStr = convertTrWord(trillions) + " "
					+ wordMap.get(new BigInteger("1000000000000000000000000000"));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertTrWord(remainder);
			return trillionsStr + remainderStr;
		}
		if (number.compareTo(new BigInteger("1000000000000000000000000000000000")) < 0) {
			// Nonillions
			BigInteger trillions = number.divide(new BigInteger("1000000000000000000000000000000"));
			BigInteger remainder = number.mod(new BigInteger("1000000000000000000000000000000"));
			String trillionsStr = convertTrWord(trillions) + " "
					+ wordMap.get(new BigInteger("1000000000000000000000000000000"));
			String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertTrWord(remainder);
			return trillionsStr + remainderStr;
		}
		// Decillions
		BigInteger trillions = number.divide(new BigInteger("1000000000000000000000000000000000"));
		BigInteger remainder = number.mod(new BigInteger("1000000000000000000000000000000000"));
		String trillionsStr = convertTrWord(trillions) + " "
				+ wordMap.get(new BigInteger("1000000000000000000000000000000000"));
		String remainderStr = remainder.equals(BigInteger.ZERO) ? "" : " " + convertTrWord(remainder);
		return trillionsStr + remainderStr;
	}
	
	@Override
	public String isValid(String input, Locale locale) {
	    String[] words = input.trim().toLowerCase().split("\\s+");
	    
	    Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
	    if (uniqueWords.size() != words.length) {
	    	if(locale.getDefault().equals(new Locale("en")))
	    		return "Input contains duplicate words.";
	    	return "Girilen Değer, duplike kelimeler içeriyor";
	    }
	    
	    List<String> allowedWordsEn = new ArrayList<>(WORDS_TO_NUMBERS.keySet());
	    List<String> allowedWordsTr = new ArrayList<>(numberMap.keySet());
	    List<String> expectedWords = new ArrayList<>();
	    for (String word : words) {
	        if (allowedWordsEn.contains(word)) {
	            expectedWords.add(word);
	        }
	        
	        if(allowedWordsTr.contains(word)) {
	        	expectedWords.add(word);
	        }
	        
	    }
	    if (!Arrays.equals(words, expectedWords.toArray())) {
	    	if(locale.getDefault().equals(new Locale("en")))
	    		return "Input words are not in the correct order.";
	    	return "Girilen Değer Doğru Sırada Değil";
	    }
	    
	    if(locale.getDefault().equals(new Locale("en")))
	    	return "valid";
	    return "geçerli";
	}

}
