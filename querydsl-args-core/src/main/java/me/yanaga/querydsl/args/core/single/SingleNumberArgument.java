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
import com.querydsl.core.types.dsl.NumberExpression;

import java.util.function.BiFunction;

public class SingleNumberArgument<T extends Number & Comparable<T>> extends AbstractSingleArgument<NumberExpression<T>, T> {

    SingleNumberArgument(T value) {
        super(value);
    }

    public static <T extends Number & Comparable<T>> SingleNumberArgument<T> of(T value) {
        return new SingleNumberArgument<>(value);
    }

    public static <T extends Number & Comparable<T>> SingleNumberArgument<T> of() {
        return of(null);
    }

    @SafeVarargs
    @Override
    public final void append(BooleanBuilder builder, BiFunction<NumberExpression<T>, T, BooleanExpression> operation, NumberExpression<T> path, NumberExpression<T>... paths) {
        super.append(builder, operation, path, paths);
    }

    @SafeVarargs
    @Override
    public final void append(BooleanBuilder builder, NumberExpression<T> path, NumberExpression<T>... paths) {
        super.append(builder, path, paths);
    }

}
