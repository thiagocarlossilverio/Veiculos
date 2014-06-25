/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author TCS
 */
public class VeiculoBean {
    private int idveiculo;
    private String ano;
    private String cor;
    private String descricao;
    private String Valor;
    private byte[] fotocapa;
    private byte[] foto1;
    private byte[]foto2;
    private byte[] foto3;
    private byte[] foto4;
    private int idcidades;
    private int idusuario;
    private int idmodelo;
    private String nomeModelo;
    private String nomeMarca;
    private String tipo;
   
    //eito crreto para fazer
    private ModeloBean modelo;
   // private MarcaBean marca;

    /**
     * @return the idveiculo
     */
    public int getIdveiculo() {
        return idveiculo;
    }

    /**
     * @param idveiculo the idveiculo to set
     */
    public void setIdveiculo(int idveiculo) {
        this.idveiculo = idveiculo;
    }

    /**
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the Valor
     */
    public String getValor() {
        return Valor;
    }

    /**
     * @param Valor the Valor to set
     */
    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    /**
     * @return the fotocapa
     */
    public byte[] getFotocapa() {
        return fotocapa;
    }

    /**
     * @param fotocapa the fotocapa to set
     */
    public void setFotocapa(byte[] fotocapa) {
        this.fotocapa = fotocapa;
    }

    /**
     * @return the foto1
     */
    public byte[] getFoto1() {
        return foto1;
    }

    /**
     * @param foto1 the foto1 to set
     */
    public void setFoto1(byte[] foto1) {
        this.foto1 = foto1;
    }

    /**
     * @return the foto2
     */
    public byte[] getFoto2() {
        return foto2;
    }

    /**
     * @param foto2 the foto2 to set
     */
    public void setFoto2(byte[] foto2) {
        this.foto2 = foto2;
    }

    /**
     * @return the foto3
     */
    public byte[] getFoto3() {
        return foto3;
    }

    /**
     * @param foto3 the foto3 to set
     */
    public void setFoto3(byte[] foto3) {
        this.foto3 = foto3;
    }

    /**
     * @return the foto4
     */
    public byte[] getFoto4() {
        return foto4;
    }

    /**
     * @param foto4 the foto4 to set
     */
    public void setFoto4(byte[] foto4) {
        this.foto4 = foto4;
    }

    /**
     * @return the idcidades
     */
    public int getIdcidades() {
        return idcidades;
    }

    /**
     * @param idcidades the idcidades to set
     */
    public void setIdcidades(int idcidades) {
        this.idcidades = idcidades;
    }

    /**
     * @return the idusuario
     */
    public int getIdusuario() {
        return idusuario;
    }

    /**
     * @param idusuario the idusuario to set
     */
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    /**
     * @return the idmodelo
     */
    public int getIdmodelo() {
        return idmodelo;
    }

    /**
     * @param idmodelo the idmodelo to set
     */
    public void setIdmodelo(int idmodelo) {
        this.idmodelo = idmodelo;
    }

    /**
     * @return the nomeModelo
     */
    public String getNomeModelo() {
        return nomeModelo;
    }

    /**
     * @param nomeModelo the nomeModelo to set
     */
    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    /**
     * @return the nomeMarca
     */
    public String getNomeMarca() {
        return nomeMarca;
    }

    /**
     * @param nomeMarca the nomeMarca to set
     */
    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the modelo
     */
    public ModeloBean getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(ModeloBean modelo) {
        this.modelo = modelo;
    }
    

}