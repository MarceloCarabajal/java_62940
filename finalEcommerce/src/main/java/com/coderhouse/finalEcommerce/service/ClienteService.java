package com.coderhouse.finalEcommerce.service;

import com.coderhouse.finalEcommerce.dto.CompraDTO;
import com.coderhouse.finalEcommerce.entity.Cliente;
import com.coderhouse.finalEcommerce.entity.Producto;
import com.coderhouse.finalEcommerce.error.CompraException;
import com.coderhouse.finalEcommerce.repository.ClienteRepository;
import com.coderhouse.finalEcommerce.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encuentra cliente con ID: " + id));
    }

    @Transactional
    public Cliente saveCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente updateClienteById(Long id, Cliente clienteDetails){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encuentra cliente con ID: " + id));

        cliente.setNombre(clienteDetails.getNombre());
        cliente.setApellido(clienteDetails.getApellido());
        cliente.setEdad(clienteDetails.getEdad());
        cliente.setEmail(clienteDetails.getEmail());

        cliente.setProductos(clienteDetails.getProductos());

        if(clienteDetails.getDni() != 0){
            cliente.setDni(clienteDetails.getDni());
        }

        if(clienteDetails.getNumCliente() != null && !clienteDetails.getNumCliente().isEmpty()){
            cliente.setNumCliente(clienteDetails.getNumCliente());
        }

        return clienteRepository.save(cliente);
    }

    public void deleteClienteById(Long id){
        if(!clienteRepository.existsById(id)){
            throw new IllegalArgumentException("No se encuentra cliente con ID: " + id);
        }
        clienteRepository.deleteById(id);
    }

    @Transactional
    public Cliente buyProductsByCustomer(CompraDTO compraDTO) throws CompraException {
        Cliente cliente = clienteRepository.findById(compraDTO.getClienteId())
                .orElseThrow(() -> new CompraException("No se encuentra cliente con ID: " + compraDTO.getClienteId()));

        for (Long productoId : compraDTO.getProductosId()) {
            Producto producto = productoRepository.findById(productoId)
                    .orElseThrow(() -> new CompraException("No se encuentra producto con ID: " + productoId));

            cliente.getProductos().add(producto);
            producto.getClientes().add(cliente);

            productoRepository.save(producto);
        }

        return clienteRepository.save(cliente);
    }
}
