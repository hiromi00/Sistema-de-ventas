/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.hiromi00.sistema.gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import mx.com.hiromi00.sistema.database.BaseDatos;
import mx.com.hiromi00.sistema.pojo.Producto;

/**
 *
 * @author cesar
 */
public class InventariosFrame extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTabla = new DefaultTableModel();
    BaseDatos database = new BaseDatos();
    Producto productoSeleccionado = null;
    /**
     * Creates new form InventarioFrame
     */
    public InventariosFrame() {
        initComponents();
        bArticulos.setToolTipText("Nuevo Producto");
        btnProveedores.setToolTipText("Nuevo Proveedor");
        btnCategorias.setToolTipText("Nueva categoria");
        cargarColumnasTabla();
        cargarModeloTabla();
    }
    
    private void cargarColumnasTabla(){
        modeloTabla.addColumn("Clave");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Unidad de medida");
        modeloTabla.addColumn("Precio de compra");
        modeloTabla.addColumn("Precio de venta");
        modeloTabla.addColumn("Existencias");
    }
    
    //Despliega la foto a mostrar en la interfaz
    private void desplegarFoto(Producto prod){
        ImageIcon imagenProducto = null;
        try{
            //Obitnee la imagen desde la base de datos
            InputStream isFoto = database.buscarFoto(prod);
            BufferedImage biFoto = ImageIO.read(isFoto);
            imagenProducto = new ImageIcon(biFoto);
            
            Image imageProd = imagenProducto.getImage();
            int anchoImg = lblImgArt.getWidth();
            int altoImg = lblImgArt.getHeight();
            
            Image imgRedimensionada = imageProd.getScaledInstance(anchoImg, altoImg, Image.SCALE_DEFAULT);
            
            ImageIcon iconoRedimensionadao = new ImageIcon(imgRedimensionada);
            
            lblImgArt.setIcon(iconoRedimensionadao);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    //Método para cargar los datos de la tabla que está mostrada
    private void cargarModeloTabla(){
        
        
        //Se ordenan los productos dentro de un ArrayList
        ArrayList <Producto> listaProductos = database.obtenerProductos();
        //Se establece el número de filas que tendra la lista del frame
        int numeroProductos = listaProductos.size();
        modeloTabla.setNumRows(numeroProductos);
        //Se crea el recorrido para poder llenar la tabla
        for(int i = 0; i < numeroProductos; i++){
            Producto prod = listaProductos.get(i);
            
            //Se declara el objeto que será referencia para llenar la tabla
            String clave = prod.getIdProducto();
            String nombre = prod.getNomProducto();
            String unidad = prod.getUnidadProducto();
            Double precioCompra = prod.getPrecioCompraProducto();
            Double precioVenta = prod.getPrecioVentaProducto();
            Double existencia = prod.getExistenciaProducto();
            
            //Se procede a llenar los campos
            modeloTabla.setValueAt(clave, i, 0);
            modeloTabla.setValueAt(prod, i, 1);
            modeloTabla.setValueAt(unidad, i, 2);
            modeloTabla.setValueAt(precioCompra, i, 3);
            modeloTabla.setValueAt(precioVenta, i, 4);
            modeloTabla.setValueAt(existencia, i, 5);
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bArticulos = new javax.swing.JButton();
        btnCategorias = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        lblArt = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        tfClave = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        lblImgArt = new javax.swing.JLabel();
        lblExistencia = new javax.swing.JLabel();
        tfExistencia = new javax.swing.JTextField();
        lblNuevoInv = new javax.swing.JLabel();
        tfNuevoInv = new javax.swing.JTextField();
        bNuevoInv = new javax.swing.JButton();
        lblBuscarArt = new javax.swing.JLabel();
        tfBuscarArt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        tablaProductos.getSelectionModel().addListSelectionListener(
            new ListSelectionListener(){
                @Override
                public void valueChanged(ListSelectionEvent event){
                    if(!event.getValueIsAdjusting() && (tablaProductos.getSelectedRow() >= 0)){
                        //Selecciona la fila en la que se va a trabajar
                        int filaSeleccionada = tablaProductos.getSelectedRow();
                        Producto prod = (Producto)modeloTabla.getValueAt(filaSeleccionada, 1);
                        //Una vez obtenidos los datos, se procede a vaciar en los campos que muestra la interfaz
                        tfNombre.setText(prod.getNomProducto());
                        tfClave.setText(prod.getIdProducto());
                        String existencias = String.valueOf(prod.getExistenciaProducto());
                        tfExistencia.setText(existencias);
                        productoSeleccionado = prod;
                        //Muestra la imagen
                        desplegarFoto(prod);
                        tfClave.enable(false);
                        tfNombre.enable(false);
                        tfExistencia.enable(false);

                    }
                }
            }
        );
        btnEditProd = new javax.swing.JButton();
        btnDeleteProd = new javax.swing.JButton();
        lblEditProd = new javax.swing.JLabel();
        lblBorrarPord = new javax.swing.JLabel();

        setTitle("Inventario");

        ImageIcon iconobtnArticulo = new ImageIcon("images/newItem.png");
        Image imgbtnArticulo = iconobtnArticulo.getImage();
        //Las dimensiones establecidas como las preferenciales, se establecen aca 
        Dimension prefSizebtnArticulo = bArticulos.getPreferredSize();

        int anchobtnArticulo = (int)(prefSizebtnArticulo.getWidth()*7.0);
        int altobtnArticulo = (int)(prefSizebtnArticulo.getHeight()*7.0);
        Image imgRedimbtnArticulo = imgbtnArticulo.getScaledInstance(anchobtnArticulo, altobtnArticulo, Image.SCALE_DEFAULT);
        ImageIcon iconRedimbtnArticulo = new ImageIcon(imgRedimbtnArticulo);

        bArticulos.setIcon(iconRedimbtnArticulo);
        bArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bArticulosActionPerformed(evt);
            }
        });

        ImageIcon iconobtnCategorias = new ImageIcon("images/newCat.png");
        Image imgbtnCategorias = iconobtnCategorias.getImage();
        //Las dimensiones establecidas como las preferenciales, se establecen aca 
        Dimension prefSizebtnCategorias = btnCategorias.getPreferredSize();

        int anchobtnCategorias = (int)(prefSizebtnCategorias.getWidth()*7.0);
        int altobtnCategorias = (int)(prefSizebtnCategorias.getHeight()*7.0);
        Image imgRedimbtnCategorias = imgbtnCategorias.getScaledInstance(anchobtnCategorias, altobtnCategorias, Image.SCALE_DEFAULT);
        ImageIcon iconRedimbtnCategorias = new ImageIcon(imgRedimbtnCategorias);

        btnCategorias.setIcon(iconRedimbtnCategorias);
        btnCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriasActionPerformed(evt);
            }
        });

        ImageIcon iconobtnProveedores = new ImageIcon("images/newProv.png");
        Image imgbtnProveedores = iconobtnProveedores.getImage();
        //Las dimensiones establecidas como las preferenciales, se establecen aca 
        Dimension prefSizebtnProveedores = btnProveedores.getPreferredSize();

        int anchobtnProveedores = (int)(prefSizebtnProveedores.getWidth()*7.0);
        int altobtnProveedores = (int)(prefSizebtnProveedores.getHeight()*7.0);
        Image imgRedimbtnProveedores = imgbtnProveedores.getScaledInstance(anchobtnProveedores, altobtnProveedores, Image.SCALE_DEFAULT);
        ImageIcon iconRedimbtnProveedores = new ImageIcon(imgRedimbtnProveedores);

        btnProveedores.setIcon(iconRedimbtnProveedores);
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        lblArt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblArt.setText("Articulos");

        lblClave.setText("Clave");

        lblNombre.setText("Nombre");

        lblExistencia.setText("Existencia");

        lblNuevoInv.setText("Ingresar al Inventario");

        bNuevoInv.setText("Aceptar");
        bNuevoInv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoInvActionPerformed(evt);
            }
        });

        lblBuscarArt.setText("Buscar");

        tfBuscarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBuscarArtActionPerformed(evt);
            }
        });
        tfBuscarArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfBuscarArtKeyReleased(evt);
            }
        });

        tablaProductos.setModel(modeloTabla);

        jScrollPane1.setViewportView(tablaProductos);

        btnEditProd.setPreferredSize(new java.awt.Dimension(100, 64));
        ImageIcon iconobtnEditarProd = new ImageIcon("images/584fc1c26a5ae41a83ddee75.png");
        Image imgbtnEditarProd = iconobtnEditarProd.getImage();
        //Las dimensiones establecidas como las preferenciales, se establecen aca 
        Dimension prefSizeEditarProd = btnEditProd.getPreferredSize();

        int anchobtnEditarProd = (int)(prefSizeEditarProd.getWidth()*0.6);
        int altoEditarProd = (int)(prefSizeEditarProd.getHeight()*0.6);
        System.out.println(anchobtnEditarProd);
        System.out.println(altoEditarProd);
        Image imgRedimbtnEditarProd = imgbtnEditarProd.getScaledInstance(anchobtnEditarProd, altoEditarProd, Image.SCALE_DEFAULT);
        ImageIcon iconRedimbtnEditarProd = new ImageIcon(imgRedimbtnEditarProd);

        btnEditProd.setIcon(iconRedimbtnEditarProd);
        btnEditProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProdActionPerformed(evt);
            }
        });

        btnDeleteProd.setPreferredSize(new java.awt.Dimension(100, 64));
        ImageIcon iconBtnDeleteProd = new ImageIcon("images/deleteProd.png");
        Image imgbtnDeleteProd = iconBtnDeleteProd.getImage();
        //Las dimensiones establecidas como las preferenciales, se establecen aca 
        Dimension prefSizeDeleteProd = btnDeleteProd.getPreferredSize();

        int anchobtnDeleteProd = (int)(prefSizeDeleteProd.getWidth()*0.6);
        int altoDeleteProd = (int)(prefSizeDeleteProd.getHeight()*0.6);
        Image imgRedimbtnDeleteProd = imgbtnDeleteProd.getScaledInstance(anchobtnDeleteProd, altoDeleteProd, Image.SCALE_DEFAULT);
        ImageIcon iconRedimbtnDeleteProd = new ImageIcon(imgRedimbtnDeleteProd);

        btnDeleteProd.setIcon(iconRedimbtnDeleteProd);
        btnDeleteProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProdActionPerformed(evt);
            }
        });

        lblEditProd.setText("Editar Producto");

        lblBorrarPord.setText("Borrar Producto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfBuscarArt, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfClave, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblArt)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bArticulos, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(lblClave)
                                            .addComponent(lblExistencia))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNuevoInv)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tfNuevoInv)
                                            .addComponent(tfExistencia))
                                        .addGap(6, 6, 6)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblNombre)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(bNuevoInv, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                                        .addComponent(lblImgArt, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lblBuscarArt))
                        .addGap(87, 87, 87))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEditProd)
                            .addComponent(btnEditProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeleteProd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBorrarPord))
                        .addGap(75, 75, 75))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCategorias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnProveedores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblArt)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClave)
                    .addComponent(lblNombre))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(tfClave))
                        .addGap(18, 18, 18)
                        .addComponent(lblExistencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNuevoInv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNuevoInv, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bNuevoInv))
                        .addGap(18, 18, 18)
                        .addComponent(lblBuscarArt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfBuscarArt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblImgArt, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditProd, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDeleteProd, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEditProd)
                            .addComponent(lblBorrarPord))
                        .addContainerGap(90, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfBuscarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBuscarArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBuscarArtActionPerformed

    private void bArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bArticulosActionPerformed
        ProductosFrame artAccion = new ProductosFrame(null, true, null, null, "Nuevo Producto", false);
        artAccion.setVisible(true);
        artAccion.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        artAccion.setLocation(500, 200);
        artAccion.setAlwaysOnTop(true);
    }//GEN-LAST:event_bArticulosActionPerformed

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        CategoriaFrame catAccion = new CategoriaFrame(null, true);
        catAccion.setVisible(true);
        catAccion.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        catAccion.setLocation(500, 200);
        catAccion.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        ProveedoresFrame proAccion = new ProveedoresFrame(null, true);
        proAccion.setVisible(true);
        proAccion.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        proAccion.setLocation(500, 200);
        proAccion.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void bNuevoInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoInvActionPerformed
        
        double existencia = Double.parseDouble(tfNuevoInv.getText());
        double cantidadActual = productoSeleccionado.getExistenciaProducto();
        
        double nuevaCantidad = existencia + cantidadActual;
        
        database.actualizarInventario(productoSeleccionado, nuevaCantidad);
        cargarModeloTabla();
    }//GEN-LAST:event_bNuevoInvActionPerformed

    private void tfBuscarArtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarArtKeyReleased
        limpiarTabla();
        
        //Comenza la captura de lo introducido en el area "buscar"
        String cadenaBusqueda = tfBuscarArt.getText();
        ArrayList<Producto> listaProd = database.obtenerProductosPorCriterio(cadenaBusqueda);
        
        int numProd = listaProd.size();
        modeloTabla.setNumRows(numProd);
        
        for(int i = 0; i < numProd; i++){
            Producto prod = listaProd.get(i);
            String clave = prod.getIdProducto();
            String nombProd = prod.getNomProducto();
            String unidad = prod.getUnidadProducto();
            Double precioCompra = prod.getPrecioCompraProducto();
            Double precioVenta = prod.getPrecioVentaProducto();
            Double existencia = prod.getExistenciaProducto();
            
            //Se procede a llenar los campos
            modeloTabla.setValueAt(clave, i, 0);
            modeloTabla.setValueAt(prod, i, 1);
            modeloTabla.setValueAt(unidad, i, 2);
            modeloTabla.setValueAt(precioCompra, i, 3);
            modeloTabla.setValueAt(precioVenta, i, 4);
            modeloTabla.setValueAt(existencia, i, 5);
        }
    }//GEN-LAST:event_tfBuscarArtKeyReleased

    private void btnDeleteProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProdActionPerformed
        
        //Preguntar si realmente quiere borrar un producto
        int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este producto?");
        
        if (opcion == 0){
            modeloTabla.removeRow(tablaProductos.getSelectedRow());
            database.borrarProd(productoSeleccionado);
        }
    }//GEN-LAST:event_btnDeleteProdActionPerformed

    private void btnEditProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProdActionPerformed
        String nombreProd = productoSeleccionado.getNomProducto();
        ImageIcon imgProducto = null;
        ProductosFrame frameProd = null;
        
        int opcion = JOptionPane.showConfirmDialog(this, "¿está seguro que desea editar el prodcuto " + nombreProd + "?");
        
        if (opcion == 0){
            try{
                InputStream isFoto = database.buscarFoto(productoSeleccionado);
                //Recupera o lee el stream del inputStream
                BufferedImage biFoto = ImageIO.read(isFoto);
                //Comviente el buffered en una imagen 
                imgProducto = new ImageIcon(biFoto);
                
                //Crear la ventana  que permite la actualización
                frameProd = new ProductosFrame(null, true, productoSeleccionado, imgProducto, "Actualizar Producto", true);
                frameProd.setVisible(true);
                
                if(frameProd != null){
                    if(frameProd.getInformacion() != ""){
                        cargarModeloTabla();
                    }
                }
            } catch(IOException ex){
                
            }
            
        }
        
        
    }//GEN-LAST:event_btnEditProdActionPerformed
    //Método que vacia la tabla y la va reduciendo cada vez que se intrudice algo con el teclado
    private void limpiarTabla(){
        int numFilas = modeloTabla.getRowCount();
        
        if (numFilas > 0){
            for (int i = numFilas - 1; i >= 0; i--){
                modeloTabla.removeRow(i);
            }
        }
    }//Fil del método limpiar tabla

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bArticulos;
    private javax.swing.JButton bNuevoInv;
    private javax.swing.JButton btnCategorias;
    private javax.swing.JButton btnDeleteProd;
    private javax.swing.JButton btnEditProd;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblArt;
    private javax.swing.JLabel lblBorrarPord;
    private javax.swing.JLabel lblBuscarArt;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblEditProd;
    private javax.swing.JLabel lblExistencia;
    private javax.swing.JLabel lblImgArt;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNuevoInv;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField tfBuscarArt;
    private javax.swing.JTextField tfClave;
    private javax.swing.JTextField tfExistencia;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfNuevoInv;
    // End of variables declaration//GEN-END:variables
}