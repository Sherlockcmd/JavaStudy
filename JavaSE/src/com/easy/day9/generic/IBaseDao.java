package com.easy.day9.generic;

public interface IBaseDao<T> {
          void add(T t);
          void update(T t);
}
