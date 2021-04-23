/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import BACKEND.clsReservacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import BACKEND.clsVuelos;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author geovanni
 */
public class clsQuerys {
    public int fncLogin(String pUsuario, String pPass){
        int Resp = 0;
        try{
            Statement sql = clsConexion.getConexion().createStatement();
            //System.out.println(sql);
            String Query = "SELECT Usuario FROM TB_PERSONA WHERE Usuario = '" +  pUsuario 
                    + "'AND Pass = '" + pPass + "';";
            //System.out.println(Query);
            ResultSet resultado = sql.executeQuery(Query);
            if(resultado!=null && resultado.next()){
                Resp = 1;
                System.out.println("Tiene Resultados.");
                
            }else{
                System.out.println("El usuario o contraseña no son correctos.");
            }
 
        }catch(SQLException Ex){
            //System.out.println("No hay conexion");
            System.out.println(Ex.getMessage());
            
        }

        return Resp;
    }  
    public int fncIngresoVuelo( clsVuelos objVuelos  ){
        int retorno=0; 
        try{
            Connection Con = clsConexion.getConexion();
            String consulta = "INSERT INTO TB_VUELO(Origen,Destino,Fecha,HoraSalida,HoraLlegada,TipoAvion,Estatus) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement P = Con.prepareStatement(consulta);
            P.setString(1, objVuelos.getOrigen());
            P.setString(2, objVuelos.getDestino());
            P.setString(3, objVuelos.getFecha());   
            P.setString(4, objVuelos.getHoraSalida());
            P.setString(5, objVuelos.getHoraLlegada());
            P.setString(6, objVuelos.getTipoAvion());
            P.setString(7, objVuelos.getEstatus());  
            P.executeUpdate();
            retorno = 1;
            
        }catch(SQLException Ex){
            System.out.println(Ex.getMessage());
        }
        return retorno;
    }
    public ResultSet fncConsultaVuelos(int pId){
        ResultSet rs = null;
        try{
            Connection Con = clsConexion.getConexion();  //CONEXION
            String consulta = "SELECT Id, Origen, Destino, Fecha, HoraSalida, HoraLlegada, TipoAvion, Estatus FROM TB_VUELO";
            if(pId != 0){
                consulta = consulta + " WHERE Id =" + pId;
            }
            PreparedStatement ps = Con.prepareStatement(consulta);
            rs = ps.executeQuery();
            
            
        }catch(SQLException Ex){
            System.out.println(Ex.getMessage());
        } 
        
        
        return rs;
    }
    public int fncModificaCliente( clsVuelos objVuelos){
        int Resp=0; // 0 no se ingreso.
        try{
            Connection Con = clsConexion.getConexion();  //CONEXION A BD
            String consulta = "UPDATE TB_VUELO SET Origen = ?, Destino = ?, Fecha = ?, HoraSalida = ?, HoraLlegada = ?, TipoAvion = ?, Estatus = ? WHERE Id = ?";
            PreparedStatement P = Con.prepareStatement(consulta);
            P.setString(1, objVuelos.getOrigen());
            P.setString(2, objVuelos.getDestino());
            P.setString(3, objVuelos.getFecha());   
            P.setString(4, objVuelos.getHoraSalida());
            P.setString(5, objVuelos.getHoraLlegada());
            P.setString(6, objVuelos.getTipoAvion());
            P.setString(7, objVuelos.getEstatus());
            P.setInt(8, objVuelos.getId());
            P.executeUpdate(); //EJECUTA LA SENTENCIA EN LA BASE DE DATOS
            Resp = 1;
            
        }catch(SQLException Ex){
            System.out.println(Ex.getMessage());
        }
        return Resp;
    }
    public int fncEliminaVuelo(int vId){
        int Resp=0; // 0 no se ingreso.
        try{
            Connection Con = clsConexion.getConexion();  //CONEXION A BD
            String consulta = "DELETE FROM TB_VUELO WHERE Id = " + vId;
            PreparedStatement ps = Con.prepareStatement(consulta);
            ps.executeUpdate(); //EJECUTA LA SENTENCIA EN LA BASE DE DATOS
            Resp = 1;
        }catch(SQLException Ex){
            System.out.println(Ex.getMessage());
        }
        return Resp;
    }
    
    
    //Guardar datos de la persona que lleva el boleto
    public ResultSet consulta(String sql){
        ResultSet res = null;
        try{
            Connection Con = clsConexion.getConexion();
            PreparedStatement pstm = Con.prepareStatement(sql);
            res = pstm.executeQuery();
        }catch(SQLException e){
            System.err.println("Error consulta: " + e.getMessage());
        }
        return res;
    }
    public DefaultComboBoxModel Obt_Vuelo(){
        DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("Seleccione un vuelo");
        ResultSet res = this.consulta("Select * from TB_VUELO Where Estatus = 'Programado' and TipoAvion = 'Boing747'");
        
        try{
            while(res.next()){
                ListaModelo.addElement(res.getString("Id"));
            }
            res.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return ListaModelo;
    }
    public int fncReservaBoing( clsReservacion objReservacion ){
        int res = 0;
        try{
            Connection Con = clsConexion.getConexion();
            String consulta = "INSERT INTO TB_RESERVACION(VUELO_ID, FILA, ASIENTO, NO_PASAPORTE, NOMBRE, NACIONALIDAD, FECHA_NAC) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = Con.prepareStatement(consulta);
            ps.setInt(1, objReservacion.getVUELO_ID());
            ps.setInt(2, objReservacion.getFILA());
            ps.setString(3, objReservacion.getASIENTO());
            ps.setInt(4, objReservacion.getNO_PASAPORTE());
            ps.setString(5, objReservacion.getNOMBRE());
            ps.setString(6, objReservacion.getNACIONALIDAD());
            ps.setString(7, objReservacion.getFECHA_NAC());
            ps.executeUpdate();
            res = 1;
        }catch(SQLException Ex){
            System.out.println(Ex.getMessage());
        }
        return res;
    }
    
    public ResultSet consultaEmbraer(String sql){
        ResultSet res = null;
        try{
            Connection Con = clsConexion.getConexion();
            PreparedStatement pstm = Con.prepareStatement(sql);
            res = pstm.executeQuery();
        }catch(SQLException e){
            System.err.println("Error consulta: " + e.getMessage());
        }
        return res;
    }
    public DefaultComboBoxModel Obt_VueloEmbraer(){
        DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("Seleccione un vuelo");
        ResultSet res = this.consultaEmbraer("Select * from TB_VUELO Where Estatus = 'Programado' and TipoAvion = 'Embraer'");
        
        try{
            while(res.next()){
                ListaModelo.addElement(res.getString("Id"));
            }
            res.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return ListaModelo;
    }
}
