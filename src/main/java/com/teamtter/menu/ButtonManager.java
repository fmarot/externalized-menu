package com.teamtter.menu;

/**
 * Defines methods that can be called from a module
 * to interract with button it has no direct handle onto
 */
public interface ButtonManager {
	void releaseButton(ButtonDescription button);

	void selectButton(ButtonDescription button);

}
