package io.github.otavioborgsm.service;

import io.github.otavioborgsm.domain.entity.Pedido;
import io.github.otavioborgsm.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);
}
