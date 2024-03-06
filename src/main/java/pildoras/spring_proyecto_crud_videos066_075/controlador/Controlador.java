/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildoras.spring_proyecto_crud_videos066_075.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pildoras.spring_proyecto_crud_videos066_075.dao.ClienteDAO;
import pildoras.spring_proyecto_crud_videos066_075.controlador.entity.Cliente;

/**
 *
 *
 */
@Controller
@RequestMapping("/cliente")
public class Controlador {

    @Autowired
    private ClienteDAO clienteDao;

    @RequestMapping("/lista")
    public String vListaCliente(Model miModelo) {

        //obtener los clientes desde el DAO    
        List<Cliente> losClientes = clienteDao.getClientes();

        //agregsr los clientes al modelo en modo clave valor
        miModelo.addAttribute("clientes", losClientes);

        // Agrega un mensaje adicional al modelo
        String mensaje = clienteDao.obtenerMensaje();
        miModelo.addAttribute("mensaje", mensaje);

        return "listaclientes";
    }

    @RequestMapping("/muestraFormularioAgregar")
    public String muestraFormularioAgregar(Model miModelo) {

         System.out.println("*****.muestraFormularioAgregar()");
        
        //Bind datos clientes
        Cliente miCliente = new Cliente();

        // Establecer el texto del boton del formulario según corresponda: Actualizar/Insertar
        miModelo.addAttribute("boton", "Insertar");

        //agregar el cliente al modelo
        miModelo.addAttribute("cliente", miCliente);

        return "formularioCliente";
    }

    // este método no tiene vista propia, llama al DAO para insertar registro y recarga la vista principal de lista/cliente
    @PostMapping("/insertarCliente")
    public String insertarCliente(@ModelAttribute("cliente") Cliente miCliente) {

        System.out.println("*****.insertarCliente()");

        //Insertar cliente en BBDD
        clienteDao.insertarCliente(miCliente);

        // después de hacer operaciones con la bbdd se usa redirect para que recargue la URL y vuelva a ejecutar la lógica relacionada.
        // si no se pone redirect solamente carga la vista.
        return "redirect:/cliente/lista";
    }

    // como los datos vienen por URL se usa anotatación GetMapping
    // este método recibe como parámetro con RequestParam el id. clienteId es el nombre identificativo temporal.
    // A continuación se pone que tipo de dato es (int) y el nombre del parámetro
    // Como segundo argumento del parámetro se pone el modelo para poblar el formulario con los datos a modificar
    @GetMapping("/formularioActualizar")
    public String formularioActualizar(@RequestParam("clienteId") int id, Model miModelo) {

        System.out.println("*****.formularioActualizar()");

        // Obtener el cliente
        Cliente miCliente = clienteDao.getCliente(id);

        // Establecer el cliente como atributo del modelo
        miModelo.addAttribute("cliente", miCliente);

        // Establecer el texto del boton del formulario según corresponda: Actualizar/Insertar
        miModelo.addAttribute("boton", "Actualizar");

        // Enviar al formulario
        return "formularioCliente";
    }

    @GetMapping("/eliminar")
    public String eliminarCliente(@RequestParam("clienteId") int Id) {

        // eliminar el cliente
        clienteDao.eliminarCliente(Id);

        // Redireccionar a la lista de clientes
        return "redirect:/cliente/lista";

    }

}
