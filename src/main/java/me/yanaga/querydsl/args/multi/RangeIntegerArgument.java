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

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.NumberPath;
import me.yanaga.querydsl.args.AbstractArgument;
import me.yanaga.querydsl.args.single.IntegerArgument;

class RangeIntegerArgument extends AbstractArgument<NumberPath<Integer>> implements IntegerArgument {

	private static final long serialVersionUID = 1L;

	private final Integer inicio;

	private final Integer termino;

	RangeIntegerArgument(Integer inicio, Integer termino) {
		this.inicio = inicio;
		this.termino = termino;
	}

	@Override
	protected BooleanExpression doAppend(NumberPath<Integer> path) {
		return path.between(inicio, termino);
	}

	@Override
	public String toString() {
		return String.format("%d-%d", inicio, termino);
	}
}
