package com.dm102.agenciaviagem.repository;

import com.dm102.agenciaviagem.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbstractBaseRepository<T extends AbstractBaseEntity> extends JpaRepository<T, Long> {

    List<Country> findByCountry(String country);

    List<State> findByState(String state);

    List<State> findByStateAndIdCountry(String state, Long idCountry);

    List<City> findByCity(String city);

    List<City> findByCityAndIdState(String city, Long idState);

    List<Attendant> findByName(String name);

    List<PaymentType> findByDescription(String payment);

    List<TransportType> findByType(String type);

}