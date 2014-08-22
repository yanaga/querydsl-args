package me.yanaga.querydsl.args.multi;

import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.ComparablePath;
import me.yanaga.querydsl.args.AbstractArgument;
import me.yanaga.querydsl.args.single.ComparableArgument;

class RangeComparableArgument extends AbstractArgument<ComparablePath<Comparable<?>>> implements ComparableArgument {

	private static final long serialVersionUID = 1L;

	private final Comparable<?> inicio;

	private final Comparable<?> termino;

	RangeComparableArgument(Comparable<?> inicio, Comparable<?> termino) {
		this.inicio = inicio;
		this.termino = termino;
	}

	@Override
	public String toString() {
		return String.format("%s-%s", inicio, termino);
	}

	@Override
	protected BooleanExpression doAppend(ComparablePath<Comparable<?>> path) {
		return path.between(inicio, termino);
	}

}
