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
import java.math.BigDecimal;
import java.util.Objects;

public class CustomNumberType extends Number implements Serializable, Comparable<CustomNumberType> {

	private final BigDecimal value;

	private CustomNumberType(BigDecimal value) {
		this.value = value;
	}

	public static CustomNumberType of(BigDecimal value) {
		return new CustomNumberType(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CustomNumberType) {
			CustomNumberType other = (CustomNumberType) obj;
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
	public int intValue() {
		return value.intValue();
	}

	@Override
	public long longValue() {
		return value.longValue();
	}

	@Override
	public float floatValue() {
		return value.floatValue();
	}

	@Override
	public double doubleValue() {
		return value.doubleValue();
	}

	@Override
	public int compareTo(CustomNumberType o) {
		return ComparisonChain.start().compare(this.value, o.value).result();
	}

	public BigDecimal getValue() {
		return value;
	}

}
