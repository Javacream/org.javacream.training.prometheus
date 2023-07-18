package org.javacream.util.metric;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "org.javacream:name=request,type=counter")
public class RequestCounter {
	private int counter = 0;

	@ManagedAttribute(description =  "a simpleCounter")
	public int getCounter() {
		return counter;
	}
	public void increment() {
		counter++;
	}

}
