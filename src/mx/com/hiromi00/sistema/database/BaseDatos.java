/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.hiromi00.sistema.database;

import java.sql.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import mx.com.hiromi00.sistema.pojo.CategoriaProd;
import mx.com.hiromi00.sistema.pojo.DetalleVenta;
import mx.com.hiromi00.sistema.pojo.Producto;
import mx.com.hiromi00.sistema.pojo.Proveedor;
import mx.com.hiromi00.sistema.pojo.Venta;
/**
 *
 * @author cesar
 */
public class BaseDatos {
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Statement st = null;
    public BaseDatos(){
        try{
            Class.forName("org.postgresql.Driver");
        }   catch(ClassNotFoundException exp){
            exp.printStackTrace();
        }      
    }
    
    //Método para insertar productos
    public void insertarProducto(Producto prod){
        try{
            //Se abre la conexión con la base de datos
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "yokodera00");
            
            //Se crea el archivo que contendrá la foto
            File fileFoto = prod.getFotoProducto();
            //Se crea un objeto que ingresará una imagen de manera binaria
            FileInputStream archivo = new FileInputStream(fileFoto);
            
            //Se inicia la conexión de la base de datos
            String sqlText = "INSERT INTO cat_productos (id_prod, nombre_prod, desc_prod, "
                        + "stock_prod, foto_prod, unidad_prod, precio_compra_prod, "
                        + "precio_venta_prod, existencias_prod, id_categoria_prod, id_proveedor) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            ps = conn.prepareStatement(sqlText);
            //Se llenan los campos para la tabla, mandando a llamar los getters de la clase Producto
            ps.setString(1, prod.getIdProducto());
            ps.setString(2, prod.getNomProducto());
            ps.setString(3, prod.getDescProdcuto());
            ps.setDouble(4, prod.getStockProducto());
            //Se crea el tamaño que se usará para el tercer parametro del BinaryStream
            long tamFoto = fileFoto.length();
            ps.setBinaryStream(5, archivo, tamFoto);
            ps.setString(6, prod.getUnidadProducto());
            ps.setDouble(7, prod.getPrecioCompraProducto());
            ps.setDouble(8, prod.getPrecioVentaProducto());
            ps.setDouble(9, prod.getExistenciaProducto());
            ps.setInt(10, prod.getIdCategoriaProducto());
            ps.setInt(11, prod.getIdProveedorProducto());
  
            ps.executeUpdate();
        }catch(SQLException | FileNotFoundException exp){
            exp.printStackTrace();
        }
        //Cierra las conexiones
        finally{
            try{
                ps.close();
                conn.close();
            }catch(SQLException exp){
                exp.printStackTrace();
            }
        }
    }//Fin del método para insertar productos
    
    //Inicio del método para insertar proveedores
    public void insertarProveedor(Proveedor prov){
        try{
            //Se abre la conexión con la base de datos
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "yokodera00");
            
            //Se inicia la conexión de la base de datos
            String sqlText = "INSERT INTO cat_proveedores (nombre_proveedor, direc_proveedor, "
                            + "tel_proveedor, email_proveedor, contacto_proveedor) "
                            + "VALUES (?, ?, ?, ?, ?)";
            
            ps = conn.prepareStatement(sqlText);
            //Se llenan los campos para la tabla, mandando a llamar los getters de la clase Producto
            ps.setString(1, prov.getNomProveedor());
            ps.setString(2, prov.getDirecProveedor());
            ps.setString(3, prov.getTelProveedor());
            ps.setString(4, prov.getEmailProveedor());
            ps.setString(5, prov.getContactoProveedor());

  
            ps.executeUpdate();
        }catch(SQLException exp){
            exp.printStackTrace();
        }
        //Cierra las conexiones
        finally{
            try{
                ps.close();
                conn.close();
            }catch(SQLException exp){
                exp.printStackTrace();
            }
        }
    }//Fin del método para insertar proveedores
    
    //Inico del método que actualiza el inventario
    public void actualizarInventario(Producto prod, double cantidad){
        try{
            //Se abre la conexión con la base de datos
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "yokodera00");
            
            //Se inicia la conexión de la base de datos
            String sqlText = "UPDATE cat_productos SET existencias_prod = ? WHERE id_prod = ?";
            
            ps = conn.prepareStatement(sqlText);
            //Se llenan los campos para la tabla, mandando a llamar los getters de la clase Producto
            ps.setDouble(1, cantidad);
            ps.setString(2, prod.getIdProducto());

            ps.executeUpdate();
        }catch(SQLException exp){
            exp.printStackTrace();
        }
        //Cierra las conexiones
        finally{
            try{
                ps.close();
                conn.close();
            }catch(SQLException exp){
                exp.printStackTrace();
            }
        }
    }//Fin del método para actualizar inventario
    
    //Método para agregar una venta a la base de datos
    public Long insertarVenta(Venta venta){
        Long lastVal = 0l;
        try{
            
            //Se abre la conexión con la base de datos
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "yokodera00");
            
            //Se inicia la conexión de la base de datos
            String sqlText = "INSERT INTO ventas (monto_venta, fecha_venta) VALUES (?, ?)";
            
            ps = conn.prepareStatement(sqlText);
            //Se llenan los campos para la tabla, mandando a llamar los getters de la clase Producto
            ps.setDouble(1, venta.getMontoVenta());
            ps.setDate(2, venta.getFechaVenta());

            ps.executeUpdate();
            ps.close();
            
            //Se vuelve a abrir un nuevo ps, con una función de postgres que añade una nueva columna
            ps = this.conn.prepareStatement("SELECT lastval()");
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                lastVal = rs.getLong("lastval");
            }
        }catch(SQLException exp){
            exp.printStackTrace();
        }
        //Cierra las conexiones
        finally{
            try{
                rs.close();
                ps.close();
                conn.close();
            }catch(SQLException exp){
                exp.printStackTrace();
            }
        }
        return lastVal;
    }//Fin del método apra insertar una venta 
    
    //Inicio del método para insertar categorias
    public void insertarCategoria(CategoriaProd catProd){
        try{
            //Se abre la conexión con la base de datos
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "yokodera00");
            
            //Se inicia la conexión de la base de datos
            String sqlText = "INSERT INTO cat_categorias (nom_categoria_prod, desc_categoria_prod) "
                            + "VALUES (?, ?)";
            
            ps = conn.prepareStatement(sqlText);
            //Se llenan los campos para la tabla, mandando a llamar los getters de la clase Producto
            ps.setString(1, catProd.getNomCategoriaProd());
            ps.setString(2, catProd.getDescCategoriaProd());

            ps.executeUpdate();
        }catch(SQLException exp){
            exp.printStackTrace();
        }
        //Cierra las conexiones
        finally{
            try{
                ps.close();
                conn.close();
            }catch(SQLException exp){
                exp.printStackTrace();
            }
        }
    }//Fin del método para insertar categorias
    
    //Inicio del método para insertar detalle de venta
    public void insertarDetalleVenta(DetalleVenta detVen){
        try{
            //Se abre la conexión con la base de datos
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "yokodera00");
            
            //Se inicia la conexión de la base de datos
            String sqlText = "INSERT INTO detalle_venta (id_venta, id_prod, cantidad_vendida) "
                            + "VALUES (?, ?, ?)";
            
            ps = conn.prepareStatement(sqlText);
            //Se llenan los campos para la tabla, mandando a llamar los getters de la clase Producto
            ps.setLong(1, detVen.getIdVenta());
            ps.setString(2, detVen.getIdProducto());
            ps.setDouble(3, detVen.getCantidadVendida());

            ps.executeUpdate();
        }catch(SQLException exp){
            exp.printStackTrace();
        }
        //Cierra las conexiones
        finally{
            try{
                ps.close();
                conn.close();
            }catch(SQLException exp){
                exp.printStackTrace();
            }
        }
    }//Fin del método para insetar detalle de venta
    
    //Inicio del método para obtener los productos
    public ArrayList<Producto> obtenerProductos(){
        ArrayList <Producto> listaProductos = new ArrayList<Producto>();
        try{
            //Se abre la conexión con la base de datos
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "yokodera00");
 
            //Se inicia la conexión de la base de datos
            String sqlText = "SELECT * FROM cat_productos ORDER BY nombre_prod";
            
            ps = conn.prepareStatement(sqlText);
            //Se realiza la consulta con la base de datos
            rs = ps.executeQuery();
            
            while (rs.next()){
                String idProd = rs.getString("id_prod");
                String nombreProd = rs.getString("nombre_prod");
                String descrProd = rs.getString("desc_prod");
                Double stockProd = rs.getDouble("stock_prod");
                String unidadProd = rs.getString("unidad_prod");
                Double compraProd = rs.getDouble("precio_compra_prod");
                Double ventaProd = rs.getDouble("precio_venta_prod");
                Double existenicaProd = rs.getDouble("existencias_prod");
                int idCatProd = rs.getInt("id_categoria_prod");
                int idProvProd = rs.getInt("id_proveedor");
                
                
                Producto prod = new Producto(idProd, nombreProd, descrProd, stockProd, 
                                null, unidadProd, compraProd, ventaProd, existenicaProd, idCatProd, idProvProd);
                
                listaProductos.add(prod);
                
            }
            
        }catch(SQLException exp){
            exp.printStackTrace();
        }
        //Cierra las conexiones
        finally{
            try{
                ps.close();
                conn.close();
            }catch(SQLException exp){
                exp.printStackTrace();
            }
        }
        return listaProductos;
    }//Fin del método apra obtener productos

    //Inicio método para obtener las categorias
    public ArrayList<CategoriaProd> obtenerCategorias(){
        
        ArrayList <CategoriaProd> listaCategorias = new ArrayList<CategoriaProd>();
        try{
            //Se abre la conexión con la base de datos
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "yokodera00");
 
            //Se inicia la conexión de la base de datos
            String sqlText = "SELECT * FROM cat_categorias";
            
            ps = conn.prepareStatement(sqlText);
            //Se realiza la consulta con la base de datos
            rs = ps.executeQuery();
            
            while (rs.next()){
                int idCatProd = rs.getInt("id_categoria_prod");
                String nomCat = rs.getString("nom_categoria_prod");
                String descCat = rs.getString("desc_categoria_prod");
                
                
                CategoriaProd catProd = new CategoriaProd(idCatProd, nomCat, descCat);
                
                listaCategorias.add(catProd);
                
            }
            
        }catch(SQLException exp){
            exp.printStackTrace();
        }
        //Cierra las conexiones
        finally{
            try{
                ps.close();
                conn.close();
            }catch(SQLException exp){
                exp.printStackTrace();
            }
        }
        return listaCategorias;
        
    }//Fin del método para obtener las categorias
    
    //Inicio método para obtener los proveedores
    public ArrayList<Proveedor> obtenerProveedores(){
        ArrayList <Proveedor> listaProveedores = new ArrayList<Proveedor>();
        try{
            //Se abre la conexión con la base de datos
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "yokodera00");
 
            //Se inicia la conexión de la base de datos
            String sqlText = "SELECT * FROM cat_proveedores";
            
            ps = conn.prepareStatement(sqlText);
            //Se realiza la consulta con la base de datos
            rs = ps.executeQuery();
            
            while (rs.next()){
                int idProv = rs.getInt("id_proveedor");
                String nomProv = rs.getString("nombre_proveedor");
                String dirProv = rs.getString("direc_proveedor");
                String telProv = rs.getString("tel_proveedor");
                String emailProv = rs.getString("email_proveedor");
                String contProv = rs.getString("contacto_proveedor");
                
                
                Proveedor prov = new Proveedor(idProv, nomProv, dirProv, telProv, emailProv, contProv);
                
                listaProveedores.add(prov);
                
            }
            
        }catch(SQLException exp){
            exp.printStackTrace();
        }
        //Cierra las conexiones
        finally{
            try{
                ps.close();
                conn.close();
            }catch(SQLException exp){
                exp.printStackTrace();
            }
        }
        return listaProveedores;
    }//Fin del método para obtener los proveedores
    
    
    /*
        Método que obtiene los productos de la base de datos
        en base al criterio de busqueda establecido
    */
    public ArrayList<Producto> obtenerProductosPorCriterio(String criterio){
        ArrayList<Producto> listaProd = new ArrayList<>();
        try{
            //Se abre la conexión con la base de datos
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "yokodera00");

            //Se inicia la conexión de la base de datos
            String sqlText = "SELECT * FROM cat_productos "
                             + "WHERE id_prod LIKE '" + criterio + "%' "
                             + "OR nombre_prod LIKE '%" + criterio + "%' "
                             + "ORDER BY nombre_prod";
            //Se crea el statement para ejecutar los codigos en la base de datos
            st = conn.createStatement();
            //Se realiza la consulta con la base de datos
            rs = st.executeQuery(sqlText);


            while (rs.next()){
                String idProd = rs.getString("id_prod");
                String nombreProd = rs.getString("nombre_prod");
                String descrProd = rs.getString("desc_prod");
                Double stockProd = rs.getDouble("stock_prod");
                String unidadProd = rs.getString("unidad_prod");
                Double compraProd = rs.getDouble("precio_compra_prod");
                Double ventaProd = rs.getDouble("precio_venta_prod");
                Double existenicaProd = rs.getDouble("existencias_prod");
                int idCatProd = rs.getInt("id_categoria_prod");
                int idProvProd = rs.getInt("id_proveedor");

                Producto prod = new Producto(idProd, nombreProd, descrProd, stockProd, 
                                    null, unidadProd, compraProd, ventaProd, existenicaProd, idCatProd, idProvProd);

                listaProd.add(prod);

            }

            }catch(SQLException exp){
                exp.printStackTrace();
            }
        //Cierra las conexiones
        finally{
            try{
                st.close();
                conn.close();
            }catch(SQLException exp){
                exp.printStackTrace();
            }
        }
        return listaProd;
    }//Fin del método de busqueda de productos
    
    //Inicio del método que elimina productos de la base de datos
    public void borrarProd(Producto prod){
        try{
            //Se abre la conexión con la base de datos
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "yokodera00");
            
            //Se inicia la conexión de la base de datos
            String sqlText = "DELETE FROM cat_productos WHERE id_prod = ?";
            
            ps = conn.prepareStatement(sqlText);
            //Se llenan los campos para la tabla, mandando a llamar los getters de la clase Producto
            ps.setString(1, prod.getIdProducto());
  
            ps.executeUpdate();
        }catch(SQLException exp){
            exp.printStackTrace();
        }
        //Cierra las conexiones
        finally{
            try{
                ps.close();
                conn.close();
            }catch(SQLException exp){
                exp.printStackTrace();
            }
        }
    }//Fin del método que elimina prductos
    
    //Método para buscar la foto dentro de la base de datos
    public InputStream buscarFoto(Producto prod){
        InputStream streamFoto = null;
       try{
            //Se abre la conexión con la base de datos
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "yokodera00");

            //Se inicia la conexión de la base de datos
            String sqlText = "SELECT foto_prod FROM cat_productos WHERE id_prod = ?";
            
            ps = conn.prepareStatement(sqlText);
            
            ps.setString(1, prod.getIdProducto());

            rs = ps.executeQuery();
            while (rs.next()){
                //Recupera el archivo binario de la foto
                streamFoto = rs.getBinaryStream("foto_prod");

            }

            }catch(SQLException exp){
                exp.printStackTrace();
            }
        //Cierra las conexiones
        finally{
            try{
                ps.close();
                conn.close();
            }catch(SQLException exp){
                exp.printStackTrace();
            }
        }
        return streamFoto;
    } //Fin del método para buscar una foto 
    
    //Inicio del método que actualiza los productos
    public void actualizarProducto(Producto prod, boolean cambiarFoto){
        try{
            //Se abre la conexión con la base de datos
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-sistema", "postgres", "yokodera00");
            
            if (cambiarFoto){
                //Se crea el archivo que contendrá la foto
                File fileFoto = prod.getFotoProducto();
                //Se crea un objeto que ingresará una imagen de manera binaria
                FileInputStream archivo = new FileInputStream(fileFoto);
                //Se inicia la conexión de la base de datos
                String sqlText = "UPDATE cat_productos SET  desc_prod = ?, stock_prod = ?, foto_prod = ?, unidad_prod = ?,"
                                 + "precio_compra_prod = ?, precio_venta_prod = ?, id_categoria_prod = ?, id_proveedor = ?"
                                 + "WHERE id_prod = ?";
                ps = conn.prepareStatement(sqlText);
                //Se llenan los campos para la tabla, mandando a llamar los getters de la clase Producto
                ps.setString(1, prod.getDescProdcuto());
                ps.setDouble(2, prod.getStockProducto());
                //Se crea el tamaño que se usará para el tercer parametro del BinaryStream
                long tamFoto = fileFoto.length();
                ps.setBinaryStream(3, archivo, tamFoto);
                ps.setString(4, prod.getUnidadProducto());
                ps.setDouble(5, prod.getPrecioCompraProducto());
                ps.setDouble(6, prod.getPrecioVentaProducto());
                ps.setInt(7, prod.getIdCategoriaProducto());
                ps.setInt(8, prod.getIdProveedorProducto());
                ps.setString(9, prod.getIdProducto());
            }
            else{
                //Se crea el archivo que contendrá la foto
                File fileFoto = prod.getFotoProducto();
                //Se crea un objeto que ingresará una imagen de manera binaria
                FileInputStream archivo = new FileInputStream(fileFoto);
                //Se inicia la conexión de la base de datos
                String sqlText = "UPDATE cat_productos SET  desc_prod = ?, stock_prod = ?, unidad_prod = ?,"
                                 + "precio_compra_prod = ?, precio_venta_prod = ?, id_categoria = ?, id_proveedor = ?"
                                 + "WHERE id_prod = ?";
                ps = conn.prepareStatement(sqlText);
                //Se llenan los campos para la tabla, mandando a llamar los getters de la clase Producto
                ps.setString(1, prod.getDescProdcuto());
                ps.setDouble(2, prod.getStockProducto());
                ps.setString(3, prod.getUnidadProducto());
                ps.setDouble(4, prod.getPrecioCompraProducto());
                ps.setDouble(5, prod.getPrecioVentaProducto());
                ps.setInt(6, prod.getIdCategoriaProducto());
                ps.setInt(7, prod.getIdProveedorProducto());
                ps.setString(8, prod.getIdProducto());
            }

            ps.executeUpdate();
        }catch(SQLException | FileNotFoundException exp){
            exp.printStackTrace();
        }
        //Cierra las conexiones
        finally{
            try{
                ps.close();
                conn.close();
            }catch(SQLException exp){
                exp.printStackTrace();
            }
        }
    }//Fin del método para actualizar el producto
}
    
