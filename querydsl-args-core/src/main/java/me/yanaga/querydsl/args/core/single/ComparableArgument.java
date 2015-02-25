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

import com.google.common.base.Strings;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.expr.ComparableExpression;
import me.yanaga.querydsl.args.core.Argument;

public interface ComparableArgument extends Argument<ComparableExpression<? extends Comparable<?>>, String> {

	@SuppressWarnings("unchecked")
	public default void append(BooleanBuilder builder, ComparableExpression<? extends Comparable<?>> path, ComparableExpression<? extends Comparable<?>>... paths) {
		append(builder, (p, s) -> p.stringValue().containsIgnoreCase(s), path, paths);
	}

	public static ComparableArgument of(String value) {
		if (!Strings.isNullOrEmpty(value)) {
			String trimmed = value.trim();
			if (!trimmed.isEmpty()) {
				return new SingleComparableArgument(trimmed);
			}
		}
		return new EmptyComparableArgument();
	}

	public static ComparableArgument of() {
		return new EmptyComparableArgument();
	}

}
