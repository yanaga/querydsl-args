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
import com.querydsl.jpa.impl.JPAQuery;
import me.yanaga.querydsl.args.core.TestConfig;
import me.yanaga.querydsl.args.core.model.Person;
import me.yanaga.querydsl.args.core.model.QPerson;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = TestConfig.class)
public class SingleStringArgumentTest extends AbstractTransactionalTestNGSpringContextTests {

    @PersistenceContext
    private EntityManager entityManager;

    @BeforeMethod
    public void setUp() {
        Person person = new Person();
        person.setOneString("abcdef");
        person.setAnotherString("uvwxyz");
        entityManager.persist(person);
    }

    @Test
    public void testAppendFunction() {
        BooleanBuilder builder = new BooleanBuilder();
        SingleArgument.of("cd").append(builder, QPerson.person.oneString::containsIgnoreCase);
        Person result = new JPAQuery<Void>(entityManager).select(QPerson.person).from(QPerson.person).where(builder).fetchOne();
        assertThat(result.getOneString()).isEqualTo("abcdef");
    }

    @Test
    public void testAppendDefaultOneArgument() {
        SingleStringArgument argument = SingleStringArgument.of("cd");
        BooleanBuilder builder = new BooleanBuilder();
        argument.append(builder, QPerson.person.oneString);
        Person result = new JPAQuery<Void>(entityManager).select(QPerson.person).from(QPerson.person).where(builder).fetchOne();
        assertThat(result.getOneString()).isEqualTo("abcdef");
    }

    @Test
    public void testAppendDefaultOneArgumentWithNoResult() {
        SingleStringArgument argument = SingleStringArgument.of("yanaga");
        BooleanBuilder builder = new BooleanBuilder();
        argument.append(builder, QPerson.person.oneString);
        Person result = new JPAQuery<Void>(entityManager).select(QPerson.person).from(QPerson.person).where(builder).fetchOne();
        assertThat(result).isNull();
    }

    @Test
    public void testAppendStartsWithTwoArguments() {
        SingleStringArgument argument = SingleStringArgument.of("a");
        BooleanBuilder builder = new BooleanBuilder();
        argument.append(builder, QPerson.person.oneString, QPerson.person.anotherString);
        Person result = new JPAQuery<Void>(entityManager).select(QPerson.person).from(QPerson.person).where(builder).fetchOne();
        assertThat(result.getAnotherString()).isEqualTo("uvwxyz");
    }

    @Test
    public void testAppendDefaultWithThreeArgumentsUsingComparable() {
        SingleStringArgument argument = SingleStringArgument.of("a");
        BooleanBuilder builder = new BooleanBuilder();
        argument.append(builder, QPerson.person.oneString, QPerson.person.anotherString, QPerson.person.oneBigDecimal.stringValue());
        Person result = new JPAQuery<Void>(entityManager).select(QPerson.person).from(QPerson.person).where(builder).fetchOne();
        assertThat(result.getAnotherString()).isEqualTo("uvwxyz");
    }

    @Test
    public void testAppendStartsWithThreeArgumentsUsingComparable() {
        SingleStringArgument argument = SingleStringArgument.of("z");
        BooleanBuilder builder = new BooleanBuilder();
        argument.append(builder, QPerson.person.oneString, QPerson.person.anotherString, QPerson.person.oneBigDecimal.stringValue());
        Person result = new JPAQuery<Void>(entityManager).select(QPerson.person).from(QPerson.person).where(builder).fetchOne();
        assertThat(result.getAnotherString()).isEqualTo("uvwxyz");
    }

}
