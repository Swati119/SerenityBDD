package com.bda.app.definitions.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

import com.bda.app.pages.DictionaryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

@SuppressWarnings("serial")
public class DictionarySteps extends ScenarioSteps {
	
	DictionaryPage dictionaryPage;

    /** Enters search text as.
	 *
	 * @param keyword
	 *            the keyword
	 */
    @Step
    public void entersSearchTextAs(String keyword) {
        dictionaryPage.setSearchTextAs(keyword);
    }

    /** Performs search.
	 */
    @Step
    public void performsSearch() {
        dictionaryPage.clickLookup();
    }

    /** Can view definition of.
	 *
	 * @param definition
	 *            the definition
	 */
    @Step
    public void canViewDefinitionOf(String definition) {
        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

    /** Checks if is on homepage.
	 */
    @Step
    public void isOnHomepage() {
        dictionaryPage.open();
    }

    /** Searches for.
	 *
	 * @param term
	 *            the term
	 */
    @Step
    public void searchesFor(String term) {
    	entersSearchTextAs(term);
        performsSearch();
    }
}
