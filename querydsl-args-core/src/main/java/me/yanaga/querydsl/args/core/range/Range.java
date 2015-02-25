package me.yanaga.querydsl.args.core.range;

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

import java.io.Serializable;
import java.util.Objects;

public class Range<T extends Comparable<T>> implements Serializable {

	private final T begin;

	private final T end;

	private Range(T begin, T end) {
		this.begin = begin;
		this.end = end;
	}

	public static <T extends Comparable<T>> Range<T> of(T begin, T end) {
		return new Range<>(begin, end);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Range) {
			Range other = (Range) obj;
			return Objects.equals(this.begin, other.begin) && Objects.equals(this.end, other.end);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.begin, this.end);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("begin", begin).add("end", end).toString();
	}

	public T getBegin() {
		return begin;
	}

	public T getEnd() {
		return end;
	}

}
