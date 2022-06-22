package src;
import java.io.*;
import java.net.*;
import java.util.Scanner;

class TreeClient {
    public static void main(String[] args) throws IOException {
//        try{
//            Socket socket = new Socket("localhost", 1234);
//            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            GUI gui = new GUI();
            gui.start();
            gui.getRamka().setVisible(true);

//            Scanner scanner = new Scanner(System.in);
//            String tekst;
//            System.out.println("Wybierz typ drzewka: ");
//            System.out.println("    int, double, string ");
//            tekst = scanner.next();
//            out.println(tekst);
//            System.out.println(in.readLine());
//            System.out.println("Dodawanie elementu = add ");
//            System.out.println("Pokazywanie drewa = draw ");
//            System.out.println("Poszukiwanie elementu = search ");
//            System.out.println("Usuwanie elementu = delete ");
//            System.out.println("__________________________________________");
//            System.out.println("Wpisz komende z listy: |liczba + komenda|");
//
//            do {
//                tekst = scanner.next();
//                out.println(tekst);
//                System.out.println(in.readLine());
//            } while (!tekst.equals("exit"));
//
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
