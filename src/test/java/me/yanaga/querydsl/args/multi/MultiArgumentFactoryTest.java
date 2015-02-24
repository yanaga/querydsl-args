package me.yanaga.querydsl.args.multi;

/*
 * #%L
 * queydsl-args
 * %%
 * Copyright (C) 2014 - 2015 Edson Yanaga
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
