/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.hiromi00.sistema.gui;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import mx.com.hiromi00.sistema.database.BaseDatos;
import mx.com.hiromi00.sistema.pojo.CategoriaProd;
import mx.com.hiromi00.sistema.pojo.Producto;
import mx.com.hiromi00.sistema.pojo.Proveedor;

/**
 *
 * @author cesar
 */
public class ProductosFrame extends javax.swing.JDialog {

    /**
     * Creates new form ProveedorFrame
     */
    DefaultComboBoxModel <CategoriaProd>  modeloCategoria;
    DefaultComboBoxModel<Proveedor> modeloProveedor;
    BaseDatos database;
    boolean actualizando;
    String informacion = "";
    
    
    public ProductosFrame(java.awt.Frame parent, boolean modal, Producto prod, ImageIcon icono, String titulo, boolean actualizar) {
        super(parent, modal);
        modeloCategoria = new DefaultComboBoxModel<CategoriaProd>();
        modeloProveedor = new DefaultComboBoxModel<Proveedor>();
        database = new BaseDatos();
        cargarmodeloCategoria();
        cargarModeloProveedor();
        initComponents();
        this.actualizando = actualizar;
        this.setTitle(titulo);
        if(prod != null){
            cargarProducto(prod, icono);
        }
    }
    //Funcion para volver a cargar los datos para editar
    private void cargarProducto(Producto prod, ImageIcon icono){
        //Se procede a establecer la imagen redimensionada
        Image imageProd = icono.getImage();
        int anchoImg = lblImagenArt.getWidth();
        int altoImg = lblImagenArt.getHeight();

        Image imgRedimensionada = imageProd.getScaledInstance(anchoImg, altoImg, Image.SCALE_DEFAULT);

        ImageIcon iconoRedimensionadao = new ImageIcon(imgRedimensionada);

        lblImagenArt.setIcon(iconoRedimensionadao);

        String clave = prod.getIdProducto();
        String nombre = prod.getNomProducto();
        String descProd = prod.getDescProdcuto();
        double stock = prod.getStockProducto();
        String unidad = prod.getUnidadProducto();
        double precioCompra = prod.getPrecioCompraProducto();
        double precioVenta = prod.getPrecioVentaProducto();
        
        tfClaveArt.setText(clave);
        tfNombreProd.setText(nombre);
        taDescProd.setText(descProd);
        tfStockProd.setText(String.valueOf(stock));
        cbUnidadArt.setSelectedItem(unidad);
        tfCompraArt.setText(String.valueOf(precioCompra));
        tfVentaArt.setText(String.valueOf(precioVenta));
        
        
        tfClaveArt.enable(false);
        tfNombreProd.enable(false);
        
        
    }//Fin del metodo de carga de datos
    
    //Agregar las categorias al ComboBox
    private void cargarmodeloCategoria(){
        ArrayList<CategoriaProd> listaCat;
        listaCat = database.obtenerCategorias();
        
        for(CategoriaProd catprod : listaCat){
            modeloCategoria.addElement(catprod);
        }
    }//Fin de la carga de categorias
    
    //Agregar los proveedores al comboBox
    private void cargarModeloProveedor(){
        ArrayList<Proveedor> listaProv;
        listaProv = database.obtenerProveedores();
        
        for(Proveedor prov : listaProv){
            modeloProveedor.addElement(prov);
        }
    }//Fin de la carga de proveedores

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblClaveArt = new javax.swing.JLabel();
        tfClaveArt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescProd = new javax.swing.JTextArea();
        bAceptarArt = new javax.swing.JButton();
        bCancelarArt = new javax.swing.JButton();
        lblStock = new javax.swing.JLabel();
        tfStockProd = new javax.swing.JTextField();
        lblCatArt = new javax.swing.JLabel();
        cbCategoriaArt = new javax.swing.JComboBox<>();
        bNuevaCat = new javax.swing.JButton();
        lblUnidadArt = new javax.swing.JLabel();
        cbUnidadArt = new javax.swing.JComboBox<>();
        lblCompraArt = new javax.swing.JLabel();
        tfCompraArt = new javax.swing.JTextField();
        lblVentaArt = new javax.swing.JLabel();
        tfVentaArt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblImagenArt = new javax.swing.JLabel();
        lblProvArt = new javax.swing.JLabel();
        cbProvArt = new javax.swing.JComboBox<>();
        lblNombreProd = new javax.swing.JLabel();
        tfNombreProd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Producto");

