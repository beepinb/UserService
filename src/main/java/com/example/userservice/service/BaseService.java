package com.example.userservice.service;

import java.util.List;

public interface BaseService <S,T>{

    public List<S> findAll();  //
    public S findById(Long id);//
    public void add(S s); //
    public void update(S s); //
    public void delete(Long id);  //
}
