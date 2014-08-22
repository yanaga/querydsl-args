package me.yanaga.querydsl.args.multi;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.NumberPath;
import me.yanaga.querydsl.args.AbstractArgument;
import me.yanaga.querydsl.args.single.LongArgument;

class RangeLongArgument extends AbstractArgument<NumberPath<Long>> implements LongArgument {

	private static final long serialVersionUID = 1L;

	private final Long inicio;

	private final Long termino;

	RangeLongArgument(Long inicio, Long termino) {
		this.inicio = inicio;
		this.termino = termino;
	}

	@Override
	protected BooleanExpression doAppend(NumberPath<Long> path) {
		return path.between(inicio, termino);
	}

	@Override
	public String toString() {
		return String.format("%d-%d", inicio, termino);
	}
}
