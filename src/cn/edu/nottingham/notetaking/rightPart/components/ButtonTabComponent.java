package cn.edu.nottingham.notetaking.rightPart.components;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

import cn.edu.nottingham.notetaking.rightPart.util.browser.WindowsAsTabs;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import java.awt.*;
import java.awt.event.*;

/**
 * component to be used as tabComponent; Contains a JLabel to show the text and
 * a JButton to close the tab it belongs to
 * 
 * @author PENGHAO LI,WENYU DU
 */
public class ButtonTabComponent extends JPanel {

    private static final long serialVersionUID = -431214147719656889L;
    private final JTabbedPane pane;
    private JWebBrowser browser;

    /**
     * constructor
     * 
     * @author PENGHAO LI,WENYU DU
     */
    public ButtonTabComponent(final JTabbedPane pane) {
	// unset default FlowLayout' gaps
	super(new FlowLayout(FlowLayout.LEFT, 0, 0));
	if (pane == null) {
	    throw new NullPointerException("TabbedPane is null");
	}
	this.pane = pane;
	setOpaque(false);

	// make JLabel read titles from JTabbedPane
	JLabel label = new JLabel() {

	    private static final long serialVersionUID = 8163807957523663051L;

	    public String getText() {
		int i = pane.indexOfTabComponent(ButtonTabComponent.this);
		if (i != -1) {
		    return pane.getTitleAt(i);
		}
		return null;
	    }
	};

	add(label);
	// add more space between the label and the button
	label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
	// tab button
	JButton button = new TabButton();
	add(button);
	// add more space to the top of the component
	setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
    }

    public void setBrowser(JWebBrowser browser) {
	this.browser = browser;
    }

    public String getBrowserUrl() {
	return browser.getResourceLocation();
    }

    /**
     * add a class to handle the close button
     * 
     * @author PENGHAO LI,WENYU DU
     */
    private class TabButton extends JButton implements ActionListener {

	private static final long serialVersionUID = -5814434535042355772L;

	/**
	 * constructor
	 * 
	 * @author PENGHAO LI,WENYU DU
	 */
	public TabButton() {
	    int size = 17;
	    setPreferredSize(new Dimension(size, size));
	    setToolTipText("close this tab");
	    // Make the button looks the same for all Laf's
	    setUI(new BasicButtonUI());
	    // Make it transparent
	    setContentAreaFilled(false);
	    // No need to be focusable
	    setFocusable(false);
	    setBorder(BorderFactory.createEtchedBorder());
	    setBorderPainted(false);
	    // Making nice rollover effect
	    // we use the same listener for all buttons
	    addMouseListener(buttonMouseListener);
	    setRolloverEnabled(true);
	    // Close the proper tab by clicking the button
	    addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
	    int i = pane.indexOfTabComponent(ButtonTabComponent.this);
	    if (i != -1) {
		pane.remove(i);
		if (pane.getTabCount() == 0) {
		    WindowsAsTabs.generateTabs(pane);
		}
	    }
	}

	// we don't want to update UI for this button
	public void updateUI() {
	}

	/**
	 * paint the cross
	 * 
	 * @author PENGHAO LI,WENYU DU
	 */
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g.create();
	    // shift the image for pressed buttons
	    if (getModel().isPressed()) {
		g2.translate(1, 1);
	    }
	    g2.setStroke(new BasicStroke(2));
	    g2.setColor(Color.BLACK);
	    if (getModel().isRollover()) {
		g2.setColor(Color.MAGENTA);
	    }
	    int delta = 6;
	    g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight()
		    - delta - 1);
	    g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight()
		    - delta - 1);
	    g2.dispose();
	}
    }

    private final static MouseListener buttonMouseListener = new MouseAdapter() {
	public void mouseEntered(MouseEvent e) {
	    Component component = e.getComponent();
	    if (component instanceof AbstractButton) {
		AbstractButton button = (AbstractButton) component;
		button.setBorderPainted(true);
	    }
	}

	public void mouseExited(MouseEvent e) {
	    Component component = e.getComponent();
	    if (component instanceof AbstractButton) {
		AbstractButton button = (AbstractButton) component;
		button.setBorderPainted(false);
	    }
	}
    };
}
