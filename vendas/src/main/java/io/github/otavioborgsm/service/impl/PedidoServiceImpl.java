package io.github.otavioborgsm.service.impl;

import io.github.otavioborgsm.domain.repository.Pedidos;
import io.github.otavioborgsm.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repositpry;

    public PedidoServiceImpl(Pedidos repositpry) {
        this.repositpry = repositpry;
    }
}
