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

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.expr.NumberExpression;
import me.yanaga.querydsl.args.core.TestConfig;
import me.yanaga.querydsl.args.core.model.CustomNumberType;
import me.yanaga.querydsl.args.core.model.Person;
import me.yanaga.querydsl.args.core.model.QPerson;
import org.assertj.core.api.Assertions;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = TestConfig.class)
public class SingleBigDecimalArgumentTest extends AbstractTransactionalTestNGSpringContextTests {

	@PersistenceContext
	private EntityManager entityManager;

	@BeforeMethod
	public void setUp() {
		Person person = new Person();
		person.setOneBigDecimal(new BigDecimal("123.12"));
		person.setAnotherBigDecimal(new BigDecimal("321"));
		person.setOneCustomNumberType(CustomNumberType.of(new BigDecimal(222)));
		entityManager.persist(person);
	}

	@Test
	public void testAppendDefaultOneArgument() {
		SingleBigDecimalArgument argument = SingleBigDecimalArgument.of(new BigDecimal("123.12"));
		BooleanBuilder builder = new BooleanBuilder();
		argument.append(builder, QPerson.person.oneBigDecimal);
		Person result = new JPAQuery(entityManager).from(QPerson.person).where(builder).uniqueResult(QPerson.person);
		assertThat(result.getOneBigDecimal()).isEqualTo(new BigDecimal("123.12"));
	}

	@Test
	public void testAppendDefaultTwoArguments() {
		SingleBigDecimalArgument argument = SingleBigDecimalArgument.of(new BigDecimal("123.12"));
		BooleanBuilder builder = new BooleanBuilder();
		argument.append(builder, QPerson.person.oneBigDecimal, QPerson.person.anotherBigDecimal);
		Person result = new JPAQuery(entityManager).from(QPerson.person).where(builder).uniqueResult(QPerson.person);
		assertThat(result.getOneBigDecimal()).isEqualTo(new BigDecimal("123.12"));
	}

	@Test
	public void testAppendGoeTwoArguments() {
		SingleBigDecimalArgument argument = SingleBigDecimalArgument.of(new BigDecimal("200"));
		BooleanBuilder builder = new BooleanBuilder();
		argument.append(builder, NumberExpression::goe, QPerson.person.oneBigDecimal, QPerson.person.anotherBigDecimal);
		Person result = new JPAQuery(entityManager).from(QPerson.person).where(builder).uniqueResult(QPerson.person);
		assertThat(result.getAnotherBigDecimal()).isEqualTo(new BigDecimal("321"));
	}

	@Test
	public void testAppendGoeTwoArgumentsWithNoResult() {
		SingleBigDecimalArgument argument = SingleBigDecimalArgument.of(new BigDecimal("400"));
		BooleanBuilder builder = new BooleanBuilder();
		argument.append(builder, NumberExpression::goe, QPerson.person.oneBigDecimal, QPerson.person.anotherBigDecimal);
		Person result = new JPAQuery(entityManager).from(QPerson.person).where(builder).uniqueResult(QPerson.person);
		assertThat(result).isNull();
	}

	@Test
	public void testAppendDefaultCustomNumberType() {
		SingleBigDecimalArgument argument = SingleBigDecimalArgument.of(new BigDecimal("222"));
		BooleanBuilder builder = new BooleanBuilder();
		argument.append(builder, QPerson.person.oneCustomNumberType.castToNum(BigDecimal.class));
		Person result = new JPAQuery(entityManager).from(QPerson.person).where(builder).uniqueResult(QPerson.person);
		Assertions.assertThat(result.getOneCustomNumberType()).isEqualTo(CustomNumberType.of(new BigDecimal("222")));
	}

	@Test
	public void testAppendLoeCustomNumberTypeAndBigDecimal() {
		SingleBigDecimalArgument argument = SingleBigDecimalArgument.of(new BigDecimal("250"));
		BooleanBuilder builder = new BooleanBuilder();
		argument.append(builder, NumberExpression::loe, QPerson.person.oneCustomNumberType.castToNum(BigDecimal.class), QPerson.person.anotherBigDecimal);
		Person result = new JPAQuery(entityManager).from(QPerson.person).where(builder).uniqueResult(QPerson.person);
		Assertions.assertThat(result.getOneCustomNumberType()).isEqualTo(CustomNumberType.of(new BigDecimal("222")));
	}

	@Test
	public void testAppendDefaultCustomNumberTypeWithNoResult() {
		SingleBigDecimalArgument argument = SingleBigDecimalArgument.of(new BigDecimal("123.12"));
		BooleanBuilder builder = new BooleanBuilder();
		argument.append(builder, QPerson.person.oneCustomNumberType.castToNum(BigDecimal.class));
		Person result = new JPAQuery(entityManager).from(QPerson.person).where(builder).uniqueResult(QPerson.person);
		assertThat(result).isNull();
	}

}
