package br.com.tqi.desafio.desafiotqi.repository;

import br.com.tqi.desafio.desafiotqi.repository.model.Cliente;
import br.com.tqi.desafio.desafiotqi.repository.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, String>{

    List<Emprestimo> findByCliente(Cliente cliente);
    Emprestimo findById(Long id);
}
