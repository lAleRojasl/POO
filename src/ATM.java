import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
-------------------------------
| Autor: Alejandro Rojas Jara |
| Curso: POO                  |
| Fecha: 22/08/2019           |
-------------------------------
*/

public class ATM extends JFrame implements ActionListener {
    //UI Attributes
    private JButton[] btnNumbers;  // Array of 10 numeric Buttons
    private JButton btnDelete, btnWithdraw, btnDeposit, btnConfirm,
                    btnChangeAccount,btnViewBalance,btnViewMonthInterest;
    private JTextField tfDisplay;

    //Cuentas Attributes
    private Cuenta[] accounts = new Cuenta[10];
    private Cuenta activeAccount = null;
    //Possible actions:
    // _InputID -> User is logging in.
    // _Selecting -> User logged. Selecting option.
    // _Deposit -> Active user is depositing
    // _Withdraw -> Active user is withdrawing
    private String activeCommand = "_InputID";
    private String currentInput = "";

    // Constructor to setup the GUI components
    public ATM() {
        //Initialize Cuentas
        for(int i = 0; i < 10; i++ ){
            accounts[i] = new Cuenta(i,100000.0d);
        }

        JFrame frame = new JFrame("ATM");
        //Initialize UI Components
        Panel panelDisplay = new Panel(new BorderLayout());
        //panelDisplay.setPreferredSize(new Dimension(400,40));
        tfDisplay = new JTextField("Digite su ID: ", 20);
        tfDisplay.setEditable(false);
        tfDisplay.setHorizontalAlignment(JTextField.CENTER);
        tfDisplay.setFont(new Font("Courier", Font.BOLD,15));
        panelDisplay.add(tfDisplay, BorderLayout.CENTER);

        // Set up button panel
        Panel panelButtons = new Panel(new GridLayout(6, 3));
        btnNumbers = new JButton[10];  // Construct an array of 10 numeric Buttons
        for(int i = 1; i < 10; i++) {
            String numString = String.valueOf(i);
            btnNumbers[i] = new JButton(numString);  // Construct Button
            btnNumbers[i].addActionListener(this);
            panelButtons.add(btnNumbers[i]);  // The Panel adds this Button
        }
        // You should use a loop for the above statements!!!

        btnDelete = new JButton("Borrar");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(this);

        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(this);

        btnConfirm = new JButton("Confirmar");
        panelButtons.add(btnConfirm);
        btnConfirm.addActionListener(this);

        btnDeposit = new JButton("Depositar");
        panelButtons.add(btnDeposit);
        btnDeposit.addActionListener(this);

        btnWithdraw = new JButton("Retirar");
        panelButtons.add(btnWithdraw);
        btnWithdraw.addActionListener(this);

        btnChangeAccount = new JButton("Cambiar Cuenta");
        panelButtons.add(btnChangeAccount);
        btnChangeAccount.addActionListener(this);

        btnViewBalance = new JButton("Ver Balance");
        panelButtons.add(btnViewBalance);
        btnViewBalance.addActionListener(this);

        btnViewMonthInterest = new JButton("Ver Intereses");
        panelButtons.add(btnViewMonthInterest);
        btnViewMonthInterest.addActionListener(this);

        setLayout(new BorderLayout());  // "super" Frame sets to BorderLayout
        add(panelDisplay, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);

        setTitle("ATM"); // "super" JFrame sets title
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);         // "super" JFrame sets initial size
        setVisible(true);          // "super" JFrame shows           // "super" Frame shows
    }

    // ActionEvent handler - Called back upon button-click.
    @Override
    public void actionPerformed(ActionEvent evt) {
        // Display the counter value on the TextField tfCount
        String userInput = evt.getActionCommand();

        switch (userInput){
            case "Cambiar Cuenta":
                activeCommand = "_InputID";
                currentInput = "";
                activeAccount = null;
                tfDisplay.setText("Digite su ID: ");
                break;

            case "Ver Balance":
                if(activeAccount != null) tfDisplay.setText("Su balance actual es de: "+activeAccount.getBalance());
                break;

            case "Ver Intereses":
                if(activeAccount != null) tfDisplay.setText("Sus intereses mensuales son de: "+activeAccount.calculateMonthlyInterest());
                break;

            case "Depositar":
                if(activeAccount != null) {
                    activeCommand = "_Deposit";
                    tfDisplay.setText("Digite monto a depositar: ");
                }
                break;

            case "Retirar":
                if(activeAccount != null) {
                    activeCommand = "_Withdraw";
                    tfDisplay.setText("Digite monto a retirar: ");
                }
                break;

            case "Confirmar":
                //Retirar monto
                if(activeCommand == "_Withdraw"){
                    activeAccount.withdrawCash(Integer.parseInt(currentInput));
                    currentInput = "";
                    activeCommand = "_Selecting";
                    tfDisplay.setText("Monto retirado! Nuevo balance: "+activeAccount.getBalance());
                }
                //Depositar monto
                else if(activeCommand == "_Deposit") {
                    activeAccount.depositCash(Integer.parseInt(currentInput));
                    currentInput = "";
                    activeCommand = "_Selecting";
                    tfDisplay.setText("Monto depositado! Nuevo balance: " + activeAccount.getBalance());
                }
                break;

            //Clear Screen inputs
            case "Borrar":
                currentInput = "";
                if(activeCommand == "_InputID") tfDisplay.setText("Digite su ID: ");
                if(activeCommand == "_Deposit") tfDisplay.setText("Digite monto a depositar: ");
                if(activeCommand == "_Withdraw") tfDisplay.setText("Digite monto a retirar: ");
                break;

            //Append input number to Screen
            default:
                //We search for the account with the input ID
                if(activeCommand == "_InputID"){
                    int id = Integer.parseInt(evt.getActionCommand());
                    activeAccount = accounts[id];
                    activeCommand = "_Selecting";
                    tfDisplay.setText("Cuenta "+ id + " activa! Desea depositar o retirar?");
                }
                //The user is selecting an option
                if(activeCommand != "_Selecting") {
                    String inputString = evt.getActionCommand();
                    currentInput += inputString;
                    tfDisplay.setText(tfDisplay.getText() + inputString);
                }
                break;

        }
    }
}
