import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    static Connection conn;
    public static void main(String[] args) throws Exception {
        try (Scanner inputuser = new Scanner(System.in)) {
            String choice;
            boolean keadaan = true;
            String URL = "jdbc:mysql://localhost:3306/tugaspenjualan";
            String user = "root";
            String password ="";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(URL, user, password);
                System.out.println("Berhasil Terkoneksi");
                Penjualan pjl = new Penjualan();
                while(keadaan){
                    System.out.println("|     MENU    |");
                    System.out.println("1. Lihat Data ");
                    System.out.println("2. Input Data ");
                    System.out.println("3. Update Data ");
                    System.out.println("4. Cari Data ");
                    System.out.println("5. Hapus Data ");
                    System.out.print(" Masukkan Pilihan : ");
                    choice = inputuser.next();
                    switch(choice){
                        case "1":
                        pjl.seeData();
                        break;
                        case "2":
                        pjl.addData();
                        break;
                        case "3":
                        pjl.update();
                        break;
                        case "4":
                        pjl.searchData();
                        break;
                        case "5":
                        pjl.clear();
                        break;
                        default :
                        System.err.println("Menu Tidak Ada");
                    }
                    System.out.println("\n Close Program [y/n]? : ");
                    choice = inputuser.next();
                    keadaan = choice.equalsIgnoreCase("n");
                }
                System.out.println("Terima Kasih");
            }
            catch(ClassNotFoundException ex){
                System.err.println("Driver Tidak Ada");
                System.exit(0);
            }
            catch(SQLException e){
                System.err.println("Disconnected");
            }
        }
    }
}
