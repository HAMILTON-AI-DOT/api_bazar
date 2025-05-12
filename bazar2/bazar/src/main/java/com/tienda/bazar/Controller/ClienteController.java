package com.tienda.bazar.Controller;


import com.tienda.bazar.Model.Cliente;
import com.tienda.bazar.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;


    @PostMapping("/clientes/crear")
        public String crearCliente(@RequestBody Cliente cliente){
        clienteService.createCliente(cliente);
        return "cliente creado con exito";
    }


    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }


    @GetMapping("/clientes/traer/{id}")
    public List<Cliente> getCliente(@PathVariable Long id){
       return clienteService.getClienteParticular(id);
    }


    @DeleteMapping("/clientes/eliminar/{id}")
    public String borrarCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);
        return "Cliente eliminado";
    }


    @PutMapping("/clientes/editar/{id}")
    public Cliente actualizarCliente( @PathVariable long id, @RequestBody Cliente cliente){
        return clienteService.updateCliente(id,cliente);
    }






}
