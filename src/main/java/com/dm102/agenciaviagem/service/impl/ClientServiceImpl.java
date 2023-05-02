package com.dm102.agenciaviagem.service.impl;

import com.dm102.agenciaviagem.entity.Address;
import com.dm102.agenciaviagem.entity.Client;
import com.dm102.agenciaviagem.entity.Contact;
import com.dm102.agenciaviagem.entity.Document;
import com.dm102.agenciaviagem.repository.AbstractBaseRepository;
import com.dm102.agenciaviagem.repository.ClientRepository;
import com.dm102.agenciaviagem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AbstractBaseRepository<Document> documentRepository;

    @Autowired
    AbstractBaseRepository<Address> addressRepository;

    @Autowired
    AbstractBaseRepository<Contact> contactRepository;

    @Override
    public List<Client> getClientList() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClient(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client createAndUpdateClient(Client client, Long... idUpdate) {
        if(!ObjectUtils.isEmpty(idUpdate)){
            if(clientRepository.findById(idUpdate[0]).isEmpty()){
                return null;
            } else {
                client.setId(idUpdate[0]);
            }
        } else {
            if(addressRepository.findById(client.getIdAddress()).isEmpty()) {
                System.out.println("Endereco com o Id: " + client.getIdAddress() + " nao encontrado!");
                return null;
            }
            if(documentRepository.findById(client.getIdDocument()).isEmpty()) {
                System.out.println("Documento com o Id: " + client.getIdDocument() + " nao encontrado!");
                return null;
            }
            if(contactRepository.findById(client.getIdContact()).isEmpty()) {
                System.out.println("Contato com o Id: " + client.getIdContact() + " nao encontrado!");
                return null;
            }
/*
            Long id = clientRepository.getLastId();
            client.setId(Objects.nonNull(id) && id > 0 ? ++id : 1);
*/
        }
        client.setName(client.getName().toUpperCase());
        client.setSurname(client.getSurname().toUpperCase());
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
