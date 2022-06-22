package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import static java.awt.BorderLayout.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.util.Scanner;

public class GUI extends JFrame {
    private JFrame ramka;
    private JPanel panel;
    private JPanel topPanel;
    private JTextField tekstTypDrezwka;
    private JTextField notatka;
    private JButton button;
    private int[] ostatniWiersz;
    private PrintWriter out;
    private BufferedReader in;
    private Socket socket;
    private JTextField addressField;
    private JTextArea textArea;
    private JButton startButton;
    private JRadioButton intButton;
    private JRadioButton doubleButton;
    private JRadioButton stringButton;
    private JButton addElement;
    private JButton searchElement;
    private JButton deleteElement;
    private JButton drawTree;
    private JTextField elementField;
    private JButton stworzDrzewko;
    private JButton deleteButton;
    private JButton findButton;
    private JLabel podajElement;

    public static void main(String[] args) throws IOException {
        GUI gui = new GUI();
        gui.start();
        gui.getRamka().setVisible(true);
    }

    public GUI() {
        ramka = new JFrame("Drzewo binarne");
        panel = new JPanel();
    }

    public void start() throws IOException {
        socket = new Socket("localhost", 1234);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        ramka.setSize(600, 650);
        ramka.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setLayout(new BorderLayout());

        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(600,100));

        topPanel.add(new JLabel(" Wybierz typ drzewka: "));
        intButton = new JRadioButton("Integer", true);
        doubleButton = new JRadioButton("Double");
        stringButton = new JRadioButton("String");

        startButton = new JButton("Stworz");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(intButton);
        buttonGroup.add(doubleButton);
        buttonGroup.add(stringButton);
        topPanel.add(intButton);
        topPanel.add(doubleButton);
        topPanel.add(stringButton);
        topPanel.add(startButton);
        startButton.addActionListener(a -> {
            try {
//                if (intButton.isSelected()){
//                    out.println("int");
//                } else if (doubleButton.isSelected()){
//                    out.println("double");
//                } else {
//                    out.println("string");
//                }
                startTree();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        panel.add(topPanel, BorderLayout.NORTH);
    }


    public JFrame startTree() throws IOException {
        connectToServer();
        topPanel.removeAll();

        podajElement = new JLabel("Podaj element");
        tekstTypDrezwka = new JTextField( 10);
        topPanel.add(podajElement);
        topPanel.add(tekstTypDrezwka);

        addElement = new JButton("Add");
        searchElement = new JButton("Search");
        deleteElement = new JButton("Delete");
        drawTree = new JButton("Draw Tree");

        addElement.addActionListener(a-> {
            try {
                processAdd();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        searchElement.addActionListener(a-> {
            try {
                processSearch();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        deleteElement.addActionListener(a-> {
            try {
                processDelete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        drawTree.addActionListener(a-> {
            try {
                processDraw();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        topPanel.add(addElement);
        topPanel.add(searchElement);
        topPanel.add(deleteElement);
        topPanel.add(drawTree);

        panel.updateUI();
        return ramka;
    }

    public JFrame getRamka() {
        ramka.add(panel);
        return ramka;
    }

    private void connectToServer() throws IOException {


        if (intButton.isSelected()) {
            out.println("int");
            System.out.println(in.readLine());
        } else if (doubleButton.isSelected()) {
            out.println("double");
            System.out.println(in.readLine());
        } else if (stringButton.isSelected()) {
            out.println("string");
            System.out.println(in.readLine());
        }
    }


    private void processAdd() throws IOException {
        String text = tekstTypDrezwka.getText();
        out.println(text);
        System.out.println(in.readLine());
        out.println("add");
        System.out.println(in.readLine());
    }

    private void processSearch() throws IOException {
        String text = tekstTypDrezwka.getText();
        out.println(text);
        System.out.println(in.readLine());
        out.println("search");
        System.out.println(in.readLine());
    }
    private void processDraw() throws IOException {
        String text = tekstTypDrezwka.getText();
        out.println("draw");
        System.out.println(in.readLine());
    }

    private void processDelete() throws IOException {
        String text = tekstTypDrezwka.getText();
        out.println(text);
        System.out.println(in.readLine());
        out.println("delete");
        System.out.println(in.readLine());
    }
}
