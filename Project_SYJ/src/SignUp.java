import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.MemberDAO;
import database.MemberVo;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SignUp extends JFrame {
	private MemberDAO dao;

	private JPanel contentPane;
	private JButton backBtn;
	private JTextField mail;
	private JTextField id_SignUP;
	private JPasswordField password_SignUp;
	private JPasswordField check_password;
	private JLabel tf_pwd_double_check;
	private JLabel tf_mailInput;
	private JLabel ID_duplicate_Msg;
	private JLabel tf_pwd_Msg;
	private JButton SignUp_Btn;
	private JButton IDCheck_btn;
	private JTextField name_field;
	private JLabel tf_name_Msg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
		dao = new MemberDAO();

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/img/\uC571\uC544\uC774\uCF58.png")));
		setTitle("\uC624! \uCD9C\uC11D - \uD559\uC0DD\uAD00\uB9AC\uC2DC\uC2A4\uD15C ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		backBtn = new JButton("<");
		backBtn.setForeground(new Color(255, 255, 255));
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home_Login h = new Home_Login(); // ????????? ??????
				h.setVisible(true);

			}
		});

		// ???????????? ????????? ?????????
		backBtn.setFont(new Font("??????????????? ??????", Font.BOLD, 17));
		backBtn.setBackground(new Color(204, 204, 255));
		backBtn.setBounds(394, 0, 56, 29);
		contentPane.add(backBtn);

		name_field = new JTextField(10);
		name_field.setColumns(10);
		name_field.setBounds(22, 43, 356, 38);
		contentPane.add(name_field);

		id_SignUP = new JTextField(10);
		id_SignUP.setColumns(10);
		id_SignUP.setBounds(12, 174, 356, 38);
		contentPane.add(id_SignUP);

		password_SignUp = new JPasswordField(10);
		password_SignUp.setBounds(12, 291, 356, 38);
		contentPane.add(password_SignUp);

		check_password = new JPasswordField(10);
		check_password.setBounds(12, 411, 356, 38);
		contentPane.add(check_password);

		mail = new JTextField(20);
		mail.setBounds(12, 528, 356, 38);
		contentPane.add(mail);
		mail.setColumns(10);

		// ?????? ?????? ????????? ??????
		tf_name_Msg = new JLabel("");
		tf_name_Msg.setForeground(Color.RED);
		tf_name_Msg.setBounds(22, 111, 356, 20);
		contentPane.add(tf_name_Msg);

		ID_duplicate_Msg = new JLabel("");
		ID_duplicate_Msg.setForeground(Color.RED);
		ID_duplicate_Msg.setBounds(12, 217, 356, 20);
		contentPane.add(ID_duplicate_Msg);

		tf_pwd_Msg = new JLabel("");
		tf_pwd_Msg.setForeground(Color.RED);
		tf_pwd_Msg.setBounds(12, 339, 356, 20);
		contentPane.add(tf_pwd_Msg);

		tf_pwd_double_check = new JLabel("");
		tf_pwd_double_check.setForeground(Color.RED);
		tf_pwd_double_check.setBounds(12, 459, 356, 20);
		contentPane.add(tf_pwd_double_check);

		tf_mailInput = new JLabel("");
		tf_mailInput.setForeground(Color.RED);
		tf_mailInput.setBounds(12, 576, 356, 20);
		contentPane.add(tf_mailInput);

		// ???????????? ????????? ????????? ???????????? ?????? ????????? ????????????
		SignUp_Btn = new JButton("???????????? ??????");
		SignUp_Btn.setBackground(new Color(255, 240, 245));
		SignUp_Btn.setFont(new Font("??????????????? ??????", Font.BOLD, 18));

		SignUp_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ??????????????? ????????? ????????????
				String name_length = name_field.getText();
				String ID_length = id_SignUP.getText();
				String password_length = password_SignUp.getText();
				String mail_length = mail.getText();

				// ???????????? ??????, false?????? ?????? ??????
				boolean user = new MemberDAO().IDCheck(id_SignUP.getText());
				// ??????????????? ?????? ???????????????????????? ?????????????????? ??????

				// ???????????? ???????????? ????????????
				if (name_field.getText().equals("")) {
					tf_name_Msg.setText("????????? ???????????????.");
					JOptionPane.showMessageDialog(null, "????????? ???????????????..", "???????????? ??????!", JOptionPane.ERROR_MESSAGE);

					// ???????????? ???????????? ????????????^^
				} else if (!password_SignUp.getText().equals(check_password.getText())) {
					tf_pwd_double_check.setText("??????????????? ???????????? ????????????.");
					JOptionPane.showMessageDialog(null, "??????????????? ???????????? ????????????.", "???????????? ??????!", JOptionPane.ERROR_MESSAGE);

				} else if (id_SignUP.getText().equals("")) {
					ID_duplicate_Msg.setText("???????????? ???????????????.");
					JOptionPane.showMessageDialog(null, "???????????? ???????????????.", "???????????? ??????!", JOptionPane.ERROR_MESSAGE);

				} else if (user == true) {
					ID_duplicate_Msg.setText("????????? ??????????????????.");
					JOptionPane.showMessageDialog(null, "????????? ??????????????????.", "???????????? ??????!", JOptionPane.ERROR_MESSAGE);

				} else if (password_SignUp.getText().equals("")) {
					tf_pwd_Msg.setText("??????????????? ???????????????.");
					JOptionPane.showMessageDialog(null, "??????????????? ???????????????.", "???????????? ??????!", JOptionPane.ERROR_MESSAGE);

				} else if (check_password.getText().equals("")) {
					tf_pwd_double_check.setText("??????????????? ?????? ??? ???????????????.");
					JOptionPane.showMessageDialog(null, "??????????????? ?????? ??? ???????????????.", "???????????? ??????!", JOptionPane.ERROR_MESSAGE);

				} else if (mail.getText().equals("")) {
					tf_mailInput.setText("??????????????? ???????????????.");
					JOptionPane.showMessageDialog(null, "??????????????? ???????????????.", "???????????? ??????!", JOptionPane.ERROR_MESSAGE);

				} else if (name_length.length() > 10) {
					tf_name_Msg.setText("????????? 10?????? ????????? ??????????????????.");
					JOptionPane.showMessageDialog(null, "????????? 10?????? ????????? ??????????????????.", "???????????? ??????!", JOptionPane.ERROR_MESSAGE);
				} else if (ID_length.length() > 10) {
					ID_duplicate_Msg.setText("ID??? 10?????? ????????? ??????????????????.");
					JOptionPane.showMessageDialog(null, "ID??? 10?????? ????????? ??????????????????.", "???????????? ??????!", JOptionPane.ERROR_MESSAGE);
				} else if (password_length.length() > 10) {
					tf_pwd_Msg.setText("??????????????? 10?????? ????????? ??????????????????.");
					JOptionPane.showMessageDialog(null, "??????????????? 10?????? ????????? ??????????????????.", "???????????? ??????!",
							JOptionPane.ERROR_MESSAGE);
				} else if (mail_length.length() > 30) {
					tf_mailInput.setText("??????????????? 30?????? ????????? ??????????????????.");
					JOptionPane.showMessageDialog(null, "??????????????? 30?????? ????????? ??????????????????.", "???????????? ??????!",
							JOptionPane.ERROR_MESSAGE);
				} else {
					// ???????????????
					MemberVo vo = new MemberVo(name_field.getText(), id_SignUP.getText(), password_SignUp.getText(),
							mail.getText());
					boolean b = dao.SignUp(vo);


					// ???????????? ??????????????? ?????? ?????????
					if (b == false) {

						JOptionPane alert = new JOptionPane();
						alert.showMessageDialog(null,
								name_field.getText() + "???!\n??????????????? ???????????????. \n?????????????????? ????????? ???????????? ????????????.");
						dispose();
						Home_Login attendance = new Home_Login(); // ????????? ??????
						attendance.setVisible(true);

					}
				}
			}
		});

		SignUp_Btn.setBounds(131, 637, 151, 47);
		contentPane.add(SignUp_Btn);

		// ???????????? ?????? ????????? ???????????? ??????????????? ????????????.
		IDCheck_btn = new JButton("?????? ??????");
		IDCheck_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ???????????? ??????, false?????? ?????? ??????
				boolean user = new MemberDAO().IDCheck(id_SignUP.getText());
				// ??????????????? ?????? ???????????????????????? ?????????????????? ??????

				if (user == true) {
					ID_duplicate_Msg.setText("????????? ??????????????????.");
				} else {
					ID_duplicate_Msg.setText(id_SignUP.getText() + " ??? ?????? ????????? ????????? ?????????.");
				}

			}
		});
		IDCheck_btn.setBackground(new Color(255, 240, 245));
		IDCheck_btn.setBounds(131, 141, 97, 23);
		contentPane.add(IDCheck_btn);

		JLabel backgroud = new JLabel("");
		backgroud.setBounds(0, 0, 450, 713);
		backgroud.setIcon(new ImageIcon(SignUp.class.getResource("/img/\uD68C\uC6D0\uAC00\uC785\uCC3D.png")));
		contentPane.add(backgroud);
	}
}