        lblClaveArt.setText("Clave");

        jLabel2.setText("Descripción");

        taDescProd.setColumns(20);
        taDescProd.setRows(5);
        jScrollPane1.setViewportView(taDescProd);

        bAceptarArt.setText("Aceptar");
        bAceptarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarArtActionPerformed(evt);
            }
        });

        bCancelarArt.setText("Cancelar");
        bCancelarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarArtActionPerformed(evt);
            }
        });

        lblStock.setText("Stock Requerido");

        lblCatArt.setText("Categoria");

        cbCategoriaArt.setModel(modeloCategoria);
        cbCategoriaArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaArtActionPerformed(evt);
            }
        });

        bNuevaCat.setText("Nueva Categoria");
        bNuevaCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevaCatActionPerformed(evt);
            }
        });

        lblUnidadArt.setText("Unidad de medida");

        cbUnidadArt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilogramo", "Litro", "Pieza" }));

        lblCompraArt.setText("Precio de compra");

        lblVentaArt.setText("Precio de venta");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(230, 230));

        lblImagenArt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblImagenArtMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblImagenArt, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblImagenArt, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblProvArt.setText("Proveedor");

        cbProvArt.setModel(modeloProveedor);

        lblNombreProd.setText("Nombte del producto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfClaveArt, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClaveArt))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUnidadArt)
                    .addComponent(lblStock)
                    .addComponent(tfStockProd, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbUnidadArt, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNombreProd)
                        .addGap(159, 159, 159))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(bAceptarArt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bCancelarArt, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tfNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProvArt)
                    .addComponent(cbProvArt, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfCompraArt, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfVentaArt, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCompraArt)
                                .addGap(85, 85, 85)
                                .addComponent(lblVentaArt))
                            .addComponent(lblCatArt)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbCategoriaArt, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bNuevaCat)))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClaveArt)
                    .addComponent(lblStock)
                    .addComponent(lblCatArt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfStockProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfClaveArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbCategoriaArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bNuevaCat)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreProd)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCompraArt)
                            .addComponent(lblUnidadArt)
                            .addComponent(lblVentaArt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbUnidadArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCompraArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfVentaArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblProvArt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbProvArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bAceptarArt)
                                    .addComponent(bCancelarArt)))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Método apra poder guardar o actualizar los datos de un producto
    private void bAceptarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarArtActionPerformed
        String codigo = tfClaveArt.getText().toLowerCase();
        String nombre = tfNombreProd.getText().toLowerCase();
        String descripcion = taDescProd.getText().toLowerCase();
        double stock = Double.parseDouble(tfStockProd.getText());
        double precioCompra = Double.parseDouble(tfCompraArt.getText());
        double precioVenta = Double.parseDouble(tfVentaArt.getText());
        String unidad = cbUnidadArt.getSelectedItem().toString();
        CategoriaProd categoria = (CategoriaProd)cbCategoriaArt.getSelectedItem();
        Proveedor proveedor = (Proveedor)cbProvArt.getSelectedItem();
        
        
        if(actualizando){
            if(imgArtFile == null){
                //Actualiza los datos, sin meterse en el campo de la foto
                Producto prod = new Producto(codigo, nombre, descripcion, stock, 
                                null, unidad, precioCompra, precioVenta, 
                                0.0, categoria.getIdCategoriaProd(), proveedor.getIdProveedor());
                
                database.actualizarProducto(prod, false);
                
            }
            else{
                //Aquí sí se mete al campo de la foto
                Producto prod = new Producto(codigo, nombre, descripcion, stock, 
                                imgArtFile, unidad, precioCompra, precioVenta, 
                                0.0, categoria.getIdCategoriaProd(), proveedor.getIdProveedor());
                
                database.actualizarProducto(prod, true);
            }
            JOptionPane.showMessageDialog(this, "Producto actualizado");
            this.dispose();
            informacion = "1";
        }//Fin de la condición que actualiza los datos ya escritos
        else{
            
            //Se evalua si se cargo una iamgen o no
            if (imgArtFile == null){
                JOptionPane.showMessageDialog(this, "No ha seleccionado una imagen");
            }
            else{
                //Despues de haber recuperado todos los datos capturados, se crea el objeto Producto
                Producto prod = new Producto(codigo, nombre, descripcion, stock, imgArtFile, 
                                unidad, precioCompra, precioVenta, 0.0, categoria.getIdCategoriaProd(), 
                                proveedor.getIdProveedor());
                database.insertarProducto(prod);

                JOptionPane.showMessageDialog(this, "Se ha realizado la inserción de un nuevo producto");

                //Se procede a cerrar la ventana
                this.dispose();
            }
        }
    //Fin del método para guardar o actulizar un prodcuto   
    }//GEN-LAST:event_bAceptarArtActionPerformed
    
    private void bNuevaCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevaCatActionPerformed
        CategoriaFrame catFrame = new CategoriaFrame(null, true);
        catFrame.setVisible(true);
        catFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        catFrame.setLocation(500, 200);
        catFrame.setAlwaysOnTop(true);
        
    }//GEN-LAST:event_bNuevaCatActionPerformed
    
    //Declaración del archivo que tendra la imagen
    File imgArtFile;
    private void lblImagenArtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenArtMousePressed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                                         "Archivos de imagen jpg, png, gif", "jpg", "png", "gif");
        //Elige el formato de que va a llevar la imagen a elegir
        chooser.setFileFilter(filter);
        
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION){
            int anchoImagen = lblImagenArt.getWidth();
            int altoImagen = lblImagenArt.getHeight();
            
            //Acepta el archivo seleccionado por el usuario
            imgArtFile = chooser.getSelectedFile();
            //Se crea en base a la ruta absoluta de la imagen seleccionada
            ImageIcon icono = new ImageIcon(imgArtFile.getAbsolutePath());
            Image imagen = icono.getImage();
            //Establece los limites del tamaño de la imagen 
            Image imagenRedimesionada = imagen.getScaledInstance(anchoImagen, altoImagen, Image.SCALE_DEFAULT);

            
            ImageIcon iconoRedimencionado = new ImageIcon(imagenRedimesionada);
            
            lblImagenArt.setIcon(iconoRedimencionado);
            
        }
        
    }//GEN-LAST:event_lblImagenArtMousePressed

    private void bCancelarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarArtActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelarArtActionPerformed

    private void cbCategoriaArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriaArtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold lllllllllllldefaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductosFrame dialog = new ProductosFrame(new javax.swing.JFrame(), true, null, null, "Nuevo Producto", false);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    public String getInformacion(){
        return informacion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptarArt;
    private javax.swing.JButton bCancelarArt;
    private javax.swing.JButton bNuevaCat;
    private javax.swing.JComboBox<CategoriaProd> cbCategoriaArt;
    private javax.swing.JComboBox<Proveedor> cbProvArt;
    private javax.swing.JComboBox<String> cbUnidadArt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCatArt;
    private javax.swing.JLabel lblClaveArt;
    private javax.swing.JLabel lblCompraArt;
    private javax.swing.JLabel lblImagenArt;
    private javax.swing.JLabel lblNombreProd;
    private javax.swing.JLabel lblProvArt;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblUnidadArt;
    private javax.swing.JLabel lblVentaArt;
    private javax.swing.JTextArea taDescProd;
    private javax.swing.JTextField tfClaveArt;
    private javax.swing.JTextField tfCompraArt;
    private javax.swing.JTextField tfNombreProd;
    private javax.swing.JTextField tfStockProd;
    private javax.swing.JTextField tfVentaArt;
    // End of variables declaration//GEN-END:variables
}
