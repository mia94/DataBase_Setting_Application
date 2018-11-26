package database_setting.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import database_setting.service.InitService;

import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class SettingUi extends JFrame implements ActionListener {
	
	private JPanel contentPane;
	private JButton btn3;
	private JButton btn1;
	private JButton btn2;
	private InitService initService;


	/**
	 * Create the frame.
	 */
	public SettingUi() {
		initService = new InitService();
		initComponents();
	}
	private void initComponents() {
		setTitle("Database Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "\uB370\uC774\uD130\uBCA0\uC774\uC2A4 \uAD00\uB9AC \uBA54\uB274", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		btn1 = new JButton("초기화");
		btn1.addActionListener(this);
		contentPane.add(btn1);
		
		btn2 = new JButton("백업");
		btn2.addActionListener(this);
		contentPane.add(btn2);
		
		btn3 = new JButton("복원");
		btn3.addActionListener(this);
		contentPane.add(btn3);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn2) {
			do_btn2_actionPerformed(e);
		}
		if (e.getSource() == btn1) {
			do_btn1_actionPerformed(e);
		}
		if (e.getSource() == btn3) {
			do_btn3_actionPerformed(e);
		}
	}
	protected void do_btn3_actionPerformed(ActionEvent e) {
		//백업
	}
	protected void do_btn1_actionPerformed(ActionEvent e) {
		//초기화
		try {
			initService.service(filePath("SQL File 디렉터리 선택",true));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	protected void do_btn2_actionPerformed(ActionEvent e) {
		//복원
	}
	
	private String filePath(String dialogTitle, boolean isOpen) throws Exception {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle(dialogTitle);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//디렉터리 선택
		chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		int ret = -1;
		if(isOpen) {
			ret = chooser.showOpenDialog(null);
		}else {
			ret = chooser.showSaveDialog(null);
		}
		if(ret != JFileChooser.APPROVE_OPTION) {
			throw new Exception("파일을 선택하지 않았습니다.");
		}
		return chooser.getSelectedFile().getPath();
	}
}


















