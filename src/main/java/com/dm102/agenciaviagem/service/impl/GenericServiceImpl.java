package com.dm102.agenciaviagem.service.impl;

import com.dm102.agenciaviagem.entity.*;
import com.dm102.agenciaviagem.repository.*;
import com.dm102.agenciaviagem.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class GenericServiceImpl implements GenericService {

    @Autowired
    AbstractBaseRepository<PaymentType> paymentTypeRepository;

    @Autowired
    AbstractBaseRepository<Attendant> attendantRepository;

    @Autowired
    AbstractBaseRepository<TransportType> transportTypeRepository;

    @Autowired
    AbstractBaseRepository<Country> countryRepository;

    @Autowired
    AbstractBaseRepository<State> stateRepository;

    @Autowired
    AbstractBaseRepository<City> cityRepository;

    @Autowired
    AbstractBaseRepository<Address> addressRepository;

    @Autowired
    AbstractBaseRepository<Contact> contactRepository;

    @Autowired
    AbstractBaseRepository<Document> documentRepository;

    @Autowired
    CreateAndUpdateServiceImpl createAndUpdateServiceImpl;

    @Override
    public List<?> getList(String path) {
        return getObjectList(path);
    }

    @Override
    public Optional<?> getOne(String path, Long id) {
        return getObject(path,id);
    }

    @Override
    public Object createAndUpdate(String path, Object object, Long... id) {
        if(ObjectUtils.isEmpty(object)) {
            return null;
        }
        return getCreateUpdate(path, object, id);
    }

    @Override
    public void deleteOne(String path, Long id) {
        deleteObject(path,id);
    }

    private List<?> getObjectList(String path){

        return switch (path) {
            case "pais" -> countryRepository.findAll();
            case "estado" -> stateRepository.findAll();
            case "cidade" -> cityRepository.findAll();
            case "transporte" -> transportTypeRepository.findAll();
            case "pagamento" -> paymentTypeRepository.findAll();
            case "atendente" -> attendantRepository.findAll();
            case "endereco" -> addressRepository.findAll();
            case "contato" -> contactRepository.findAll();
            case "documento" -> documentRepository.findAll();
            default -> null;
        };
    }

    private Optional<?> getObject(String path, Long id){
        return switch (path) {
            case "pais" -> countryRepository.findById(id);
            case "estado" -> stateRepository.findById(id);
            case "cidade" -> cityRepository.findById(id);
            case "transporte" -> transportTypeRepository.findById(id);
            case "pagamento" -> paymentTypeRepository.findById(id);
            case "atendente" -> attendantRepository.findById(id);
            case "endereco" -> addressRepository.findById(id);
            case "contato" -> contactRepository.findById(id);
            case "documento" -> documentRepository.findById(id);
            default -> null;
        };
    }

    private void deleteObject(String path, Long id){
        switch (path) {
            case "pais" -> countryRepository.deleteById(id);
            case "estado" -> stateRepository.deleteById(id);
            case "cidade" -> cityRepository.deleteById(id);
            case "transporte" -> transportTypeRepository.deleteById(id);
            case "pagamento" -> paymentTypeRepository.deleteById(id);
            case "atendente" -> attendantRepository.deleteById(id);
            case "endereco" -> addressRepository.deleteById(id);
            case "contato" -> contactRepository.deleteById(id);
            case "documento" -> documentRepository.deleteById(id);
            default -> {
            }
        };
    }

    private Object getCreateUpdate(String path, Object object, Long... idUpdate){
        return switch (path) {
            case "pais" -> createAndUpdateServiceImpl.getCreateUpdateCountry(path, object, idUpdate);
            case "estado" -> createAndUpdateServiceImpl.getCreateUpdateState(path, object, idUpdate);
            case "cidade" -> createAndUpdateServiceImpl.getCreateUpdateCity(path, object, idUpdate);
            case "transporte" -> createAndUpdateServiceImpl.getCreateUpdateTransport(path, object, idUpdate);
            case "atendente" -> createAndUpdateServiceImpl.getCreateUpdateAttendant(path, object, idUpdate);
            case "pagamento" -> createAndUpdateServiceImpl.getCreateUpdatePayment(path, object, idUpdate);
            case "endereco" -> createAndUpdateServiceImpl.getCreateUpdateAddress(path, object, idUpdate);
            case "contato" -> createAndUpdateServiceImpl.getCreateUpdateContact(path, object, idUpdate);
            case "documento" -> createAndUpdateServiceImpl.getCreateUpdateDocument(path, object, idUpdate);
            default -> null;
        };

    }

}
