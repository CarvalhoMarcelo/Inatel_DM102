package com.dm102.agenciaviagem.service;

import com.dm102.agenciaviagem.entity.TravelPackage;

import java.util.List;
import java.util.Optional;

public interface PackageService {

    List<TravelPackage> getPackageList();
    Optional<TravelPackage> getPackage(Long id);
    TravelPackage createAndUpdatePackage(TravelPackage travelPackage, Long... idUpdate);
    void deletePackage(Long id);

}
