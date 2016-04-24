package com.bda.app.html.elements;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bda.app.constants.enums.Timeouts;

/**
 * 
 * All input types: http://www.w3schools.com/tags/att_input_type.asp
 * @author zeeshans
 *
 */
public class InputText extends BaseElement {

	private static final Logger	LOGGER	= LoggerFactory.getLogger(InputText.class);

	/**
	 * Instantiates a new input text.
	 *
	 * @param locator
	 *            the locator
	 */
	public InputText(By locator) {
		super(locator);
	}

	/**
	 * Clear.
	 */
	public void clear() {
		element(locator).clear();
		LOGGER.info("Cleared element located {}", locator);
		assertThat(element(locator).getTextValue()).as("Unable to clear element located %s", locator).isEmpty();
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		String value = element(locator).getTextValue();
		LOGGER.info("Value of Element located {} : {}", locator, value);
		return value;
	}

	/**
	 * Sets the text.
	 *
	 * @param expectedText
	 *            the new text
	 */
	public void setText(String expectedText) {
		try {
			click();
			enter(expectedText).intoField(locator);
			waitABit(Timeouts.FIVE.seconds / 5);
			String actualText = element(locator).getTextValue();
			LOGGER.info("Element located {} has value: {}", locator, actualText);
			assertThat(actualText).isEqualToIgnoringCase(expectedText);
		} catch (NoSuchElementException nsee) {
			LOGGER.error("Element not found! {}", nsee);
			fail("Element not found!", nsee);
		} catch (ElementNotVisibleException enve) {
			LOGGER.error("Element not visible! {}", enve);
			fail("Element not visible!", enve);
		} finally {
			waitForDocumentReadyStateToComplete();
		}
	}
}
