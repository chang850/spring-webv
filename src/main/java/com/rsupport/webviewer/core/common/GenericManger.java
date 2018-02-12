package com.rsupport.webviewer.core.common;

import java.io.Serializable;

public interface GenericManger<T, ID extends Serializable> {
    <S extends T> S save(S entity);
    T findOne(ID var1);
    T getOne(ID var1);
}
