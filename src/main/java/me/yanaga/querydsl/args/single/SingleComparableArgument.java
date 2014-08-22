package me.yanaga.querydsl.args.single;

import com.google.common.base.Strings;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.path.ComparablePath;
import me.yanaga.querydsl.args.AbstractArgument;

class SingleComparableArgument extends AbstractArgument<ComparablePath<Comparable<?>>> implements ComparableArgument {

	private static final long serialVersionUID = 1L;

	private final String value;

	SingleComparableArgument(String value) {
		this.value = value;
	}

	@Override
	protected BooleanExpression doAppend(ComparablePath<Comparable<?>> path) {
		if (!Strings.isNullOrEmpty(value)) {
			return path.stringValue().containsIgnoreCase(value);
		}
		return null;
	}

	@Override
	public String toString() {
		return value;
	}

}
