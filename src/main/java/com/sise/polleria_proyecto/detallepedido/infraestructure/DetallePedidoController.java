package com.sise.polleria_proyecto.detallepedido.infraestructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import com.sise.polleria_proyecto.detallepedido.application.dto.request.InsertarDetallePedidoRequestDto;
import com.sise.polleria_proyecto.detallepedido.application.dto.response.InsertarDetallePedidoResponseDto;
import com.sise.polleria_proyecto.detallepedido.application.service.DetallePedidoApplicationService;



@RestController
@RequestMapping("/detallepedido")
public class DetallePedidoController {
    

    @Autowired
    DetallePedidoApplicationService detallePedidoApplicationService;

    @PostMapping
    public ResponseEntity<InsertarDetallePedidoResponseDto> insertarDetallePedido(@RequestBody InsertarDetallePedidoRequestDto requestDto) {
        try {
            InsertarDetallePedidoResponseDto responseDto = detallePedidoApplicationService.insertarDetallePedido(requestDto);
            return  ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
