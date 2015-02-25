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

import javax.faces.component.UIComponent;
import javax.faces.convert.Converter;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

abstract class AbstractTemporalArgumentConverter implements Converter {

	static final String PATTERN_KEY = "pattern";

	DateTimeFormatter getPattern(UIComponent component) {
		return Optional.ofNullable(component.getAttributes().get(PATTERN_KEY))
				.map(Object::toString)
				.map(DateTimeFormatter::ofPattern)
				.orElse(getDefaultPattern());
	}

	abstract DateTimeFormatter getDefaultPattern();

}
