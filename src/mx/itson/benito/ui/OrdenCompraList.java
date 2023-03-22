/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.benito.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.itson.benito.entidades.OrdenCompra;
import mx.itson.benito.persistencia.OrdenCompraDAO;
import mx.itson.edu.mx.enumeradores.Estado;


/**
 *
 * @author carlo
 */
public class OrdenCompraList extends javax.swing.JFrame {

    /**
     * Creates new form OrdenCompraList
     */
    public OrdenCompraList() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrdenesCompras = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnOrdenar = new javax.swing.JMenuItem();
        btnRecibir = new javax.swing.JMenuItem();
        btnCancelar = new javax.swing.JMenuItem();
        btnEliminar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Herramienta de compra");

        tblOrdenesCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Folio", "Fecha", "Proveedor", "SubTotal", "Total", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tblOrdenesCompras);

        jMenu1.setText("Opciones");

        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        jMenu1.add(btnOrdenar);

        btnRecibir.setText("Recibir");
        btnRecibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecibirActionPerformed(evt);
            }
        });
        jMenu1.add(btnRecibir);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jMenu1.add(btnCancelar);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jMenu1.add(btnEliminar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Proveedores");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(278, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(241, 241, 241))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tblOrdenesCompras.removeColumn(tblOrdenesCompras.getColumnModel().getColumn(0));
        cargarTable();
    }//GEN-LAST:event_formWindowOpened

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        OrdenCompraForm form = new OrdenCompraForm(this, true, 0);
        form.setVisible(true);
        cargarTable();
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        this.setVisible(false);
        ProveedorList p = new ProveedorList();
        p.setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void btnRecibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecibirActionPerformed
       int renglon = tblOrdenesCompras.getSelectedRow();
       if(renglon != -1){
           Estado estado = (Estado) tblOrdenesCompras.getModel().getValueAt(renglon, 6);
           if(estado == Estado.Cerrado || estado == Estado.Cancelado){
               JOptionPane.showMessageDialog(this, "Ocurrió un error, esta compra se encuentra deshabilitada", "Compra cerrada o cancelada", JOptionPane.ERROR_MESSAGE);
           }else{
               int idOrdenCompra = Integer.parseInt(tblOrdenesCompras.getModel().getValueAt(renglon, 0).toString());
               OrdenCompraForm form = new OrdenCompraForm(this, true, idOrdenCompra );
       
               form.setVisible(true);
               cargarTable();
           } 
       }else{
           JOptionPane.showMessageDialog(this, "Ocurrió un error, seleccione una orden", "Error al seleccionar", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnRecibirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int renglon = tblOrdenesCompras.getSelectedRow();
         if(renglon != -1){
            int resultado = JOptionPane.showConfirmDialog(this, "¿Esta seguro que quiere eliminar esta orden?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            if(resultado == JOptionPane.YES_OPTION){
                int idOrdenCompra = Integer.parseInt(tblOrdenesCompras.getModel().getValueAt(renglon, 0).toString());        
                if(OrdenCompraDAO.eliminar(idOrdenCompra)){
                    JOptionPane.showMessageDialog(this, "El registro se elimino correctamente", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE);          
                }else {
                    JOptionPane.showMessageDialog(this, "Ocurrio un error al intentar eliminar el registro", "Error al eliminar", JOptionPane.ERROR_MESSAGE);  
                }       
                cargarTable(); 
            }            
         }else{
              JOptionPane.showMessageDialog(this, "Ocurrió un error, seleccione una orden", "Error al seleccionar", JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       int renglon = tblOrdenesCompras.getSelectedRow();
       if(renglon != -1){
           Estado estado = (Estado) tblOrdenesCompras.getModel().getValueAt(renglon, 6);
           if(estado == Estado.Cerrado || estado == Estado.Cancelado){
               JOptionPane.showMessageDialog(this, "Ocurrió un error, esta compra se encuentra deshabilitada", "Compra cerrada o cancelada", JOptionPane.ERROR_MESSAGE);
           }else{
               int idOrdenCompra = Integer.parseInt(tblOrdenesCompras.getModel().getValueAt(renglon, 0).toString());
                int resultado = JOptionPane.showConfirmDialog(this, "¿Esta seguro que quiere cancelar esta orden?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                if(resultado == JOptionPane.YES_OPTION){
                    OrdenCompra ordenCompra = OrdenCompraDAO.obtenerPorId(idOrdenCompra);
                    OrdenCompraDAO.editar(ordenCompra.getId(), ordenCompra.getFolio(), ordenCompra.getFecha(), ordenCompra.getProveedor(), ordenCompra.getSubTotal(), ordenCompra.getTotal(), Estado.Cancelado);
                    cargarTable(); 
                }  
           } 
       }else{
           JOptionPane.showMessageDialog(this, "Ocurrió un error, seleccione una orden", "Error al seleccionar", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    private void cargarTable(){
        OrdenCompraDAO ordenCompra = new OrdenCompraDAO();
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        DefaultTableModel modelo = (DefaultTableModel) tblOrdenesCompras.getModel();
        modelo.setRowCount(0);
        for(OrdenCompra o : ordenCompra.obtenerTodos()){
            
            modelo.addRow(new Object[] {o.getId(), o.getFolio(), formatoFecha.format(o.getFecha()), o.getProveedor(), o.getSubTotal(), o.getTotal(), o.getEstado()});
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
            java.util.logging.Logger.getLogger(OrdenCompraList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdenCompraList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdenCompraList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdenCompraList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdenCompraList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCancelar;
    private javax.swing.JMenuItem btnEliminar;
    private javax.swing.JMenuItem btnOrdenar;
    private javax.swing.JMenuItem btnRecibir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrdenesCompras;
    // End of variables declaration//GEN-END:variables
}
