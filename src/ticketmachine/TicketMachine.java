/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketmachine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Radu
 */
public class TicketMachine extends javax.swing.JFrame {

    /**
     * Creates new form ShowTimes
     */
    //Objects that help in calling methods from other classes
    Miscellaneous miscellaneous = new Miscellaneous();
    DataBase dataBase = new DataBase();
    //Class attributes
    String insertedCODE = "", titleFinal = "", dayFinal = "", hoursFinal = "", adultFinal = "", seniorFinal = "", studentFinal = "", totalSumFinal = "";

    //Constructor that receives strings as parameters from other classes, they are null at first run
    public TicketMachine(String title, String day, String hours, String adult, String senior, String student, String totalSum) {
        setContentPane(new JLabel(new ImageIcon("ticketmachine.jpg")));
        initComponents();
        setTitle("Ticket Machine");
        setLocationRelativeTo(null);
        show_movie();
        //Setting the attributes value
        titleFinal = title;
        dayFinal = day;
        hoursFinal = hours;
        adultFinal = adult;
        seniorFinal = senior;
        studentFinal = student;
        totalSumFinal = totalSum;
        //Hiding buttons
        btnPurchaseTicket.setVisible(false);
        btnShowPayment.setVisible(false);
        btnPrintReceipt.setVisible(false);
        //If statements to set the label's new text and hide buttons as the user is progressing
        if (!title.equals("")) {
            btnShowTimes.setVisible(false);
            txtMovieCODE.setVisible(false);
            btnListMovies.setVisible(false);
        }
        if (!title.equals("") && adult.equals("")) {
            lblWelcome.setText("Now press Purchase Ticket!");
            btnPurchaseTicket.setVisible(true);
        } else if ((!adult.equals("") || !senior.equals("") || !student.equals("")) && totalSum.equals("")) {
            lblWelcome.setText("Now press Show Receipt!");
            btnShowPayment.setVisible(true);
        } else if (!totalSum.equals("")) {
            lblWelcome.setText("Now press Print Receipt!");
            btnPrintReceipt.setVisible(true);
        }
    }

