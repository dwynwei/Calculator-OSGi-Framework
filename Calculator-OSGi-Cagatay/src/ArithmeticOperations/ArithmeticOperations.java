package ArithmeticOperations;

import java.math.BigInteger;

public interface ArithmeticOperations {

	default BigInteger sum(BigInteger a, BigInteger b) {
		System.out.println(a.add(b));
		return a.add(b);
	}

	default BigInteger sub(BigInteger a, BigInteger b) {
		System.out.println(a.subtract(b));
		return a.subtract(b);
	}

	default BigInteger mult(BigInteger a, BigInteger b) {
		System.out.println(a.multiply(b));
		return a.multiply(b);
	}

	default BigInteger div(BigInteger a, BigInteger b) {

		if (b == BigInteger.ZERO) {
			System.out.println("2. Değer Sıfırdan Farklı Olmalıdır !");
			return null;
		} else {
			System.out.println(a.divide(b));
			return a.divide(b);
		}

	}

}
