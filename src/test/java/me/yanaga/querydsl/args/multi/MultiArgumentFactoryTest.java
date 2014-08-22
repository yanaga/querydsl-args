package me.yanaga.querydsl.args.multi;

import com.mysema.query.BooleanBuilder;
import me.yanaga.querydsl.args.QPerson;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MultiArgumentFactoryTest {

	@Test
	public void testMultiIntegerOfWithOneArgumentAndComma() {
		MultiIntegerArgument argument = MultiArgumentFactory.integerOf("123a,b321");
		BooleanBuilder builder = new BooleanBuilder();
		argument.append(builder, QPerson.person.someInteger);
		assertTrue(builder.hasValue());
		assertEquals("person.someInteger = 123 || person.someInteger = 321", builder.toString());
	}

	@Test
	public void testMultiIntegerOfWithTwoArgumentsAndComma() {
		MultiIntegerArgument argument = MultiArgumentFactory.integerOf("123a,b321");
		BooleanBuilder builder = new BooleanBuilder();
		argument.append(builder, QPerson.person.someInteger, QPerson.person.anotherInteger);
		assertTrue(builder.hasValue());
		assertEquals("person.someInteger = 123 || person.anotherInteger = 123 || person.someInteger = 321 || person.anotherInteger = 321", builder.toString());
	}

}
