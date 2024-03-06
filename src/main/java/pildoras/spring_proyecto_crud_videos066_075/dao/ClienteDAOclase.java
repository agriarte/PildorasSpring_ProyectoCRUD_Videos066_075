/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildoras.spring_proyecto_crud_videos066_075.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pildoras.spring_proyecto_crud_videos066_075.controlador.entity.Cliente;

/**
 *
 * DAO significa "Data Access Object". El patrón DAO es un patrón de diseño que
 * proporciona una interfaz abstracta para algún tipo de fuente de datos, como
 * una base de datos o algún otro mecanismo de almacenamiento de datos. El
 * propósito principal del patrón DAO es aislar el código de acceso a datos de
 * la lógica empresarial, proporcionando una capa de abstracción entre la
 * aplicación y la fuente de datos. En el caso específico de Hibernate, un DAO
 * se utiliza para encapsular la lógica de acceso a datos y proporcionar
 * operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los objetos que
 * están mapeados a las tablas de la base de datos mediante el framework
 * Hibernate.
 *
 */
// esta anotacion hace que reconozca la clase como un bean
@Repository
public class ClienteDAOclase implements ClienteDAO {

    // tiene que llamarse exactamente igual a como está definido en el archivo de config servlet
    //<!--  Configuración Hibernate session factory --> <bean id="sessionFactory" ...   
    //autowired hace inyección de dependencias mágica
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional // anotacion que nos ahorra tener que hacer el begin y el commit
    public List<Cliente> getClientes() {
        // Obtener la sesión
        Session miSession = sessionFactory.getCurrentSession();
        // Crear la consulta "Query"
        Query<Cliente> miQuery = miSession.createQuery("FROM Cliente", Cliente.class);
        // Ejecutar la query y devolver resultados
        List<Cliente> clientes = miQuery.getResultList();
        return clientes;
    }

    // Método adicional para obtener un String
    @Override
    public String obtenerMensaje() {
        String mensaje = "Esto es un String declarado en ClienteDAOclase.java (texto desde el DAO)";
        return mensaje;
    }

    @Override
    @Transactional
    public void insertarCliente(Cliente miCliente) {
        // Obtener la sesión
        Session miSession = sessionFactory.getCurrentSession();
        // Insertar o actualizar cliente
        miSession.saveOrUpdate(miCliente);

    }

    @Override
    @Transactional
    public Cliente getCliente(int id) {
       
        //Obtener la sesión
        Session miSession = sessionFactory.getCurrentSession();

        //Obtener la información del cliente seleccionado
        Cliente miCliente = miSession.get(Cliente.class, id);

        return miCliente;
    }

    @Override
    @Transactional
    public void eliminarCliente(int id) {
        // TODO Auto-generated method stub

        //Obtener la sesión
        Session miSession = sessionFactory.getCurrentSession();

        // Borrar el cliente de la BBDD utilizandocomo criterio su Id correspondiente
        Query consulta = miSession.createQuery("delete from Cliente where id=:IdDelCliente");

        consulta.setParameter("IdDelCliente", id);

        consulta.executeUpdate();

    }

   

}
