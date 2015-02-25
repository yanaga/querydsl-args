package me.yanaga.querydsl.args.core.infrastructure.jpa;

/*
 * #%L
 * querydsl-args-core
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

import me.yanaga.querydsl.args.core.model.CustomDateType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Converter(autoApply = true)
public class CustomDateTypeAttributeConverter implements AttributeConverter<CustomDateType, Date> {

	@Override
	public Date convertToDatabaseColumn(CustomDateType attribute) {
		if (attribute != null) {
			return Date.from(attribute.getValue().atStartOfDay(ZoneOffset.UTC).toInstant());
		}
		return null;
	}

	@Override
	public CustomDateType convertToEntityAttribute(Date dbData) {
		if (dbData != null) {
			return CustomDateType.of(LocalDateTime.ofInstant(dbData.toInstant(), ZoneOffset.UTC).toLocalDate());
		}
		return null;
	}

}
