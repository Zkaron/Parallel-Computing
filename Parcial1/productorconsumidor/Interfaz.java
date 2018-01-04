/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial1.productorconsumidor;

/**
 *
 * @author luis
 */
public class Interfaz extends javax.swing.JFrame {
    Almacen almacen;
    Productor productor;
    Consumidor consumidor;
    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        almacen = new Almacen(50);
        productor = new Productor(almacen, cantidadAlmacenLabel);
        consumidor = new Consumidor(almacen, cantidadAlmacenLabel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        productorLabel = new javax.swing.JLabel();
        consumidorLabel = new javax.swing.JLabel();
        almacenLabel = new javax.swing.JLabel();
        cantidadAlmacenLabel = new javax.swing.JLabel();
        productorSlider = new javax.swing.JSlider();
        consumidorSlider = new javax.swing.JSlider();
        iniciarButton = new javax.swing.JButton();
        detenerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        productorLabel.setText("Productor");

        consumidorLabel.setText("Consumidor");

        almacenLabel.setText("Almacen");

        cantidadAlmacenLabel.setText("0");

        productorSlider.setMaximum(10);
        productorSlider.setMinimum(1);
        productorSlider.setValue(5);
        productorSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                productorSliderStateChanged(evt);
            }
        });

        consumidorSlider.setMaximum(10);
        consumidorSlider.setMinimum(1);
        consumidorSlider.setValue(5);
        consumidorSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                consumidorSliderStateChanged(evt);
            }
        });

        iniciarButton.setText("Iniciar");
        iniciarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarButtonActionPerformed(evt);
            }
        });

        detenerButton.setText("Detener");
        detenerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detenerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(productorLabel)
                        .addGap(55, 55, 55))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(productorSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(almacenLabel)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cantidadAlmacenLabel)
                        .addGap(22, 22, 22)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(consumidorLabel)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(consumidorSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iniciarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(detenerButton)
                .addGap(135, 135, 135))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productorLabel)
                    .addComponent(consumidorLabel)
                    .addComponent(almacenLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consumidorSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productorSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidadAlmacenLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detenerButton)
                    .addComponent(iniciarButton)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarButtonActionPerformed
        almacen = new Almacen(50);
        almacen.almacenado = Integer.parseInt(cantidadAlmacenLabel.getText());
        productor = new Productor(almacen, cantidadAlmacenLabel);
        consumidor = new Consumidor(almacen, cantidadAlmacenLabel);
        productor.rapidez = productorSlider.getValue();
        consumidor.rapidez = consumidorSlider.getValue();
        
        cantidadAlmacenLabel.setText(almacen.almacenado + "");
        
        productor.start();
        consumidor.start();
    }//GEN-LAST:event_iniciarButtonActionPerformed

    private void productorSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_productorSliderStateChanged
        if(!productorSlider.getValueIsAdjusting()) {
            productor.rapidez = productorSlider.getValue();
        }
    }//GEN-LAST:event_productorSliderStateChanged

    private void consumidorSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_consumidorSliderStateChanged
        if(!consumidorSlider.getValueIsAdjusting()) {
            consumidor.rapidez = consumidorSlider.getValue();
        }
    }//GEN-LAST:event_consumidorSliderStateChanged

    private void detenerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detenerButtonActionPerformed
        productor.terminate();
        consumidor.terminate();
        try {
            productor.join();
            consumidor.join();   
        } catch(InterruptedException e) {
            
        }
 
    }//GEN-LAST:event_detenerButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel almacenLabel;
    private javax.swing.JLabel cantidadAlmacenLabel;
    private javax.swing.JLabel consumidorLabel;
    private javax.swing.JSlider consumidorSlider;
    private javax.swing.JButton detenerButton;
    private javax.swing.JButton iniciarButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel productorLabel;
    private javax.swing.JSlider productorSlider;
    // End of variables declaration//GEN-END:variables
}
