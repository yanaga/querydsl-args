package me.yanaga.querydsl.args;

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

public abstract class AbstractArgument<T extends Expression<?>> implements Argument<T> {

	private static final long serialVersionUID = 1L;

	@Override
	public final void append(BooleanBuilder builder, T path, T... paths) {
		BooleanBuilder orBuilder = new BooleanBuilder();
		orBuilder.or(doAppend(path));
		for (T t : paths) {
			orBuilder.or(doAppend(t));
		}
		if (orBuilder.hasValue()) {
			builder.or(orBuilder);
		}
	}

	protected abstract BooleanExpression doAppend(T path);

}
