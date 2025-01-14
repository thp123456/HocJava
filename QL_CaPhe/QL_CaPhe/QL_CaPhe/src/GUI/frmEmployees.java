/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import DAO.NhanVienDAO;
import POJO.Account;
import POJO.NhanVien;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author tranc
 */
public class frmEmployees extends javax.swing.JInternalFrame {
    ArrayList<NhanVien> dsNhanVien = new ArrayList<>();
    
        
    /**
     * Creates new form Product
     */
    public frmEmployees() {
        initComponents();
        dsNhanVien = NhanVienDAO.layDanhsachNhanVien();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblEmpployees = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        xemchitiet = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1334, 729));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Quản Lý Nhân Sự ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 6, 410, 68));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jtblEmpployees.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
        jtblEmpployees.setRowHeight(50);
        jtblEmpployees.setShowHorizontalLines(true);
        jtblEmpployees.setShowVerticalLines(true);
        jtblEmpployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblEmpployeesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblEmpployees);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 135, 1250, 363));

        jButton1.setBackground(new java.awt.Color(241, 242, 242));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user-avatar.png"))); // NOI18N
        jButton1.setText("Thêm Nhân Viên");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 500, 200, 40));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 100, 230, 40));

        jButton2.setBackground(new java.awt.Color(241, 242, 242));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        jButton2.setText(" Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 500, -1, -1));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        btnSearch.setOpaque(true);
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchMouseExited(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 100, 40, 40));

        xemchitiet.setBackground(new java.awt.Color(241, 242, 242));
        xemchitiet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        xemchitiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/update.png"))); // NOI18N
        xemchitiet.setText("Xem Chi Tiết");
        xemchitiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xemchitietMouseClicked(evt);
            }
        });
        xemchitiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemchitietActionPerformed(evt);
            }
        });
        getContentPane().add(xemchitiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 500, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bg.jpg"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        // TODO add your handling code here:
         btnSearch.setOpaque(false);
    }//GEN-LAST:event_btnSearchMouseExited

    private void jtblEmpployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblEmpployeesMouseClicked
        // TODO add your handling code here:
//        DefaultTableModel model = (DefaultTableModel) jtblEmpployees.getModel();
//        int row = jtblEmpployees.getSelectedRow();
//        if(row >=0){
//            txtID.setText((String) jtblEmpployees.getValueAt(row, 0) );
//            txtName.setText((String) jtblEmpployees.getValueAt(row, 1) );
//            txtEmail.setText((String) jtblEmpployees.getValueAt(row, 2) );
//            txtPosition.setText((String) jtblEmpployees.getValueAt(row, 3) );
//            txtAddress.setText((String) jtblEmpployees.getValueAt(row, 4) );
//            txtBirthYear.setText(String.valueOf(jtblEmpployees.getValueAt(row, 5)));
//            txtPhone.setText((String) jtblEmpployees.getValueAt(row, 6) );
//        }
    }//GEN-LAST:event_jtblEmpployeesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DangKy fDangKy = new DangKy();
        fDangKy.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = jtblEmpployees.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(this, "Chưa chọn nhân viên cần xóa!");
        }
        else{
            String idEmp = String.valueOf(jtblEmpployees.getValueAt(row, 0));
            NhanVienDAO.deleteEmployee(idEmp);
            JOptionPane.showMessageDialog(this, "Đã xóa nhân viên"+jtblEmpployees.getValueAt(row, 1).toString());
        }
        dsNhanVien.clear();
        dsNhanVien = NhanVienDAO.layDanhsachNhanVien();
        LoadForm(dsNhanVien);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
                dsNhanVien.clear();
                dsNhanVien = NhanVienDAO.layDanhsachNhanVien();
                LoadForm(dsNhanVien);
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String searchText = txtSearch.getText();
        LoadForm(NhanVienDAO.findEmployee(searchText));
    }//GEN-LAST:event_btnSearchActionPerformed

    private void xemchitietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemchitietActionPerformed
        // TODO add your handling code here:
        int row = jtblEmpployees.getSelectedRow();
        if(row >= 0){
            NhanVien emp = new NhanVien();
            emp = dsNhanVien.get(row);
            DetailsEmployee f = new DetailsEmployee(emp);
            f.setVisible(true);
        }
          dsNhanVien.clear();
         dsNhanVien = NhanVienDAO.layDanhsachNhanVien();
         LoadForm(dsNhanVien);
    }//GEN-LAST:event_xemchitietActionPerformed

    private void xemchitietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xemchitietMouseClicked
        // TODO add your handling code here:
        int row = jtblEmpployees.getSelectedRow();
        if(row > 0){
            NhanVien emp = new NhanVien();
            emp = dsNhanVien.get(row);
            DetailsEmployee f = new DetailsEmployee(emp);
            f.setVisible(true);
        }
          LoadForm(dsNhanVien);
    }//GEN-LAST:event_xemchitietMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblEmpployees;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JButton xemchitiet;
    // End of variables declaration//GEN-END:variables
    public void LoadForm(ArrayList<NhanVien> dsNhanVien){
        
        DefaultTableModel defaultTableModel = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 7) { // Cột hình ảnh
                    return ImageIcon.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        defaultTableModel.setColumnCount(0);
        defaultTableModel.setRowCount(0);
        defaultTableModel.addColumn("ID ");
        defaultTableModel.addColumn("Họ và Tên");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("Chức vụ");
        defaultTableModel.addColumn("Địa Chỉ");
        defaultTableModel.addColumn("Năm Sinh");
        defaultTableModel.addColumn("Số Điện Thoại");
        
        for(NhanVien nv : dsNhanVien){
            Vector vec = new Vector();
            vec.add(nv.getIdEmp());
            vec.add(nv.getName());
            vec.add(nv.getEmail());
            vec.add(nv.getPosition());
            vec.add(nv.getAddress());
            vec.add(nv.getBirthYear());
            vec.add(nv.getPhone());
            
            
            defaultTableModel.addRow(vec);
        }
        jtblEmpployees.setModel(defaultTableModel);
//        TableColumnModel columnModel = jtblEmpployees.getColumnModel();
//        columnModel.getColumn(1).setPreferredWidth(150); 
//        columnModel.getColumn(2).setPreferredWidth(150);  
//        JTableHeader header = jtblEmpployees.getTableHeader();
//        header.setFont(new Font("Arial", Font.BOLD, 16)); // Font Arial, đậm, kích cỡ 14
    }
public static ImageIcon createImageIcon(String path, int width, int height) {
    if (path == null || path.isEmpty()) {
        return null;
    }
    ImageIcon imageIcon = new ImageIcon(path);
    if (imageIcon.getImageLoadStatus() == java.awt.MediaTracker.ERRORED) {
        return null;
    }
    Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    imageIcon = new ImageIcon(scaledImage);
    return imageIcon;
}

}
