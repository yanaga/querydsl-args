package me.yanaga.querydsl.args.single;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.path.ComparablePath;

class EmptyComparableArgument implements ComparableArgument {

	@Override
	public void append(BooleanBuilder builder, ComparablePath<Comparable<?>> path, ComparablePath<Comparable<?>>... paths) {
	}

}
