package com.teamtter.module1;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import com.teamtter.menu.ButtonDescription;
import com.teamtter.menu.ButtonDescription.ButtonType;
import com.teamtter.menu.ButtonManager;
import com.teamtter.menu.MenuDescriptor;

@Slf4j
public class Module1MenuDescriptor implements MenuDescriptor {

	@Getter
	private List<ButtonDescription> buttons = new ArrayList<>();
	private ButtonDescription button1;
	private ButtonDescription button2;
	private ButtonManager manager;

	public Module1MenuDescriptor() {
		buttons.add(createAction1Button());
		buttons.add(createAction2Button());
	}

	private ButtonDescription createAction1Button() {
		button1 = new ButtonDescription("icon1", "action1", ButtonDescription.MENU_FILE, ButtonType.SINGLE_SHOT);
		return button1;
	}

	private ButtonDescription createAction2Button() {
		button2 = new ButtonDescription("icon2", "action2", ButtonDescription.MENU_ALONE, ButtonType.TOGGLE_STATE);
		return button2;
	}

	@Override
	public void onButtonClicked(ButtonDescription button) {
		if (button == button1) {
			log.info("button1 clicked");
		} else if (button == button2) {
			log.info("button1 puched");
		}
	}

	@Override
	public void registerButtonManager(ButtonManager manager) {
		this.manager = manager;
	}

	/*
	 * TODO: notify manager when buttons have to be deselected, ...
	 */
}
