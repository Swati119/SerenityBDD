package com.bda.app.html.elements;

import static net.thucydides.core.matchers.BeanMatchers.the;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.thucydides.core.pages.components.HtmlTable;

public class Table extends BaseElement {
	
	private static final Logger	LOGGER	= LoggerFactory.getLogger(Table.class);
	HtmlTable					table;

	/**
	 * Instantiates a new table.
	 *
	 * @param locator
	 *            the locator
	 */
	public Table(By locator) {
		super(locator);
	}

	/**
	 * Gets the header count.
	 *
	 * @return the header count
	 */
	public int getHeaderCount() {
		int count = table.getHeadings().size();
		LOGGER.info("Table located {} has {} headers.", locator, count);
		return count;
	}

	/**
	 * Gets the row count.
	 *
	 * @return the row count
	 */
	public int getRowCount() {
		int count = table.getRows().size();
		LOGGER.info("Table located {} has {} rows.", locator, count);
		return count;
	}

	/**
	 * Gets the table header.
	 *
	 * @param locator
	 *            the locator
	 * @param headerName
	 *            the header name
	 * @return the table header
	 */
	public WebElement getTableHeader(By locator, String headerName) {
		WebElement target = null;
		List<WebElement> allHeaders = table.headingElements();
		LOGGER.info("Number of headers in table located {}: {}", locator, allHeaders.size());
		assertThat(allHeaders.size()).isGreaterThan(0);
		for (WebElement header : allHeaders) {
			if (header.getText().trim().equalsIgnoreCase(headerName)) {
				target = header;
				break;
			}
		}
		return target;
	}

	/**
	 * Gets the table header index.
	 *
	 * @param locator
	 *            the locator
	 * @param headerName
	 *            the header name
	 * @return the table header index
	 */
	public int getTableHeaderIndex(By locator, String headerName) {
		int index = -1;
		assertThat(hasHeaders()).isTrue();
		List<WebElement> allHeaders = table.headingElements();
		for (WebElement header : allHeaders) {
			if (header.getText().trim().equalsIgnoreCase(headerName)) {
				index = allHeaders.indexOf(header);
				break;
			}
		}
		return index;
	}

	/**
	 * Checks for headers.
	 *
	 * @return true, if successful
	 */
	public boolean hasHeaders() {
		boolean flag = false;
		int count = getHeaderCount();
		flag = count > 0;
		LOGGER.info("Element located {} has headers? {}", locator, flag);
		return flag;
	}

	/**
	 * Checks for rows.
	 *
	 * @return true, if successful
	 */
	public boolean hasRows() {
		boolean flag = false;
		int count = getRowCount();
		flag = count > 0;
		LOGGER.info("Element located {} has rows? {}", locator, flag);
		return flag;
	}

	/**
	 * Read table.
	 *
	 * @return the html table
	 */
	public HtmlTable readTable() {
		List<String> headings = ((HtmlTable) element(locator)).getHeadings();
		return new HtmlTable(element(locator), headings);
	}

	/**
	 * Select nth row.
	 *
	 * @param rowNumToBeSelected
	 *            the row num to be selected
	 */
	public void selectNthRow(int rowNumToBeSelected) {
		assertThat(getRowCount()).isGreaterThanOrEqualTo(rowNumToBeSelected);
		WebElement row = table.getRowElements().get(rowNumToBeSelected + 1);
		click(row);
	}

	/**
	 * Select row matching.
	 *
	 * @param locator
	 *            the locator
	 * @param headerName
	 *            the header name
	 * @param cellValue
	 *            the cell value
	 */
	public void selectRowMatching(By locator, String headerName, String cellValue) {
		assertThat(hasRows()).isTrue();
		WebElement row = table.findFirstRowWhere(the(headerName, equalTo(cellValue)));
		click(row);
	}

}
