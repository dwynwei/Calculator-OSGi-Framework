package calculator_osgi_cagatay;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import Calculator.Calculator;
import Calculator.CalculatorImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Calculator calculator = new CalculatorImpl();
		calculator.wordToNumEn("one million one hundred thousand one hundred thirty two");
		calculator.wordToNumTR("bin elli");
		calculator.numToWordEn(-101362032);
		calculator.numToWordTr(175);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
