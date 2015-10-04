package cn.edu.nottingham.notetaking.mainFrame;


import javax.swing.SwingUtilities;

/**
 * open the app
 * 
 * @author RUNFA LV,WENYU DU
 * 
 */
 
// add a new comment from master branch which would result in a conflict

//Add a new comment from Eason/test branch

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
