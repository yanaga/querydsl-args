package me.yanaga.querydsl.args;

import javax.persistence.Entity;

@Entity
public class Person {

	private Integer someInteger;

	private Integer anotherInteger;

	private Long someLong;

	private Long anotherLong;

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
}
