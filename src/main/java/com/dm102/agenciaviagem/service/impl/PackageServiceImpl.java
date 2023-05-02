package com.dm102.agenciaviagem.service.impl;

import com.dm102.agenciaviagem.entity.*;
import com.dm102.agenciaviagem.repository.AbstractBaseRepository;
import com.dm102.agenciaviagem.repository.ClientRepository;
import com.dm102.agenciaviagem.repository.ItineraryRepository;
import com.dm102.agenciaviagem.repository.PackageRepository;
import com.dm102.agenciaviagem.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class PackageServiceImpl implements PackageService {


    @Autowired
    PackageRepository packageRepository;

    @Autowired
    ItineraryRepository itineraryRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AbstractBaseRepository<PaymentType> paymentTypeRepository;

    @Autowired
    AbstractBaseRepository<Attendant> attendantRepository;


    @Override
    public List<TravelPackage> getPackageList() {
        return packageRepository.findAll();
    }

    @Override
    public Optional<TravelPackage> getPackage(Long id) {
        return packageRepository.findById(id);
    }

    @Override
    public TravelPackage createAndUpdatePackage(TravelPackage travelPackage, Long... idUpdate) {
        if(!ObjectUtils.isEmpty(idUpdate)){
            if(packageRepository.findById(idUpdate[0]).isEmpty()){
                return null;
            } else {
                travelPackage.setId(idUpdate[0]);
            }
        } else {
            if(attendantRepository.findById(travelPackage.getIdAttendant()).isEmpty()) {
                System.out.println("Atendente com o Id: " + travelPackage.getIdAttendant() + " nao encontrado!");
                return null;
            }
            if(clientRepository.findById(travelPackage.getIdClient()).isEmpty()) {
                System.out.println("Cliente com o Id: " + travelPackage.getIdClient() + " nao encontrado!");
                return null;
            }
            if(itineraryRepository.findById(travelPackage.getIdItinerary()).isEmpty()) {
                System.out.println("Roteiro com o Id: " + travelPackage.getIdItinerary() + " nao encontrado!");
                return null;
            }
            if(paymentTypeRepository.findById(travelPackage.getIdPayment()).isEmpty()) {
                System.out.println("Pagamento com o Id: " + travelPackage.getIdPayment() + " nao encontrado!");
                return null;
            }
        }
        return packageRepository.save(travelPackage);
    }

    @Override
    public void deletePackage(Long id) {
        packageRepository.deleteById(id);
    }
}
