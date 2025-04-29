package com.katchau.api.resources;

import com.katchau.api.dtos.PedidoDTO;
import com.katchau.api.models.Pedido;
import com.katchau.api.services.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

    private final PedidoService pedidoService;

    public PedidoResource(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarTodos() {
        List<Pedido> pedidos = pedidoService.listarTodos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> buscarPorId(@PathVariable Long id) {
        PedidoDTO pedido = pedidoService.buscarPorId(id);
        return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<Pedido> criar(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoService.create(pedido);
        return ResponseEntity.ok(novoPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> atualizar(@PathVariable Long id, @RequestBody Pedido pedido) {
        PedidoDTO pedidoAtualizado = pedidoService.atualizar(id, pedido);
        return ResponseEntity.ok(pedidoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pedidoService.deletar(id);//a
        return ResponseEntity.noContent().build();
    }
}