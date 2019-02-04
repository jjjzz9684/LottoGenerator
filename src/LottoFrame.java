import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LottoFrame implements ActionListener {

	JTextArea textArea;
	JButton updatebtn;
	JButton generatebtn;
	public LottoFrame() {
		JFrame frame = new JFrame("Lotto Generator");
		JPanel panel = new JPanel();
		textArea = new JTextArea("", 5, 10);
		updatebtn = new JButton("갱신");
		generatebtn = new JButton("번호생성");
		
		updatebtn.addActionListener(this);
		generatebtn.addActionListener(this);

		panel.setLayout(new FlowLayout());
		panel.add(updatebtn);
		panel.add(generatebtn);
		frame.add(panel, BorderLayout.NORTH);
		frame.add(textArea, BorderLayout.CENTER);

		frame.setSize(200, 200);
		frame.setLocation(300, 300);
		frame.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == generatebtn) {
			System.out.println("generate");
			String str = "";
	        for (int i = 0; i < 5; i++) {
	            str +=  (i+1) +"번째 : " + new Generator().generator().toString()+"\n";
	        }
	        textArea.setText(str);
		}
		if (e.getSource() == updatebtn) {
			UpdateFrame uf = new UpdateFrame();
		}
	}

}
/*import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LottoFrame extends Frame implements ActionListener {
	Frame f;
	Panel p;
	TextArea ta;
	Button update, generate;
	
	//public static void main(String[] args)
	public LottoFrame() {
		f = new Frame("Lotto Generator");
		p = new Panel();
		ta = new TextArea();
		
		update = new Button("갱신");
		generate = new Button("번호생성");
		
		generate.addActionListener(this);
		
		p.add(update); p.add(generate);
		f.add(p, BorderLayout.NORTH);
		f.add(ta, BorderLayout.CENTER);
		
		f.setSize(300, 150);
		f.setLocation(300, 300);
		
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		String name = arg0.getActionCommand();
		if(name.equals("번호생성")) {
	        for (int i = 0; i < 5; i++) {
	            ta.append( (i+1) +"번째 : " + new Generator().generator().toString()+"\n");
	        }
		}
		else {
			UpdateFrame uf = new UpdateFrame();
		}
		
	}

}
*/