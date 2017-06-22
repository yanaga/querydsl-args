package me.yanaga.querydsl.args.core.stream;

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

import java.util.function.Function;
import java.util.stream.Collector;

public class ArgumentCollectors {

    private ArgumentCollectors() {
    }

    public static Collector<BooleanExpression, BooleanBuilder, BooleanBuilder> toBooleanBuilder() {
        return Collector.of(
                BooleanBuilder::new,
                BooleanBuilder::or,
                BooleanBuilder::or,
                Function.identity(),
                Collector.Characteristics.UNORDERED);
    }

}
