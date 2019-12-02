/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificador;

/**
 *
 * @author armando
 */
public class Subfamilia {
    
    private int idFamilia;
    private String familia;
    private int idSubFamilia;
    private String subFamilia;

    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public int getIdSubFamilia() {
        return idSubFamilia;
    }

    public void setIdSubFamilia(int idSubFamilia) {
        this.idSubFamilia = idSubFamilia;
    }

    public String getSubFamilia() {
        return subFamilia;
    }

    public void setSubFamilia(String subFamilia) {
        this.subFamilia = subFamilia;
    }

    @Override
    public String toString() {
        return "Subfamilia{" + "idFamilia=" + idFamilia + ", familia=" + familia + ", idSubFamilia=" + idSubFamilia + ", subFamilia=" + subFamilia + '}';
    }

    
    
}
