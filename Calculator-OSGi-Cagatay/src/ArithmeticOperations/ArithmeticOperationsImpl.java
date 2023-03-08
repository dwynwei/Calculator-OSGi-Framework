package ArithmeticOperations;

public abstract class ArithmeticOperationsImpl implements ArithmeticOperations {
	
	@Override
	public long sum(long a, long b) {
		return ArithmeticOperations.super.sum(a, b);
	}
	
	@Override
	public long sub(long a, long b) {
		return ArithmeticOperations.super.sub(a, b);
	}
	
	@Override
	public long mult(long a, long b) {
		return ArithmeticOperations.super.mult(a, b);
	}
	
	@Override
	public Long div(long a, long b) {
		return ArithmeticOperations.super.div(a, b);
	}
	
}
