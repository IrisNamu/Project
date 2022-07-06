import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class attendance_Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    System.out.println("sqlDate:" + sqlDate);
	    System.out.println("utilDate:" + utilDate);
	    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					attendance_Main frame = new attendance_Main();
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
	public attendance_Main() {
		setTitle("\uC624! \uCD9C\uC11D \u2013 \uD559\uC0DD\uAD00\uB9AC\uC2DC\uC2A4\uD15C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel who_early_leave = new JPanel();
		who_early_leave.setBackground(Color.WHITE);
		who_early_leave.setBounds(0, 0, 466, 713);
		contentPane.add(who_early_leave);
		who_early_leave.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 204, 204));
		separator.setBackground(new Color(255, 204, 204));
		separator.setBounds(0, 200, 454, -5);
		who_early_leave.add(separator);

		JPanel Menubar = new JPanel();
		Menubar.setBackground(new Color(19, 25, 53));
		Menubar.setBounds(0, 0, 454, 64);
		who_early_leave.add(Menubar);
		Menubar.setLayout(null);

		JButton attendanceMenu = new JButton("");
		attendanceMenu.setIcon(new ImageIcon(attendance_Main.class.getResource("/img/click_atten_menu.png")));
		attendanceMenu.setBounds(0, 0, 75, 64);
		Menubar.add(attendanceMenu);
		attendanceMenu.setBackground(new Color(19, 25, 53));

		JButton manageStudent_Menu = new JButton("");
		manageStudent_Menu.setIcon(new ImageIcon(attendance_Main.class.getResource("/img/stu_menu.png")));
		manageStudent_Menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				management_Student manage = new management_Student(); // 홈화면 호출
				manage.setVisible(true);
			}
		});
		manageStudent_Menu.setBackground(new Color(19, 25, 53));
		manageStudent_Menu.setBounds(76, 0, 75, 64);
		Menubar.add(manageStudent_Menu);

		JButton cak_Menu = new JButton("");
		cak_Menu.setIcon(new ImageIcon(attendance_Main.class.getResource("/img/cal_menu.png")));
		cak_Menu.setBackground(new Color(19, 25, 53));
		cak_Menu.setBounds(152, 0, 75, 64);
		Menubar.add(cak_Menu);
		
		JButton statistics_Menu_1 = new JButton("");
		statistics_Menu_1.setBackground(new Color(19, 25, 53));
		statistics_Menu_1.setBounds(227, 0, 75, 64);
		Menubar.add(statistics_Menu_1);
		
		JButton statistics_Menu_2 = new JButton("");
		statistics_Menu_2.setBackground(new Color(19, 25, 53));
		statistics_Menu_2.setBounds(303, 0, 75, 64);
		Menubar.add(statistics_Menu_2);
		
		JButton statistics_Menu_2_1 = new JButton("");
		statistics_Menu_2_1.setBackground(new Color(19, 25, 53));
		statistics_Menu_2_1.setBounds(379, 0, 75, 64);
		Menubar.add(statistics_Menu_2_1);

		JPanel chooseDateCheck = new JPanel();
		chooseDateCheck.setBackground(new Color(255, 224, 172));
		chooseDateCheck.setBounds(0, 67, 454, 150);
		who_early_leave.add(chooseDateCheck);
		chooseDateCheck.setLayout(null);
		
		
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    System.out.println("sqlDate:" + sqlDate);
	    System.out.println("utilDate:" + utilDate);
	    

		JButton all_student = new JButton("\uC804\uCCB4");
		all_student.setBackground(Color.DARK_GRAY);
		all_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		all_student.setForeground(Color.WHITE);
		all_student.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		all_student.setBounds(76, 85, 65, 38);
		chooseDateCheck.add(all_student);

		JButton who_attendance = new JButton("\uB4F1\uC6D0");
		who_attendance.setBackground(new Color(51, 153, 204));
		who_attendance.setForeground(new Color(255, 255, 255));
		who_attendance.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		who_attendance.setBounds(153, 85, 65, 38);
		chooseDateCheck.add(who_attendance);

		JButton who_absent = new JButton("\uACB0\uC11D");
		who_absent.setBackground(new Color(255, 0, 0));
		who_absent.setForeground(new Color(255, 255, 255));
		who_absent.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		who_absent.setBounds(307, 84, 65, 38);
		chooseDateCheck.add(who_absent);

		JButton who_Did_Not_attend = new JButton("\uBBF8\uB4F1");
		who_Did_Not_attend.setBackground(new Color(51, 204, 204));
		who_Did_Not_attend.setForeground(new Color(255, 255, 255));
		who_Did_Not_attend.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		who_Did_Not_attend.setBounds(230, 85, 65, 38);
		chooseDateCheck.add(who_Did_Not_attend);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 145, 454, 33);
		chooseDateCheck.add(separator_1);
		separator_1.setBackground(new Color(255, 204, 204));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setForeground(new Color(255, 250, 250));
		dateChooser.getCalendarButton().setFont(new Font("굴림", Font.BOLD, 13));
		dateChooser.getCalendarButton().setText("날짜");
		dateChooser.getCalendarButton().setBackground(new Color(105, 105, 105));
		dateChooser.setDateFormatString("M월 d일 a h시 mm분 (y년)");
		dateChooser.setBounds(76, 25, 295, 46);
		chooseDateCheck.add(dateChooser);

		JPanel date_panel = new JPanel();
		date_panel.setBackground(new Color(255, 224, 172));
		date_panel.setBounds(12, 10, 430, 61);

		JPanel panel = new JPanel();
		panel.setBounds(0, 219, 454, 39);
		who_early_leave.add(panel);
		panel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 478, 39);
		menuBar.setBackground(Color.WHITE);
		panel.add(menuBar);

		JMenu sort_nenubar = new JMenu("  정렬방법   ∨  ");
		sort_nenubar.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		sort_nenubar.setBackground(new Color(255, 255, 204));
		sort_nenubar.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(sort_nenubar);

		JRadioButtonMenuItem name_order = new JRadioButtonMenuItem("\uC774\uB984\uC21C");
		name_order.setBackground(new Color(255, 255, 255));
		sort_nenubar.add(name_order);

		JRadioButtonMenuItem reverse_name = new JRadioButtonMenuItem("\uC774\uB984\uC5ED\uC21C");
		reverse_name.setBackground(new Color(255, 255, 255));
		sort_nenubar.add(reverse_name);

		JRadioButtonMenuItem lower_grade = new JRadioButtonMenuItem("\uC800\uD559\uB144\uC21C");
		lower_grade.setBackground(new Color(255, 255, 255));
		sort_nenubar.add(lower_grade);

		JRadioButtonMenuItem upper_grade = new JRadioButtonMenuItem("\uACE0\uD559\uB144\uC21C");
		upper_grade.setBackground(new Color(255, 255, 255));
		sort_nenubar.add(upper_grade);

		JMenu day_menubar = new JMenu("  요일    ∨  ");
		day_menubar.setHorizontalAlignment(SwingConstants.CENTER);
		day_menubar.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		day_menubar.setBackground(new Color(255, 255, 204));
		menuBar.add(day_menubar);

		JRadioButtonMenuItem mon = new JRadioButtonMenuItem("\uC6D4\uC694\uC77C");
		mon.setBackground(Color.WHITE);
		day_menubar.add(mon);

		JRadioButtonMenuItem tue = new JRadioButtonMenuItem("\uD654\uC694\uC77C");
		tue.setBackground(Color.WHITE);
		day_menubar.add(tue);

		JRadioButtonMenuItem wed = new JRadioButtonMenuItem("\uC218\uC694\uC77C");
		wed.setBackground(Color.WHITE);
		day_menubar.add(wed);

		JRadioButtonMenuItem thurs = new JRadioButtonMenuItem("\uBAA9\uC694\uC77C");
		thurs.setBackground(Color.WHITE);
		day_menubar.add(thurs);

		JRadioButtonMenuItem fri = new JRadioButtonMenuItem("\uAE08\uC694\uC77C");
		fri.setBackground(Color.WHITE);
		day_menubar.add(fri);

		JRadioButtonMenuItem sat = new JRadioButtonMenuItem("\uD1A0\uC694\uC77C");
		sat.setBackground(Color.WHITE);
		day_menubar.add(sat);

		JRadioButtonMenuItem special_lecture = new JRadioButtonMenuItem("일요일");
		special_lecture.setBackground(Color.WHITE);
		day_menubar.add(special_lecture);
		
		textField = new JTextField();
		menuBar.add(textField);
		textField.setFont(new Font("굴림", Font.BOLD, 15));
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setText("직접 검색");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("검색");
		menuBar.add(btnNewButton);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBackground(new Color(255, 255, 255));
		scrollBar.setForeground(new Color(255, 204, 102));
		scrollBar.setBounds(427, 257, 23, 456);
		who_early_leave.add(scrollBar);

		JPanel panel_who_attendance = new JPanel();
		panel_who_attendance.setToolTipText("MM월 dd일 a H시 mm분 (yyyy년)");
		panel_who_attendance.setBounds(0, 257, 454, 456);
		who_early_leave.add(panel_who_attendance);
		panel_who_attendance.setLayout(null);

		JButton add_student_btn = new JButton("+");
		add_student_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int result = JOptionPane.showConfirmDialog(null, "학생 정보를 추가하시겠습니까?", "오!출석 - 학생 추가하기",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {

				} else if (result == JOptionPane.YES_OPTION) {
					addStudentPage addstudent = new addStudentPage(); // 홈화면 호출
					addstudent.setVisible(true);
				}
			}
		});
		add_student_btn.setBounds(311, 391, 106, 55);
		panel_who_attendance.add(add_student_btn);
		add_student_btn.setBackground(new Color(102, 153, 204));
		add_student_btn.setForeground(Color.WHITE);
		add_student_btn.setFont(new Font("굴림", Font.BOLD, 40));

	}
}