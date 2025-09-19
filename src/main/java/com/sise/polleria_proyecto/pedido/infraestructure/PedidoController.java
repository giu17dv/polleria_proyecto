package com.sise.polleria_proyecto.pedido.infraestructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sise.polleria_proyecto.pedido.application.dto.request.InsertarPedidoRequestDto;
import com.sise.polleria_proyecto.pedido.application.dto.response.InsertarPedidoResponseDto;
import com.sise.polleria_proyecto.pedido.application.service.PedidoApplicationService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    

    @Autowired
    PedidoApplicationService pedidoApplicationService;

    @PostMapping
    public ResponseEntity<InsertarPedidoResponseDto> insertarPedido(@RequestBody InsertarPedidoRequestDto requestDto) {
        try {
            InsertarPedidoResponseDto responseDto = pedidoApplicationService.insertarPedido(requestDto);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
