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

import com.mysema.query.BooleanBuilder;
import me.yanaga.querydsl.args.core.model.QPerson;
import org.testng.annotations.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgumentCollectorsTest {

	@Test
	public void testToBooleanBuilder() throws Exception {
		BooleanBuilder builder = Stream.of(QPerson.person.oneString, QPerson.person.anotherString)
				.map(e -> e.startsWith("abc"))
				.collect(ArgumentCollectors.toBooleanBuilder());
		assertThat(builder.toString()).isEqualTo("startsWith(person.oneString,abc) || startsWith(person.anotherString,abc)");
	}

}
