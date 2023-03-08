package Calculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import Helper.StringHelper;

public class CalculatorImpl implements Calculator {

	
	
	@Override
	public long wordToNumEn(String input) throws RuntimeException {
		
		boolean isValidInput = true;
	    long result = 0;
	    long finalResult = 0;
	    List<String> numberInWords = Arrays.asList
	    (
	    "zero","one","two","three","four","five","six","seven",
	    "eight","nine","ten","eleven","twelve","thirteen","fourteen",
	    "fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
	    "thirty","forty","fifty","sixty","seventy","eighty","ninety",
	    "hundred","thousand","million","billion","trillion"
	    );
	    
	    //input = "one hundred thirty two";

	    if(input != null && input.length()> 0)
	    {
	        input = input.replaceAll("-", " ");
	        input = input.toLowerCase().replaceAll(" and", " ");
	        String[] splittedParts = input.trim().split("\\s+");

	        for(String str : splittedParts)
	        {
	            if(!numberInWords.contains(str))
	            {
	                isValidInput = false;
	                System.out.println("Invalid word found : "+str);
	                break;
	            }
	        }
	        if(isValidInput)
	        {
	            for(String str : splittedParts)
	            {
	                if(str.equalsIgnoreCase("zero")) {
	                    result += 0;
	                }
	                else if(str.equalsIgnoreCase("one")) {
	                    result += 1;
	                }
	                else if(str.equalsIgnoreCase("two")) {
	                    result += 2;
	                }
	                else if(str.equalsIgnoreCase("three")) {
	                    result += 3;
	                }
	                else if(str.equalsIgnoreCase("four")) {
	                    result += 4;
	                }
	                else if(str.equalsIgnoreCase("five")) {
	                    result += 5;
	                }
	                else if(str.equalsIgnoreCase("six")) {
	                    result += 6;
	                }
	                else if(str.equalsIgnoreCase("seven")) {
	                    result += 7;
	                }
	                else if(str.equalsIgnoreCase("eight")) {
	                    result += 8;
	                }
	                else if(str.equalsIgnoreCase("nine")) {
	                    result += 9;
	                }
	                else if(str.equalsIgnoreCase("ten")) {
	                    result += 10;
	                }
	                else if(str.equalsIgnoreCase("eleven")) {
	                    result += 11;
	                }
	                else if(str.equalsIgnoreCase("twelve")) {
	                    result += 12;
	                }
	                else if(str.equalsIgnoreCase("thirteen")) {
	                    result += 13;
	                }
	                else if(str.equalsIgnoreCase("fourteen")) {
	                    result += 14;
	                }
	                else if(str.equalsIgnoreCase("fifteen")) {
	                    result += 15;
	                }
	                else if(str.equalsIgnoreCase("sixteen")) {
	                    result += 16;
	                }
	                else if(str.equalsIgnoreCase("seventeen")) {
	                    result += 17;
	                }
	                else if(str.equalsIgnoreCase("eighteen")) {
	                    result += 18;
	                }
	                else if(str.equalsIgnoreCase("nineteen")) {
	                    result += 19;
	                }
	                else if(str.equalsIgnoreCase("twenty")) {
	                    result += 20;
	                }
	                else if(str.equalsIgnoreCase("thirty")) {
	                    result += 30;
	                }
	                else if(str.equalsIgnoreCase("forty")) {
	                    result += 40;
	                }
	                else if(str.equalsIgnoreCase("fifty")) {
	                    result += 50;
	                }
	                else if(str.equalsIgnoreCase("sixty")) {
	                    result += 60;
	                }
	                else if(str.equalsIgnoreCase("seventy")) {
	                    result += 70;
	                }
	                else if(str.equalsIgnoreCase("eighty")) {
	                    result += 80;
	                }
	                else if(str.equalsIgnoreCase("ninety")) {
	                    result += 90;
	                }
	                else if(str.equalsIgnoreCase("hundred")) {
	                    result *= 100;
	                }
	                else if(str.equalsIgnoreCase("thousand")) {
	                    result *= 1000;
	                    finalResult += result;
	                    result=0;
	                }
	                else if(str.equalsIgnoreCase("million")) {
	                    result *= 1000000;
	                    finalResult += result;
	                    result=0;
	                }
	                else if(str.equalsIgnoreCase("billion")) {
	                    result *= 1000000000;
	                    finalResult += result;
	                    result=0;
	                }
	                else if(str.equalsIgnoreCase("trillion")) {
	                    result *= 1000000000000L;
	                    finalResult += result;
	                    result=0;
	                }
	            }

	            finalResult += result;
	            result=0;
	            System.out.println(finalResult);
	        }
	    }
		return finalResult;
	}

