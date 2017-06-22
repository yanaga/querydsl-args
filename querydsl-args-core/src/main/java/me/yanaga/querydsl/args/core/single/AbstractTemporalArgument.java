package me.yanaga.querydsl.args.core.single;

/*
 * #%L
 * querydsl-args-core
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

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.TemporalExpression;

import java.time.format.DateTimeFormatter;
import java.util.function.BiFunction;

public abstract class AbstractTemporalArgument<T extends TemporalExpression<V>, V extends Comparable<?>>
        extends AbstractSingleArgument<T, V> {

    protected AbstractTemporalArgument(V value) {
        super(value);
    }

    @SafeVarargs
    @Override
    public final void append(BooleanBuilder builder, BiFunction<T, V, BooleanExpression> operation, T path, T... paths) {
        super.append(builder, operation, path, paths);
    }

    @SafeVarargs
    @Override
    public final void append(BooleanBuilder builder, T path, T... paths) {
        super.append(builder, path, paths);
    }

    public abstract String format(DateTimeFormatter formatter);

}
