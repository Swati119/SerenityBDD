package com.bda.app.html.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Textarea extends BaseElement {
	
	private static final Logger	LOGGER	= LoggerFactory.getLogger(Textarea.class);
	
	/**
	 * Instantiates a new textarea.
	 *
	 * @param locator
	 *            the locator
	 */
	public Textarea(By locator) {
		super(locator);
	}

}
