package ArithmeticOperations;

public interface ArithmeticOperations {
	
	default long sum(long a, long b) {
		System.out.println(a+b);
		return a + b;
	}
	
	default long sub(long a, long b) {
		System.out.println(a-b);
		return a - b;
	}
	default long mult(long a, long b) {
		System.out.println(a*b);
		return a * b;
	}
	default Long div(long a, long b) {
		
		if(b == 0) {
			System.out.println("2. Değer Sıfırdan Farklı Olmalıdır !");
			return null;
		}else {
			System.out.println(a/b);
			return a / b;
		}
		
	}
	
}
