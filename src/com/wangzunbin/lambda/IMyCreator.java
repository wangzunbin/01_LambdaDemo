package com.wangzunbin.lambda;

import java.util.List;

//@FunctionalInterface
public interface IMyCreator<T extends List<?>> {

	T create();
}
