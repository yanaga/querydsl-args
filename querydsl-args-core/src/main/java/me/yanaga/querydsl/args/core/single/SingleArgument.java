package me.yanaga.querydsl.args.core.single;

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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SingleArgument {

	private SingleArgument() {
	}

	public static SingleBigDecimalArgument of(BigDecimal value) {
		return SingleBigDecimalArgument.of(value);
	}

	public static SingleBigIntegerArgument of(BigInteger value) {
		return SingleBigIntegerArgument.of(value);
	}

	public static <T extends Comparable<T>> SingleComparableArgument<T> of(T value) {
		return SingleComparableArgument.of(value);
	}

	public static SingleIntegerArgument of(Integer value) {
		return SingleIntegerArgument.of(value);
	}

	public static SingleLocalDateArgument of(LocalDate value) {
		return SingleLocalDateArgument.of(value);
	}

	public static SingleLocalDateTimeArgument of(LocalDateTime value) {
		return SingleLocalDateTimeArgument.of(value);
	}

	public static SingleLongArgument of(Long value) {
		return SingleLongArgument.of(value);
	}

	public static <T extends Number & Comparable<T>> SingleNumberArgument<T> of(T value) {
		return SingleNumberArgument.of(value);
	}

	public static <T> SingleSimpleArgument<T> of(T value) {
		return SingleSimpleArgument.of(value);
	}

	public static SingleStringArgument of(String value) {
		return SingleStringArgument.of(value);
	}

}
