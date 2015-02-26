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
import com.mysema.query.types.expr.ComparableExpressionBase;
import com.mysema.query.types.expr.StringExpression;
import me.yanaga.querydsl.args.core.Argument;

import java.util.function.BiFunction;

import static com.google.common.base.Preconditions.checkNotNull;

@SuppressWarnings("unchecked")
public interface StringArgument extends Argument<StringExpression, StringExpression, String> {

	public void append(BooleanBuilder builder,
			BiFunction<ComparableExpressionBase<? extends Comparable<?>>, Comparable<?>, BooleanExpression> operationFunction,
			ComparableExpressionBase<? extends Comparable<?>> path,
			ComparableExpressionBase<? extends Comparable<?>>... paths);

	public void append(BooleanBuilder builder,
			ComparableExpressionBase<? extends Comparable<?>> path,
			ComparableExpressionBase<? extends Comparable<?>>... paths);

	public static StringArgument of(String value) {
		checkNotNull(value);
		return new SingleStringArgument(value);
	}

	public static StringArgument of() {
		return new SingleStringArgument();
	}

}
