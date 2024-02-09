import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class BankHomePage extends Frame implements ActionListener {
    Button runProgramBtn;
    Label statusLabel;

    public BankHomePage() {
        setLayout(new FlowLayout());

        runProgramBtn = new Button("Run Program");
        add(runProgramBtn);
        runProgramBtn.addActionListener(this);

        statusLabel = new Label("Click 'Run Program' to execute your Java program in VS Code terminal.");
        add(statusLabel);

        setTitle("Java Program Runner");
        setSize(400, 150);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == runProgramBtn) {
            /*executeCommand("cd C:\\Users\\gamin\\IdeaProjects\\Java Programs\\src");
            executeCommand("javac bank.java");
            executeCommand("java bank");*/
            try {
                bank.main(new String[]{});
            } catch (IOException ex) {
                System.out.println("ERROR: Running the program");
            }
        }
    }

//    private void executeCommand(String command) {
//        try {
//            Process process = Runtime.getRuntime().exec(command);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line); // Output the command execution result to console
//            }
//            process.waitFor(); // Wait for the process to finish
//            reader.close();
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        new BankHomePage();
    }
}
