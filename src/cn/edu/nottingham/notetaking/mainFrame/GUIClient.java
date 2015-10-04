package cn.edu.nottingham.notetaking.mainFrame;


import javax.swing.SwingUtilities;

/**
 * open the app
 * 
 * @author RUNFA LV,WENYU DU
 * 
 */
 

public class GUIClient {
	/**
	 * the main method to open the app
	 * 
	 * @author RUNFA LV, WENYU DU
	 * 
	 */
	public static void main(String[] args) {
		//avoid unsafe of swing.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MyFrame();
			}
		});
	}
}
