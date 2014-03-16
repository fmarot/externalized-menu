package com.teamtter.application;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import lombok.extern.slf4j.Slf4j;

import com.teamtter.menu.ButtonDescription;
import com.teamtter.menu.ButtonDescription.ButtonType;
import com.teamtter.menu.ButtonManager;
import com.teamtter.menu.MenuDescriptor;

@Slf4j
public class HeaderBar extends JPanel implements ButtonManager {

	private Map<ButtonDescription, AbstractButton> description2Buttons = new HashMap<>();
	private MenuDescriptor moduleMenuDescriptor;

	public HeaderBar() {
		setBackground(Color.BLACK);
		this.setLayout(new FlowLayout());
	}

	public void reinitMenuFrom(MenuDescriptor moduleMenuDescriptor) {
		this.moduleMenuDescriptor = moduleMenuDescriptor;
		this.removeAll();
		// register so that the module can interract with us later
		moduleMenuDescriptor.registerButtonManager(this);
		// build the buttons
		for (ButtonDescription buttonDesc : moduleMenuDescriptor.getButtons()) {
			AbstractButton button = buildButtonFromDescription(buttonDesc);
			description2Buttons.put(buttonDesc, button);
			add(button);
		}
	}

	/** */
	private AbstractButton buildButtonFromDescription(final ButtonDescription buttonDesc) {
		AbstractButton result = null;
		ButtonType buttonType = buttonDesc.getType();
		switch (buttonType) {
		case SINGLE_SHOT:
			result = new JButton(buttonDesc.getI18nKey());
			break;
		case TOGGLE_STATE:
			result = new JToggleButton(buttonDesc.getI18nKey());
			break;
		default:
			log.error("Unknown button type {}", buttonType);
			break;
		}

		// on click, redirect the logic to the module
		result.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				moduleMenuDescriptor.onButtonClicked(buttonDesc);
			}
		});

		return result;
	}

	@Override
	public void releaseButton(ButtonDescription button) {
		// ...
	}

	@Override
	public void selectButton(ButtonDescription button) {
		// ...
	}
}
