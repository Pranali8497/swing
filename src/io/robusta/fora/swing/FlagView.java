package io.robusta.fora.swing;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.Flag;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class FlagView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @wbp.nonvisual location=130,379
	 */
	Flag model;
	FlagController controller;

	public FlagView() {
		this.model = ForaDataSource.getInstance().getFlags().get(0);
		initView();
	}
	
	public FlagView(Flag flag) {
		this.model = flag;
		initView();
	}
	
	JTextPane commentPane;
	JTextPane flagContentPane;
	/**
	 * Create the panel.
	 */
	public void initView() {

		commentPane = new JTextPane();
		commentPane.setBackground(UIManager.getColor("Label.background"));
		commentPane.setEditable(false);
		commentPane.setText(model.getComment().getContent());
		add(commentPane);
		
		JLabel lblUser = new JLabel(String.valueOf(model.getComment().getUser()));
		lblUser.setVerticalAlignment(SwingConstants.TOP);
		lblUser.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/user.png")));
		add(lblUser);

		flagContentPane = new JTextPane();
		flagContentPane.setBackground(UIManager.getColor("Label.background"));
		flagContentPane.setEditable(false);
		flagContentPane.setText(model.getContent());
		add(flagContentPane);
		
		JButton buttonDel = new JButton("");
		buttonDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.del();
			}
		});
		buttonDel.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/delete.png")));
		add(buttonDel);
		

	}

	public void setController(FlagController controller) {
		this.controller = controller;
	}
	
}
