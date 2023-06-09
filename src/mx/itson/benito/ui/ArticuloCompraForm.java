/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package mx.itson.benito.ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.itson.benito.entidades.Articulo;
import mx.itson.benito.entidades.ArticuloComprado;
import mx.itson.benito.entidades.OrdenCompra;
import mx.itson.benito.persistencia.ArticuloCompradoDAO;
import mx.itson.benito.persistencia.ArticuloDAO;
import mx.itson.benito.persistencia.OrdenCompraDAO;


/**
 *
 * @author carlo
 */
public class ArticuloCompraForm extends javax.swing.JDialog {

    List<ArticuloComprado> articulosComprados = new ArrayList<>();
    int idProveedor;
    int id;
    /**
     * Creates new form ArticuloCompraForm
     */
    public ArticuloCompraForm(javax.swing.JDialog parent, boolean modal, int idProveedor, int id) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.idProveedor = idProveedor;
        this.id = id;
        cargarArticulos();
        tblArticulos.removeColumn(tblArticulos.getColumnModel().getColumn(0));
    }
    public void cargarArticulos(){       
        for(Articulo a : ArticuloDAO.obtenerTodos()){
           if(idProveedor== a.getProveedor().getId() ){
                cbxArticulos.addItem(a);
           }         
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

        cbxArticulos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        snrCantidad = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArticulos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Articulos:");

        jLabel2.setText("Cantidad:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Articulo", "Precio", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(tblArticulos);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(cbxArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(snrCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(snrCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Articulo articulo = (Articulo) cbxArticulos.getSelectedItem();
        int cantidad = Integer.parseInt(snrCantidad.getValue().toString());  
        ArticuloComprado a = new ArticuloComprado();
        a.setArticulo(articulo);
        a.setCantidad(cantidad);    
        articulosComprados.add(a);     
        
        OrdenCompra o = OrdenCompraDAO.obtenerPorId(id);
        
        ArticuloCompradoDAO.guardar(articulo, cantidad, o);
        
        
        cargarListArticulos();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       int renglon = tblArticulos.getSelectedRow();
         if(renglon != -1){
            int resultado = JOptionPane.showConfirmDialog(this, "¿Esta seguro que quiere eliminar a este articulo?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            if(resultado == JOptionPane.YES_OPTION){
                int idArticulo = Integer.parseInt(tblArticulos.getModel().getValueAt(renglon, 0).toString());        
                if(ArticuloCompradoDAO.eliminar(idArticulo)){
                    JOptionPane.showMessageDialog(this, "El registro se elimino correctamente", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE);          
                }else {
                    JOptionPane.showMessageDialog(this, "Ocurrio un error al intentar eliminar el registro", "Error al eliminar", JOptionPane.ERROR_MESSAGE);  
                }       
                cargarListArticulos(); 
            }            
         }else{
              JOptionPane.showMessageDialog(this, "Ocurrió un error, seleccione un proveedor", "Error al seleccionar", JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_btnEliminarActionPerformed
    
    public void cargarListArticulos(){
        DefaultTableModel modelo = (DefaultTableModel) tblArticulos.getModel();
        modelo.setRowCount(0); 
        for(ArticuloComprado a : ArticuloCompradoDAO.obtenerTodos()){   
            if(a.getOrdenCompra().getId() == id){
                modelo.addRow(new Object[] {a.getId(),a.getArticulo(), a.getArticulo().getPrecio(), a.getCantidad()});
            }
                     
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(ArticuloCompraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArticuloCompraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArticuloCompraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArticuloCompraForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArticuloCompraForm dialog = new ArticuloCompraForm(new javax.swing.JDialog(), true,0,0);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<Articulo> cbxArticulos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner snrCantidad;
    private javax.swing.JTable tblArticulos;
    // End of variables declaration//GEN-END:variables
}
