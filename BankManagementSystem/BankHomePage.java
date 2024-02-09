import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BankHomePage extends Frame implements ActionListener {
    Button runProgramBtn;
    Label statusLabel;

    public BankHomePage() {
        setLayout(new FlowLayout());

        JPanel logoPanel = new JPanel();
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\Amit\\OneDrive\\Desktop\\OOPS\\Ramaiah.png"); 
        JLabel logoLabel = new JLabel(logoIcon);
        logoPanel.add(logoLabel);
        add(logoPanel, BorderLayout.NORTH);

        JLabel titleLabel = new JLabel("Welcome to RIT-MiniBank");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton runProgramBtn = new JButton("Launch RIT-MiniBank");
        buttonPanel.add(runProgramBtn);
        add(buttonPanel, BorderLayout.SOUTH);
        runProgramBtn.addActionListener(this);

        setTitle("Rit-MiniBank");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == runProgramBtn) {
            try {
                bank.main(new String[]{});
            } catch (IOException ex) {
                System.out.println("ERROR: Running the program");
            }
        }
    }

    public static void main(String[] args) {
        new BankHomePage();
    }
}
