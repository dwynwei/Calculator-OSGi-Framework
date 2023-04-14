package calculator_osgi_cagatay;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import Calculator.Calculator;
import Calculator.CalculatorImpl;

public class Activator extends CalculatorImpl implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
