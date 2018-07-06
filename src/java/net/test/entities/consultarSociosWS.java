/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.test.entities;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author merlinh
 */
@WebService(serviceName = "consultarSociosWS")
public class consultarSociosWS {
    
    public consultarSociosWS(){
        
    }
    
    /**
     * This is a sample web service operation
     * @return 
     * @throws java.sql.SQLException
     */
    @WebMethod(operationName = "socio")
    public ArrayList socio() throws SQLException {
        return new DBUtil().getData();
    }
    
    @WebMethod(operationName = "cotizacion")
    public String[] cotizacion(@WebParam(name = "cotizacion") int monto) throws SQLException {
        return new DBUtil().getBestPartner(monto);
    }
}