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

import com.google.common.base.Strings;
import me.yanaga.querydsl.args.core.single.SingleLocalDateTimeArgument;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@FacesConverter(forClass = SingleLocalDateTimeArgument.class)
public class SingleLocalDateTimeArgumentConverter extends AbstractTemporalArgumentConverter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		DateTimeFormatter pattern = getPattern(component);
		if (!Strings.isNullOrEmpty(value)) {
			try {
				return SingleLocalDateTimeArgument.of(LocalDateTime.parse(value.trim(), pattern));
			}
			catch (DateTimeParseException ex) {
				throw new ConverterException("Invalid Date", ex);
			}
		}
		return SingleLocalDateTimeArgument.of();
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			DateTimeFormatter pattern = getPattern(component);
			SingleLocalDateTimeArgument argument = (SingleLocalDateTimeArgument) value;
			return argument.format(pattern);
		}
		return null;
	}

	@Override
	DateTimeFormatter getDefaultPattern() {
		return DateTimeFormatter.ISO_LOCAL_DATE_TIME;
	}

}
