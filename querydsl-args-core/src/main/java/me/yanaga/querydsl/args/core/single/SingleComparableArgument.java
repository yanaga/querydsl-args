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
import com.mysema.query.types.expr.ComparableExpression;

import java.util.function.BiFunction;

public class SingleComparableArgument<T extends Comparable> extends AbstractSingleArgument<ComparableExpression<T>, T> {

	private static final long serialVersionUID = 1L;

	private SingleComparableArgument(T value) {
		super(value);
	}

	public static <T extends Comparable> SingleComparableArgument<T> of(T value) {
		return new SingleComparableArgument<>(value);
	}

	public static SingleComparableArgument of() {
		return of(null);
	}

	@SafeVarargs
	public final void append(BooleanBuilder builder,
			BiFunction<ComparableExpression<T>, T, BooleanExpression> operation,
			ComparableExpression<T> path,
			ComparableExpression<T>... paths) {
		super.append(builder, operation, path, paths);
	}

	@SafeVarargs
	public final void append(BooleanBuilder builder, ComparableExpression<T> path, ComparableExpression<T>... paths) {
		super.append(builder, path, paths);
	}

}
