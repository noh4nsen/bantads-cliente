package com.bantads.cliente.bantadscliente.controller;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bantads.cliente.bantadscliente.DTOs.ClientePutDTO;
import com.bantads.cliente.bantadscliente.DTOs.ClienteResponseDTO;
import com.bantads.cliente.bantadscliente.data.ClienteRepository;
import com.bantads.cliente.bantadscliente.model.Cliente;
import com.bantads.cliente.bantadscliente.model.Endereco;

@CrossOrigin
@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") UUID id, @RequestBody ClientePutDTO clientePutDTO) {
        try {
            Optional<Cliente> clienteOp = clienteRepository.findById(id);
            if (clienteOp.isPresent()) {
                Cliente cliente = clienteOp.get();

                cliente.setNome(clientePutDTO.getNome());
                cliente.setSalario(clientePutDTO.getSalario());
                cliente.getEndereco().setCep(clientePutDTO.getEndereco().getCep());
                cliente.getEndereco().setLogradouro(clientePutDTO.getEndereco().getLogradouro());
                cliente.getEndereco().setNumero(clientePutDTO.getEndereco().getNumero());
                cliente.getEndereco().setComplemento(clientePutDTO.getEndereco().getComplemento());
                cliente.getEndereco().setBairro(clientePutDTO.getEndereco().getBairro());
                cliente.getEndereco().setCidade(clientePutDTO.getEndereco().getCidade());
                cliente.getEndereco().setEstado(clientePutDTO.getEndereco().getEstado());

                clienteRepository.save(cliente);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> getCliente(@PathVariable UUID id) {
        try {
            Optional<Cliente> clienteOp = clienteRepository.findById(id);

            if (clienteOp.isPresent()) {
                Cliente cliente = clienteOp.get();
                ClienteResponseDTO ClienteResponseDTO = mapper.map(cliente, ClienteResponseDTO.class);
                return ResponseEntity.ok(ClienteResponseDTO);
            } else {
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/por-cpf/{cpf}")
    public ResponseEntity<ClienteResponseDTO> getClientePorIdUsuario(@PathVariable String cpf) {
        try {
            Optional<Cliente> clienteOp = clienteRepository.findByCpf(cpf);

            if (clienteOp.isPresent()) {
                Cliente cliente = clienteOp.get();
                ClienteResponseDTO ClienteResponseDTO = mapper.map(cliente, ClienteResponseDTO.class);
                return ResponseEntity.ok(ClienteResponseDTO);
            } else {
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/por-usuario/{idExternoUsuario}")
    public ResponseEntity<ClienteResponseDTO> getClientePorIdUsuario(@PathVariable UUID idExternoUsuario) {
        try {
            Optional<Cliente> clienteOp = clienteRepository.findByIdExternoUsuario(idExternoUsuario);

            if (clienteOp.isPresent()) {
                Cliente cliente = clienteOp.get();
                ClienteResponseDTO ClienteResponseDTO = mapper.map(cliente, ClienteResponseDTO.class);
                return ResponseEntity.ok(ClienteResponseDTO);
            } else {
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/health")
    public String health() {
        return "ʕ·͡ᴥ·ʔ";
    }
}
