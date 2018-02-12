package com.rsupport.webviewer.core.common;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;


@Transactional
@RequiredArgsConstructor
public class GenericManagerImpl<T, ID extends Serializable> implements GenericManger<T, ID> {

    private final JpaRepository<T, ID> repository;

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public <S extends T> S save(S entity) {
        return this.repository.save(entity);
    }

    @Override
    public T findOne(ID var1) {
        return this.repository.findOne(var1);
    }

    @Override
    public T getOne(ID var1) {
        return this.repository.getOne(var1);
    }
}
