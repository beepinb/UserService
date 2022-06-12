package com.example.userservice.service;

import java.util.List;

public interface BaseService <S,T,R>{

    public List<S> findAll();  //
    public S findById(Long id);//
    public void add(T s); //
    public void update(T s); //
    public void delete(Long id);  //
}
