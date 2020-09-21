/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.hiromi00.sistema.pojo;

/**
 *
 * @author cesar
 */
public class Proveedor {
        
    private int idProveedor;
    private String nomProveedor;
    private String direcProveedor;
    private String telProveedor;
    private String emailProveedor;
    private String contactoProveedor;

    public Proveedor(int idProveedor, String nomProveedor, String direcProveedor, String telProveedor, String emailProveedor, String contactoProveedor) {
        this.idProveedor = idProveedor;
        this.nomProveedor = nomProveedor;
        this.direcProveedor = direcProveedor;
        this.telProveedor = telProveedor;
        this.emailProveedor = emailProveedor;
        this.contactoProveedor = contactoProveedor;
    }

    

    public String getContactoProveedor() {
        return contactoProveedor;
    }

    public void setContactoProveedor(String contactoProveedor) {
        this.contactoProveedor = contactoProveedor;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNomProveedor() {
        return nomProveedor;
    }

    public void setNomProveedor(String nomProveedor) {
        this.nomProveedor = nomProveedor;
    }

    public String getDirecProveedor() {
        return direcProveedor;
    }

    public void setDirecProveedor(String direcProveedor) {
        this.direcProveedor = direcProveedor;
    }

    public String getTelProveedor() {
        return telProveedor;
    }

    public void setTelProveedor(String telProveedor) {
        this.telProveedor = telProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }
    
    @Override 
    public String toString(){
        return this.nomProveedor;
    }
}
