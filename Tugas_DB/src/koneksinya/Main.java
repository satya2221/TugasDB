/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksinya;
import java.util.Scanner;
/**
 *
 * @author Satya
 */
public class Main {
    public static void main(String[] args) {
        char choice,ulangi;
        Scanner input =new Scanner(System.in);
        do{
        System.out.println("Data Mahasiswa");
        System.out.println("Pilih");
        System.out.println("1.Input data");
        System.out.println("2.Tampilkan data");
        System.out.print("Pilihan : ");
        choice = input.next().charAt(0);
        
            switch(choice){
                case '1':
                new InputDataMhs();
              break;
                case '2':
                new LihatDataMhs();
              break;
            }
            System.out.print("Ulangi ?(y/n) : ");
            ulangi = input.next().charAt(0);
        }while (true);
    }
}
