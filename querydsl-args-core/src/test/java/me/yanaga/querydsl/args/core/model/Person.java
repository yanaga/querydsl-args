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
import com.mysema.query.annotations.PropertyType;
import com.mysema.query.annotations.QueryType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	private String aString;

	private String anotherString;

	private Integer anInteger;

	private Integer anotherInteger;

	private Long aLong;

	private Long anotherLong;

	private BigDecimal aBigDecimal;

	private BigDecimal anotherBigDecimal;

	private BigInteger aBigInteger;

	private BigInteger anotherBigInteger;

	private Date aDate;

	private Date anotherDate;

	private Instant anInstant;

	private Instant anotherInstant;

	private LocalDate aLocalDate;

	private LocalDate anotherLocalDate;

	@QueryType(PropertyType.NUMERIC)
	private CustomNumberType aCustomNumberType;

	@QueryType(PropertyType.NUMERIC)
	private CustomNumberType anotherCustomNumberType;

	@QueryType(PropertyType.DATETIME)
	private CustomDateTimeType aCustomDateTimeType;

	@QueryType(PropertyType.DATETIME)
	private CustomDateTimeType anotherCustomDateTimeType;

	@QueryType(PropertyType.DATE)
	private CustomDateType aCustomDateType;

	@QueryType(PropertyType.DATE)
	private CustomDateType anotherCustomDateType;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).omitNullValues().toString();
	}

	public Long getId() {
		return id;
	}

	public String getaString() {
		return aString;
	}

	public void setaString(String aString) {
		this.aString = aString;
	}

	public String getAnotherString() {
		return anotherString;
	}

	public void setAnotherString(String anotherString) {
		this.anotherString = anotherString;
	}

	public Integer getAnInteger() {
		return anInteger;
	}

	public void setAnInteger(Integer anInteger) {
		this.anInteger = anInteger;
	}

	public Integer getAnotherInteger() {
		return anotherInteger;
	}

	public void setAnotherInteger(Integer anotherInteger) {
		this.anotherInteger = anotherInteger;
	}

	public Long getaLong() {
		return aLong;
	}

	public void setaLong(Long aLong) {
		this.aLong = aLong;
	}

	public Long getAnotherLong() {
		return anotherLong;
	}

	public void setAnotherLong(Long anotherLong) {
		this.anotherLong = anotherLong;
	}

	public BigDecimal getaBigDecimal() {
		return aBigDecimal;
	}

	public void setaBigDecimal(BigDecimal aBigDecimal) {
		this.aBigDecimal = aBigDecimal;
	}

	public BigDecimal getAnotherBigDecimal() {
		return anotherBigDecimal;
	}

	public void setAnotherBigDecimal(BigDecimal anotherBigDecimal) {
		this.anotherBigDecimal = anotherBigDecimal;
	}

	public BigInteger getaBigInteger() {
		return aBigInteger;
	}

	public void setaBigInteger(BigInteger aBigInteger) {
		this.aBigInteger = aBigInteger;
	}

	public BigInteger getAnotherBigInteger() {
		return anotherBigInteger;
	}

	public void setAnotherBigInteger(BigInteger anotherBigInteger) {
		this.anotherBigInteger = anotherBigInteger;
	}

	public Date getaDate() {
		return aDate;
	}

	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}

	public Date getAnotherDate() {
		return anotherDate;
	}

	public void setAnotherDate(Date anotherDate) {
		this.anotherDate = anotherDate;
	}

	public Instant getAnInstant() {
		return anInstant;
	}

	public void setAnInstant(Instant anInstant) {
		this.anInstant = anInstant;
	}

	public Instant getAnotherInstant() {
		return anotherInstant;
	}

	public void setAnotherInstant(Instant anotherInstant) {
		this.anotherInstant = anotherInstant;
	}

	public LocalDate getaLocalDate() {
		return aLocalDate;
	}

	public void setaLocalDate(LocalDate aLocalDate) {
		this.aLocalDate = aLocalDate;
	}

	public LocalDate getAnotherLocalDate() {
		return anotherLocalDate;
	}

	public void setAnotherLocalDate(LocalDate anotherLocalDate) {
		this.anotherLocalDate = anotherLocalDate;
	}

	public CustomNumberType getaCustomNumberType() {
		return aCustomNumberType;
	}

	public void setaCustomNumberType(CustomNumberType aCustomNumberType) {
		this.aCustomNumberType = aCustomNumberType;
	}

	public CustomNumberType getAnotherCustomNumberType() {
		return anotherCustomNumberType;
	}

	public void setAnotherCustomNumberType(CustomNumberType anotherCustomNumberType) {
		this.anotherCustomNumberType = anotherCustomNumberType;
	}

	public CustomDateTimeType getaCustomDateTimeType() {
		return aCustomDateTimeType;
	}

	public void setaCustomDateTimeType(CustomDateTimeType aCustomDateTimeType) {
		this.aCustomDateTimeType = aCustomDateTimeType;
	}

	public CustomDateTimeType getAnotherCustomDateTimeType() {
		return anotherCustomDateTimeType;
	}

	public void setAnotherCustomDateTimeType(CustomDateTimeType anotherCustomDateTimeType) {
		this.anotherCustomDateTimeType = anotherCustomDateTimeType;
	}

	public CustomDateType getaCustomDateType() {
		return aCustomDateType;
	}

	public void setaCustomDateType(CustomDateType aCustomDateType) {
		this.aCustomDateType = aCustomDateType;
	}

	public CustomDateType getAnotherCustomDateType() {
		return anotherCustomDateType;
	}

	public void setAnotherCustomDateType(CustomDateType anotherCustomDateType) {
		this.anotherCustomDateType = anotherCustomDateType;
	}

}
