package kobeU.cs.guiChat.app;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Board extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel upperPanel = null;
	private JTextField jTextField = null;
	private JScrollPane jScrollPane = null;
	private GUIChat manager = null;  //  @jve:decl-index=0:
	private JTextArea jTextArea = null;
	private JLabel jLabel = null;
	/**
	 * This is the default constructor
	 */
	public Board() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 */
	private void initialize() {
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1000, 2000));
		this.setContentPane(getJContentPane());
		this.setTitle("ChatBoard");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				manager.startTermination();
			}
		});
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BoxLayout(getJContentPane(), BoxLayout.Y_AXIS));
			jContentPane.add(getUpperPanel(), null);
			jContentPane.add(getJScrollPane(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes upperPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getUpperPanel() {
		if (upperPanel == null) {
			jLabel = new JLabel();
			jLabel.setText("input msg: ");
			jLabel.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			upperPanel = new JPanel();
			upperPanel.setLayout(new BoxLayout(getUpperPanel(), BoxLayout.X_AXIS));
			upperPanel.setPreferredSize(new Dimension(300, 40));
			upperPanel.add(jLabel, null);
			upperPanel.add(getJTextField(), null);
		}
		return upperPanel;
	}

	/**
	 * This method initializes jTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					manager.sendMsg(jTextField.getText());
					jTextField.setText("");
				}
			});
		}
		return jTextField;
	}

	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setPreferredSize(new Dimension(300, 300));
			jScrollPane.setViewportView(getJTextArea());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTextArea
	 *
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setLineWrap(true);
			jTextArea.setEditable(false);
		}
		return jTextArea;
	}

	/***************************************
	 *  public methods
	 */
	public void setManager(GUIChat chatManager) {
		this.manager = chatManager;
	}
	public void addMessage(String text) {
		jTextArea.insert(text+"\n", 0);
		jTextArea.setCaretPosition(0);
	}


	@Override
	public void setVisible(boolean flag) {
		if((manager==null)&& flag) {
			System.err.println("Please set manager before setting GUIChatBoard visible.");
		} else {
			super.setVisible(flag);
		}
	}
}  //  @jve:decl-index=0:visual-constraint="69,9"
