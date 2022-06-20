package io.github.otavioborgsm.service;

import io.github.otavioborgsm.domain.entity.Pedido;
import io.github.otavioborgsm.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);
}
