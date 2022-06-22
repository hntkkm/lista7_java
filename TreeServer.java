package src;
import java.io.*;
import java.net.*;
import java.util.Objects;

//todo metody osobno
//todo czym jest t

class TreeServer {

    public static <T extends Comparable<T>> void main(String[] args) {
        try(ServerSocket server = new ServerSocket(1234)){
            System.out.println("Let's make a tree");
            Socket client = server.accept();

            //odbieranie od clienta
            InputStream input = client.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(input));

            //wysylanie do clienta
            OutputStream output = client.getOutputStream();
            PrintWriter out = new PrintWriter(output, true);

            Tree<Integer> drzewoInt = new Tree<>();
            Tree<String> drzewoString = new Tree<>();
            Tree<Double> drzewoDouble = new Tree<>();
            Tree<T> drzewo;

            T tekst = null;
            T previous = null;
            String typ;
            tekst = (T) in.readLine();

            if ("int".equals(tekst)) {
                drzewo = (Tree<T>) drzewoInt;
                out.println("dzrewko stworzono");
            } else if ("double".equals(tekst)) {
                drzewo = (Tree<T>) drzewoDouble;
                out.println("dzrewko stworzono");
            } else {
                drzewo = (Tree<T>) drzewoString;
                out.println("dzrewko stworzono");
            }
            do {
                System.out.println(tekst);
                tekst = (T) in.readLine();
                if (Objects.equals(tekst, "draw")) {
                    out.println(drzewo);
                    previous = tekst;
                }
                else if (previous!= null){
                    if ("add".equals(tekst)) {
                        try {
                            drzewo.insert(previous);
                            out.println("element " + previous + " zostal dodany");
                        } catch (NumberFormatException e) {
                            out.println("elementy drzewa musza byc jednego typu");
                        }
                        previous = tekst;
                    } else if ("search".equals(tekst)) {
                        try {
                            if (drzewo.search(previous) == true) {
                                out.println("element " + previous + " jest w drzewie");
                            } else {
                                out.println("elementu " + previous + " nie ma w drzewie");
                            }
                        } catch (NumberFormatException e) {
                            out.println("elementy drzewa musza byc jednego typu");
                        }
                        previous = tekst;
                    } else if ("delete".equals(tekst)) {
                        try {
                            drzewo.delete(previous);
                            out.println("element " + previous + " zostal usuniety");
                        } catch (NumberFormatException e) {
                            out.println("elementy drzewa musza byc jednego typu");
                        }
                        previous = tekst;
                    } else {
                        out.println("...");
                        previous = tekst;
                    }
                } else {
                    out.println("...");
                    previous = tekst;
                }
            }while (!tekst.equals("exit"));
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

