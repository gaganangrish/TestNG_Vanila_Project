package listeners;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.Tests.Tests;

public abstract class MyAnnotationTransformer implements IAnnotationTransformer{
/*
	@Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		System.out.println("Transformer running for " + testMethod.getName());
		System.out.println("Value of Test case number is: "+Tests.sparam);
		if (Tests.sparam==2) {
			if (testMethod.getName().equals("launchBrowser")){
				System.out.println("Skipping launchBrowser test on listener");
				annotation.setEnabled(false);
			}
		}
		
    }*/
}