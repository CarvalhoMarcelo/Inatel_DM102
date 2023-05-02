package com.dm102.agenciaviagem.service.impl;

import com.dm102.agenciaviagem.entity.*;
import com.dm102.agenciaviagem.repository.AbstractBaseRepository;
import com.dm102.agenciaviagem.repository.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CreateAndUpdateServiceImpl {

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

    AbstractBaseRepository<Contact> contactRepository;

    @Autowired
    AbstractBaseRepository<Document> documentRepository;

    @Autowired
    ClientRepository clientRepository;

    public Object getCreateUpdateCountry(String path, Object object, Long... idUpdate){
        ObjectMapper mapper = new ObjectMapper();
        Country country = mapper.convertValue(object, Country.class);
        if(!ObjectUtils.isEmpty(idUpdate)){
            if(countryRepository.findById(idUpdate[0]).isEmpty()){
                return null;
            } else {
                country.setId(idUpdate[0]);
            }
        } else {
            if(countryRepository.findByCountry(country.getCountry().toUpperCase()).size() > 0){
                return null;
            }
        }
        country.setCountry(country.getCountry().toUpperCase());
        country.setContinent(country.getContinent().toUpperCase());
        return countryRepository.save(country);
    }

    public Object getCreateUpdateState(String path, Object object, Long... idUpdate){
        ObjectMapper mapper = new ObjectMapper();
        State state = mapper.convertValue(object, State.class);
        if(!ObjectUtils.isEmpty(idUpdate)){
            if(stateRepository.findById(idUpdate[0]).isEmpty()){
                return null;
            } else {
                state.setId(idUpdate[0]);
            }
        } else {
            if(countryRepository.findById(state.getIdCountry()).isEmpty() ||
                    stateRepository.findByStateAndIdCountry(state.getState().toUpperCase(), state.getIdCountry()).size() > 0){
                return null;
            }
        }
        state.setState(state.getState().toUpperCase());
        return stateRepository.save(state);
    }

    public Object getCreateUpdateCity(String path, Object object, Long... idUpdate){
        ObjectMapper mapper = new ObjectMapper();
        City city = mapper.convertValue(object, City.class);
        if(!ObjectUtils.isEmpty(idUpdate)){
            if(cityRepository.findById(idUpdate[0]).isEmpty()){
                return null;
            } else {
                city.setId(idUpdate[0]);
            }
        } else {
            if(stateRepository.findById(city.getIdState()).isEmpty() ||
                    cityRepository.findByCityAndIdState(city.getCity().toUpperCase(), city.getIdState()).size() > 0){
                return null;
            }
        }
        city.setCity(city.getCity().toUpperCase());
        return cityRepository.save(city);
    }

    public Object getCreateUpdateTransport(String path, Object object, Long... idUpdate){
        ObjectMapper mapper = new ObjectMapper();
        TransportType transportType = mapper.convertValue(object, TransportType.class);
        if (!ObjectUtils.isEmpty(idUpdate)) {
            if (transportTypeRepository.findById(idUpdate[0]).isEmpty()) {
                return null;
            } else {
                transportType.setId(idUpdate[0]);
            }
        } else {
            if (transportTypeRepository.findByType(transportType.getType().toUpperCase()).size() > 0) {
                return null;
            }
        }
        transportType.setType(transportType.getType().toUpperCase());
        transportType.setClassType(transportType.getClassType().toUpperCase());
        return transportTypeRepository.save(transportType);
    }

    public Object getCreateUpdateAttendant(String path, Object object, Long... idUpdate){
        ObjectMapper mapper = new ObjectMapper();
        Attendant attendant = mapper.convertValue(object, Attendant.class);
        if (!ObjectUtils.isEmpty(idUpdate)) {
            if (attendantRepository.findById(idUpdate[0]).isEmpty()) {
                return null;
            } else {
                attendant.setId(idUpdate[0]);
            }
        } else {
            if (attendantRepository.findByName(attendant.getName().toUpperCase()).size() > 0) {
                return null;
            }
        }
        attendant.setName(attendant.getName().toUpperCase());
        attendant.setSurname(attendant.getSurname().toUpperCase());
        return attendantRepository.save(attendant);
    }

    public Object getCreateUpdatePayment(String path, Object object, Long... idUpdate){
        ObjectMapper mapper = new ObjectMapper();
        PaymentType paymentType = mapper.convertValue(object, PaymentType.class);
        if (!ObjectUtils.isEmpty(idUpdate)) {
            if (paymentTypeRepository.findById(idUpdate[0]).isEmpty()) {
                return null;
            } else {
                paymentType.setId(idUpdate[0]);
            }
        } else {
            if (paymentTypeRepository.findByDescription(paymentType.getDescription().toUpperCase()).size() > 0) {
                return null;
            }
        }
        paymentType.setDescription(paymentType.getDescription().toUpperCase());
        return paymentTypeRepository.save(paymentType);
    }

    public Object getCreateUpdateAddress(String path, Object object, Long... idUpdate){
        ObjectMapper mapper = new ObjectMapper();
        Address address = mapper.convertValue(object, Address.class);
        if(!ObjectUtils.isEmpty(idUpdate)){
            if(addressRepository.findById(idUpdate[0]).isEmpty()){
                return null;
            } else {
                address.setId(idUpdate[0]);
            }
        } else {
            if(countryRepository.findById(address.getIdCountry()).isEmpty() ||
               stateRepository.findById(address.getIdState()).isEmpty() ||
               cityRepository.findById(address.getIdCity()).isEmpty()) {
                return null;
            }
        }
        address.setTypeOfStreet(address.getTypeOfStreet().toUpperCase());
        address.setAddress(address.getAddress().toUpperCase());
        address.setNumber(address.getNumber().toUpperCase());
        address.setPostalCode(address.getPostalCode().toUpperCase());
        return addressRepository.save(address);
    }


    public Object getCreateUpdateContact(String path, Object object, Long... idUpdate){
        ObjectMapper mapper = new ObjectMapper();
        Contact contact = mapper.convertValue(object, Contact.class);
        if(!ObjectUtils.isEmpty(idUpdate)){
            if(contactRepository.findById(idUpdate[0]).isEmpty()){
                return null;
            } else {
                contact.setId(idUpdate[0]);
            }
        } else {
            if(clientRepository.findById(contact.getIdClient()).isEmpty()) {
                return null;
            }
        }
        contact.setEmail(contact.getEmail().toUpperCase());
        return contactRepository.save(contact);
    }

    public Object getCreateUpdateDocument(String path, Object object, Long... idUpdate){
        ObjectMapper mapper = new ObjectMapper();
        Document document = mapper.convertValue(object, Document.class);
        if(!ObjectUtils.isEmpty(idUpdate)){
            if(documentRepository.findById(idUpdate[0]).isEmpty()){
                return null;
            } else {
                document.setId(idUpdate[0]);
            }
        } else {
            if(clientRepository.findById(document.getIdClient()).isEmpty()) {
                return null;
            }
        }
        document.setRg(document.getRg().toUpperCase());
        document.setPassaport(document.getPassaport().toUpperCase());
        return documentRepository.save(document);
    }



}
