package me.yanaga.querydsl.args.multi;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.NumberPath;
import me.yanaga.querydsl.args.AbstractArgument;
import me.yanaga.querydsl.args.single.IntegerArgument;

class RangeIntegerArgument extends AbstractArgument<NumberPath<Integer>> implements IntegerArgument {

	private static final long serialVersionUID = 1L;

	private final Integer inicio;

	private final Integer termino;

	RangeIntegerArgument(Integer inicio, Integer termino) {
		this.inicio = inicio;
		this.termino = termino;
	}

	@Override
	protected BooleanExpression doAppend(NumberPath<Integer> path) {
		return path.between(inicio, termino);
	}

	@Override
	public String toString() {
		return String.format("%d-%d", inicio, termino);
	}
}
