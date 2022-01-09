package br.com.tqi.desafio.desafiotqi.service;

import br.com.tqi.desafio.desafiotqi.controller.request.SolicitarEmprestimoRequest;
import br.com.tqi.desafio.desafiotqi.controller.response.DetalheEmprestimoResponse;
import br.com.tqi.desafio.desafiotqi.repository.EmprestimoRepository;
import br.com.tqi.desafio.desafiotqi.repository.model.Cliente;
import br.com.tqi.desafio.desafiotqi.repository.model.Emprestimo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SolicitarEmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private ClienteService clienteService;

    @Transactional
    public Emprestimo solicitarEmprestimo(SolicitarEmprestimoRequest solicitarEmprestimoRequest) {

        Cliente cliente = clienteService.validaLogin(solicitarEmprestimoRequest.getIdCliente());
        if(cliente == null)
            return null;

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataPrimeiraParcela(solicitarEmprestimoRequest.getDataPrimeiraParcela());
        emprestimo.setValorParcela(solicitarEmprestimoRequest.getValorParcela());
        emprestimo.setQtdDeParcelas(solicitarEmprestimoRequest.getQtdDeParcelas());
        emprestimo.setCliente(cliente);

        return emprestimoRepository.save(emprestimo);

    }


    public List<Emprestimo> buscaEmprestimos(Long clienteId) {
        Cliente cliente = clienteService.validaLogin(clienteId);
        if(cliente == null)
            return null;
        return emprestimoRepository.findByCliente(cliente);
    }

    public DetalheEmprestimoResponse buscaDetalheEmprestimo(Long clienteId, Long emprestimoId) {
        Cliente cliente = clienteService.validaLogin(clienteId);
        if(cliente == null)
            return null;
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId);
        if(emprestimo == null)
            return null;
        return DetalheEmprestimoResponse.toDetalheEmprestimoResponse(emprestimo, cliente);
    }
}
