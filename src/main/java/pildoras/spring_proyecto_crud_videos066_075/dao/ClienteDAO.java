package pildoras.spring_proyecto_crud_videos066_075.dao;

import java.util.List;
import pildoras.spring_proyecto_crud_videos066_075.controlador.entity.Cliente;

/**
 *
 */
public interface ClienteDAO {
    public List<Cliente> getClientes();

    public String obtenerMensaje();

    public void insertarCliente(Cliente miCliente);

    public Cliente getCliente(int clienteId);
    
    public void eliminarCliente(int id);
    
}