    //Method that returns an array list that is displayed in the main menu table
    private ArrayList<Movie> moviesList() {
        ArrayList<Movie> moviesList = new ArrayList<>();
        try {
            Connection conObj = DriverManager.getConnection("jdbc:derby://localhost:1527/MovieDB", "use", "use");
            Statement statObj = conObj.createStatement();
            ResultSet resObj = statObj.executeQuery("Select CODE, TITLE, GENRES from LIST");
            Movie movie;
            while (resObj.next()) {
                movie = new Movie(resObj.getString("CODE"), resObj.getString("TITLE"), resObj.getString("GENRES"));
                moviesList.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moviesList;
    }

    //Method that populates the Java Table with the aray list
    private void show_movie() {
        ArrayList<Movie> list = moviesList();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getCode();
            row[1] = list.get(i).getTitle();
            row[2] = list.get(i).getGenres();
            model.addRow(row);
        }

    }

    //Method that saves the data to external file
    private void saveCSV() {
        if (!totalSumFinal.equals("")) {
            try {
                FileWriter fw = new FileWriter("tickets.csv", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.println(titleFinal + "," + dayFinal + "," + hoursFinal + "," + adultFinal + "," + seniorFinal + "," + studentFinal + "," + totalSumFinal);
                pw.flush();
                pw.close();
                lblWelcome.setText("Now check the project folder!");
                miscellaneous.correct_click();
            } catch (Exception e) {
                lblWelcome.setText("File does not exist!");
                miscellaneous.error_click();
            }
        } else {
            lblWelcome.setText("Don't skip steps!");
            miscellaneous.error_click();
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

        txtMovieCODE = new javax.swing.JTextField();
        btnShowTimes = new javax.swing.JButton();
        btnListMovies = new javax.swing.JButton();
        btnPurchaseTicket = new javax.swing.JButton();
        btnShowPayment = new javax.swing.JButton();
        btnPrintReceipt = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMovieCODE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMovieCODE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMovieCODE.setText("Type Code");
        txtMovieCODE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMovieCODEMouseClicked(evt);
            }
        });
        txtMovieCODE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMovieCODEActionPerformed(evt);
            }
        });
        txtMovieCODE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMovieCODEKeyPressed(evt);
            }
        });

        btnShowTimes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnShowTimes.setText("Show Times");
        btnShowTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowTimesActionPerformed(evt);
            }
        });

        btnListMovies.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnListMovies.setText("List Movies");
        btnListMovies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListMoviesActionPerformed(evt);
            }
        });

        btnPurchaseTicket.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPurchaseTicket.setText("Purchase Ticket");
        btnPurchaseTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseTicketActionPerformed(evt);
            }
        });

        btnShowPayment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnShowPayment.setText("Show Payment");
        btnShowPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowPaymentActionPerformed(evt);
            }
        });

        btnPrintReceipt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrintReceipt.setText("Print Receipt");
        btnPrintReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintReceiptActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome to Ticket Machine!");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE", "TITLE", "GENRE"
            }
        ));
        table.setEnabled(false);
        table.setFocusable(false);
        table.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMovieCODE, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnShowTimes)
                        .addGap(18, 18, 18)
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnListMovies)
                        .addGap(18, 18, 18)
                        .addComponent(btnPurchaseTicket)
                        .addGap(18, 18, 18)
                        .addComponent(btnShowPayment)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrintReceipt)))
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtMovieCODE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnShowTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblWelcome)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnListMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPurchaseTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrintReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowTimesActionPerformed
        //The text from the text field is sent as a parameter to bd method to search
        insertedCODE = txtMovieCODE.getText();
        String dbResult = dataBase.getMovieName(insertedCODE);
        //Statement that checks if the filtering returns a value
        if (!dbResult.equals("")) {
            ShowTimes showTimes = new ShowTimes(insertedCODE);
            showTimes.setVisible(true);
            miscellaneous.correct_click();
            this.dispose();
        } else {
            lblWelcome.setText("Incorrect Code! Insert a valid one!");
            miscellaneous.error_click();
        }
    }//GEN-LAST:event_btnShowTimesActionPerformed

    private void btnListMoviesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListMoviesActionPerformed
        //Statement that checks if the movie listing is populated
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (table.getRowCount() != 0) {
            for (int i = table.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            miscellaneous.correct_click();
        } else {
            show_movie();
            miscellaneous.correct_click();
        }
    }//GEN-LAST:event_btnListMoviesActionPerformed

    private void btnPurchaseTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseTicketActionPerformed
        //Statement that verifies if the movie title was previously selected
        if (!titleFinal.equals("")) {
            new PurchaseTicket(titleFinal, dayFinal, hoursFinal).setVisible(true);
            miscellaneous.correct_click();
            this.dispose();
        } else {
            lblWelcome.setText("Don't skip steps!");
            miscellaneous.error_click();
        }
    }//GEN-LAST:event_btnPurchaseTicketActionPerformed

    private void btnShowPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowPaymentActionPerformed
        //Statement that opens a new window if the attributes are not null
        try {
            new ShowPayment(titleFinal, dayFinal, hoursFinal, adultFinal, seniorFinal, studentFinal).setVisible(true);
            miscellaneous.correct_click();
            this.dispose();
        } catch (Exception e) {
            lblWelcome.setText("Don't skip steps!");
            miscellaneous.error_click();
        }
    }//GEN-LAST:event_btnShowPaymentActionPerformed

    private void btnPrintReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintReceiptActionPerformed
        //Event that calls the method to insert data into CSV
        saveCSV();
    }//GEN-LAST:event_btnPrintReceiptActionPerformed

    private void txtMovieCODEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMovieCODEMouseClicked
        //Statement that clears the text on click
        if (txtMovieCODE.getText().equals("Type Code") || lblWelcome.getText().equals("Incorrect Code! Insert a valid one!")) {
            txtMovieCODE.setText("");
        }
    }//GEN-LAST:event_txtMovieCODEMouseClicked

    private void txtMovieCODEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMovieCODEKeyPressed
        //Statement that clears the text on key press
        if (txtMovieCODE.getText().equals("Type Code")) {
            txtMovieCODE.setText("");
        }
    }//GEN-LAST:event_txtMovieCODEKeyPressed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        //Action that opens new a new window and closes the old one
        new TicketMachine("", "", "", "", "", "", "").setVisible(true);
        miscellaneous.correct_click();
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtMovieCODEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMovieCODEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMovieCODEActionPerformed

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
            java.util.logging.Logger.getLogger(TicketMachine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicketMachine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicketMachine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicketMachine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicketMachine("", "", "", "", "", "", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnListMovies;
    private javax.swing.JButton btnPrintReceipt;
    private javax.swing.JButton btnPurchaseTicket;
    private javax.swing.JButton btnShowPayment;
    private javax.swing.JButton btnShowTimes;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtMovieCODE;
    // End of variables declaration//GEN-END:variables
}
