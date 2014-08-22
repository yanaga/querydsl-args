package me.yanaga.querydsl.args.single;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.path.NumberPath;

class EmptyIntegerArgument implements IntegerArgument {

	@Override
	public void append(BooleanBuilder builder, NumberPath<Integer> path, NumberPath<Integer>... paths) {
	}

}
