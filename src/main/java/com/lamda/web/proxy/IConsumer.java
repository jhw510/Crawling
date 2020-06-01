package com.lamda.web.proxy;

import java.util.function.Consumer;
import java.util.function.Predicate;

@FunctionalInterface
public interface IConsumer<T> {
    public void accept (T t);


}
