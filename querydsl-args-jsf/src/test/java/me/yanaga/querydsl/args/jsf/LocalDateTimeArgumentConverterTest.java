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
import me.yanaga.querydsl.args.core.single.LocalDateTimeArgument;
import org.testng.annotations.Test;

import javax.faces.component.UIComponent;
import javax.faces.convert.ConverterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LocalDateTimeArgumentConverterTest {

	private final LocalDateTimeArgumentConverter converter = new LocalDateTimeArgumentConverter();

	@Test
	public void testGetAsObject() throws Exception {
		UIComponent component = mock(UIComponent.class);
		Object object = converter.getAsObject(null, component, "2015-02-25T17:47:06");
		assertThat(object).isInstanceOf(LocalDateTimeArgument.class);
		assertThat(object.toString()).isEqualTo("2015-02-25T17:47:06");
	}

	@Test(expectedExceptions = ConverterException.class)
	public void testGetAsObjectWithInvalidInput() throws Exception {
		UIComponent component = mock(UIComponent.class);
		converter.getAsObject(null, component, "abc");
	}

	@Test
	public void testGetAsObjectWithPattern() throws Exception {
		UIComponent component = mock(UIComponent.class);
		Map<String, Object> attributes = ImmutableMap.of("pattern", "dd/MM/yyyy HH:mm:ss");
		when(component.getAttributes()).thenReturn(attributes);
		Object object = converter.getAsObject(null, component, "25/02/2015 17:47:06");
		assertThat(object).isInstanceOf(LocalDateTimeArgument.class);
		LocalDateTimeArgument argument = (LocalDateTimeArgument) object;
		assertThat(argument.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)).isEqualTo("2015-02-25T17:47:06");
	}

	@Test
	public void testGetAsObjectWithEmpty() throws Exception {
		UIComponent component = mock(UIComponent.class);
		Object object = converter.getAsObject(null, component, "");
		assertThat(object).isInstanceOf(LocalDateTimeArgument.class);
		assertThat(object.toString()).isEqualTo("");
	}

	@Test
	public void testGetAsString() throws Exception {
		UIComponent component = mock(UIComponent.class);
		assertThat(converter.getAsString(null, component, LocalDateTimeArgument.of(LocalDateTime.of(2015, 2, 25, 17, 47, 6)))).isEqualTo("2015-02-25T17:47:06");
	}

	@Test
	public void testGetAsStringWithPattern() throws Exception {
		UIComponent component = mock(UIComponent.class);
		Map<String, Object> attributes = ImmutableMap.of("pattern", "dd/MM/yyyy HH:mm:ss");
		when(component.getAttributes()).thenReturn(attributes);
		assertThat(converter.getAsString(null, component, LocalDateTimeArgument.of(LocalDateTime.of(2015, 2, 25, 17, 47, 6)))).isEqualTo("25/02/2015 17:47:06");
	}

}
