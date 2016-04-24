package com.bda.app.pages;

import static ch.lambdaj.Lambda.convert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bda.app.pages.objects.DictionaryPageOR;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.pages.WebElementFacade;

public class DictionaryPage extends BasePage implements DictionaryPageOR {

	/**
	 * Gets the definitions.
	 *
	 * @return the definitions
	 */
	public List<String> getDefinitions() {
		WebElementFacade definitionList = find(By.tagName("ol"));
		List<WebElement> results = definitionList
				.findElements(By.tagName("li"));
		return convert(results, toStrings());
	}

	/**
	 * To strings.
	 *
	 * @return the converter
	 */
	private Converter<WebElement, String> toStrings() {
		return new Converter<WebElement, String>() {
			public String convert(WebElement from) {
				return from.getText();
			}
		};
	}

	/**
	 * Sets the search text as.
	 *
	 * @param keyword
	 *            the new search text as
	 */
	public void setSearchTextAs(String keyword) {
		txtSearchTerms.setText(keyword);		
	}

	/**
	 * Click lookup.
	 */
	public void clickLookup() {
		btnLookup.click();
	}
}
