/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketmachine;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Radu
 */
public class ShowTimes extends javax.swing.JFrame {

    //Objects that help in calling methods from other classes 
    Miscellaneous miscellaneous = new Miscellaneous();
    DataBase dataBase = new DataBase();
    //Class attributes
    String ID = "", title = "", day = "", hours = "", code = "";

    /**
     * Creates new form NewJFrame
     */
    //Constructor that receives a string as parameter from TicketMachine class
    public ShowTimes(String code) {
        setContentPane(new JLabel(new ImageIcon("showtimes.jpg")));
        initComponents();
        setTitle("Show Times");
        setLocationRelativeTo(null);
        btnAccept.setVisible(false);
        show_movie(code);
        lblCode.setText(code);
        String movieTitle = dataBase.getMovieName(code);
        txtMovieSelected.setText(movieTitle);
    }

    //Method that returns an array list with results from the code filter
    private ArrayList<Movie> moviesList(String code) {
        ArrayList<Movie> moviesList = new ArrayList<>();
        try {
            Connection conObj = DriverManager.getConnection("jdbc:derby://localhost:1527/MovieDB", "use", "use");
            Statement statObj = conObj.createStatement();
            ResultSet resObj = statObj.executeQuery("Select DAY, HOURS from MOVIES Where CODE = '" + code + "'");
            Movie movie;
            while (resObj.next()) {
                movie = new Movie(resObj.getString("DAY"), resObj.getString("HOURS"));
                moviesList.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moviesList;
    }

    //Method that populates the Java Table with the aray list
    private void show_movie(String code) {
        ArrayList<Movie> list = moviesList(code);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row = new Object[2];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getDay();
            row[1] = list.get(i).getHour();
            model.addRow(row);
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

        lblSelectPeriod = new javax.swing.JLabel();
        txtMovieSelected = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtDaySelected = new javax.swing.JTextField();
        txtHoursSelected = new javax.swing.JTextField();
        btnAccept = new javax.swing.JButton();
        lblChosenCode = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSelectPeriod.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSelectPeriod.setText("SELECT A ROW ");

        txtMovieSelected.setEditable(false);
        txtMovieSelected.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMovieSelected.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMovieSelected.setText("TITLE");
        txtMovieSelected.setFocusable(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Day", "Hours"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        txtDaySelected.setEditable(false);
        txtDaySelected.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDaySelected.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDaySelected.setText("DAY");
        txtDaySelected.setFocusable(false);

        txtHoursSelected.setEditable(false);
        txtHoursSelected.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtHoursSelected.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHoursSelected.setText("HOUR");
        txtHoursSelected.setFocusable(false);

        btnAccept.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAccept.setText("Accept Movie");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        lblChosenCode.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblChosenCode.setText("Chosen Code:");

        lblCode.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCode.setText("Code");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCode, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblChosenCode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSelectPeriod))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtMovieSelected, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDaySelected, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtHoursSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAccept)
                                .addGap(60, 60, 60)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblChosenCode)
                    .addComponent(lblSelectPeriod))
                .addGap(7, 7, 7)
                .addComponent(lblCode)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMovieSelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(txtDaySelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHoursSelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        //Statement that checks if the text boxes have changed their values
        title = txtMovieSelected.getText();
        day = txtDaySelected.getText();
        hours = txtHoursSelected.getText();
        if (!day.equals("DAY") && !hours.equals("HOUR")) {
            TicketMachine ticketMachine = new TicketMachine(title, day, hours, "", "", "", "");
            ticketMachine.setVisible(true);
            miscellaneous.correct_click();
            this.dispose();
        } else {
            lblSelectPeriod.setText("Select a time slot");
            miscellaneous.error_click();
        }
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        //Method that gets the day and hour from the selected row
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRow = table.getSelectedRow();
        txtDaySelected.setText(model.getValueAt(selectedRow, 0).toString());
        txtHoursSelected.setText(model.getValueAt(selectedRow, 1).toString());
        btnAccept.setVisible(true);
    }//GEN-LAST:event_tableMouseClicked

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
            java.util.logging.Logger.getLogger(ShowTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowTimes("").setVisible(true);
            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblChosenCode;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblSelectPeriod;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtDaySelected;
    private javax.swing.JTextField txtHoursSelected;
    private javax.swing.JTextField txtMovieSelected;
    // End of variables declaration//GEN-END:variables
}