package com.tienda.bazar.Service;

import com.tienda.bazar.Model.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {





    public String createCliente(Cliente cliente);


    public List<Cliente> getClientes();


    public List<Cliente> getClienteParticular(Long id);


    public Cliente updateCliente(Long id, Cliente clienteActualizado);


    public String deleteCliente(Long id);












}
