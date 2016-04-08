import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.plaf.basic.BasicInternalFrameUI.InternalFramePropertyChangeListener;

public class Windows2DInternalFrame extends JInternalFrame {
	
	private BuffImage bfImg;
	private int size_internal_2d_frame_x;
	private int size_internal_2d_frame_y;
	private Boolean flagExit = false;
	private Windows2DInternalFrame tempForClose;

	public Windows2DInternalFrame(int size_internal_Main_frame_x, int size_internal_Main_frame_y ) {
		// TODO Auto-generated constructor stub
		super(("2D Window"), true, true, true, true);
		flagExit = false;
		tempForClose = this;
		this.size_internal_2d_frame_x = size_internal_Main_frame_x;
		this.size_internal_2d_frame_y = size_internal_Main_frame_y;
		bfImg = new BuffImage(size_internal_Main_frame_x - 10, size_internal_Main_frame_y - 10 );
		this.add(bfImg);
		this.setSize(size_internal_Main_frame_x, size_internal_Main_frame_y);
		this.setMaximumSize(new Dimension(300, 240));
		//this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.addInternalFrameListener(new addActionListenerClose());
		this.moveToFront();
		this.setVisible(true);		
	}	
	
	public Boolean getFlagExit() {
		return flagExit;
	}

	public void setFlagExit(Boolean flagExit) {
		this.flagExit = flagExit;
	}
	
	public class addActionListenerClose implements InternalFrameListener{

		@Override
		public void internalFrameActivated(InternalFrameEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void internalFrameClosed(InternalFrameEvent e) {
			// TODO Auto-generated method stub
			flagExit = true;
			try {
				tempForClose.setClosed(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		@Override
		public void internalFrameClosing(InternalFrameEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void internalFrameDeactivated(InternalFrameEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void internalFrameDeiconified(InternalFrameEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void internalFrameIconified(InternalFrameEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void internalFrameOpened(InternalFrameEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	

	public BuffImage getBfImg() {
		return bfImg;
	}

	public void setBfImg(BuffImage bfImg) {
		this.bfImg = bfImg;
	}

	public int getSize_internal_2d_frame_x() {
		return size_internal_2d_frame_x;
	}

	public void setSize_internal_2d_frame_x(int size_internal_2d_frame_x) {
		this.size_internal_2d_frame_x = size_internal_2d_frame_x;
	}

	public int getSize_internal_2d_frame_y() {
		return size_internal_2d_frame_y;
	}

	public void setSize_internal_2d_frame_y(int size_internal_2d_frame_y) {
		this.size_internal_2d_frame_y = size_internal_2d_frame_y;
	}

}
