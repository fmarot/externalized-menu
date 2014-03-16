package com.teamtter.module2;

import java.awt.Color;
import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import com.teamtter.menu.MenuDescriptor;
import com.teamtter.modules.Module;

public class Module2 implements Module {

	@Override
	public Component getMainComponent() {
		JPanel jPanel = new JPanel();
		jPanel.setBackground(Color.PINK);
		return jPanel;
	}

	@Override
	public String getName() {
		return "Module1";
	}

	@Override
	public MenuDescriptor getMenuDescriptor() {
		return new Module2MenuDescriptor();
	}

	@Override
	public List<String> getApplications() {
		return Arrays.asList("appA", "appZ", "appE", "appR", "appT", "appY");
	}
}
