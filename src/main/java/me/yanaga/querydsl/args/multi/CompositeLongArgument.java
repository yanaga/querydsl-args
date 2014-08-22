package me.yanaga.querydsl.args.multi;

import com.mysema.query.types.path.NumberPath;
import me.yanaga.querydsl.args.Argument;

class CompositeLongArgument extends AbstractCompositeArgument<NumberPath<Long>> implements MultiLongArgument {

	private static final long serialVersionUID = 1L;

	CompositeLongArgument(Iterable<Argument<NumberPath<Long>>> args) {
		super(args);
	}

}
