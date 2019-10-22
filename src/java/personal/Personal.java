/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal;

/**
 *
 * @author usuario
 */
public class Personal {
  private int noPersonalBm;
  private int noPersonal;
  private String rfc;
  private String curp;
  private String ap1;
  private String ap2;
  private String nombre;
  private String funcion;
  private int idestatus;

    public Personal() {
    }

    public Personal(int noPersonalBm, int noPersonal, String rfc, String curp, String ap1, String ap2, String nombre, String funcion, int idestatus) {
        this.noPersonalBm = noPersonalBm;
        this.noPersonal = noPersonal;
        this.rfc = rfc;
        this.curp = curp;
        this.ap1 = ap1;
        this.ap2 = ap2;
        this.nombre = nombre;
        this.funcion = funcion;
        this.idestatus = idestatus;
    }

    public int getNoPersonalBm() {
        return noPersonalBm;
    }

    public void setNoPersonalBm(int noPersonalBm) {
        this.noPersonalBm = noPersonalBm;
    }

    public int getNoPersonal() {
        return noPersonal;
    }

    public void setNoPersonal(int noPersonal) {
        this.noPersonal = noPersonal;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getAp1() {
        return ap1;
    }

    public void setAp1(String ap1) {
        this.ap1 = ap1;
    }

    public String getAp2() {
        return ap2;
    }

    public void setAp2(String ap2) {
        this.ap2 = ap2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public int getIdestatus() {
        return idestatus;
    }

    public void setIdestatus(int idestatus) {
        this.idestatus = idestatus;
    }
  
  
}
