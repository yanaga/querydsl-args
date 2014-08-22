package me.yanaga.querydsl.args.single;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.NumberPath;
import me.yanaga.querydsl.args.AbstractArgument;

class SingleIntegerArgument extends AbstractArgument<NumberPath<Integer>> implements IntegerArgument {

	private static final long serialVersionUID = 1L;

	private final Integer value;

	SingleIntegerArgument(Integer value) {
		this.value = value;
	}

	@Override
	protected BooleanExpression doAppend(NumberPath<Integer> path) {
		return path.eq(value);
	}

	@Override
	public String toString() {
		return value.toString();
	}

}
