package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeBuilderTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){

		EnvelopeBuilder builder = new EnvelopeBuilder();
		Assert.assertEquals(0, builder.getxVals().size());
		Assert.assertEquals(0, builder.getyVals().size());
	}

	@Test
	public void insertMethod(){

		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.insert(new Coordinate(0.0,1.0));
		Assert.assertEquals(1, builder.getxVals().size());
	}

	@Test
	public void buildMethod(){

		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.insert(new Coordinate(0.0,1.0));
		builder.insert(new Coordinate(2.0,0.0));
		builder.insert(new Coordinate(1.0,3.0));
		Envelope result = builder.build();
		Assert.assertFalse(result.isEmpty());
		Assert.assertEquals(0.0, result.getXmin(), EPSILON);
	}
}
