package me.yanaga.querydsl.args.single;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.path.NumberPath;

class EmptyLongArgument implements LongArgument {

	@Override
	public void append(BooleanBuilder builder, NumberPath<Long> path, NumberPath<Long>... paths) {
	}

}
