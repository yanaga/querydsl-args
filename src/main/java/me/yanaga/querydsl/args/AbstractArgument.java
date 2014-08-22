package me.yanaga.querydsl.args;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Expression;
import com.mysema.query.types.expr.BooleanExpression;

public abstract class AbstractArgument<T extends Expression<?>> implements Argument<T> {

	private static final long serialVersionUID = 1L;

	@Override
	public final void append(BooleanBuilder builder, T path, T... paths) {
		BooleanBuilder orBuilder = new BooleanBuilder();
		orBuilder.or(doAppend(path));
		for (T t : paths) {
			orBuilder.or(doAppend(t));
		}
		if (orBuilder.hasValue()) {
			builder.or(orBuilder);
		}
	}

	protected abstract BooleanExpression doAppend(T path);

}
