package com.dm102.agenciaviagem.repository;

import com.dm102.agenciaviagem.entity.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<TravelPackage, Long> {

}
