import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class ParametersFrame extends JInternalFrame {
	
	private JTextArea paramText;
	private JScrollPane scroller1;
	private int size_internal_Param_frame_x;
	private int size_internal_Param_frame_y;
	
	public ParametersFrame(int x,int y, int size_internal_Param_frame_x,int size_internal_Param_frame_y) {
		// TODO Auto-generated constructor stub
		super(("Parameters Window"), true, true, true, true);
		this.size_internal_Param_frame_x = size_internal_Param_frame_x;
		this.size_internal_Param_frame_y = size_internal_Param_frame_y;
		paramText = new JTextArea();
		paramText.setBackground(Color.white);
		paramText.setLineWrap(true);
		paramText.setBounds(0, 0, 100, 70);
	
		scroller1 = new JScrollPane();
		scroller1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller1.setViewportView(paramText);
		scroller1.setBounds(0, 0, size_internal_Param_frame_x, size_internal_Param_frame_y);
		
		this.setBounds(x, y, size_internal_Param_frame_x, size_internal_Param_frame_y);
		this.getContentPane().add(scroller1);
		this.setVisible(true);
		
	}
	
	public JTextArea getParamText() {
		return paramText;
	}

	public void setParamText(JTextArea paramText) {
		this.paramText = paramText;
	}

	public JScrollPane getScroller1() {
		return scroller1;
	}

	public void setScroller1(JScrollPane scroller1) {
		this.scroller1 = scroller1;
	}

	public int getSize_internal_Param_frame_x() {
		return size_internal_Param_frame_x;
	}

	public void setSize_internal_Param_frame_x(int size_internal_Param_frame_x) {
		this.size_internal_Param_frame_x = size_internal_Param_frame_x;
	}

	public int getSize_internal_Param_frame_y() {
		return size_internal_Param_frame_y;
	}

	public void setSize_internal_Param_frame_y(int size_internal_Param_frame_y) {
		this.size_internal_Param_frame_y = size_internal_Param_frame_y;
	}

}
