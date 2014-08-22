package me.yanaga.querydsl.args.single;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.NumberPath;
import me.yanaga.querydsl.args.AbstractArgument;

class SingleLongArgument extends AbstractArgument<NumberPath<Long>> implements LongArgument {

	private static final long serialVersionUID = 1L;

	private final Long value;

	SingleLongArgument(Long value) {
		this.value = value;
	}

	@Override
	protected BooleanExpression doAppend(NumberPath<Long> path) {
		return path.eq(value);
	}

	@Override
	public String toString() {
		return value.toString();
	}

}