	@Override
	public long wordToNumTR(String word){
		
		boolean isValidInput = true;
	    long result = 0;
	    long finalResult = 0;
	    
	    List<String> allowedStrings = Arrays.asList("sıfır", "bir", "iki", "üç", "dört", "beş",
				"altı", "yedi", "sekiz", "dokuz", "on", "on bir", "on iki", "on üç", "on dört", "on beş", "on altı",
				"on yedi", "on sekiz", "on dokuz", "yirmi", "otuz", "kırk", "elli", "altmıþ", "yetmiş", "seksen",
				"doksan", "yüz", "bin", "milyon", "milyar", "trilyon");
	    
	    if(word != null && word.length()> 0)
	    {
	    	word = word.replaceAll("-", " ");
	    	word = word.toLowerCase().replaceAll(" ve", " ");
	        String[] splittedParts = word.trim().split("\\s+");

	        for(String str : splittedParts)
	        {
	            if(!allowedStrings.contains(str))
	            {
	                isValidInput = false;
	                System.out.println("Geçersiz Kelime Kullanıldı : "+str);
	                break;
	            }
	        }
	        if(isValidInput)
	        {
	            for(String str : splittedParts)
	            {
	            	if (str.equalsIgnoreCase("sıfır")) {
						result += 0;
					} else if (str.equalsIgnoreCase("bir")) {
						result += 1;
					} else if (str.equalsIgnoreCase("iki")) {
						result += 2;
					} else if (str.equalsIgnoreCase("üç")) {
						result += 3;
					} else if (str.equalsIgnoreCase("dört")) {
						result += 4;
					} else if (str.equalsIgnoreCase("beş")) {
						result += 5;
					} else if (str.equalsIgnoreCase("altı")) {
						result += 6;
					} else if (str.equalsIgnoreCase("yedi")) {
						result += 7;
					} else if (str.equalsIgnoreCase("sekiz")) {
						result += 8;
					} else if (str.equalsIgnoreCase("dokuz")) {
						result += 9;
					} else if (str.equalsIgnoreCase("on")) {
						result += 10;
					} else if (str.equalsIgnoreCase("on bir")) {
						result += 11;
					} else if (str.equalsIgnoreCase("on iki")) {
						result += 12;
					} else if (str.equalsIgnoreCase("on üç")) {
						result += 13;
					} else if (str.equalsIgnoreCase("on dört")) {
						result += 14;
					} else if (str.equalsIgnoreCase("on beş")) {
						result += 15;
					} else if (str.equalsIgnoreCase("on altı")) {
						result += 16;
					} else if (str.equalsIgnoreCase("on yedi")) {
						result += 17;
					} else if (str.equalsIgnoreCase("on sekiz")) {
						result += 18;
					} else if (str.equalsIgnoreCase("on dokuz")) {
						result += 19;
					} else if (str.equalsIgnoreCase("yirmi")) {
						result += 20;
					} else if (str.equalsIgnoreCase("otuz")) {
						result += 30;
					} else if (str.equalsIgnoreCase("kırk")) {
						result += 40;
					} else if (str.equalsIgnoreCase("elli")) {
						result += 50;
					} else if (str.equalsIgnoreCase("altmış")) {
						result += 60;
					} else if (str.equalsIgnoreCase("yetmiş")) {
						result += 70;
					} else if (str.equalsIgnoreCase("seksen")) {
						result += 80;
					} else if (str.equalsIgnoreCase("doksan")) {
						result += 90;
					} else if (str.equalsIgnoreCase("yüz")) {
						result *= 100;
					} else if (str.equalsIgnoreCase("bin")) {
						result *= 1000;
						finalResult += result;
						result = 0;
					} else if (str.equalsIgnoreCase("milyon")) {
						result *= 1000000;
						finalResult += result;
						result = 0;
					} else if (str.equalsIgnoreCase("milyar")) {
						result *= 1000000000;
						finalResult += result;
						result = 0;
					} else if (str.equalsIgnoreCase("trilyon")) {
						result *= 1000000000000L;
						finalResult += result;
						result = 0;
					}
	            }

	            finalResult += result;
	            result=0;
	            System.out.println(finalResult);
	        }
	    }
		return finalResult;
		
		
	}

	@Override
	public String numToWordEn(long number) {
		
		StringHelper stringHelper = new StringHelper();
		boolean isNegative = number < 0;
		number = Math.abs(number);		
		
		if (number == 0) {
	        return "zero";
	    }
	    
	    String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	    String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	    String[] thousands = {"", "thousand", "million", "billion", "trillion"};

	    int[] groups = new int[5];
	    int i = 0;
	    while (number > 0) {
	        groups[i++] = (int)(number % 1000);
	        number /= 1000;
	    }

	    StringBuilder words = new StringBuilder();
	    
	    for (int j = 4; j >= 0; j--) {
	        if (groups[j] != 0) {
	            if (words.length() > 0) {
	                words.append(" ");
	            }
	            words.append(stringHelper.translateHundredsEn(groups[j])).append(" ").append(thousands[j]);
	        }
	    }
	    
	    System.out.println(number < 0 ? "minus " + words.toString() : words.toString());
	    
	    if(isNegative) {
	    	words.insert(0, "minus ");
	    }
		return words.toString();
	}

	@Override
	public String numToWordTr(long number) {
		
		StringHelper stringHelper = new StringHelper();
		boolean isNegative = number < 0;
		number = Math.abs(number);	
		
		if (number == 0) {
	        return "sıfır";
	    }
	    
	    String[] units = {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz", "on", "on bir", "on iki", "on üç", "on dört", "on beş", "on altı", "on yedi", "on sekiz", "on dokuz"};
	    String[] tens = {"", "", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
	    String[] thousands = {"", "bin", "milyon", "milyar", "trilyon"};

	    int[] groups = new int[5];
	    int i = 0;
	    while (number > 0) {
	        groups[i++] = (int)(number % 1000);
	        number /= 1000;
	    }

	    StringBuilder words = new StringBuilder();
	    for (int j = 4; j >= 0; j--) {
	        if (groups[j] != 0) {
	            if (words.length() > 0) {
	                words.append(" ");
	            }
	            words.append(stringHelper.translateHundredsTr(groups[j])).append(" ").append(thousands[j]);
	        }
	    }
	    
	    if (isNegative) {
	        words.insert(0, "eksi ");
	    }
	    return words.toString();		
	}

}
