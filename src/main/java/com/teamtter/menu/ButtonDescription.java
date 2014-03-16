package com.teamtter.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ButtonDescription {
	public enum ButtonType {
		SINGLE_SHOT,
		TOGGLE_STATE
	};

	public static final String MENU_VIEW = "MENU_VIEW";
	public static final String MENU_FILE = "MENU_FILE";
	public static final String MENU_ALONE = "MENU_ALONE";

	String iconName;
	String i18nKey;
	String partOfMenu;
	ButtonType type;

}
