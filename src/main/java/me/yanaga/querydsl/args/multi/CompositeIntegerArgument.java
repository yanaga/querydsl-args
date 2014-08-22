package me.yanaga.querydsl.args.multi;

import com.mysema.query.types.path.NumberPath;
import me.yanaga.querydsl.args.Argument;

class CompositeIntegerArgument extends AbstractCompositeArgument<NumberPath<Integer>> implements MultiIntegerArgument {

	private static final long serialVersionUID = 1L;

	CompositeIntegerArgument(Iterable<Argument<NumberPath<Integer>>> args) {
		super(args);
	}

}
