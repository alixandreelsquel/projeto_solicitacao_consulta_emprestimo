package br.com.tqi.desafio.desafiotqi.controller;

import br.com.tqi.desafio.desafiotqi.controller.request.SolicitarEmprestimoRequest;
import br.com.tqi.desafio.desafiotqi.controller.response.DetalheEmprestimoResponse;
import br.com.tqi.desafio.desafiotqi.controller.response.SolicitarEmprestimoResponse;
import br.com.tqi.desafio.desafiotqi.repository.model.Emprestimo;
import br.com.tqi.desafio.desafiotqi.service.SolicitarEmprestimoService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value = "/emprestimo")
public class SolicitarEmprestimoController {


        @Autowired
        private SolicitarEmprestimoService solicitarEmprestimoService;

        @PostMapping
        public ResponseEntity<SolicitarEmprestimoResponse> solicitarEmprestimo(@RequestBody SolicitarEmprestimoRequest solicitarEmprestimoRequest) throws ParseException {
            Integer qtdDeParcela = validaQtdDeParcela(solicitarEmprestimoRequest.getQtdDeParcelas());
            if(qtdDeParcela == null)
                return new ResponseEntity(null, BAD_REQUEST);

            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
            DateTime dt = formatter.parseDateTime(solicitarEmprestimoRequest.getDataPrimeiraParcela());
            DateTime dataDaPrimeiraParcela = validaDataDaPrimeiraParcela(dt);
            if(dataDaPrimeiraParcela == null)
                return new ResponseEntity(null, BAD_REQUEST);


            Emprestimo response = solicitarEmprestimoService.solicitarEmprestimo(solicitarEmprestimoRequest);
            if(response == null)
                return new ResponseEntity(null, UNAUTHORIZED);
            return new ResponseEntity(SolicitarEmprestimoResponse.toSolicitarEmprestimoResponse(response), OK);
        }


        @GetMapping("/{clienteId}")
        public ResponseEntity<List<SolicitarEmprestimoResponse>> buscaEmprestimos(@PathVariable("clienteId") Long clienteId) {
            List<Emprestimo> emprestimos = solicitarEmprestimoService.buscaEmprestimos(clienteId);
            return new ResponseEntity(emprestimos, OK);

        }

        @GetMapping("/{clienteId}/detalhe/{emprestimoId}")
        public ResponseEntity<SolicitarEmprestimoResponse> buscaDetalheEmprestimo(@PathVariable("emprestimoId") Long emprestimoId, @PathVariable("clienteId") Long clienteId) {
            DetalheEmprestimoResponse detalheEmprestimoResponse = solicitarEmprestimoService.buscaDetalheEmprestimo(clienteId, emprestimoId);
            if(detalheEmprestimoResponse == null)
                return new ResponseEntity(null, NOT_FOUND);
            return new ResponseEntity(detalheEmprestimoResponse, OK);

    }

        private Integer validaQtdDeParcela(int qtdDeParcelas){

            if(qtdDeParcelas <= 60)
                return qtdDeParcelas;
            else
                return null;
        }
        private DateTime validaDataDaPrimeiraParcela(DateTime dataDoEmprestimo){

            DateTime dataAtual = new DateTime();
            dataAtual = dataAtual.plusMonths(3);
            if(dataDoEmprestimo.isAfter(dataAtual))
                return null;
            return dataDoEmprestimo;
        }
}
