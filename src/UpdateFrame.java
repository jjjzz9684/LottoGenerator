import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UpdateFrame  {

	List<Set> wl;
	JTextArea textArea;
	JScrollPane scroll;
	public UpdateFrame() {
		JFrame frame = new JFrame("Lotto Generator");
		JPanel panel = new JPanel();
		textArea = new JTextArea("", 5, 10);
		
		panel.setLayout(new FlowLayout());
		frame.add(panel, BorderLayout.NORTH);
		frame.add(textArea, BorderLayout.CENTER);

		wl = new WinList().getList();
		String str = "";
		for (int i=0; i<wl.size(); i++) {
			List<Integer> list = new ArrayList<Integer>(wl.get(i));
			Collections.sort(list);
			String strtmp = (i+1)+"È¸Â÷ : "+list+"\n";
			str += strtmp;
		}
		
		textArea.setText(str);
		scroll = new JScrollPane(textArea);
		frame.add(scroll);
		frame.setSize(500, 250);
		frame.setLocation(800, 400);
		frame.setVisible(true);
		
		
	}
}
