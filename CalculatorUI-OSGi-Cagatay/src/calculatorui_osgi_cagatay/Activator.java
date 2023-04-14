package calculatorui_osgi_cagatay;

import java.math.BigInteger;
import Calculator.Calculator;
import Calculator.CalculatorImpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import UserInterface.CalculatorFrame;

public class Activator extends CalculatorFrame implements BundleActivator {

	private static BundleContext context;
	
	private static Calculator calculator;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		// Number To Words
				System.out.println("*************************TEST FOR WORD TO NUMBER - TURKISH**********************************");
				test("sıfır", BigInteger.ZERO);
				test("bir", BigInteger.ONE);
				test("eksi bir", BigInteger.ONE.negate());
				test("on", BigInteger.TEN);
				test("on bir", BigInteger.valueOf(11));
				test("yirmi üç", BigInteger.valueOf(23));
				test("yüz", BigInteger.valueOf(100));
				test("yüz doksan dokuz", BigInteger.valueOf(199));
				test("iki yüz yirmi dört", BigInteger.valueOf(224));
				test("beş yüz yirmi", BigInteger.valueOf(520));
				test("bin", BigInteger.valueOf(1000));
				test("bin beş yüz otuz yedi", BigInteger.valueOf(1537));
				test("dokuz bin dokuz yüz doksan dokuz", BigInteger.valueOf(9999));
				test("elli milyon dokuz bin dokuz yüz doksan dokuz", BigInteger.valueOf(50009999));
				test("yüz doksan milyar elli milyon dokuz bin dokuz yüz doksan dokuz", new BigInteger("190050009999"));
				test("yüz elli kentilyon üç yüz altmış beş katrilyon beş yüz doksan altı trilyon yüz milyar iki yüz kırk yedi milyon üç yüz yetmiş beş bin",
						new BigInteger("150365596100247375000"));
				test("yüz üç desilyon yüz elli kentilyon üç yüz altmış beş katrilyon beş yüz doksan altı trilyon yüz milyar iki yüz kırk yedi milyon üç yüz yetmiş beş bin",
						new BigInteger("103000000000000150365596100247375000"));
				System.out.println("*****************************TEST FOR NUMBER TO WORD - TURKISH******************************");

				test(new BigInteger("0"), "sıfır");
				test(new BigInteger("1"), "bir");
				test(new BigInteger("10"), "on");
				test(new BigInteger("25"), "yirmi beş");
				test(new BigInteger("100"), "yüz");
				test(new BigInteger("456"), "dört yüz elli altı");
				test(new BigInteger("1000"), "bin");
				test(new BigInteger("1234"), "bin iki yüz otuz dört");
				test(new BigInteger("10000"), "on bin");
				test(new BigInteger("99999"), "doksan dokuz bin dokuz yüz doksan dokuz");
				test(new BigInteger("100000"), "yüz bin");
				test(new BigInteger("123456"), "yüz yirmi üç bin dört yüz elli altı");
				test(new BigInteger("1000000"), "bir milyon");
				test(new BigInteger("123456789"), "yüz yirmi üç milyon dört yüz elli altı bin yedi yüz seksen dokuz");
				test(new BigInteger("1000000000"), "bir milyar");
				test(new BigInteger("9876543210"), "dokuz milyar sekiz yüz yetmiş altı milyon beş yüz kırk üç bin iki yüz on");
				test(new BigInteger("1000000000000"), "bir trilyon");
				test(new BigInteger("999999999999999"),
						"dokuz yüz doksan dokuz trilyon dokuz yüz doksan dokuz milyar dokuz yüz doksan dokuz milyon dokuz yüz doksan dokuz bin dokuz yüz doksan dokuz");
				test(new BigInteger("103000000000000150365596100247375000"),
						"yüz üç desilyon yüz elli kentilyon üç yüz altmış beş katrilyon beş yüz doksan altı trilyon yüz milyar iki yüz kırk yedi milyon üç yüz yetmiş beş bin");

				System.out.println("********************TEST FOR WORD TO NUMBER - ENGLISH*********************");

