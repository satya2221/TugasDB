/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksinya;

import java.sql.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 *
 * @author Satya
 */
public class InputDataMhs extends JFrame{
    String DBurl = "jdbc:mysql://localhost/praktikumsatya";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    
    Font fontt = new Font("SanSerif", Font.PLAIN, 20);
    
    JPanel untukform = new JPanel();
    
    JLabel lnamanya = new JLabel("Nama anda : ");
    JTextField tfnama = new JTextField(50);

    JLabel lnimnya = new JLabel("NIM anda : ");
    JTextField tfnim = new JTextField(9);

    JLabel lalamatnya = new JLabel("Alamat anda : ");
    JTextField taalamatnya = new JTextField();
    
    JButton btn_tambah = new JButton("tambah");
    
    public InputDataMhs(){
       setTitle("Tugas try Database");
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
       setLayout(null);
       setSize(800,600);     
       
       JLabel label = new JLabel("--INPUT DATA MAHASISWA--");
       untukform.add(label);
       label.setBounds(250, 20, 300, 20);
       label.setFont(fontt);
       
       add(untukform);
       untukform.setBounds(10,10,755,525);
       untukform.setLayout(null);
       
       untukform.add(lnamanya);
        lnamanya.setBounds(250,100,90,20);
        untukform.add(tfnama);
        tfnama.setBounds(350,100,120,20);

        untukform.add(lnimnya);
        lnimnya.setBounds(250,200,90,20);
        untukform.add(tfnim);
        tfnim.setBounds(350,200,120,20);

        untukform.add(lalamatnya);
        lalamatnya.setBounds(250,300,90,20);
        untukform.add(taalamatnya);
        taalamatnya.setBounds(350,300,120,20);
        
        untukform.add(btn_tambah);
        btn_tambah.setBounds(300,380,90,20);
        
        btn_tambah.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               inputDatanya();
           }
            });
    }
    public void inputDatanya() {
        try {
            String query = "INSERT INTO `mhs`(`nim`, `nama`, `address`) VALUES ('"+tfnim.getText()+"','"+tfnama.getText()+"','"+taalamatnya.getText()+"')";
            Class.forName("com.mysql.jdbc.Driver");
            koneksi =  (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            statement = (Statement)koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data disimpan","Hasil",JOptionPane.INFORMATION_MESSAGE);
            statement.close();
            koneksi.close();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
//    public static void main(String[] args) {
//    new InputDataMhs();
//    }
}
