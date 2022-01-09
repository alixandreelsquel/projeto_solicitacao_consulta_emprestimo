package br.com.tqi.desafio.desafiotqi.service;

import br.com.tqi.desafio.desafiotqi.controller.request.CadastroClienteRequest;
import br.com.tqi.desafio.desafiotqi.controller.request.LoginRequest;
import br.com.tqi.desafio.desafiotqi.repository.ClienteRepository;
import br.com.tqi.desafio.desafiotqi.repository.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastraCliente(CadastroClienteRequest cadastraClienteRequest){
        Cliente cliente = new Cliente();

        cliente.setNome(cadastraClienteRequest.getNome());
        cliente.setEmail(cadastraClienteRequest.getEmail());
        cliente.setCpf(cadastraClienteRequest.getCpf());
        cliente.setRg(cadastraClienteRequest.getRg());
        cliente.setEndereco(cadastraClienteRequest.getEndereco());
        cliente.setRenda(cadastraClienteRequest.getRenda());
        cliente.setSenha(cadastraClienteRequest.getSenha());

       return clienteRepository.save(cliente);

    }

    public Cliente login(LoginRequest loginRequest){
        Cliente cliente = clienteRepository.findByEmailAndSenha(loginRequest.getEmail(), loginRequest.getSenha());
        if(cliente == null)
            return null;
        cliente.setLogged(true);
        cliente = clienteRepository.save(cliente);

        return cliente;
    }

    public Cliente validaLogin(Long idCliente){
        Cliente cliente = clienteRepository.findById(idCliente);
        if(cliente != null){
            if(cliente.getLogged())
                return cliente;
            else return null;
        } else return null;


    }
}
