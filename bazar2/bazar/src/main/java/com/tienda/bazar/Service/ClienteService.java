package com.tienda.bazar.Service;


import com.tienda.bazar.Model.Cliente;
import com.tienda.bazar.Repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {





    @Autowired
    IClienteRepository clienteRepository;



    @Override
    public String createCliente(Cliente cliente) {
       clienteRepository.save(cliente);
        return "";
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Cliente> getClienteParticular(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()){
            return List.of(clienteOptional.get());
        }else return List.of();
    }

    @Override
    public Cliente updateCliente(Long id, Cliente clienteActualizado) {

        return clienteRepository.findById(id).map(cliente -> {

            cliente.setDni(clienteActualizado.getDni());
            cliente.setNombre(clienteActualizado.getNombre());
            cliente.setApellido(clienteActualizado.getApellido());
            return clienteRepository.save(cliente);
        }).orElseThrow(() -> new RuntimeException("Cliente no encontrado") );
    }


    @Override
    public String deleteCliente(Long id) {
        clienteRepository.deleteById(id);
        return "";
    }
}
