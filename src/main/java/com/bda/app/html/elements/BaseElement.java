package com.bda.app.html.elements;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bda.app.pages.BasePage;

/**
 * All HTML elements: http://www.w3schools.com/html/html_form_elements.asp
 * @author zeeshans
 *
 */
public class BaseElement extends BasePage {
	
	private static final Logger	LOGGER	= LoggerFactory.getLogger(BaseElement.class);
	
	By	locator;

	/**
	 * Instantiates a new base element.
	 *
	 * @param locator
	 *            the locator
	 */
	public BaseElement(By locator) {
		this.locator = locator;
	}

	/**
	 * Click.
	 */
	public void click() {
		waitFor(ExpectedConditions.presenceOfElementLocated(locator));
		click(element(locator));
		LOGGER.info("Clicked on element located {}", locator);
	}

	/**
	 * Gets the attribute.
	 *
	 * @param attr
	 *            the attr
	 * @return the attribute
	 */
	public String getAttribute(String attr) {
		WebElement element = element(locator);
		assertThat(hasAttribute(attr)).isTrue();
		String value = element.getAttribute(attr);			
		return value;
	}

	/**
	 * Checks for attribute.
	 *
	 * @param attr
	 *            the attr
	 * @return true, if successful
	 */
	public boolean hasAttribute(String attr) {
		boolean flag = false;
		WebElement element = element(locator);
		if(element.getAttribute(attr)!=null) {
			flag = true;
		}
		return flag;
	}

	/**
	 * Checks if is displayed.
	 *
	 * @return true, if is displayed
	 */
	public boolean isDisplayed() {
		boolean flag = false;
		waitFor(ExpectedConditions.presenceOfElementLocated(locator));
		flag = isElementVisible(locator);
		LOGGER.info("Element located {} is displayed? {}", locator, flag);
		return flag;
	}
	
	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	public boolean isEnabled() {
		boolean flag = false;
		waitFor(ExpectedConditions.elementToBeClickable(locator));
		flag = element(locator).isEnabled();
		LOGGER.info("Element located {} is enabled? {}", locator, flag);
		return flag;
	}
	
	/**
	 * Wait for absence.
	 *
	 * @param locator
	 *            the locator
	 */
	public void waitForAbsence(By locator) {
		assertThat(waitFor(ExpectedConditions.invisibilityOfElementLocated(locator))).isNotNull();
	}

}
