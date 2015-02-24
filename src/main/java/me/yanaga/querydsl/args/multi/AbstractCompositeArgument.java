package me.yanaga.querydsl.args.multi;

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

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Expression;
import me.yanaga.querydsl.args.Argument;

import java.util.List;

abstract class AbstractCompositeArgument<T extends Expression<?>> implements Argument<T> {

	private static final long serialVersionUID = 1L;

	final List<Argument<T>> args;

	AbstractCompositeArgument(Iterable<Argument<T>> args) {
		this.args = ImmutableList.copyOf(args);
	}

	@Override
	public final void append(BooleanBuilder builder, T path, T... paths) {
		BooleanBuilder predicate = new BooleanBuilder();
		for (Argument<T> arg : args) {
			arg.append(predicate, path, paths);
		}
		if (predicate.hasValue()) {
			builder.or(predicate);
		}
	}

	@Override
	public String toString() {
		return Joiner.on(',').skipNulls().join(args);
	}

}
