/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prestamos", "root", "");
            st = conn.createStatement();
        }catch(ClassNotFoundException e){
            System.err.println("Error: " + e);
        }
    }
    public ArrayList getData(){
        ArrayList result = new ArrayList();
        try{
            String query = "select * from socios";
            rs = st.executeQuery(query);
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
            System.err.println(e.getMessage());
        }
        return result;
    }

    public String[] getBestPartner(int valor) {
        
        String[] result = new String[5];
        //HashMap<String, String> result = new HashMap();
        try{
            String query = "CALL `prestamos`.`getBestPartner`("+ valor + ")";
            rs = st.executeQuery(query);
            while(rs.next()){
                
                /*result.put("socio", rs.getString("socio"));
                result.put("CM", rs.getString("CM"));
                result.put("VF", rs.getString("VF"));
                result.put("TX", rs.getString("TX"));
                result.put("Valor_max", rs.getString("Valor_max"));*/
                
                result[0] = rs.getString("monto");
                result[1] = rs.getString("socio");
                result[2] = rs.getString("CM");
                result[3] = rs.getString("VF");
                result[4] = rs.getString("TX");
                result[5] = rs.getString("Valor_max");
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
