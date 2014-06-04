package fiuba.algo3;

import fiuba.algo3.Foo;
import org.junit.Assert;

import org.junit.Test;

public class FooTest {
	
	@Test
	public void deberiaHacerFoo(){
		Foo foo = new Foo();
		Assert.assertEquals("Foo", foo.hacerFoo());
	}
}
