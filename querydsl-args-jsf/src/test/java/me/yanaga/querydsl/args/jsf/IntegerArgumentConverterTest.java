package me.yanaga.querydsl.args.jsf;

import me.yanaga.querydsl.args.core.single.IntegerArgument;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerArgumentConverterTest {

	private final IntegerArgumentConverter converter = new IntegerArgumentConverter();

	@Test
	public void testGetAsObject() throws Exception {
		Object object = converter.getAsObject(null, null, "123");
		assertThat(object).isInstanceOf(IntegerArgument.class);
		assertThat(object.toString()).isEqualTo("123");
	}

	@Test
	public void testGetAsObjectWithEmpty() throws Exception {
		Object object = converter.getAsObject(null, null, "");
		assertThat(object).isInstanceOf(IntegerArgument.class);
		assertThat(object.toString()).isEqualTo("");
	}

	@Test
	public void testGetAsString() throws Exception {
		assertThat(converter.getAsString(null, null, IntegerArgument.of("123"))).isEqualTo("123");
	}

}
