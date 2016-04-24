package com.bda.app.html.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Button extends BaseElement {

	private static final Logger	LOGGER	= LoggerFactory.getLogger(Button.class);
	
	/**
	 * Instantiates a new button.
	 *
	 * @param locator
	 *            the locator
	 */
	public Button(By locator) {
		super(locator);
	}

}
