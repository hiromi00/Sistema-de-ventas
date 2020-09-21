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
public class DetalleVenta {
    
    private int idDetalleVenta;
    private Long idVenta;
    private String idProducto;
    private Double cantidadVendida;

    public DetalleVenta(Long idVenta, String idProducto, Double cantidadVendida) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidadVendida = cantidadVendida;
    }

    public Double getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(Double cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
    
    
    
}
