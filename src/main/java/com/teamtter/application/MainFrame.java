package com.teamtter.application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.teamtter.menu.MenuDescriptor;
import com.teamtter.module1.Module1;
import com.teamtter.module2.Module2;
import com.teamtter.modules.Module;

public class MainFrame extends JFrame {

	private Module1 module1 = new Module1();
	private Module2 module2 = new Module2();

	private Tabbar tabbar;
	private HeaderBar headerBar;
	private JPanel centerPanel;

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Example GUI");
		setSize(700, 650);
		setLayout(new BorderLayout());
		createContent();
	}

	private void createContent() {
		JPanel wrappingPanel = new JPanel(new GridLayout(1, 2));
		this.add(wrappingPanel, BorderLayout.CENTER);

		JPanel moduleListPanel = new JPanel(new GridLayout(9, 1));
		JButton buttonShowModule1 = new JButton("show Module 1");
		buttonShowModule1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				showModule(module1);
			}
		});
		JButton buttonShowModule2 = new JButton("show Module 2");
		buttonShowModule2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				showModule(module2);
			}
		});
		moduleListPanel.add(buttonShowModule1);
		moduleListPanel.add(buttonShowModule2);
		wrappingPanel.add(moduleListPanel);

		JPanel rightPanel = new JPanel(new BorderLayout());
		wrappingPanel.add(rightPanel);
		tabbar = new Tabbar();
		headerBar = new HeaderBar();

		JPanel northPanel = new JPanel(new GridLayout(2, 1));
		northPanel.add(tabbar);
		northPanel.add(headerBar);
		rightPanel.add(northPanel, BorderLayout.NORTH);

		centerPanel = new JPanel(new BorderLayout());
		rightPanel.add(centerPanel, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.YELLOW);
		rightPanel.add(southPanel, BorderLayout.SOUTH);
	}

	void showModule(Module module) {
		centerPanel.removeAll();
		centerPanel.add(module.getMainComponent(), BorderLayout.CENTER);

		List<String> applications = module.getApplications();
		tabbar.setModuleApplications(applications);
		MenuDescriptor moduleMenuDescriptor = module.getMenuDescriptor();
		headerBar.reinitMenuFrom(moduleMenuDescriptor);

		revalidate();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainFrame mainFrame = new MainFrame();
				mainFrame.setVisible(true);
			}
		});
	}
}
