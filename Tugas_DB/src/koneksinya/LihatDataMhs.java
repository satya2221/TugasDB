/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksinya;

import java.awt.FlowLayout;
import javax.swing.*;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 *
 * @author Satya
 */
public class LihatDataMhs extends JFrame{
    String[][] data = new String[50][3];
    String[] kolom = {"Nim", "Nama", "Alamat"};
    JTable tabel;
    JScrollPane scrollPane;
    String DBurl = "jdbc:mysql://localhost/praktikumsatya";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    ResultSet hasilnya;
    
    public LihatDataMhs(){
       setTitle("Tugas try Database");
       setSize(800,600); 
       
       try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
            statement = koneksi.createStatement();
            String sql = "SELECT * FROM `mhs`";
            hasilnya = statement.executeQuery(sql);
            int p = 0;
            while (hasilnya.next()) {
                data[p][0] = hasilnya.getString("nim");
                data[p][1] = hasilnya.getString("nama");
                data[p][2] = hasilnya.getString("address");
                p++;
            }
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
        tabel = new JTable(data, kolom);
        scrollPane = new JScrollPane(tabel);
        
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
       setLayout(new FlowLayout());
       add(scrollPane);
    }
//    public static void main(String[] args) {
//        new LihatDataMhs();
//    }
}
