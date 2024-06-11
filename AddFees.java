/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.niufeemanagment;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Deepak Kumar
 */
public class AddFees extends javax.swing.JFrame {

    /**
     * Creates new form AddFees
     */
    
    

    
   private void displayCashFirst() {
      dd_number .setVisible(false);
      cnumber.setVisible(false);
      bname.setVisible(false);
      ddt.setVisible(false);
      ct.setVisible(false);
      bnt.setVisible(false);
               
    }
  boolean Validation()
  { 
       if(rname.getText().equals(""))
     {
       JOptionPane.showMessageDialog(this,"Enter Reciever Name");
           return false;       
     }
     if(rollt.getText().equals("") || rollt.getText().matches("[0-9]+")==false) {
         JOptionPane.showMessageDialog(this,"Enter Ammount (in number) ");
        return false;   
       }
    
     
     if(combobox.getSelectedItem().toString().equalsIgnoreCase("Cheque"))
     {
         if(ct.getText().equals(""))
         {
           JOptionPane.showMessageDialog(this,"Enter Cheque Number ");
           return false;     
         }
         if(bnt.getText().equals(""))
         {
           JOptionPane.showMessageDialog(this,"Enter Bank Name ");
           return false;     
         }
     }
     if(combobox.getSelectedIndex()==0)
     {
         if(ddt.getText().equals(""))
         {
           JOptionPane.showMessageDialog(this,"Enter DD Number ");
           return false;     
         }
         if(bnt.getText().equals(""))
         {
           JOptionPane.showMessageDialog(this,"Enter Bank Name ");
           return false;     
         }
     }
       if(combobox.getSelectedItem().toString().equalsIgnoreCase("phone pay"))
     {
         if(upit.getText().equals(""))
         {
           JOptionPane.showMessageDialog(this,"Enter UPI  Number ");
           return false;     
         }
         
     }
       if(combobox.getSelectedItem().toString().equalsIgnoreCase("Google Pay"))
     {
         if(upit.getText().equals(""))
         {
           JOptionPane.showMessageDialog(this,"Enter UPI  Number ");
           return false;     
         }
         
     }
         return true;
       
  }
  
   public void fillComboBox()
  {
      try
      {
       Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/niufee?zeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection con =  DriverManager.getConnection(url,"root","Deepaksingh@09");
        String sql = "select CNAME from course";
        PreparedStatement st = con.prepareStatement(sql);
       ResultSet  rs = st.executeQuery(sql);
       while(rs.next())
       {
           courset.addItem(rs.getString("CNAME"));
       }
      
      }
      catch(Exception e)
      {
          e.printStackTrace();
          
      }
  }
   public int getRun()
   {
    int rno=0;
      try
      {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/niufee?zeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection con =  DriverManager.getConnection(url,"root","Deepaksingh@09");
        PreparedStatement st = con.prepareStatement("select max(reciept_no) from fees_details");
        ResultSet  rs = st.executeQuery();
        if(rs.next()==true)
        {
         rno =  rs.getInt(1);
        }
      
      }
      catch(Exception e1)
      {
          e1.printStackTrace();
          
      }
 
       return rno;
   }
   
