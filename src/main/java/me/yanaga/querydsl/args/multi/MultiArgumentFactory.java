package me.yanaga.querydsl.args.multi;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.mysema.query.types.path.ComparablePath;
import com.mysema.query.types.path.NumberPath;
import me.yanaga.querydsl.args.Argument;
import me.yanaga.querydsl.args.single.ArgumentFactory;

public class MultiArgumentFactory {

	private MultiArgumentFactory() {
	}

	public static MultiComparableArgument comparableOf(String value) {
		ImmutableList.Builder<Argument<ComparablePath<Comparable<?>>>> builder = ImmutableList.builder();
		for (String token : splitTokens(normalize(value))) {
			if (token.matches("\\d+-\\d+")) {
				String[] split = token.split("-");
				builder.add(new RangeComparableArgument(split[0], split[1]));
			}
			else {
				String numeros = token.replaceAll("\\D", "");
				if (numeros.matches("\\d+")) {
					builder.add(ArgumentFactory.comparableOf(numeros));
				}
			}
		}
		return new CompositeComparableArgument(builder.build());
	}

	public static MultiIntegerArgument integerOf(String value) {
		ImmutableList.Builder<Argument<NumberPath<Integer>>> builder = ImmutableList.builder();
		for (String token : splitTokens(normalize(value))) {
			if (token.matches("\\d+-\\d+")) {
				String[] split = token.split("-");
				builder.add(new RangeIntegerArgument(Integer.valueOf(split[0]), Integer.valueOf(split[1])));
			}
			else {
				String numeros = token.replaceAll("\\D", "");
				if (numeros.matches("\\d+")) {
					builder.add(ArgumentFactory.integerOf(numeros));
				}
			}
		}
		return new CompositeIntegerArgument(builder.build());
	}

	public static MultiLongArgument longOf(String value) {
		ImmutableList.Builder<Argument<NumberPath<Long>>> builder = ImmutableList.builder();
		for (String token : splitTokens(normalize(value))) {
			if (token.matches("\\d+-\\d+")) {
				String[] split = token.split("-");
				builder.add(new RangeLongArgument(Long.valueOf(split[0]), Long.valueOf(split[1])));
			}
			else {
				String numeros = token.replaceAll("\\D", "");
				if (numeros.matches("\\d+")) {
					builder.add(ArgumentFactory.longOf(numeros));
				}
			}
		}
		return new CompositeLongArgument(builder.build());
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
