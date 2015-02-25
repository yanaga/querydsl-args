package me.yanaga.querydsl.args.core.single;

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

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Expression;
import com.mysema.query.types.expr.BooleanExpression;
import me.yanaga.querydsl.args.core.Argument;

import java.io.Serializable;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;

abstract class AbstractSingleArgument<T extends Expression<?>, V> implements Argument<T, V>, Serializable {

	private static final long serialVersionUID = 1L;

	private final V value;

	AbstractSingleArgument(V value) {
		this.value = value;
	}

	@SafeVarargs
	@Override
	public final void append(BooleanBuilder builder,
			BiFunction<T, V, BooleanExpression> operationFunction,
			T path,
			T... paths) {
		Collector<T, BooleanBuilder, BooleanBuilder> collector = Collector.of(
				BooleanBuilder::new,
				(b, t) -> b.or(operationFunction.apply(t, value)),
				BooleanBuilder::or,
				Function.identity(),
				Collector.Characteristics.UNORDERED);
		builder.and(Stream.concat(Stream.of(path), Stream.of(paths)).collect(collector));
	}

	@Override
	public String toString() {
		return value.toString();
	}

}
