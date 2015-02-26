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

	AbstractSingleArgument(V value) {
		this.value = value;
	}

	AbstractSingleArgument() {
		this(null);
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
		OptionalArgument.append(builder, value, getDefaultOperation(), path, paths);
	}

	BiFunction<T, V, BooleanExpression> getDefaultOperation() {
		return SimpleExpression::eq;
	}

	@Override
	public String toString() {
		if (value != null) {
			return value.toString();
		}
		return "";
	}

}
