/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datasiswafajar;

/**
 *
 * @author LENOVO PC
 */

import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class siswa extends javax.swing.JFrame {
Connection konek; 
Object[] row= {"nis", "nama", "tempat_lahir", "tgl_lahir", "jenis_kelamin", "alamat"};
DefaultTableModel tabMode = new DefaultTableModel (null,row);  
 
void koneksi(){
    try{
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("Driver diketemukan");
     
       try{
           String url="jdbc:mysql://localhost/datasiswa_fajar?user=root&password=";
           konek=DriverManager.getConnection(url);
           JOptionPane.showMessageDialog (null,"Anda Berhasil Koneksi");
    
       }catch(SQLException e) {
               System.out.println("Gagal Koneksi"+ e);
               System.exit(0);   
       }    
       }catch (Exception se){
         System.out.println("Driver tidak ditemukan"+ se);
         JOptionPane.showMessageDialog (null,"koneksi tidak ditemukan...");
         System.exit(0) ;
     }
    } 
void hapus(){
    txtnis.setText("");
    txtnama.setText("");
    txttempat_lahir.setText("");
    txttgl_lahir.setText("");
    txtalamat.setText("");
    txtnis.requestFocus();  
}

void combokel() {
    cmbkel.addItem("laki-laki");
    cmbkel.addItem("perempuan");
}

void cari(){
    koneksi();
    try{
        String sql="Select * from siswa where nis ='"+txtnis.getText()+"'";
        Statement st =konek.createStatement();
        ResultSet rs=st.executeQuery(sql);
        while (rs.next()){
            txtnama.setText(rs.getString("nama"));
            txttempat_lahir.setText(rs.getString("tempat_lahir"));
            txttgl_lahir.setText(rs.getString("tgl_lahir"));
            cmbkel.setSelectedItem(rs.getString("jenis_kelamin"));
            txtalamat.setText(rs.getString("alamat"));
        }
    }catch(SQLException se) {
        JOptionPane.showMessageDialog (null,"ada kesalahan"+ se);        
    }
}
    
void hapustabel(){
    int row = tabMode.getRowCount();
    for (int i=0;i<row;i++){
        tabMode.removeRow(0);
    }
}

void tampiltabel(){
       koneksi();
       hapustabel();
       
       try{
           String SQL ="Select * from siswa";
           Statement stat= konek.createStatement();
           ResultSet set = stat.executeQuery(SQL);
           while(set.next()){
               String nis=set.getString("nis"); 
               String nama=set.getString("nama"); 
               String tempat_lahir=set.getString("tempat_lahir"); 
               String tgl_lahir=set.getString("tgl_lahir"); 
               String jenis_kelamin=set.getString("jenis_kelamin"); 
               String alamat=set.getString("alamat");
               String[] data={nis,nama,tempat_lahir,tgl_lahir,jenis_kelamin,alamat};
               tabMode.addRow(data);
           }  
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Ada kesalahan data di"+ e);
       }
}




/**
     * Creates new form siswa
     */
    public siswa() {
        initComponents();
        koneksi();
        hapus();
        combokel();
        mastertable.setModel(tabMode);
        tampiltabel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        txttempat_lahir = new javax.swing.JTextField();
        txttgl_lahir = new javax.swing.JTextField();
        txtalamat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnis = new javax.swing.JTextField();
        cmbkel = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        mastertable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 51));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel1.setText("FORM DATA SISWA");

        jPanel2.setBackground(new java.awt.Color(153, 255, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(430, 430, 430)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(545, 545, 545))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("nama");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("tempat_lahir");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("tgl_lahir");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("jenis_kelamin");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("alamat");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("nis");

        txtnis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnisActionPerformed(evt);
            }
        });

        cmbkel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnis, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbkel, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtnama, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txttempat_lahir, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txttgl_lahir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtnis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txttempat_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txttgl_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbkel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mastertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        mastertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mastertableMouseClicked(evt);
            }
        });
        mastertable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                mastertableAncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(mastertable);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jButton1.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jButton1)
                .addGap(27, 27, 27)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(35, 35, 35)
                .addComponent(jButton3)
                .addGap(28, 28, 28))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnisActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtnisActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       String nis=txtnis.getText();
       String nama=txtnama.getText();
       String tempat_lahir=txttempat_lahir.getText();
       String tgl_lahir=txttgl_lahir.getText();
       String jenis_kelamin=cmbkel.getSelectedItem().toString();
       String alamat=txtalamat.getText();
       
    if(nis.equals("")| (nama.equals("")) | (alamat.equals(""))){
       JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
       txtnis.requestFocus();
       
    }else{
           try{
               String sql ="Insert into siswa values (?,?,?,?,?,?)";
               PreparedStatement stat = konek.prepareCall(sql);
           try{
               stat.setString(1, nis);
               stat.setString(2, nama);
               stat.setString(3, tempat_lahir);
               stat.setString(4, tgl_lahir);
               stat.setString(5, jenis_kelamin);
               stat.setString(6, alamat);
               stat.executeUpdate();
               JOptionPane.showMessageDialog(null,"data tersimpan");
               tampiltabel();
           }catch(Exception e){
                  JOptionPane.showMessageDialog(null, "Ada kesalahan di" + e);
              }
           }catch(Exception se){
                  JOptionPane.showMessageDialog(null, "Ada kesalahan di" + se);
           }
       }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //update
        
        koneksi();
        
        int ok=JOptionPane.showConfirmDialog(null,"Anda yakin ingin mengedit data dengan nis" + txtnis.getText()+ "'","Konfirmasi Update Data",JOptionPane.YES_NO_CANCEL_OPTION);                               
        
        if (ok==0){
        try{
            String sql="Update siswa set nama='"+txtnama.getText()+"',tempat_lahir='"+txttempat_lahir.getText()+"',tgl_lahir='"+txttgl_lahir.getText()+"',jenis_kelamin='"+cmbkel.getSelectedItem().toString()+"',alamat='"+txtalamat.getText()+"'where nis='"+txtnis.getText()+"'";
            PreparedStatement stat = konek.prepareStatement(sql);
            try{
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil di Update");
                tampiltabel();
                hapus();
            }catch(SQLException e) {
                JOptionPane.showMessageDialog (null, "Ada Kesalahan di" + e);
            }     
            }catch(SQLException se) {
                JOptionPane.showMessageDialog(null, "Ada Kesalahan di" + se);
            }       
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        koneksi();
              
         int ok= JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data dengan nis ='"+txtnis.getText()+"'","Konfirmasi Hapus Data",JOptionPane.YES_NO_OPTION);         
           
         if (ok==0){
             try{
                 String sql= "delete from siswa where nis='"+txtnis.getText()+"'";
                 PreparedStatement stat = konek.prepareStatement(sql);
                 try{
                     stat.executeUpdate();
                     JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                     hapus();
                     tampiltabel();
                 }catch(Exception e){
                     JOptionPane.showMessageDialog(null, "Ada kesalahan di" +e);
                 }                         
             }catch(SQLException se){
               JOptionPane.showMessageDialog(null,"Ada kesalahan di" + se);
             }               
         }else{
             hapus();
             JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus....");
         }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void mastertableAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_mastertableAncestorMoved
        // TODO add your handling code here:
      
    }//GEN-LAST:event_mastertableAncestorMoved

    private void mastertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mastertableMouseClicked
        // TODO add your handling code here:
         int row = mastertable.rowAtPoint(evt.getPoint());
        
        String nis = mastertable.getValueAt(row,0).toString();
        txtnis.setText(nis);
        
        String nama = mastertable.getValueAt(row,1).toString();
        txtnama.setText(nama);
        
        
        String tempat_lahir = mastertable.getValueAt(row,2).toString();
        txttempat_lahir.setText(tempat_lahir);
        
        
        String tgl_lahir = mastertable.getValueAt(row,3).toString();
        txttgl_lahir.setText(tgl_lahir);
        
   
        String jenis_kelamin = mastertable.getValueAt(row,4).toString();
        cmbkel.setSelectedItem(jenis_kelamin);
        
        
        String alamat = mastertable.getValueAt(row,5).toString();
        txtalamat.setText(alamat);
        
        
    }//GEN-LAST:event_mastertableMouseClicked

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
            java.util.logging.Logger.getLogger(siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new siswa().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbkel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mastertable;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnis;
    private javax.swing.JTextField txttempat_lahir;
    private javax.swing.JTextField txttgl_lahir;
    // End of variables declaration//GEN-END:variables
}
