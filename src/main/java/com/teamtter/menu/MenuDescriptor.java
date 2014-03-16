package com.teamtter.menu;

import java.util.List;

public interface MenuDescriptor {
	List<ButtonDescription> getButtons();

	void onButtonClicked(ButtonDescription button);

	void registerButtonManager(ButtonManager manager);
}
