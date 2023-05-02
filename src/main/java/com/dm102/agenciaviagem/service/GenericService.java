package com.dm102.agenciaviagem.service;


import java.util.List;
import java.util.Optional;

public interface GenericService {

    List<?> getList(String path);
    Optional<?> getOne(String path, Long id);
    Object createAndUpdate(String path, Object object, Long... id);
    void deleteOne(String path, Long id);

}
