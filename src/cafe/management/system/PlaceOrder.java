/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cafe.management.system;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import dao.BillDao;
import dao.CategoryDao;
import dao.ProductDao;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Bill;
import model.Category;
import model.Product;

/**
 *
 * @author yassine
 */
public class PlaceOrder extends javax.swing.JFrame {
    public String userEmail;
    
    public int billId=1;
    public int grandTotal = 0;
    public int productPrice =0;
    public int productTotal =0;
    
    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobileNumberPattern= "^[0-9]*$";

    /**
     * Creates new form PlaceOrder
     */
    public PlaceOrder() {
        initComponents();
    }
    public PlaceOrder(String email) {
        initComponents();
        txtProdName.setEditable(false);
        txtProdPrice.setEditable(false);
        txtProdTotal.setEditable(false);
        btnAddtoCart.setEnabled(false);
        btnGenerate.setEnabled(false);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) jSpinner1.getEditor()).getTextField();
        tf.setEditable(false);
        userEmail = email;
    }
    
    public void productNameByCategory(String category){
        DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDao.getAllRecordsByCategory(category);
        Iterator<Product> itr = list.iterator();
        while(itr.hasNext()){
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getName()});
        }
    }
    
    public void filterProductByName(String name,String category){
        DefaultTableModel dtm =(DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDao.filterProductByname(name,category);
        Iterator<Product> itr = list.iterator();
        while(itr.hasNext()){
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getName()});
        }
    }
    
    public void clearProdFields(){
        txtProdName.setText("");
        txtProdPrice.setText("");
        txtProdTotal.setText("");
        jSpinner1.setValue(1);
        btnAddtoCart.setEnabled(false);
    }
    
    public void validateField(){
        String customerName = txtCustName.getText();
        String customerMoblieNumber = txtCustNumber.getText();
        String customerEmail = txtCustEmail.getText();
        if(!customerEmail.equals("") && customerMoblieNumber.matches(mobileNumberPattern) && customerMoblieNumber.length()==10 && customerEmail.matches(emailPattern) && grandTotal > 0){
            btnGenerate.setEnabled(true);
        }
        else{
            btnGenerate.setEnabled(false);
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

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelId = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCustName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCustNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCustEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtProdName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtProdPrice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        txtProdTotal = new javax.swing.JTextField();
        btnclear = new javax.swing.JButton();
        btnAddtoCart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        grandTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLblGtotal = new javax.swing.JLabel();
        btnGenerate = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(50, 5));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/place order.png"))); // NOI18N
        jLabel1.setText("Place Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 15, 123, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1317, 15, -1, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Bill ID :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 90, -1, -1));

        jLabelId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelId.setText("--");
        getContentPane().add(jLabelId, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 90, 49, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Customer Details :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 131, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Name :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 172, 53, -1));

        txtCustName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCustName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCustNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtCustName, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 210, 303, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Moblie Number :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 254, 101, -1));

        txtCustNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCustNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCustNumberKeyReleased(evt);
            }
        });
        getContentPane().add(txtCustNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 292, 303, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Email :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 336, 50, 16));

        txtCustEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCustEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCustEmailKeyReleased(evt);
            }
        });
        getContentPane().add(txtCustEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 370, 303, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Category :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 90, 78, -1));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 128, 251, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Search :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 172, -1, -1));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 210, 251, -1));

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 254, 251, 410));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Name :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, 57, -1));

        txtProdName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtProdName, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 128, 251, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Price :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1056, 90, 43, -1));

        txtProdPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtProdPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1056, 128, 251, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Quantity :");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 172, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Total :");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1056, 172, -1, -1));

        jSpinner1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, 251, -1));

        txtProdTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtProdTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1056, 210, 251, -1));

        btnclear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        getContentPane().add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 254, 102, -1));

        btnAddtoCart.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddtoCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add to cart.png"))); // NOI18N
        btnAddtoCart.setText("Add to Cart");
        btnAddtoCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddtoCartActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddtoCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1175, 254, -1, -1));

        grandTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        grandTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity", "Total"
            }
        ));
        grandTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grandTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(grandTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 299, 560, 360));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Grand Total :");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 690, -1, -1));

        jLblGtotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLblGtotal.setText("000");
        getContentPane().add(jLblGtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 690, 40, -1));

        btnGenerate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/generate bill & print.png"))); // NOI18N
        btnGenerate.setText("Genarate Bill & Print");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 680, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallpaperflare.com_wallpaper.jpg"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddtoCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddtoCartActionPerformed
        // TODO add your handling code here:
        String name = txtProdName.getText();
        String price = txtProdPrice.getText();
        String quantity = String.valueOf(jSpinner1.getValue());
        DefaultTableModel dtm = (DefaultTableModel) grandTable.getModel();
        dtm.addRow(new Object[]{name,price,quantity,productTotal});
        grandTotal = grandTotal + productTotal;
        jLblGtotal.setText(String.valueOf(grandTotal));
        
        clearProdFields();
        validateField();
    }//GEN-LAST:event_btnAddtoCartActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Home(userEmail).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        billId = Integer.parseInt(BillDao.getId());
        jLabelId.setText(BillDao.getId());
        ArrayList<Category> list = CategoryDao.getAllRecords();
        Iterator<Category> itr = list.iterator();
        while(itr.hasNext()){
            Category categoryObj = itr.next();
            jComboBox1.addItem(categoryObj.getName());
        }
        String category = (String) jComboBox1.getSelectedItem();
        productNameByCategory(category);
    }//GEN-LAST:event_formComponentShown

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String name = txtSearch.getText();
        String category = (String) jComboBox1.getSelectedItem();
        filterProductByName(name, category);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String ProductName = model.getValueAt(index, 0).toString();
        Product product = ProductDao.getProductByname(ProductName);
        txtProdName.setText(product.getName());
        txtProdPrice.setText(product.getPrice());
        jSpinner1.setValue(1);
        txtProdTotal.setText(product.getPrice());
        productPrice = Integer.parseInt(product.getPrice());
        productTotal = Integer.parseInt(product.getPrice());
        btnAddtoCart.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        int quantity =(Integer) jSpinner1.getValue();
        if(quantity<=1){
            jSpinner1.setValue(1);
            quantity = 1;
        } 
        productTotal = productPrice * quantity;
        txtProdTotal.setText(String.valueOf(productTotal));
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String category = (String) jComboBox1.getSelectedItem();
        productNameByCategory(category);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        clearProdFields();
    }//GEN-LAST:event_btnclearActionPerformed

    private void txtCustNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustNameKeyReleased
        // TODO add your handling code here:
        validateField();
    }//GEN-LAST:event_txtCustNameKeyReleased

    private void txtCustNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustNumberKeyReleased
        // TODO add your handling code here:
        validateField();
    }//GEN-LAST:event_txtCustNumberKeyReleased

    private void txtCustEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustEmailKeyReleased
        // TODO add your handling code here:
        validateField();
    }//GEN-LAST:event_txtCustEmailKeyReleased

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        // TODO add your handling code here:
        String customerName = txtCustName.getText();
        String customerMobileNumber = txtCustNumber.getText();
        String customerEmail = txtCustEmail.getText(); 
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String todaydate = dFormat.format(date);
        String total = String.valueOf(grandTotal);
        String createBy = userEmail;
        
        Bill bill =new Bill();
        bill.setId(billId);
        bill.setName(customerName);
        bill.setMoblieNumber(customerMobileNumber);
        bill.setEmail(customerEmail);
        bill.setDate(todaydate);
        bill.setTotal(total);
        bill.setCreateBy(createBy);
        
        BillDao.save(bill);
        
        //Create Doc
        String path = "D:\\";
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
        try{
            PdfWriter.getInstance(doc, new FileOutputStream(path+""+billId+".pdf"));
            doc.open();
            Paragraph cafeName = new Paragraph("                                                            ADIA CAFE\n");
            doc.add(cafeName);
            Paragraph starline = new Paragraph("****************************************************************************************************************");
            doc.add(starline);
            Paragraph p1 = new Paragraph("\tBill ID :"+billId+"\nCostomer Name :"+customerName+"\nTotel Paid :"+grandTotal);
            doc.add(p1);
            doc.add(starline);
            PdfPTable tb1 = new PdfPTable(4);
            tb1.addCell("Name");
            tb1.addCell("Price");
            tb1.addCell("Quantity");
            tb1.addCell("Total");
            for(int i=0; i<grandTable.getRowCount();i++){
                String n = grandTable.getValueAt(i, 0).toString();
                String p = grandTable.getValueAt(i, 1).toString();
                String q = grandTable.getValueAt(i, 2).toString();
                String t = grandTable.getValueAt(i, 3).toString();
                tb1.addCell(n);
                tb1.addCell(p);
                tb1.addCell(q);
                tb1.addCell(t);
            }
            doc.add(tb1);
            doc.add(starline);
            Paragraph msg = new Paragraph("Thank you, Please visit Again");
            //open pdf
            OpenPdf.openById(String.valueOf(billId));
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        doc.close();
        setVisible(false);
        new PlaceOrder(createBy).setVisible(true);
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void grandTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grandTableMouseClicked
        // TODO add your handling code here:
        int index = grandTable.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this product ?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            TableModel model = grandTable.getModel();
            String total = model.getValueAt(index, 3).toString();
            grandTotal = grandTotal - Integer.parseInt(total);
            jLblGtotal.setText(String.valueOf(grandTotal));
            ((DefaultTableModel) grandTable.getModel()).removeRow(index);
        }
    }//GEN-LAST:event_grandTableMouseClicked

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
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddtoCart;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnclear;
    private javax.swing.JTable grandTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLblGtotal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCustEmail;
    private javax.swing.JTextField txtCustName;
    private javax.swing.JTextField txtCustNumber;
    private javax.swing.JTextField txtProdName;
    private javax.swing.JTextField txtProdPrice;
    private javax.swing.JTextField txtProdTotal;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}