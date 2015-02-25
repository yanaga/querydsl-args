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

import com.google.common.collect.ImmutableMap;
import me.yanaga.querydsl.args.core.single.LocalDateArgument;
import org.testng.annotations.Test;

import javax.faces.component.UIComponent;
import javax.faces.convert.ConverterException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LocalDateArgumentConverterTest {

	private final LocalDateArgumentConverter converter = new LocalDateArgumentConverter();

	@Test
	public void testGetAsObject() throws Exception {
		UIComponent component = mock(UIComponent.class);
		Object object = converter.getAsObject(null, component, "2015-02-27");
		assertThat(object).isInstanceOf(LocalDateArgument.class);
		assertThat(object.toString()).isEqualTo("2015-02-27");
	}

	@Test(expectedExceptions = ConverterException.class)
	public void testGetAsObjectWithInvalidInput() throws Exception {
		UIComponent component = mock(UIComponent.class);
		converter.getAsObject(null, component, "abc");
	}

	@Test
	public void testGetAsObjectWithPattern() throws Exception {
		UIComponent component = mock(UIComponent.class);
		Map<String, Object> attributes = ImmutableMap.of("pattern", "dd/MM/yyyy");
		when(component.getAttributes()).thenReturn(attributes);
		Object object = converter.getAsObject(null, component, "25/02/2015");
		assertThat(object).isInstanceOf(LocalDateArgument.class);
		LocalDateArgument argument = (LocalDateArgument) object;
		assertThat(argument.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).isEqualTo("25/02/2015");
	}

	@Test
	public void testGetAsObjectWithEmpty() throws Exception {
		UIComponent component = mock(UIComponent.class);
		Object object = converter.getAsObject(null, component, "");
		assertThat(object).isInstanceOf(LocalDateArgument.class);
		assertThat(object.toString()).isEqualTo("");
	}

	@Test
	public void testGetAsString() throws Exception {
		UIComponent component = mock(UIComponent.class);
		assertThat(converter.getAsString(null, component, LocalDateArgument.of(LocalDate.of(2015, 2, 25)))).isEqualTo("2015-02-25");
	}

	@Test
	public void testGetAsStringWithPattern() throws Exception {
		UIComponent component = mock(UIComponent.class);
		Map<String, Object> attributes = ImmutableMap.of("pattern", "dd/MM/yyyy");
		when(component.getAttributes()).thenReturn(attributes);
		assertThat(converter.getAsString(null, component, LocalDateArgument.of(LocalDate.of(2015, 2, 25)))).isEqualTo("25/02/2015");
	}

}
