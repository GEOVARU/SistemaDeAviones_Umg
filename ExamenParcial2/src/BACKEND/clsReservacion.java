/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BACKEND;

/**
 *
 * @author msarazua
 */
public class clsReservacion {
    private int RESERVACION;
    private int VUELO_ID;
    private int FILA;
    private String ASIENTO;
    private int NO_PASAPORTE;
    private String NOMBRE;
    private String NACIONALIDAD;
    private String FECHA_NAC;

    public clsReservacion() {
    }

    public clsReservacion(int RESERVACION, int VUELO_ID, int FILA, String ASIENTO, int NO_PASAPORTE, String NOMBRE, String NACIONALIDAD, String FECHA_NAC) {
        this.RESERVACION = RESERVACION;
        this.VUELO_ID = VUELO_ID;
        this.FILA = FILA;
        this.ASIENTO = ASIENTO;
        this.NO_PASAPORTE = NO_PASAPORTE;
        this.NOMBRE = NOMBRE;
        this.NACIONALIDAD = NACIONALIDAD;
        this.FECHA_NAC = FECHA_NAC;
    }

    public int getRESERVACION() {
        return RESERVACION;
    }

    public void setRESERVACION(int RESERVACION) {
        this.RESERVACION = RESERVACION;
    }

    public int getVUELO_ID() {
        return VUELO_ID;
    }

    public void setVUELO_ID(int VUELO_ID) {
        this.VUELO_ID = VUELO_ID;
    }

    public int getFILA() {
        return FILA;
    }

    public void setFILA(int FILA) {
        this.FILA = FILA;
    }

    public String getASIENTO() {
        return ASIENTO;
    }

    public void setASIENTO(String ASIENTO) {
        this.ASIENTO = ASIENTO;
    }

    public int getNO_PASAPORTE() {
        return NO_PASAPORTE;
    }

    public void setNO_PASAPORTE(int NO_PASAPORTE) {
        this.NO_PASAPORTE = NO_PASAPORTE;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getNACIONALIDAD() {
        return NACIONALIDAD;
    }

    public void setNACIONALIDAD(String NACIONALIDAD) {
        this.NACIONALIDAD = NACIONALIDAD;
    }

    public String getFECHA_NAC() {
        return FECHA_NAC;
    }

    public void setFECHA_NAC(String FECHA_NAC) {
        this.FECHA_NAC = FECHA_NAC;
    }

        
    
}
