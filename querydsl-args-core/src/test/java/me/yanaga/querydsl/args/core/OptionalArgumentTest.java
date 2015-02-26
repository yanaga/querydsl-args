package me.yanaga.querydsl.args.core;

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
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.expr.SimpleExpression;
import me.yanaga.querydsl.args.core.model.CustomNumberType;
import me.yanaga.querydsl.args.core.model.Person;
import me.yanaga.querydsl.args.core.model.QPerson;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = TestConfig.class)
public class OptionalArgumentTest extends AbstractTransactionalTestNGSpringContextTests {

	@PersistenceContext
	private EntityManager entityManager;

	@BeforeMethod
	public void setUp() {
		Person person = new Person();
		person.setOneString("abcdef");
		person.setAnotherString("uvwxyz");
		person.setOneCustomNumberType(CustomNumberType.of(new BigDecimal("123")));
		person.setAnotherCustomNumberType(CustomNumberType.of(new BigDecimal("321")));
		entityManager.persist(person);
	}

	@Test
	public void testAppendNullWithDefaultAndTwoArguments() throws Exception {
		BooleanBuilder builder = new BooleanBuilder();
		OptionalArgument.append(builder, null, QPerson.person.oneCustomNumberType, QPerson.person.anotherCustomNumberType);
		List<Person> result = new JPAQuery(entityManager).from(QPerson.person).where(builder).list(QPerson.person);
		assertThat(result.size()).isEqualTo(1);
	}

	@Test
	public void testAppendNullWithOperationAndTwoArguments() throws Exception {
		BooleanBuilder builder = new BooleanBuilder();
		OptionalArgument.<SimpleExpression, CustomNumberType>append(builder, null, SimpleExpression::eq, QPerson.person.oneCustomNumberType, QPerson.person.anotherCustomNumberType);
		List<Person> result = new JPAQuery(entityManager).from(QPerson.person).where(builder).list(QPerson.person);
		assertThat(result.size()).isEqualTo(1);
	}

	@Test
	public void testAppendWithDefaultAndTwoArguments() throws Exception {
		BooleanBuilder builder = new BooleanBuilder();
		OptionalArgument.append(builder, CustomNumberType.of(new BigDecimal("222")), QPerson.person.oneCustomNumberType, QPerson.person.anotherCustomNumberType);
		List<Person> result = new JPAQuery(entityManager).from(QPerson.person).where(builder).list(QPerson.person);
		assertThat(result).isEmpty();
	}

}