				testEn("one", BigInteger.ONE);
				testEn("fifty six", BigInteger.valueOf(56));
				testEn("three hundred forty five", BigInteger.valueOf(345));
				testEn("six thousand seven hundred eighty nine", BigInteger.valueOf(6789));
				testEn("ninety eight thousand seven hundred sixty five", BigInteger.valueOf(98765));
				testEn("two million three hundred forty five thousand six hundred seventy eight", BigInteger.valueOf(2345678));
				testEn("thirty five million nine hundred eighty four thousand two hundred thirteen",
						BigInteger.valueOf(35984213));
				testEn("four hundred fifty six million seven hundred eighty nine thousand one hundred twenty three",
						BigInteger.valueOf(456789123));
				testEn("two billion three hundred forty five million six hundred seventy eight thousand nine hundred twelve",
						new BigInteger("2345678912"));
				testEn("twenty five billion six hundred seventy four million eight hundred twenty one thousand three hundred fifty six",
						new BigInteger("25674821356"));
				testEn("three hundred forty five billion six hundred seventy eight million nine hundred twelve thousand three hundred forty five",
						new BigInteger("345678912345"));
				testEn("two billion three hundred forty five million six hundred seventy eight thousand nine hundred twelve",
						new BigInteger("2345678912"));
				testEn("five hundred ninety nine decillion nine hundred ninety nine nonillion nine hundred ninety nine octillion nine hundred ninety nine septillion nine hundred ninety nine sextillion nine hundred ninety nine quintillion nine hundred ninety nine quadrillion nine hundred ninety nine trillion nine hundred ninety nine billion nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine",
						new BigInteger("599999999999999999999999999999999999"));
				
				System.out.println("*********************TEST FOR NUMBER TO WORD - ENGLISH*************************");
				
				testEnW(new BigInteger("0"), "zero");
				testEnW(new BigInteger("1"), "one");
				testEnW(new BigInteger("10"), "ten");
				testEnW(new BigInteger("25"), "twenty five");
				testEnW(new BigInteger("100"), "one hundred");
				testEnW(new BigInteger("456"), "four hundred fifty six");
				testEnW(new BigInteger("1000"), "one thousand");
				testEnW(new BigInteger("1234"), "one thousand two hundred thirty four");
				testEnW(new BigInteger("10000"), "ten thousand");
				testEnW(new BigInteger("99999"), "ninety nine thousand nine hundred ninety nine");
				testEnW(new BigInteger("100000"), "one hundred thousand");
				testEnW(new BigInteger("123456"), "one hundred twenty three thousand four hundred fifty six");
				testEnW(new BigInteger("1000000"), "one million");
				testEnW(new BigInteger("123456789"), "one hundred twenty three million four hundred fifty six thousand seven hundred eighty nine");
				testEnW(new BigInteger("1000000000"), "one billion");
				testEnW(new BigInteger("9876543210"), "nine billion eight hundred seventy six million five hundred forty three thousand two hundred ten");
				testEnW(new BigInteger("1000000000000"), "one trillion");
				testEnW(new BigInteger("999999999999999"), "nine hundred ninety nine trillion nine hundred ninety nine billion nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine");
				testEnW(new BigInteger("100999000999999999999999999999999999"), "one hundred decillion nine hundred ninety nine nonillion nine hundred ninety nine septillion nine hundred ninety nine sextillion nine hundred ninety nine quintillion nine hundred ninety nine quadrillion nine hundred ninety nine trillion nine hundred ninety nine billion nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine");
				testEnW(new BigInteger("-100999000999999999999999999999999999"), "minus one hundred decillion nine hundred ninety nine nonillion nine hundred ninety nine septillion nine hundred ninety nine sextillion nine hundred ninety nine quintillion nine hundred ninety nine quadrillion nine hundred ninety nine trillion nine hundred ninety nine billion nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine");
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}
	
	private static void test(String input, BigInteger expected) {
		BigInteger result = calculator.convertTr(input);

		if (!result.equals(expected)) {
			System.out.printf("FAILED: input=\"%s\", expected=%s, actual=%s%n", input, expected, result);
		} else {
			System.out.printf("PASSED: input=\"%s\", expected=%s, actual=%s%n", input, expected, result);
		}
	}
	// İlk Metod Sonu *********************

	// Çalışan Metot Dokunma - 2
	private static void test(BigInteger input, String expected) {
		String result = calculator.convertTrWord(input);

		if (!result.equals(expected)) {
			System.out.printf("FAILED: input=%s, expected=%s, actual=%s%n", input, expected, result);
		} else {
			System.out.printf("PASSED: input=%s, expected=%s, actual=%s%n", input, expected, result);
		}
	}
	// Çalışan Metot Dokunma - 2 - SON

	private static void testEn(String input, BigInteger expected) {
		BigInteger result = calculator.convertEn(input);

		if (!result.equals(expected)) {
			System.out.printf("FAILED: input=\"%s\", expected=%s, actual=%s%n", input, expected, result);
		} else {
			System.out.printf("PASSED: input=\"%s\", expected=%s, actual=%s%n", input, expected, result);
		}
	}
	
	private static void testEnW(BigInteger input, String expected) {
		String result = calculator.convertEnWord(input);

		if (!result.equals(expected)) {
			System.out.printf("FAILED: input=%s, expected=%s, actual=%s%n", input, expected, result);
		} else {
			System.out.printf("PASSED: input=%s, expected=%s, actual=%s%n", input, expected, result);
		}
	}

}
