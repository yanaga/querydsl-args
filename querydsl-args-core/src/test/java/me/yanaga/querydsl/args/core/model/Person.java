package me.yanaga.querydsl.args.core.model;

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

import com.google.common.base.MoreObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	private String oneString;

	private String anotherString;

	private Integer oneInteger;

	private Integer anotherInteger;

	private Long oneLong;

	private Long anotherLong;

	private BigDecimal oneBigDecimal;

	private BigDecimal anotherBigDecimal;

	private BigInteger oneBigInteger;

	private BigInteger anotherBigInteger;

	private Date oneDate;

	private Date anotherDate;

	private Instant oneInstant;

	private Instant anotherInstant;

	private LocalDate oneLocalDate;

	private LocalDate anotherLocalDate;

	private LocalDateTime oneLocalDateTime;

	private LocalDateTime anotherLocalDateTime;

	private CustomComparableType oneCustomComparableType;

	private CustomComparableType anotherCustomComparableType;

	private CustomNumberType oneCustomNumberType;

	private CustomNumberType anotherCustomNumberType;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues().toString();
	}

	public Long getId() {
		return id;
	}

	public String getOneString() {
		return oneString;
	}

	public void setOneString(String oneString) {
		this.oneString = oneString;
	}

	public String getAnotherString() {
		return anotherString;
	}

	public void setAnotherString(String anotherString) {
		this.anotherString = anotherString;
	}

	public Integer getOneInteger() {
		return oneInteger;
	}

	public void setOneInteger(Integer oneInteger) {
		this.oneInteger = oneInteger;
	}

	public Integer getAnotherInteger() {
		return anotherInteger;
	}

	public void setAnotherInteger(Integer anotherInteger) {
		this.anotherInteger = anotherInteger;
	}

	public Long getOneLong() {
		return oneLong;
	}

	public void setOneLong(Long oneLong) {
		this.oneLong = oneLong;
	}

	public Long getAnotherLong() {
		return anotherLong;
	}

	public void setAnotherLong(Long anotherLong) {
		this.anotherLong = anotherLong;
	}

	public BigDecimal getOneBigDecimal() {
		return oneBigDecimal;
	}

	public void setOneBigDecimal(BigDecimal oneBigDecimal) {
		this.oneBigDecimal = oneBigDecimal;
	}

	public BigDecimal getAnotherBigDecimal() {
		return anotherBigDecimal;
	}

	public void setAnotherBigDecimal(BigDecimal anotherBigDecimal) {
		this.anotherBigDecimal = anotherBigDecimal;
	}

	public BigInteger getOneBigInteger() {
		return oneBigInteger;
	}

	public void setOneBigInteger(BigInteger oneBigInteger) {
		this.oneBigInteger = oneBigInteger;
	}

	public BigInteger getAnotherBigInteger() {
		return anotherBigInteger;
	}

	public void setAnotherBigInteger(BigInteger anotherBigInteger) {
		this.anotherBigInteger = anotherBigInteger;
	}

	public Date getOneDate() {
		return oneDate;
	}

	public void setOneDate(Date oneDate) {
		this.oneDate = oneDate;
	}

	public Date getAnotherDate() {
		return anotherDate;
	}

	public void setAnotherDate(Date anotherDate) {
		this.anotherDate = anotherDate;
	}

	public Instant getOneInstant() {
		return oneInstant;
	}

	public void setOneInstant(Instant oneInstant) {
		this.oneInstant = oneInstant;
	}

	public Instant getAnotherInstant() {
		return anotherInstant;
	}

	public void setAnotherInstant(Instant anotherInstant) {
		this.anotherInstant = anotherInstant;
	}

	public LocalDate getOneLocalDate() {
		return oneLocalDate;
	}

	public void setOneLocalDate(LocalDate oneLocalDate) {
		this.oneLocalDate = oneLocalDate;
	}

	public LocalDate getAnotherLocalDate() {
		return anotherLocalDate;
	}

	public void setAnotherLocalDate(LocalDate anotherLocalDate) {
		this.anotherLocalDate = anotherLocalDate;
	}

	public LocalDateTime getOneLocalDateTime() {
		return oneLocalDateTime;
	}

	public void setOneLocalDateTime(LocalDateTime oneLocalDateTime) {
		this.oneLocalDateTime = oneLocalDateTime;
	}

	public LocalDateTime getAnotherLocalDateTime() {
		return anotherLocalDateTime;
	}

	public void setAnotherLocalDateTime(LocalDateTime anotherLocalDateTime) {
		this.anotherLocalDateTime = anotherLocalDateTime;
	}

	public CustomComparableType getOneCustomComparableType() {
		return oneCustomComparableType;
	}

	public void setOneCustomComparableType(CustomComparableType oneCustomComparableType) {
		this.oneCustomComparableType = oneCustomComparableType;
	}

	public CustomComparableType getAnotherCustomComparableType() {
		return anotherCustomComparableType;
	}

	public void setAnotherCustomComparableType(CustomComparableType anotherCustomComparableType) {
		this.anotherCustomComparableType = anotherCustomComparableType;
	}

	public CustomNumberType getOneCustomNumberType() {
		return oneCustomNumberType;
	}

	public void setOneCustomNumberType(CustomNumberType oneCustomNumberType) {
		this.oneCustomNumberType = oneCustomNumberType;
	}

	public CustomNumberType getAnotherCustomNumberType() {
		return anotherCustomNumberType;
	}

	public void setAnotherCustomNumberType(CustomNumberType anotherCustomNumberType) {
		this.anotherCustomNumberType = anotherCustomNumberType;
	}

}
