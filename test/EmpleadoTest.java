/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Buddi
 */
public class EmpleadoTest {
    
    public EmpleadoTest() {
    }
    
    
    /**
     * Test of crear method, of class Empleado.
     * @throws java.lang.Exception
     */
    @Test
    public void testCrear() throws Exception {
        System.out.println("crear registro");
        Empleado instance = new Empleado("Camilo","Perez","cperezzo@ucentral.edu.co","3012338880",true,"300000","Asistente");
        instance.crear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leer method, of class Empleado.
     * @throws java.lang.Exception
     */
    @Test
    public void testLeer() throws Exception {
        System.out.println("consultarRegistros");
        try {
            ArrayList<Empleado> empleado = Empleado.leer();
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }
    
    }

    /**
     * Test of modificarRegistro method, of class Empleado.
     */
    @Test
    public void testModificarRegistro() {
        System.out.println("modificarRegistro");

        try {
            ArrayList<Empleado> result = Empleado.leer();
            Empleado e = result.get(0);
            long id = e.getId();
            String nombre = e.getNombre() + "test";
            String apellido = e.getApellido() + "test";
            String correo = e.getCorreo() + "test";
            String celular = e.getCelular() + "1111";
            Boolean esProveedor = e.isEsProveedor();
            String salario = e.getSalario() + "10";
            String cargo = e.getCargo() + "test";
            
            Empleado.modificarRegistro(e);
        } catch (ClassNotFoundException | SQLException e) {
            fail("The test case is a prototype.");
        }

    }

    /**
     * Test of eliminarRegistro method, of class Empleado.
     */
    @Test
    public void testEliminarRegistro() {
        System.out.println("eliminarRegistro");
        try {
            ArrayList<Empleado> result = Empleado.leer();
            Empleado e = result.get(0);
            long id = e.getId();
            Empleado.eliminarRegistro(id);
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }

    }
}

   