import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Alarm {
JFrame AlarmClock;
JLabel label1;
JButton button1;
JButton button2;
JLabel label2;
JFrame SetAlarmTime;
JLabel label3;
JTextField text1;
JTextField text2;
JTextField text3;
JButton button3;
Integer Input1 = -1;
Integer Input2 = -1;
Integer Input3 = -1;
Calendar cal;

	
	public static void main(String[] args) {
		new Alarm();
	}

	
	public Alarm() {
		AlarmClock = new JFrame();
		AlarmClock.setTitle("Alarm Clock");
		AlarmClock.setSize(408, 400);
		AlarmClock.setResizable(false);
		AlarmClock.setLocationRelativeTo(null);
		AlarmClock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SetAlarmTime = new JFrame();
		SetAlarmTime.setTitle("Set Alarm Time");
		SetAlarmTime.setSize(300, 300);
		SetAlarmTime.setResizable(false);
		SetAlarmTime.setLocationRelativeTo(null);
		
		ListenForButton lForButton = new ListenForButton();
		ListenForOK lForOK = new ListenForOK();

		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		
		label3 = new JLabel();
		label3.setText("Set Alarm Time");
		label3.setBounds(95,0,150,50);
		label3.setFont(new Font(label3.getName(), Font.PLAIN, 18));
		panel2.add(label3);
		
		text1 = new JTextField();
		text1.setBounds(75,60,40,25);
		text1.setText("HH");
		panel2.add(text1);
		
		text2 = new JTextField();
		text2.setBounds(130,60,40,25);
		text2.setText("MM");
		panel2.add(text2);
		
		text3 = new JTextField();
		text3.setBounds(190,60,40,25);
		text3.setText("ss");
		panel2.add(text3);

		button3 = new JButton("OK");
		button3.setBounds(100, 110, 90, 30);
		button3.addActionListener(lForOK);
		panel2.add(button3);
		
		label2 = new JLabel();
		//label2.setText(timeStamp);
		label2.setBounds(80,40,398,30);
		label2.setFont(new Font(label2.getName(), Font.PLAIN, 18));
		panel.add(label2);
		
		label1 = new JLabel();
		label1.setText("Alarm");
		label1.setBounds(180,0,398,30);
		label1.setFont(new Font(label1.getName(), Font.PLAIN, 18));
		panel.add(label1);
		
		button2  = new JButton("Set Alarm");
		button2.setBounds(155, 90, 90, 30);
		button2.addActionListener(lForButton);
		panel.add(button2);
		
		AlarmClock.add(panel);
		AlarmClock.setVisible(true);
		
		SetAlarmTime.add(panel2);
		
		while(true) {
			cal = Calendar.getInstance();
			Date date = cal.getTime();
			label2.setText(date.toString());
			Integer Hours = cal.get(Calendar.HOUR);
			Integer Minutes = cal.get(Calendar.MINUTE);
			Integer Seconds = cal.get(Calendar.SECOND);
			
			if(Hours.equals(Input1) && (Minutes.equals(Input2) && (Seconds.equals(Input3)))){
				JOptionPane.showMessageDialog(AlarmClock, "ALARM GOING OFF");
			}
		}
		
				
			} 
	private class ListenForButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SetAlarmTime.setVisible(true);
		}
	}
	
	private class ListenForOK implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String txt = text1.getText(); 
			Input1 = Integer.valueOf(txt);
			System.out.println(Input1);
			String txt2 = text2.getText();
			Input2 = Integer.valueOf(txt2);
			System.out.println(Input2);
			String txt3 = text3.getText();
			Input3 = Integer.valueOf(txt3);
			System.out.println(Input3);
			
		}
	}
}



