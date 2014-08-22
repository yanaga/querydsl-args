package me.yanaga.querydsl.args.multi;

import com.mysema.query.types.path.ComparablePath;
import me.yanaga.querydsl.args.Argument;

class CompositeComparableArgument extends AbstractCompositeArgument<ComparablePath<Comparable<?>>> implements MultiComparableArgument {

	private static final long serialVersionUID = 1L;

	CompositeComparableArgument(Iterable<Argument<ComparablePath<Comparable<?>>>> args) {
		super(args);
	}

}
