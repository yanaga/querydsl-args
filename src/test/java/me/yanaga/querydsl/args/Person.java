package me.yanaga.querydsl.args;

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

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Person {

	private String name;

	private String surname;

	private Integer someInteger;

	private Integer anotherInteger;

	private Long someLong;

	private Long anotherLong;

	private BigDecimal amount;

	private BigDecimal anotherAmount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getSomeInteger() {
		return someInteger;
	}

	public void setSomeInteger(Integer someInteger) {
		this.someInteger = someInteger;
	}

	public Integer getAnotherInteger() {
		return anotherInteger;
	}

	public void setAnotherInteger(Integer anotherInteger) {
		this.anotherInteger = anotherInteger;
	}

	public Long getSomeLong() {
		return someLong;
	}

	public void setSomeLong(Long someLong) {
		this.someLong = someLong;
	}

	public Long getAnotherLong() {
		return anotherLong;
	}

	public void setAnotherLong(Long anotherLong) {
		this.anotherLong = anotherLong;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAnotherAmount() {
		return anotherAmount;
	}

	public void setAnotherAmount(BigDecimal anotherAmount) {
		this.anotherAmount = anotherAmount;
	}

}
