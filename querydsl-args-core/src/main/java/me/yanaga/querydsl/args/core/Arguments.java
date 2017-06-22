package me.yanaga.querydsl.args.core;

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

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.SimpleExpression;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkNotNull;
import static me.yanaga.querydsl.args.core.stream.ArgumentCollectors.toBooleanBuilder;

public class Arguments {

    private Arguments() {
    }

    @SafeVarargs
    public static <T extends SimpleExpression<?>, V> void append(BooleanBuilder builder,
                                                                 V value,
                                                                 BiFunction<T, V, BooleanExpression> operation,
                                                                 T path,
                                                                 T... paths) {
        checkNotNull(builder);
        checkNotNull(operation);
        checkNotNull(path);
        builder.and(Stream.concat(Stream.of(path), Stream.of(paths))
                .filter(e -> value != null && e != null)
                .map(e -> operation.apply(e, value))
                .collect(toBooleanBuilder()));
    }

}
