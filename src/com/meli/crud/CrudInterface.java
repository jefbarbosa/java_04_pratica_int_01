package com.meli.crud;

import java.util.OptionalInt;

public interface CrudInterface<T> {

    void create(T t);
    void update(T t);

    void delete(String id);
    T read(String id);

    OptionalInt findId(String id);
}
