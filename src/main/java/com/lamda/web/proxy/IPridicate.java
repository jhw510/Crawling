package com.lamda.web.proxy;
@FunctionalInterface
public interface IPridicate<T> {
    public boolean test(T t);
}
