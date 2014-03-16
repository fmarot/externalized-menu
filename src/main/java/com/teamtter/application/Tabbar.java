package com.teamtter.application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Tabbar extends JPanel {

	public Tabbar() {
		setBackground(Color.BLUE);
		setLayout(new BorderLayout());
	}

	public void setModuleApplications(List<String> applications) {
		removeAll();
		JTabbedPane tabs = new JTabbedPane();

		for (String currAppName : applications) {
			JPanel smallHiddenPanel = new JPanel();
			int width2 = getSize().width;
			smallHiddenPanel.setSize(width2, 0);
			tabs.addTab(currAppName, smallHiddenPanel);
		}

		add(tabs, BorderLayout.CENTER);
	}
}
