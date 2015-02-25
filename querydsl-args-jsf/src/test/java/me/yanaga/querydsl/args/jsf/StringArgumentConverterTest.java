package me.yanaga.querydsl.args.jsf;

/*
 * #%L
 * querydsl-args-jsf
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

import me.yanaga.querydsl.args.core.single.StringArgument;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringArgumentConverterTest {

	private final StringArgumentConverter converter = new StringArgumentConverter();

	@Test
	public void testGetAsObject() throws Exception {
		Object object = converter.getAsObject(null, null, "abc");
		assertThat(object).isInstanceOf(StringArgument.class);
		assertThat(object.toString()).isEqualTo("abc");
	}

	@Test
	public void testGetAsObjectWithEmpty() throws Exception {
		Object object = converter.getAsObject(null, null, "");
		assertThat(object).isInstanceOf(StringArgument.class);
		assertThat(object.toString()).isEqualTo("");
	}

	@Test
	public void testGetAsString() throws Exception {
		assertThat(converter.getAsString(null, null, StringArgument.of("abc"))).isEqualTo("abc");
	}

}
