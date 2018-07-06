/*
 * Description: conexión a base de datos
 */
package net.test.entities;

import java.sql.*;
import java.util.*;

/**
 *
 * @author merlinh
 */
public class DBUtil {
    
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    
    public DBUtil() throws SQLException{
        try{
            //intento de creacion de la conexión
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prestamos", "root", "");
            //creacion de objeto para generar consultas
            st = conn.createStatement();
        }catch(ClassNotFoundException e){
            System.err.println("Error: " + e);
        }
    }
    public ArrayList getData(){
    //devuelve todos los elementos de la tabla socios en la bd
        ArrayList result = new ArrayList();
        try{
            //Query para obtener todos los socios de la tabla
            String query = "select * from socios";
            //Se trata de hacer la consulta
            rs = st.executeQuery(query);
            // rs tiene resultados, se establecen los parametros
            while(rs.next()){
                result.add(
                        new Persona(
                                rs.getInt("id"), 
                                rs.getString("socio"), 
                                rs.getDouble("tasa"), 
                                rs.getInt("valor_max")
                        )
                );
            }
        }catch(SQLException e){
            //Si no es posible realizar la consulta, se imprime por consola el motivo
            System.err.println(e.getMessage());
        }
        //Se devuelve el resultado
        return result;
    }

    public String[] getBestPartner(int valor) {
        //metodo que devuelve el mejor socio para el prestamo
        
        String[] result = new String[5];
        //HashMap<String, String> result = new HashMap();
        //ArrayList<Cotizacion> result = new ArrayList();
        try{
            //se llama a la rutina almacenada en la base de datos
            String query = "CALL `prestamos`.`getBestPartner`("+ valor + ")";
            rs = st.executeQuery(query);
            //Si rs tiene resultados, se establecen los parametros
            while(rs.next()){
                
                //se llena el arreglo con la info
                result[0] = rs.getString("monto");
                result[1] = rs.getString("socio");
                result[2] = rs.getString("CM");
                result[3] = rs.getString("VF");
                result[4] = rs.getString("TX");
                result[5] = rs.getString("Valor_max");
                
                /*result.put("socio", rs.getString("socio"));
                result.put("CM", rs.getString("CM"));
                result.put("VF", rs.getString("VF"));
                result.put("TX", rs.getString("TX"));
                result.put("Valor_max", rs.getString("Valor_max"));*/
                
                /*result.add(
                        new Cotizacion(
                                rs.getInt("monto"), 
                                rs.getString("socio"), 
                                rs.getDouble("CM"),
                                rs.getDouble("VF"),
                                rs.getDouble("TX"),
                                rs.getInt("Valor_max")
                        )
                );*/
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return result;
    }
}
