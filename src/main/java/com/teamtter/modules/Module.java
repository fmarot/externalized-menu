package com.teamtter.modules;

import java.awt.Component;
import java.util.List;

import com.teamtter.menu.MenuDescriptor;

public interface Module {
	Component getMainComponent();

	String getName();

	MenuDescriptor getMenuDescriptor();

	List<String> getApplications();
}
