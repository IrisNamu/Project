import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import database.MemberDAO;
import database.StudentDAO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;

@SuppressWarnings("serial")
public class addStudentPage extends JFrame {
	private StudentDAO dao;

	private JPanel contentPane;
	private JTextField s_name;
	private JTextField s_memo;
	private JTextField s_roll_num;
	private JTextField s_guardian1;
	private JTextField s_guardian2;
	private JTextField address;
	private JTextField stu_num;
	private JTextField s_guardian1_call;
	private JTextField s_guardian2_call;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addStudentPage frame = new addStudentPage();
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
	public addStudentPage() {
		dao = new StudentDAO();

		setTitle("\uC624!\uCD9C\uC11D - \uD559\uC0DD \uC815\uBCF4 \uB4F1\uB85D\uD558\uAE30");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton backBtn = new JButton("<");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				attendance_Main attendance = new attendance_Main(); // ????????? ??????
				attendance.setVisible(true);
			}
		});
		backBtn.setForeground(Color.WHITE);
		backBtn.setFont(new Font("??????????????? ??????", Font.BOLD, 17));
		backBtn.setBackground(new Color(128, 128, 128));
		backBtn.setBounds(385, 0, 65, 50);
		contentPane.add(backBtn);

		s_name = new JTextField();
		s_name.setFont(new Font("??????", Font.PLAIN, 14));
		s_name.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (s_name.getText().equals(" * ????????? ??????????????????.")) {
					s_name.setText("");
					s_name.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (s_name.getText().equals("")) {
					s_name.setText(" * ????????? ??????????????????.");
					s_name.setForeground(new Color(153, 153, 153));
				}
			}
		});
		s_name.setText(" * ????????? ??????????????????.");
		s_name.setBounds(200, 154, 224, 29);
		contentPane.add(s_name);
		s_name.setColumns(10);

		JComboBox s_year = new JComboBox();
		s_year.setFont(new Font("??????", Font.PLAIN, 29));
		s_year.setBounds(142, 350, 90, 23);
		contentPane.add(s_year);

		JComboBox s_month = new JComboBox();
		s_month.setBounds(244, 350, 73, 23);
		contentPane.add(s_month);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(329, 350, 73, 23);
		contentPane.add(comboBox_2);

		JCheckBox s_boy_check = new JCheckBox("\uB0A8");
		s_boy_check.setFont(new Font("??????", Font.PLAIN, 14));
		s_boy_check.setBounds(260, 109, 43, 23);
		contentPane.add(s_boy_check);

		JCheckBox s_girl_check = new JCheckBox("\uC5EC");
		s_girl_check.setFont(new Font("??????", Font.PLAIN, 15));
		s_girl_check.setBounds(307, 109, 43, 23);
		contentPane.add(s_girl_check);

		JCheckBox s_mon = new JCheckBox("???");
		s_mon.setFont(new Font("??????", Font.PLAIN, 15));
		s_mon.setHorizontalAlignment(SwingConstants.TRAILING);
		s_mon.setBounds(93, 380, 45, 34);
		contentPane.add(s_mon);

		JCheckBox s_tue = new JCheckBox("???");
		s_tue.setFont(new Font("??????", Font.PLAIN, 15));
		s_tue.setHorizontalAlignment(SwingConstants.CENTER);
		s_tue.setBounds(142, 379, 43, 37);
		contentPane.add(s_tue);

		JCheckBox s_wed = new JCheckBox("???");
		s_wed.setFont(new Font("??????", Font.PLAIN, 15));
		s_wed.setHorizontalAlignment(SwingConstants.CENTER);
		s_wed.setBounds(189, 377, 43, 39);
		contentPane.add(s_wed);

		JCheckBox s_thur = new JCheckBox("???");
		s_thur.setFont(new Font("??????", Font.PLAIN, 15));
		s_thur.setHorizontalAlignment(SwingConstants.CENTER);
		s_thur.setBounds(232, 382, 41, 29);
		contentPane.add(s_thur);

		JCheckBox s_fri = new JCheckBox("???");
		s_fri.setFont(new Font("??????", Font.PLAIN, 15));
		s_fri.setHorizontalAlignment(SwingConstants.CENTER);
		s_fri.setBounds(277, 377, 43, 39);
		contentPane.add(s_fri);

		JCheckBox s_sat = new JCheckBox("???");
		s_sat.setFont(new Font("??????", Font.PLAIN, 15));
		s_sat.setHorizontalAlignment(SwingConstants.CENTER);
		s_sat.setBounds(321, 382, 46, 29);
		contentPane.add(s_sat);

		JCheckBox s_sun = new JCheckBox("???");
		s_sun.setFont(new Font("??????", Font.PLAIN, 15));
		s_sun.setHorizontalAlignment(SwingConstants.LEFT);
		s_sun.setBounds(371, 382, 43, 29);
		contentPane.add(s_sun);

		s_memo = new JTextField();
		s_memo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (s_memo.getText().equals(" * ???????????? ??????")) {
					s_memo.setText("");
					s_memo.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (s_memo.getText().equals("")) {
					s_memo.setText(" * ???????????? ??????");
					s_memo.setForeground(new Color(153, 153, 153));
				}
			}
		});
		s_memo.setFont(new Font("??????", Font.PLAIN, 16));
		s_memo.setText(" * ???????????? ??????");
		s_memo.setToolTipText("");
		s_memo.setBounds(37, 427, 377, 82);
		contentPane.add(s_memo);
		s_memo.setColumns(10);

		s_roll_num = new JTextField();
		s_roll_num.setFont(new Font("??????", Font.PLAIN, 14));
		s_roll_num.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (s_roll_num.getText().equals(" * ?????? ??????????????? ??????????????????. ???) 010-0000-0000")) {
					s_roll_num.setText("");
					s_roll_num.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (s_roll_num.getText().equals("")) {
					s_roll_num.setText(" * ?????? ??????????????? ??????????????????. ???) 010-0000-0000");
					s_roll_num.setForeground(new Color(153, 153, 153));
				}
			}
		});
		s_roll_num.setText(" * ?????? ??????????????? ??????????????????. ???) 010-0000-0000");
		s_roll_num.setBounds(37, 519, 377, 34);
		contentPane.add(s_roll_num);
		s_roll_num.setColumns(10);

		JComboBox s_who_guardian1 = new JComboBox();
		s_who_guardian1.setBounds(37, 563, 86, 23);
		contentPane.add(s_who_guardian1);

		JComboBox s_who_guardian2 = new JComboBox();
		s_who_guardian2.setBounds(37, 605, 86, 23);
		contentPane.add(s_who_guardian2);

		s_guardian1 = new JTextField();
		s_guardian1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (s_guardian1.getText().equals(" * ?????????1 ??????")) {
					s_guardian1.setText("");
					s_guardian1.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (s_guardian1.getText().equals("")) {
					s_guardian1.setText(" * ?????????1 ??????");
					s_guardian1.setForeground(new Color(153, 153, 153));
				}
			}
		});
		s_guardian1.setText(" * ?????????1 ??????");
		s_guardian1.setColumns(10);
		s_guardian1.setBounds(135, 563, 93, 29);
		contentPane.add(s_guardian1);

		s_guardian2 = new JTextField();
		s_guardian2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (s_guardian2.getText().equals(" * ?????????2 ??????")) {
					s_guardian2.setText("");
					s_guardian2.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (s_guardian2.getText().equals("")) {
					s_guardian2.setText(" * ?????????2 ??????");
					s_guardian2.setForeground(new Color(153, 153, 153));
				}
			}
		});
		s_guardian2.setText(" * ?????????2 ??????");
		s_guardian2.setColumns(10);
		s_guardian2.setBounds(135, 602, 93, 29);
		contentPane.add(s_guardian2);

		JButton s_save_btn = new JButton("??????");
		s_save_btn.setFont(new Font("???????????????", Font.PLAIN, 16));
		s_save_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// s_name.setText(" * ????????? ??????????????????.");
			}
		});
		s_save_btn.setBounds(73, 657, 144, 46);
		contentPane.add(s_save_btn);

		JButton s_addMore_btn = new JButton("?????? ?????? ??????");
		s_addMore_btn.setFont(new Font("???????????????", Font.PLAIN, 15));
		s_addMore_btn.setBounds(244, 657, 144, 46);
		contentPane.add(s_addMore_btn);

		address = new JTextField();
		address.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (address.getText().equals(" * ????????? ??????????????????. ???) 00????????? 000??? 000???")) {
					address.setText("");
					address.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (address.getText().equals("")) {
					address.setText(" * ????????? ??????????????????. ???) 00????????? 000??? 000???");
					address.setForeground(new Color(153, 153, 153));
				}
			}
		});
		address.setText(" * ????????? ??????????????????. ???) 00????????? 000??? 000???");
		address.setFont(new Font("??????", Font.PLAIN, 14));
		address.setColumns(10);
		address.setBounds(37, 261, 350, 29);
		contentPane.add(address);

		stu_num = new JTextField();
		stu_num.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (stu_num.getText().equals(" * ???????????? 4??????(??????)")) {
					stu_num.setText("");
					stu_num.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (stu_num.getText().equals("")) {
					stu_num.setText(" * ???????????? 4??????(??????)");
					stu_num.setForeground(new Color(153, 153, 153));
				}
			}
		});
		stu_num.setText(" * ???????????? 4??????(??????)");
		stu_num.setFont(new Font("??????", Font.PLAIN, 14));
		stu_num.setColumns(10);
		stu_num.setBounds(37, 300, 259, 29);
		contentPane.add(stu_num);

		JButton IDCheck_btn = new JButton("?????? ??????");
		IDCheck_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// ???????????? ??????, false?????? ?????? ??????
				boolean user = new StudentDAO().StuNumCheck(stu_num.getText());

				// ???????????? ??????????????? ????????? ?????? ?????? - ????????? ???????????? ???????????? ????????? ??????????????? ???????????? ????????? ??????
				char temp = 0;
				boolean flag = true;
				for (int i = 0; i < stu_num.getText().length(); i++) {
					temp = stu_num.getText().charAt(i); // ????????? str??? ????????? ????????? temp??? ??????
					if (temp < '0' || temp > '9') {// temp??? ?????? '0'????????? '9'?????? ??? ??????
						flag = false;
						break;
					}
				}
				if (flag == false) {
					JOptionPane.showMessageDialog(null, "????????? '??????' 4???????????????.\r\n?????? ??????????????????.");
				} else if (stu_num.getText().length() != 4) {
					JOptionPane.showMessageDialog(null, "????????? ?????? '4??????'?????????.\r\n?????? ??????????????????.");
				} else if (user == true) {
					JOptionPane.showMessageDialog(null, "?????? ???????????? ???????????????.\n??????????????? ??????????????????.");
				} else if (user == false) {
					JOptionPane.showMessageDialog(null, "??????????????? ???????????????.");
				}

			}
		});

		IDCheck_btn.setBackground(new Color(255, 240, 245));
		IDCheck_btn.setBounds(308, 300, 104, 29);
		contentPane.add(IDCheck_btn);

		s_guardian1_call = new JTextField();
		s_guardian1_call.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (s_guardian1_call.getText().equals(" * phone ???)010-0000-0000")) {
					s_guardian1_call.setText("");
					s_guardian1_call.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (s_guardian1_call.getText().equals("")) {
					s_guardian1_call.setText(" * phone ???)010-0000-0000");
					s_guardian1_call.setForeground(new Color(153, 153, 153));
				}
			}
		});
		s_guardian1_call.setFont(new Font("??????", Font.PLAIN, 13));
		s_guardian1_call.setText(" * phone ???)010-0000-0000");
		s_guardian1_call.setColumns(10);
		s_guardian1_call.setBounds(237, 564, 177, 29);
		contentPane.add(s_guardian1_call);

		s_guardian2_call = new JTextField();
		s_guardian2_call = new JTextField();
		s_guardian2_call.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (s_guardian2_call.getText().equals(" * phone ???)010-0000-0000")) {
					s_guardian2_call.setText("");
					s_guardian2_call.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (s_guardian2_call.getText().equals("")) {
					s_guardian2_call.setText(" * phone ???)010-0000-0000");
					s_guardian2_call.setForeground(new Color(153, 153, 153));
				}
			}
		});
		s_guardian2_call.setFont(new Font("??????", Font.PLAIN, 13));
		s_guardian2_call.setText(" * phone ???)010-0000-0000");
		s_guardian2_call.setColumns(10);
		s_guardian2_call.setBounds(237, 602, 177, 29);
		contentPane.add(s_guardian2_call);

		JLabel copyright_SYG_Label = new JLabel("???! ?????? - ?????? ?????? ??????");
		copyright_SYG_Label.setForeground(Color.WHITE);
		copyright_SYG_Label.setFont(new Font("??????????????? ??????", Font.PLAIN, 23));
		copyright_SYG_Label.setOpaque(true);
		copyright_SYG_Label.setHorizontalAlignment(SwingConstants.CENTER);
		copyright_SYG_Label.setBackground(SystemColor.activeCaption);
		copyright_SYG_Label.setBounds(0, 0, 450, 50);
		contentPane.add(copyright_SYG_Label);

		JButton stu_pic = new JButton("?????? +");
		stu_pic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, "????????? ?????????????????????????", "???!?????? - ?????? ?????? ??????",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {

				} else if (result == JOptionPane.YES_OPTION) {

					JFrame window = new JFrame();

					JFileChooser fileChooser = new JFileChooser();

					// ?????? Path??? ?????? ?????? (????????????)
					fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "//" + "Desktop"));

					// ???????????? ?????????
					FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg & png ??????", "png", "jpg");

					// ???????????? ????????? ??????
					fileChooser.addChoosableFileFilter(filter);

					// ???????????? ??????????????? ??? ??????
					int pic = fileChooser.showSaveDialog(window);
					System.out.println(pic);

					if (pic == JFileChooser.APPROVE_OPTION) {
						// ????????? ????????? ?????? ??????
						File selectedFile = fileChooser.getSelectedFile();
						String filePath = fileChooser.getSelectedFile().getPath();
						stu_pic.setIcon(new ImageIcon(filePath));
						// ?????? ??????
						System.out.println(selectedFile);
					}

				}
			}
		});
		stu_pic.setFont(new Font("??????", Font.PLAIN, 21));
		stu_pic.setBackground(new Color(255, 255, 255));
		stu_pic.setBounds(37, 96, 151, 144);
		contentPane.add(stu_pic);

		JComboBox s_year_1 = new JComboBox();
		s_year_1.setBounds(351, 206, 73, 23);
		contentPane.add(s_year_1);

		JComboBox s_month_1 = new JComboBox();
		s_month_1.setBounds(277, 206, 57, 23);
		contentPane.add(s_month_1);

		JLabel lblNewLabel = new JLabel("* ????????? ??????????????? ?????? ?????????????????????.");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("??????", Font.BOLD, 15));
		lblNewLabel.setBounds(37, 60, 365, 26);
		contentPane.add(lblNewLabel);

		JLabel enter_label = new JLabel("?????? ?????????");
		enter_label.setFont(new Font("???????????????", Font.PLAIN, 16));
		enter_label.setBounds(37, 354, 57, 19);
		contentPane.add(enter_label);

		JLabel lblNewLabel_1_1 = new JLabel("????????????");
		lblNewLabel_1_1.setFont(new Font("???????????????", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(200, 205, 86, 19);
		contentPane.add(lblNewLabel_1_1);

		JLabel day_label = new JLabel("?????? ??????");
		day_label.setFont(new Font("??????", Font.PLAIN, 14));
		day_label.setBounds(37, 390, 57, 15);
		contentPane.add(day_label);

	}
}