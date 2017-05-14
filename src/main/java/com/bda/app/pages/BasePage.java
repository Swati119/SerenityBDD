package com.bda.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bda.app.constants.enums.Timeouts;
import com.bda.app.pages.objects.BasePageOR;

import net.serenitybdd.core.exceptions.SerenityManagedException;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.exceptions.ElementNotVisibleAfterTimeoutError;

public class BasePage extends PageObject implements BasePageOR {

	private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

	/**
	 * Instantiates a new base page.
	 */
	public BasePage() {
	}

	/**
	 * Instantiates a new base page.
	 *
	 * @param driver
	 *            the driver
	 */
	public BasePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Gets the page title.
	 *
	 * @return the page title
	 */
	public String getPageTitle() {
		String title = getDriver().getTitle();
		LOGGER.debug("Page title: {}", title);
		return title;
	}

	/**
	 * Checks for loaded.
	 *
	 * @return true, if successful
	 */
	public boolean waitForAngular() {
		boolean flag = false;
		try {
			getDriver().manage().timeouts().setScriptTimeout(Timeouts.SIXTY.secs, TimeUnit.SECONDS);
			waitForAngularRequestsToFinish();
			flag = true;
		} catch (SerenityManagedException swde) {
			LOGGER.warn("", swde);
		}
		return flag;
	}

	/**
	 * Maximize.
	 */
	public void maximize() {
		getDriver().manage().window().maximize();
	}

	/**
	 * Wait for document ready state to complete.
	 *
	 * @return true, if successful
	 */
	public boolean waitForDocumentReadyStateToComplete() {
		boolean flag = false;
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(getDriver(), Timeouts.SIXTY.secs);
		flag = wait.until(expectation);
		return flag;
	}

	/**
	 * Click.
	 *
	 * @param element
	 *            the element
	 * @throws Exception 
	 */
	protected void click(WebElement element) {
		if (waitFor(ExpectedConditions.elementToBeClickable(element)) != null) {
			if (element.isDisplayed()) {
				// Do nothing
			} else {
				bringElementToVisibleArea(element);
			}
			clickOn(element);
		} else {
			LOGGER.error("Element to be clicked is not clickable i.e not visible/enabled!");
			throw new ElementNotVisibleAfterTimeoutError("Element to be clicked is not clickable i.e not visible/enabled!");
		}
	}

	/**
	 * Bring element to visible area.
	 *
	 * @param element
	 *            the element
	 */
	protected void bringElementToVisibleArea(WebElement element) {
		evaluateJavascript("arguments[0].scrollIntoView(true);", element);
	}
}
