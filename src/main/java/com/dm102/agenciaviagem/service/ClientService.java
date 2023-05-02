package com.dm102.agenciaviagem.service;

import com.dm102.agenciaviagem.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> getClientList();
    Optional<Client> getClient(Long id);
    Client createAndUpdateClient(Client client, Long... idUpdate);
    void deleteClient(Long id);

}
