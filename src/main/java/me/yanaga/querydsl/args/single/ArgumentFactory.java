package me.yanaga.querydsl.args.single;

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

import com.google.common.base.Splitter;
import com.google.common.base.Strings;

public class ArgumentFactory {

	private ArgumentFactory() {
	}

	public static ComparableArgument comparableOf(String value) {
		if (!Strings.isNullOrEmpty(value)) {
			String numeros = value.replaceAll("\\D", "");
			if (numeros.matches("\\d+")) {
				return new SingleComparableArgument(numeros);
			}
		}
		return new EmptyComparableArgument();
	}

	public static IntegerArgument integerOf(String value) {
		if (!Strings.isNullOrEmpty(value)) {
			String numeros = value.replaceAll("\\D", "");
			if (numeros.matches("\\d+")) {
				return new SingleIntegerArgument(Integer.valueOf(numeros));
			}
		}
		return new EmptyIntegerArgument();
	}

	public static LongArgument longOf(String value) {
		if (!Strings.isNullOrEmpty(value)) {
			String numeros = value.replaceAll("\\D", "");
			if (numeros.matches("\\d+")) {
				return new SingleLongArgument(Long.valueOf(numeros));
			}
		}
		return new EmptyLongArgument();
	}

	static Iterable<String> splitTokens(String s) {
		return Splitter.on(',').trimResults().omitEmptyStrings().split(s);
	}

	static String normalize(String value) {
		if (!Strings.isNullOrEmpty(value)) {
			return value.replaceAll("-+", "-").replaceAll("[^\\d,-]", "");
		}
		return "";
	}

}
