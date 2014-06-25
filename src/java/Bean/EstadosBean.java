/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author TCS
 */
public class EstadosBean {
 
    private int idestados;
    private String estado;
    private String uf;

    /**
     * @return the idestados
     */
    public int getIdestados() {
        return idestados;
    }

    /**
     * @param idestados the idestados to set
     */
    public void setIdestados(int idestados) {
        this.idestados = idestados;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }
}
