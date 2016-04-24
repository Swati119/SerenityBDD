package com.bda.app.definitions;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.bda.app.definitions.steps.DictionarySteps;

import net.thucydides.core.annotations.Steps;

public class DictionaryDefinitions {
	
	@Steps
    DictionarySteps user;

    /** Given the user is on the wiktionary home page.
	 */
    @Given("the user is on the Wiktionary home page")
    public void givenTheUserIsOnTheWiktionaryHomePage() {
        user.isOnHomepage();
    }

    /** When the user looks up the definition of.
	 *
	 * @param word
	 *            the word
	 */
    @When("the user looks up the definition of the word '$word'")
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        user.searchesFor(word);
    }

    /** Then they should see a definition containing the words.
	 *
	 * @param definition
	 *            the definition
	 */
    @Then("they should see the definition '$definition'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        user.canViewDefinitionOf(definition);
    }
}
