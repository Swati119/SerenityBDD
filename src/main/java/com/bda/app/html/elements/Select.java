package com.bda.app.html.elements;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Select extends BaseElement {
	
	private static final Logger	LOGGER	= LoggerFactory.getLogger(Select.class);

	/**
	 * Instantiates a new select.
	 *
	 * @param locator
	 *            the locator
	 */
	public Select(By locator) {
		super(locator);
	}
	
	/**
	 * Gets the dropdown options.
	 *
	 * @return the dropdown options
	 */
	public List<String> getDropdownOptions() {
		List<String> list = new ArrayList<>();
		list = element(locator).getSelectOptions();
		LOGGER.info("Dropdown items of element located {}: {}", locator, list);
		return list;
	}

	/**
	 * Gets the dropdown selected option.
	 *
	 * @return the dropdown selected option
	 */
	public String getDropdownSelectedOption() {
		String selectedOption = element(locator).getSelectedVisibleTextValue();
		LOGGER.debug("Dropdown selected option of element located {}: {}", locator, selectedOption);
		return selectedOption;
	}

	/**
	 * Select from dropdown.
	 *
	 * @param expectedText
	 *            the expected text
	 */
	public void selectFromDropdown(String expectedText) {
		if (!element(locator).getSelectedVisibleTextValue().equalsIgnoreCase(expectedText)) {
			element(locator).selectByVisibleText(expectedText);
			String actualText = element(locator).getSelectedVisibleTextValue();
			LOGGER.info("Current selected option in element located {} : {}", locator, actualText);
			assertThat(actualText).isEqualToIgnoringCase(expectedText);
		}
	}

}
