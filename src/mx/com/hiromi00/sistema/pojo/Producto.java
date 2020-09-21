
package mx.com.hiromi00.sistema.pojo;

import java.io.File;

/**
 *
 * @author cesar
 */
public class Producto {
    
    private String idProducto;
    private String NomProducto;
    private String descProdcuto;
    private double stockProducto;
    private File fotoProducto;
    private String unidadProducto;
    private double precioCompraProducto;
    private double precioVentaProducto;
    private double existenciaProducto;
    private int idCategoriaProducto;
    private int idProveedorProducto;
    //Permite inicializar todos los atributos
    public Producto (String idProducto, String NomProducto, String descProdcuto, double stockProducto, 
                    File fotoProducto, String unidadProducto, double precioCompraProducto, 
                    double precioVentaProducto, double existenciaProducto, int idCategoriaProducto, int idProveedorProducto) {
        this.idProducto = idProducto;
        this.NomProducto = NomProducto;
        this.descProdcuto = descProdcuto;
        this.stockProducto = stockProducto;
        this.fotoProducto = fotoProducto;
        this.unidadProducto = unidadProducto;
        this.precioCompraProducto = precioCompraProducto;
        this.precioVentaProducto = precioVentaProducto;
        this.existenciaProducto = existenciaProducto;
        this.idCategoriaProducto = idCategoriaProducto;
        this.idProveedorProducto = idProveedorProducto;
    }
    //Crear todos los setter y getters

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNomProducto() {
        return NomProducto;
    }

    public void setNomProducto(String NomProducto) {
        this.NomProducto = NomProducto;
    }

    public String getDescProdcuto() {
        return descProdcuto;
    }

    public void setDescProdcuto(String descProdcuto) {
        this.descProdcuto = descProdcuto;
    }

    public double getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(double stockProducto) {
        this.stockProducto = stockProducto;
    }

    public File getFotoProducto() {
        return fotoProducto;
    }

    public void setFotoProducto(File fotoProducto) {
        this.fotoProducto = fotoProducto;
    }

    public String getUnidadProducto() {
        return unidadProducto;
    }

    public void setUnidadProducto(String unidadProducto) {
        this.unidadProducto = unidadProducto;
    }

    public double getPrecioCompraProducto() {
        return precioCompraProducto;
    }

    public void setPrecioCompraProducto(double precioCompraProducto) {
        this.precioCompraProducto = precioCompraProducto;
    }

    public double getPrecioVentaProducto() {
        return precioVentaProducto;
    }

    public void setPrecioVentaProducto(double precioVentaProducto) {
        this.precioVentaProducto = precioVentaProducto;
    }

    public double getExistenciaProducto() {
        return existenciaProducto;
    }

    public void setExistenciaProducto(double existenciaProducto) {
        this.existenciaProducto = existenciaProducto;
    }

    public int getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(int idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public int getIdProveedorProducto() {
        return idProveedorProducto;
    }

    public void setIdProveedorProducto(int idProveedorProducto) {
        this.idProveedorProducto = idProveedorProducto;
    }
    
    @Override
    public String toString(){
        return this.NomProducto;
    }
}
