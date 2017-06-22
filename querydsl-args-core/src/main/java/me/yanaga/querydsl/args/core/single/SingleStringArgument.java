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

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringExpression;

import java.util.function.BiFunction;

public class SingleStringArgument extends AbstractSingleArgument<StringExpression, String> {

    private static final long serialVersionUID = 1L;

    private SingleStringArgument(String value) {
        super(value);
    }

    public static SingleStringArgument of(String value) {
        return new SingleStringArgument(value);
    }

    public static SingleStringArgument of() {
        return of(null);
    }

    @Override
    public final void append(BooleanBuilder builder, BiFunction<StringExpression, String, BooleanExpression> operation, StringExpression path, StringExpression... paths) {
        super.append(builder, operation, path, paths);
    }

    @Override
    public final void append(BooleanBuilder builder, StringExpression path, StringExpression... paths) {
        super.append(builder, path, paths);
    }

    @Override
    BiFunction<StringExpression, String, BooleanExpression> getDefaultOperation() {
        return StringExpression::containsIgnoreCase;
    }

}
