package me.yanaga.querydsl.args.single;

import com.mysema.query.BooleanBuilder;
import me.yanaga.querydsl.args.QPerson;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ArgumentFactoryTest {

	@Test
	public void testNormalize() {
		assertEquals("123", ArgumentFactory.normalize("abc1d2e3xyz"));
		assertEquals("123", ArgumentFactory.normalize("abc1d2e3xyz"));
	}

	@Test
	public void testNormalizeWithHiphen() {
		assertEquals("123-456", ArgumentFactory.normalize("1a2b3c-4d5e6f"));
		assertEquals("123-456", ArgumentFactory.normalize("1a2b3c--4d5e6f"));
		assertEquals("123-456", ArgumentFactory.normalize("1a2b3c---4d5e6f"));
	}

	@Test
	public void testNormalizeWithComma() {
		assertEquals(",123,333,", ArgumentFactory.normalize("abc,123a,333b,"));
		assertEquals("123,321", ArgumentFactory.normalize("123,321"));
	}

	@Test
	public void testNormalizeWithHiphenAndComma() {
		assertEquals("123-2,,321-,,123,321", ArgumentFactory.normalize("123--abc2,,321-abc,kkk,123,321"));
	}

	@Test
	public void testIntegerOfWithOneArgument() {
		IntegerArgument argument = ArgumentFactory.integerOf("123");
		BooleanBuilder builder = new BooleanBuilder();
		argument.append(builder, QPerson.person.someInteger);
		assertTrue(builder.hasValue());
		assertEquals("person.someInteger = 123", builder.toString());
	}

	@Test
	public void testIntegerOfWithTwoArguments() {
		IntegerArgument argument = ArgumentFactory.integerOf("123");
		BooleanBuilder builder = new BooleanBuilder();
		argument.append(builder, QPerson.person.someInteger, QPerson.person.anotherInteger);
		assertTrue(builder.hasValue());
		assertEquals("person.someInteger = 123 || person.anotherInteger = 123", builder.toString());
	}

}
