package me.yanaga.querydsl.args;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Expression;

import java.io.Serializable;

public interface Argument<T extends Expression<?>> extends Serializable {

	@SuppressWarnings("unchecked")
	public void append(BooleanBuilder builder, T path, T... paths);

}
