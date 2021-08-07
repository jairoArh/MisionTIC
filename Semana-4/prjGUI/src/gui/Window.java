package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.nio.channels.AcceptPendingException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener, KeyListener, WindowListener{
	
	private JLabel title;
	private JTextField txtOne;
	private JTextField txtTwo;
	private JButton btnAccept;
	private JButton btnClean;
	private JTextField result;
	private JComboBox<String> options;
	
	private final String ACCEPT = "Aceptar";
	private final String CLEAN_FIELDS = "Limpiar Campos";
	private final String OPTION_MENU = "Opciones del Menu";
	
	
	
	public Window() {
		super("Ejemplo de Swing");
		this.setSize( new Dimension(640, 140));
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		//Organizadores de Contenido: FlowLayouyt, BorderLayout, GridLayout, GridBagLayout
		this.setLayout( new BorderLayout()); 
		this.addWindowListener( this );
	}
	
	public void begin() {
		beginComponents();
		addComponents();
	}

	private void addComponents() {
		// TODO Auto-generated method stub
		
		JPanel panel = new JPanel();
		panel.setLayout( new GridLayout(2,4));
		
		//Componentes de la Primer Fila
		panel.add( new JLabel("Numero Uno"));
		panel.add(txtOne);
		panel.add( new JLabel("Numero Dos"));
		panel.add(txtTwo);
		
		//Componentes de la Segunda fila
		panel.add(new JLabel());
		panel.add(options);
		panel.add( new JLabel("Resultado"));
		panel.add(result);
		
		JPanel panelTitle = new JPanel( new FlowLayout());
		panelTitle.add( title );
		add(panelTitle, BorderLayout.NORTH);
		
		add(panel, BorderLayout.CENTER);
		
		JPanel panelBtn = new JPanel(new FlowLayout());
		panelBtn.add( btnAccept);
		panelBtn.add(btnClean);
		add(panelBtn,BorderLayout.SOUTH);
		
	}

	private void beginComponents() {
		title = new JLabel("Ejemplo de Swing");
		
		txtOne = new JTextField(30);
		txtOne.addKeyListener( this);
		
		txtTwo = new JTextField();
		txtTwo.addKeyListener( this );	
		
		btnAccept = new JButton("Aceptar");
		btnAccept.setActionCommand(ACCEPT);
		btnAccept.addActionListener( this );
		
		btnClean = new JButton("Limpiar Campos");
		btnClean.setActionCommand(CLEAN_FIELDS);
		btnClean.addActionListener( this );
		
		String[] txtOptions = {"Sumar","Restar","Multiplicar","Dividir"};
		options = new JComboBox<>( txtOptions);
		options.setActionCommand( OPTION_MENU );
		options.addActionListener( this );
		
		result = new JTextField();
		result.setEditable( false );
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch( e.getActionCommand()) {
		case ACCEPT : txtTwo.setText( txtOne.getText());
		break;
		
		case CLEAN_FIELDS : 
			txtOne.setText("");
			txtTwo.setText("");
			break;
			
		case OPTION_MENU : validateMenu();
		break;
		}
		
		
	}

	private void validateMenu() {
		// TODO Auto-generated method stub
		int numOne = Integer.parseInt( txtOne.getText());
		int numTwo = Integer.parseInt( txtTwo.getText());
		
		switch( options.getSelectedIndex()) {
		case 0 : result.setText( String.valueOf(numOne + numTwo) );
		break;
		
		case 1: result.setText( String.valueOf( numOne > numTwo ? numOne - numTwo : numTwo - numOne ));
		break;
		
		case 2:
			break;
			
		default:
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyChar();
		
		if( !(key >= 48 && key <= 57)) {
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		int close = JOptionPane.showConfirmDialog(null, "Desea Salir","Confirmar",JOptionPane.YES_NO_OPTION);
		if( close == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
