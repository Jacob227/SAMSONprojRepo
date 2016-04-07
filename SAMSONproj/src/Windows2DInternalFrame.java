import java.awt.Dimension;

import javax.swing.JInternalFrame;

public class Windows2DInternalFrame extends JInternalFrame {
	
	private BuffImage bfImg;
	private int size_internal_2d_frame_x;
	private int size_internal_2d_frame_y;
	
	public Windows2DInternalFrame(int size_internal_Main_frame_x, int size_internal_Main_frame_y ) {
		// TODO Auto-generated constructor stub
		super(("2D Window"), true, true, true, true);
		this.size_internal_2d_frame_x = size_internal_Main_frame_x;
		this.size_internal_2d_frame_y = size_internal_Main_frame_y;
		bfImg = new BuffImage(size_internal_Main_frame_x - 10, size_internal_Main_frame_y - 10 );
		this.add(bfImg);
		this.setSize(size_internal_Main_frame_x, size_internal_Main_frame_y);
		this.setMaximumSize(new Dimension(300, 240));
		this.moveToFront();
		this.setVisible(true);		
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
