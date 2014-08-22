package me.yanaga.querydsl.args.multi;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Expression;
import me.yanaga.querydsl.args.Argument;

import java.util.List;

abstract class AbstractCompositeArgument<T extends Expression<?>> implements Argument<T> {

	private static final long serialVersionUID = 1L;

	final List<Argument<T>> args;

	AbstractCompositeArgument(Iterable<Argument<T>> args) {
		this.args = ImmutableList.copyOf(args);
	}

	@Override
	public final void append(BooleanBuilder builder, T path, T... paths) {
		BooleanBuilder predicate = new BooleanBuilder();
		for (Argument<T> arg : args) {
			arg.append(predicate, path, paths);
		}
		if (predicate.hasValue()) {
			builder.or(predicate);
		}
	}

	@Override
	public String toString() {
		return Joiner.on(',').skipNulls().join(args);
	}

}
