package com.bda.app.html.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * All input types: http://www.w3schools.com/tags/att_input_type.asp
 * @author zeeshans
 *
 */
public class InputRadio extends BaseElement {

	private static final Logger	LOGGER	= LoggerFactory.getLogger(InputRadio.class);

	/**
	 * Instantiates a new input radio.
	 *
	 * @param locator
	 *            the locator
	 */
	public InputRadio(By locator) {
		super(locator);
	}
	
}
