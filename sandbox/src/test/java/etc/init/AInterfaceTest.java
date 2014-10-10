package etc.init;

import org.junit.Test;

import etc.init.AInterface;

public class AInterfaceTest implements AInterface {

	@Test
	public void test() throws Exception {
		System.out.println(AInterface.STATIC_FIELD);
		System.out.println(AInterface.INSTANCE);
	}

}
