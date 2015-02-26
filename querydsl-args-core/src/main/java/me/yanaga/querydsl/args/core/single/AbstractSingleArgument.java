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
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.SimpleExpression;
import me.yanaga.querydsl.args.core.Argument;
import me.yanaga.querydsl.args.core.OptionalArgument;

import java.io.Serializable;
import java.util.function.BiFunction;

abstract class AbstractSingleArgument<T extends SimpleExpression<V>, V> implements Argument<T, T, V>, Serializable {

	private static final long serialVersionUID = 1L;

	final V value;

	final BiFunction<T, V, BooleanExpression> defaultOperation;

	AbstractSingleArgument(V value, BiFunction<T, V, BooleanExpression> defaultOperation) {
		this.value = value;
		this.defaultOperation = defaultOperation;
	}

	public AbstractSingleArgument(V value) {
		this(value, SimpleExpression::eq);
	}

	@SafeVarargs
	@Override
	public final void append(BooleanBuilder builder,
			BiFunction<T, V, BooleanExpression> operation,
			T path,
			T... paths) {
		OptionalArgument.append(builder, value, operation, path, paths);
	}

	@SafeVarargs
	@Override
	public final void append(BooleanBuilder builder, T path, T... paths) {
		OptionalArgument.append(builder, value, defaultOperation, path, paths);
	}

	@Override
	public String toString() {
		return value.toString();
	}

}
