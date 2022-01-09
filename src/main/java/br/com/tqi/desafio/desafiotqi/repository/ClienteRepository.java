package br.com.tqi.desafio.desafiotqi.repository;

import br.com.tqi.desafio.desafiotqi.repository.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    Cliente findById (Long id);
    Cliente findByEmailAndSenha(String email, String senha);

}
