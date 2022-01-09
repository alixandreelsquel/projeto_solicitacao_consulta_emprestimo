package br.com.tqi.desafio.desafiotqi.controller;


import br.com.tqi.desafio.desafiotqi.controller.request.CadastroClienteRequest;
import br.com.tqi.desafio.desafiotqi.controller.request.LoginRequest;
import br.com.tqi.desafio.desafiotqi.controller.response.CadastroClienteResponse;
import br.com.tqi.desafio.desafiotqi.repository.model.Cliente;
import br.com.tqi.desafio.desafiotqi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<CadastroClienteResponse> cadastraUsuario(@RequestBody CadastroClienteRequest cadastroClienteRequest){
        Cliente response = clienteService.cadastraCliente(cadastroClienteRequest);
        return new ResponseEntity(CadastroClienteResponse.toCadastroClienteResponse(response), OK);

    }

    @PostMapping(value = "/login")

    public ResponseEntity<CadastroClienteResponse> login(@RequestBody LoginRequest loginRequest){
        Cliente response = clienteService.login(loginRequest);
        if (response == null)
            return new ResponseEntity(null, NOT_FOUND);
        else
            return new ResponseEntity(CadastroClienteResponse.toCadastroClienteResponse(response), OK);

    }
}
