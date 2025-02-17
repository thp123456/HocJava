/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.KhachHangDAO;
import DAO.NhanVienDAO;
import DAO.SQLServerProvider;
import POJO.KhachHang;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author tranc
 */
public class frmKhachHang extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmKhachHang
     */
     
    public frmKhachHang() {
        initComponents();
        ArrayList<KhachHang> dsNhanVien = KhachHangDAO.layDanhsachNhanVien();
        LoadForm(dsNhanVien);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblEmpployees = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        txtPosition = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtBirthYear = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Họ và Tên :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 180, -1, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Địa Chỉ :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 300, -1, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Quản Lý Khách Hàng");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 6, 410, 68));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Điểm TV");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 260, -1, 30));

        btnPrint.setBackground(new java.awt.Color(153, 153, 255));
        btnPrint.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/printer.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 440, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("SDT :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 380, -1, 30));

        jtblEmpployees.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jtblEmpployees.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblEmpployees.setRowHeight(30);
        jtblEmpployees.setShowHorizontalLines(true);
        jtblEmpployees.setShowVerticalLines(true);
        jtblEmpployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblEmpployeesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblEmpployees);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 885, 363));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("ID  :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 140, 90, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Năm Sinh :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 340, -1, 30));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 220, 230, -1));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        btnSearch.setOpaque(true);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, 40, 40));

        txtPosition.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        getContentPane().add(txtPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 260, 230, -1));

        txtAddress.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        getContentPane().add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 300, 230, -1));

        txtID.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtID.setEnabled(false);
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 140, 230, -1));

        txtPhone.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtPhone.setOpaque(true);
        getContentPane().add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 380, 230, -1));

        jButton3.setBackground(new java.awt.Color(241, 242, 242));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/update.png"))); // NOI18N
        jButton3.setText(" Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 440, -1, -1));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 180, 230, -1));

        jButton1.setBackground(new java.awt.Color(241, 242, 242));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user-avatar.png"))); // NOI18N
        jButton1.setText("Thêm Thành Viên");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 200, 40));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 230, 40));

        jButton2.setBackground(new java.awt.Color(241, 242, 242));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        jButton2.setText(" Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 440, -1, -1));

        txtBirthYear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        getContentPane().add(txtBirthYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 340, 230, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Email :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 220, -1, 30));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bg.jpg"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtblEmpployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblEmpployeesMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jtblEmpployees.getModel();
        int row = jtblEmpployees.getSelectedRow();
        if(row >=0){
            txtID.setText((String) jtblEmpployees.getValueAt(row, 0) );
            txtName.setText((String) jtblEmpployees.getValueAt(row, 1) );
            txtEmail.setText((String) jtblEmpployees.getValueAt(row, 2) );
            txtPosition.setText( String.valueOf(jtblEmpployees.getValueAt(row, 3)) );
            txtAddress.setText((String) jtblEmpployees.getValueAt(row, 4) );
            txtBirthYear.setText(String.valueOf(jtblEmpployees.getValueAt(row, 5)));
            txtPhone.setText((String) jtblEmpployees.getValueAt(row, 6) );
        }
    }//GEN-LAST:event_jtblEmpployeesMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         if(txtID.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Chưa chọn nhân viên cần xóa!");
        }
        else{
            KhachHangDAO.deleteKhachHang(txtID.getText());
            JOptionPane.showMessageDialog(this, "Đã xóa nhân viên"+txtName.getText());
            txtID.setText("");
            txtAddress.setText("");
            txtName.setText("");
            txtEmail.setText("");
            txtPosition.setText("");
            txtPhone.setText("");
            txtBirthYear.setText("");
            ArrayList<KhachHang> dsNhanVien = KhachHangDAO.layDanhsachNhanVien();
            LoadForm(dsNhanVien);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(txtID.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Chưa chọn nhân viên cần xóa!");
        }
        else{
            String idEmp = txtID.getText();
            String name = txtName.getText();
            String email= txtEmail.getText();
            String position= txtPosition.getText();
            String address= txtAddress.getText();
            String birthYear= txtBirthYear.getText();
            String phone= txtPhone.getText();
            KhachHangDAO.updateKhachHang(idEmp, name, email, position, address, birthYear, phone);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            ArrayList<KhachHang> dsNhanVien = KhachHangDAO.layDanhsachNhanVien();
            LoadForm(dsNhanVien);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         DangKyTheThanhVien fDangKy = new DangKyTheThanhVien();
         fDangKy.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
         String searchText = txtSearch.getText();
        LoadForm(KhachHangDAO.findKhachHang(searchText));
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
         if(txtID.getText().isEmpty())return;
        if(jtblEmpployees.getModel().getRowCount()<=0)return;
        XuatThe();
    }//GEN-LAST:event_btnPrintActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(frmKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmKhachHang().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblEmpployees;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBirthYear;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void LoadForm(ArrayList<KhachHang> dsNhanVien) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) this.jtblEmpployees.getModel();
        defaultTableModel.setColumnCount(0);
        defaultTableModel.setRowCount(0);
        defaultTableModel.addColumn("ID ");
        defaultTableModel.addColumn("Họ và Tên");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("Điểm Thưởng");
        defaultTableModel.addColumn("Địa Chỉ");
        defaultTableModel.addColumn("Năm Sinh");
        defaultTableModel.addColumn("Số Điện Thoại");
        for(KhachHang nv : dsNhanVien){
            Vector vec = new Vector();
            vec.add(nv.getIdEmp());
            vec.add(nv.getName());
            vec.add(nv.getEmail());
            vec.add(nv.getDiemThuong());
            vec.add(nv.getAddress());
            vec.add(nv.getBirthYear());
            vec.add(nv.getPhone());
            defaultTableModel.addRow(vec);
        }
        TableColumnModel columnModel = jtblEmpployees.getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(150); // Độ rộng cho cột "Name"
        columnModel.getColumn(2).setPreferredWidth(150);  // Độ rộng cho cột "Age"
        columnModel.getColumn(4).setPreferredWidth(100); 
        JTableHeader header = jtblEmpployees.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16)); // Font Arial, đậm, kích cỡ 14
    }

    private void XuatThe() {
    SQLServerProvider provider = new SQLServerProvider();
    provider.open();
    try {
        Hashtable<String, Object> map = new Hashtable<>();
        map.put("MaKH", txtID.getText());
        JasperReport report = JasperCompileManager.compileReport("src/GUI/reportTheThanhVien.jrxml");
        JasperPrint p = JasperFillManager.fillReport(report, map, provider.connection);
        JasperViewer.viewReport(p, false);
    } catch (JRException ex) {
        Logger.getLogger(frmBanHang.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
