package me.yanaga.querydsl.args.core.model;

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

import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class CustomDateTimeType implements Serializable, Comparable<CustomDateTimeType> {

	private final LocalDateTime value;

	private CustomDateTimeType(LocalDateTime value) {
		this.value = value;
	}

	public static CustomDateTimeType of(LocalDateTime value) {
		return new CustomDateTimeType(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CustomDateTimeType) {
			CustomDateTimeType other = (CustomDateTimeType) obj;
			return Objects.equals(this.value, other.value);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.value);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("value", value).toString();
	}

	@Override
	public int compareTo(CustomDateTimeType o) {
		return ComparisonChain.start().compare(this.value, o.value).result();
	}

	public LocalDateTime getValue() {
		return value;
	}

}
