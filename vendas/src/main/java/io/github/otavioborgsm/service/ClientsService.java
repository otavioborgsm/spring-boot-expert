package io.github.otavioborgsm.service;

import io.github.otavioborgsm.model.Client;
import io.github.otavioborgsm.repositoty.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {

    private ClientsRepository repository;

    @Autowired
    public ClientsService( ClientsRepository repository) {
        this.repository = repository;
    }

    public void saveClient(Client client){
        validateClient(client);
        this.repository.save(client);
    }

    public void validateClient(Client client){
        //aplica validações
    }
}
