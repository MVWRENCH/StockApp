/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import stock.model.TransactionModel;
import stock.service.ItemService;
import stock.service.ItemServiceImpl;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author reynn
 */
public class ItemForm extends javax.swing.JFrame {
    private DefaultTableModel tableModel;
    private Connection connection;
    
    private ItemService itemService;
    
    public ItemForm(ItemService itemService) {
        this.itemService = itemService;
    }
    /**
     * Creates new form FormUtama
     */
    public ItemForm() {
        initComponents();
        initTable();
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        custName = new javax.swing.JTextField();
        idObat = new javax.swing.JTextField();
        jumlah = new javax.swing.JTextField();
        money = new javax.swing.JTextField();
        _returns = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        btnPrint = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        totalHarga = new javax.swing.JTextField();
        checkPrice = new javax.swing.JButton();
        checkMoney = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Stock");

        jLabel1.setText("Nama Customer");

        jLabel2.setText("ID Obat");

        jLabel3.setText("Jumlah");

        jLabel4.setText("Total Harga");

        jLabel5.setText("Uang");

        jLabel6.setText("Kembalian");

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
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
        itemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(itemTable);

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnSave.setText("Simpan");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        totalHarga.setEditable(false);
        totalHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalHargaActionPerformed(evt);
            }
        });

        checkPrice.setText("Harga");
        checkPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPriceActionPerformed(evt);
            }
        });

        checkMoney.setText("Uang");
        checkMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMoneyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPrint)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                                .addComponent(btnBatal))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idObat, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                    .addComponent(jumlah)
                                    .addComponent(money)
                                    .addComponent(_returns)
                                    .addComponent(totalHarga)
                                    .addComponent(custName))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(checkPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBatal, btnPrint, btnSave});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(custName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(totalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkPrice))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(money, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkMoney))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(_returns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrint)
                    .addComponent(btnSave)
                    .addComponent(btnBatal))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        TransactionModel data = new TransactionModel();
        data.setName(custName.getText());
        data.setAdmin("Admin");
        data.setDate_buy(LocalDate.now());
        data.setItem_id((int) Integer.parseInt(idObat.getText()));
        data.setQty((int) Integer.parseInt(jumlah.getText()));
        data.setTotal_price(Double.valueOf(totalHarga.getText()));
        
        ItemService itemService = new ItemServiceImpl();
        itemService.insert(data);
        
        loadData();
        reset();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        ItemService itemService = new ItemServiceImpl();
        List<Object[]> resultList =  itemService.report(custName.getText());
        
        String customString = String.format("%-15s | %-25s | %-15s%n", "No Transaksi", "Nama Obat", "Total Harga");

        for (int i = 0; i < resultList.size(); i++) {
            Object[] resultRow = resultList.get(i);

            int nomorTransaksi = (int) resultRow[3];
            String namaObat = (String) resultRow[2];
            double totalHarga = (double) resultRow[1];

            customString += String.format("%-15d | %-25s | %-15.2f%n", nomorTransaksi, namaObat, totalHarga);
        }

        System.out.println(customString);
        String report = "Nota Pembelian \n" + 
                        "\n Tanggal                 : " + LocalDate.now() +
                        "\n Nama Kasir          : " + "ADMIN" + 
                        "\n Nama Customer    : " + custName.getText() + "\n" +
                        customString;
        generatePDF("nota.pdf", report);

    }//GEN-LAST:event_btnPrintActionPerformed

    private void generatePDF(String filePath, String content) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
            try (InputStream fontStream = getClass().getResourceAsStream("/stock/resources/Montserrat-Regular.ttf")) {
                PDType0Font font = PDType0Font.load(document, fontStream);

                try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                    contentStream.setFont(font, 12);
                    
                    float margin = 50;
                    float yStart = page.getMediaBox().getHeight() - margin;
                    float yPosition = yStart;

                    // Set the line height
                    float lineHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * 12;

                    // Split the content into lines and add each line with newline
                    String[] lines = content.split("\\n");
                    for (String line : lines) {
                        if (yPosition - lineHeight < margin) {
                            // Create a new page if the content exceeds the current page
                            contentStream.endText();
                            contentStream.close();
                            page = new PDPage();
                            document.addPage(page);
                            contentStream.moveTo(margin, page.getMediaBox().getHeight() - margin);
                            yPosition = page.getMediaBox().getHeight() - margin;
                        }

                        contentStream.beginText();
                        contentStream.newLineAtOffset(margin, yPosition -= lineHeight);
                        contentStream.showText(line);
                        contentStream.endText();
                    }
                }
            }
            document.save(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void itemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_itemTableMouseClicked

    private void totalHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalHargaActionPerformed

    private void checkPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPriceActionPerformed
        // TODO add your handling code here:
        ItemService itemService = new ItemServiceImpl();
        Double basePrice = itemService.getPrice((int) Integer.parseInt(idObat.getText()));
        int qty = (int) Integer.parseInt(jumlah.getText());
        Double totalPrice = basePrice * qty;
        totalHarga.setText(totalPrice.toString());
    }//GEN-LAST:event_checkPriceActionPerformed

    private void checkMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMoneyActionPerformed
        // TODO add your handling code here:
        Double totalPrice = Double.valueOf(totalHarga.getText());
        Double _money = Double.valueOf(money.getText());
        Double ret = _money - totalPrice;
        _returns.setText(ret.toString());
    }//GEN-LAST:event_checkMoneyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ItemForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField _returns;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton checkMoney;
    private javax.swing.JButton checkPrice;
    private javax.swing.JTextField custName;
    private javax.swing.JTextField idObat;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField money;
    private javax.swing.JTextField totalHarga;
    // End of variables declaration//GEN-END:variables

    private void initTable(){
        tableModel = new DefaultTableModel();
        itemTable.setModel(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("Item Name");
        tableModel.addColumn("Price");
        tableModel.addColumn("Stock");
    }
    
    private void loadData(){
        //menghapus seluruh data yg ada di tabel
        tableModel.getDataVector().removeAllElements();
        //pemberitahuan tabel telah kosong
        tableModel.fireTableDataChanged();
        
        try{
            connection = ItemDatabase.getConnection();
            String query = "SELECT * FROM items";
            
            Statement statement = (Statement) connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            //mengisi tabel dgn data hasil query
            while (resultSet.next()){
                Object[] item = new Object[4];
                item[0] = resultSet.getString("id");
                item[1] = resultSet.getString("name");
                item[2] = resultSet.getDouble("price");
                item[3] = resultSet.getInt("qty");
                tableModel.addRow(item);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void reset(){
        custName.setText("");
        idObat.setText("");
        money.setText("");
        jumlah.setText("");
        _returns.setText("");
        totalHarga.setText("");
    }
}