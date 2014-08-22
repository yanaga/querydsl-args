package me.yanaga.querydsl.args.single;

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
