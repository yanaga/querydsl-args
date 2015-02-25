package me.yanaga.querydsl.args.core.range;

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
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.ComparableExpression;
import me.yanaga.querydsl.args.core.RangeArgument;

import java.io.Serializable;
import java.util.function.BiFunction;
import java.util.stream.Stream;

class AbstractRangeArgument<T extends ComparableExpression<V>, V extends Comparable<V>> implements RangeArgument<T, V>, Serializable {

	private static final long serialVersionUID = 1L;

	private final Range<V> value;

	AbstractRangeArgument(Range<V> value) {
		this.value = value;
	}

	@SafeVarargs
	@Override
	public final void append(BooleanBuilder builder,
			BiFunction<T, Range<V>, BooleanExpression> operationFunction,
			T path,
			T... paths) {
		Stream.concat(Stream.of(path), Stream.of(paths))
				.forEach(p -> builder.or(operationFunction.apply(p, value)));
	}

}
