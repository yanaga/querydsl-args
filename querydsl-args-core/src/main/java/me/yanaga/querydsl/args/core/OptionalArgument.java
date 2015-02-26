package me.yanaga.querydsl.args.core;

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

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.SimpleExpression;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkNotNull;
import static me.yanaga.querydsl.args.core.stream.ArgumentCollectors.toBooleanBuilder;

public class OptionalArgument {

	private OptionalArgument() {
	}

	public static <T> void append(BooleanBuilder builder, T value, Function<T, BooleanExpression> function) {
		checkNotNull(builder);
		checkNotNull(function);
		if (value != null) {
			builder.and(function.apply(value));
		}
	}

	@SafeVarargs
	public static <T extends SimpleExpression<?>, V> void append(BooleanBuilder builder,
			V value,
			BiFunction<T, V, BooleanExpression> operation,
			T path,
			T... paths) {
		checkNotNull(builder);
		checkNotNull(operation);
		checkNotNull(path);
		builder.and(Stream.concat(Stream.of(path), Stream.of(paths))
				.filter(e -> value != null && e != null)
				.map(e -> operation.apply(e, value))
				.collect(toBooleanBuilder()));
	}

	@SafeVarargs
	public static <T extends SimpleExpression<V>, V> void append(BooleanBuilder builder,
			V value,
			T path,
			T... paths) {
		append(builder, value, T::eq, path, paths);
	}

}
