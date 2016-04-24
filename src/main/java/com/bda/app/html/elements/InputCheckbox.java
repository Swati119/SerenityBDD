package com.bda.app.html.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * All input types: http://www.w3schools.com/tags/att_input_type.asp
 * @author zeeshans
 *
 */
public class InputCheckbox extends BaseElement {

	private static final Logger	LOGGER	= LoggerFactory.getLogger(InputCheckbox.class);

	/**
	 * Instantiates a new input checkbox.
	 *
	 * @param locator
	 *            the locator
	 */
	public InputCheckbox(By locator) {
		super(locator);
	}
	
}
