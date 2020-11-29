
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class Empleado {
    
    
    private long id;
    private String nombre, apellido, correo, celular;
    private boolean esProveedor;
    private String salario;
    private String cargo;

    public Empleado() {
    }

    public Empleado(long id, String nombre, String apellido, String correo, String celular, boolean esProveedor, String salario, String cargo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.esProveedor = esProveedor;
        this.salario = salario;
        this.cargo = cargo;
    }

    public Empleado(String nombre, String apellido, String correo, String celular, boolean esProveedor, String salario, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.esProveedor = esProveedor;
        this.salario = salario;
        this.cargo = cargo;
    }
    
    
    
    

    public Empleado(String nombre, String correo, String celular, String salario) {
        
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.salario = salario;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean isEsProveedor() {
        return esProveedor;
    }

    public void setEsProveedor(boolean esProveedor) {
        this.esProveedor = esProveedor;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
   
    

    public void crear() throws ClassNotFoundException, SQLException{
        Conexion.conectar();
        String sql = "INSERT INTO Empleado ( nombre,apellido,correo,celular,esProveedor,salario,cargo) "
                + " VALUES (?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement psm = Conexion.getConexion().prepareStatement(sql);
   
            psm.setString(1, this.nombre);
            psm.setString(2, this.apellido);
            psm.setString(3, this.correo);
            psm.setString(4, this.celular);
            psm.setBoolean(5, this.esProveedor);
            psm.setString(6, this.salario);
            psm.setString(7, this.cargo);
            psm.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         Conexion.cerrarConexion();
      
      }
    public static ArrayList<Empleado> leer() throws ClassNotFoundException, SQLException {
        
        String sql= "SELECT * FROM Empleado";
        ArrayList<Empleado> listaEmpleado = new ArrayList<>();
        ResultSet rs;
        try {
            //Prepara la sentencia SQL a ejecutar
            Conexion.conectar();
            PreparedStatement sp = Conexion.getConexion().prepareStatement(sql);
            
            //Ejecuata la sentencia y retorna los datos
            rs = sp.executeQuery();
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt("id"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setCorreo(rs.getString("correo"));
                empleado.setCelular(rs.getString("celular"));
                empleado.setEsProveedor(rs.getBoolean("esProveedor"));
                empleado.setSalario(rs.getString("salario"));
                empleado.setCargo(rs.getString("cargo"));
                listaEmpleado.add(empleado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        Conexion.cerrarConexion();
        
     
        return listaEmpleado;
    }
    public static void modificarRegistro(Empleado empleado){
        String sql= "UPDATE Empleado SET apellido = ?, correo = ?,celular = ?,esProveedor = ?,salario = ?,cargo =  ? WHERE nombre = ? ";
        Conexion.conectar();
        
        try {
            PreparedStatement psm = Conexion.getConexion().prepareStatement(sql);
   
            psm.setString(7, empleado.getNombre());
            psm.setString(1, empleado.getApellido());
            psm.setString(2, empleado.getCorreo());
            psm.setString(3, empleado.getCelular());
            psm.setBoolean(4, empleado.isEsProveedor());
            psm.setString(5, empleado.getSalario());
            psm.setString(6, empleado.getCargo());
            psm.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         Conexion.cerrarConexion(); 
        
        
    }
        public static void eliminarRegistro(long id){
        
        Conexion.conectar();
        
        try {
            Conexion.getConexion().createStatement().execute(""
                    + "delete from Empleado where id="+id+";");
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        Conexion.cerrarConexion();   
        
        }
        
        public static Empleado obtenerRegistrosById(long id) {
        
        Empleado empleado = null;
        
        Conexion.conectar();
        
        try {
            ResultSet rs = Conexion.getConexion().createStatement().executeQuery(""
                    + "select * from Empleado where id="+id+";");
            
            String nombre = rs.getString(2);
            String apellido = rs.getString(3);
            String correo = rs.getString(4);
            String celular = rs.getString(5);
            boolean esProveedor = Boolean.parseBoolean(rs.getString(6).equals("0") ? "false" : "true");
            String salario = rs.getString(7);
            String cargo = rs.getString(8);
            empleado = new Empleado(id,nombre,apellido,correo,celular,esProveedor,salario,cargo);

        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        Conexion.cerrarConexion();   
        
        return empleado;
    }
    
        public static void eliminarTodo(){
        
        Conexion.conectar();
        
        try {
            Conexion.getConexion().createStatement().execute(""
                    + "delete from Empleado");
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        Conexion.cerrarConexion();   
        
        }
    
}
        

    
    
       