   public String insertData()
   {
       String status="";
       int recieptno = Integer.parseInt(rnumbert.getText());
       String sname = rname.getText();
       int rollno = Integer.parseInt(rollt.getText());
       String payment = combobox.getSelectedItem().toString();
       String cheque =ct.getText();
       String bankname = bnt.getText();
       String ddname = ddt.getText();
       String  coursename = courset.getSelectedItem().toString();
       
       float total =Float. parseFloat(totall.getText());
       
       float amount =Float. parseFloat(txt_amount1.getText());
       float cgst =Float. parseFloat(cgstTextField.getText());
       float sgst =Float. parseFloat( sgstTextField.getText());
       
       String remark = remarkt.getText();
       
       try
       {
         Class.forName("com.mysql.cj.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/niufee?zeroDateTimeBehavior=CONVERT_TO_NULL";
        Connection con =  DriverManager.getConnection(url,"root","Deepaksingh@09");
        String sql = "insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setInt(1, recieptno);
        st.setString(2,sname);
        st.setInt(3,rollno);
        st.setString(4,cheque);
        st.setString(5,bankname);
        st.setString(6,ddname);
        st.setString(7,coursename);
        st.setFloat(8,total);
        st.setFloat(9,amount); 
        st.setFloat(10, cgst);
        st.setFloat(11, sgst);
        st.setString(12,remark); 
        
      int count =  st.executeUpdate();
      
      if(count == 1)
      {
          status ="success";
      }
      else
      {
          status="failed";
      }
               
       }
       catch(Exception e1)
       {
        e1.printStackTrace();
       }
       
       
       
   return status;    
       
       
   }
 

    public AddFees() {
        initComponents();
        displayCashFirst();
        fillComboBox();
      int r =  getRun();
      r++;
      rnumbert.setText(Integer.toString(r));  
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        bname = new javax.swing.JLabel();
        rnumber = new javax.swing.JLabel();
        mop = new javax.swing.JLabel();
        bnt = new javax.swing.JTextField();
        combobox = new javax.swing.JComboBox<>();
        rnumbert = new javax.swing.JTextField();
        dd_number = new javax.swing.JLabel();
        ddt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        head_txt = new javax.swing.JTextField();
        rollt = new javax.swing.JTextField();
        cgstTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        sgstTextField = new javax.swing.JTextField();
        totall = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        remarkt = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        print = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_amount1 = new javax.swing.JTextField();
        cnumber = new javax.swing.JLabel();
        ct = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        courset = new javax.swing.JComboBox<>();
        upiid = new javax.swing.JLabel();
        upit = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(204, 255, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 240, -1));

        jButton2.setBackground(new java.awt.Color(204, 255, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("SEARCH RECORD");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 240, -1));

        jButton3.setBackground(new java.awt.Color(204, 255, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("LOGOUT");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 240, -1));

        jButton5.setBackground(new java.awt.Color(204, 255, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setText("ADD COURSE");
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 240, -1));

        jButton6.setBackground(new java.awt.Color(204, 255, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setText("VIWE ALL RECORD");
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 240, -1));

        jButton7.setBackground(new java.awt.Color(204, 255, 0));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton7.setText("HOME");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 240, -1));

        jButton8.setBackground(new java.awt.Color(204, 255, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton8.setText("EDIT COURSE");
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 240, -1));

        jButton9.setBackground(new java.awt.Color(204, 255, 0));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton9.setText("COURSE LIST");
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 240, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 740));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bname.setText("Bank Name");
        jPanel3.add(bname, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 120, 30));

        rnumber.setText("Reciept Number");
        jPanel3.add(rnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 120, 30));

        mop.setText("Mode Of Payment");
        jPanel3.add(mop, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 120, 30));
        jPanel3.add(bnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 180, 30));

        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "Cash", "Cheque", "Phone Pay", "Google Pay" }));
        combobox.setSelectedIndex(1);
        combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxActionPerformed(evt);
            }
        });
        jPanel3.add(combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 180, 30));
        jPanel3.add(rnumbert, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 180, 30));

        dd_number.setText("DD Number");
        jPanel3.add(dd_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 120, 30));
        jPanel3.add(ddt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 180, 30));

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Sr No..");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 110, 20));

        jLabel9.setText("Head");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 100, 20));

        jLabel10.setText("Amount");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 110, 20));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 720, 20));
        jPanel2.add(head_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 210, -1));

        rollt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rolltActionPerformed(evt);
            }
        });
        jPanel2.add(rollt, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 160, 30));
        jPanel2.add(cgstTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 160, -1));

        jLabel11.setText("SGST 7%");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 70, 20));

        jLabel12.setText("GST 7%");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 70, 20));
        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 240, 0));

        jLabel13.setText("Total");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, -1));
        jPanel2.add(sgstTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 160, -1));
        jPanel2.add(totall, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 160, -1));

        jLabel15.setText("Remark");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 70, 20));

        remarkt.setColumns(20);
        remarkt.setRows(5);
        jScrollPane1.setViewportView(remarkt);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 230, 70));

        jLabel16.setText("Reciver Signature");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 90, -1));
        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 160, 0));

        print.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel2.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, -1, -1));

        jLabel1.setText("Reciever Name");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));
        jPanel2.add(rname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 150, 30));

        jLabel3.setText(" Roll No");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        txt_amount1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amount1ActionPerformed(evt);
            }
        });
        jPanel2.add(txt_amount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 160, -1));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 720, 460));

        cnumber.setText("Cheque Number");
        jPanel3.add(cnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 120, 30));
        jPanel3.add(ct, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 180, 30));

        jLabel2.setText(" Course");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, -1));

        courset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursetActionPerformed(evt);
            }
        });
        jPanel3.add(courset, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 170, 30));

        upiid.setText("UPI ID");
        jPanel3.add(upiid, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));
        jPanel3.add(upit, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 180, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1100, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxActionPerformed
       if(combobox.getSelectedIndex()==0)
       {
           dd_number.setVisible(true);
           ddt.setVisible(true);
           bname.setVisible(true);
           bnt.setVisible(true);
           
           cnumber.setVisible(false);
           ct.setVisible(false);
           upiid.setVisible(false);
           upit.setVisible(false); 
           
       }
       if(combobox.getSelectedIndex()==1)
       {
        dd_number .setVisible(false);
        cnumber.setVisible(false);
        bname.setVisible(false);
        ddt.setVisible(false);
        ct.setVisible(false);
        bnt.setVisible(false);
        upiid.setVisible(false);
        upit.setVisible(false); 
       }
       if(combobox.getSelectedIndex()==2)
       {
        dd_number .setVisible(false);
        cnumber.setVisible(true);
        bname.setVisible(true);
        ddt.setVisible(false);
        ct.setVisible(true);
        bnt.setVisible(true);
        upiid.setVisible(false);
        upit.setVisible(false);  
       }
       if(combobox.getSelectedIndex()==3)
       {
        dd_number .setVisible(false);
        cnumber.setVisible(false);
        bname.setVisible(false);
        ddt.setVisible(false);
        ct.setVisible(false);
        bnt.setVisible(false);
        upiid.setVisible(true);
        upit.setVisible(true);
       }
       
       if(combobox.getSelectedIndex()==4)
       {
        dd_number .setVisible(false);
        cnumber.setVisible(false);
        bname.setVisible(false);
        ddt.setVisible(false);
        ct.setVisible(false);
        bnt.setVisible(false);
        upiid.setVisible(true);
        upit.setVisible(true);     
       }
    }//GEN-LAST:event_comboboxActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
      if(Validation()==true)
      {
         String s = insertData();
         if(s.equals("success"))
         {
             JOptionPane.showMessageDialog(this,"Record inserted successfully");
         }
         else
         {
             JOptionPane.showMessageDialog(this,"Record  Not inserted successfully");
         }
      }
    }//GEN-LAST:event_printActionPerformed

    private void rolltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rolltActionPerformed

    }//GEN-LAST:event_rolltActionPerformed

    private void coursetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursetActionPerformed
      String s1 = courset.getSelectedItem().toString();
       head_txt.setText(s1);
    }//GEN-LAST:event_coursetActionPerformed

    private void txt_amount1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amount1ActionPerformed
       String s1 = txt_amount1.getText();
      float amt = Float.parseFloat(s1);
      
      float cgst = amt*0.07f;
      float sgst = amt*0.07f;
      
        cgstTextField.setText(Float.toString(cgst));
        sgstTextField.setText(Float.toString(sgst));
      float t = amt+cgst+sgst;
      
      totall.setText(Float.toString(t));                                    
    }//GEN-LAST:event_txt_amount1ActionPerformed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
      HomePage hp = new HomePage();
      hp.show();
      this.dispose();
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        HomePage hp = new HomePage();
      hp.show();
      this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
     signup su = new signup();
     su.show();
     this.dispose();
    }//GEN-LAST:event_jButton3MouseClicked

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
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bname;
    private javax.swing.JTextField bnt;
    private javax.swing.JTextField cgstTextField;
    private javax.swing.JLabel cnumber;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JComboBox<String> courset;
    private javax.swing.JTextField ct;
    private javax.swing.JLabel dd_number;
    private javax.swing.JTextField ddt;
    private javax.swing.JTextField head_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mop;
    private javax.swing.JButton print;
    private javax.swing.JTextArea remarkt;
    private javax.swing.JTextField rname;
    private javax.swing.JLabel rnumber;
    private javax.swing.JTextField rnumbert;
    private javax.swing.JTextField rollt;
    private javax.swing.JTextField sgstTextField;
    private javax.swing.JTextField totall;
    private javax.swing.JTextField txt_amount1;
    private javax.swing.JLabel upiid;
    private javax.swing.JTextField upit;
    // End of variables declaration//GEN-END:variables

}