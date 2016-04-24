package com.bda.app.definitions;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.ScenarioType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseDefinitions {

	private static final Logger	LOGGER	= LoggerFactory.getLogger(BaseDefinitions.class);

	/**
	 * After any scenario.
	 */
	@AfterScenario
	// equivalent to @AfterScenario(uponOutcome=AfterScenario.Outcome.ANY)
	public void afterAnyScenario() {
	}

	/**
	 * After each example scenario.
	 */
	@AfterScenario(uponType = ScenarioType.EXAMPLE)
	public void afterEachExampleScenario() {
	}

	/**
	 * After failed scenario.
	 */
	@AfterScenario(uponOutcome = AfterScenario.Outcome.FAILURE)
	public void afterFailedScenario() {
	}

	/**
	 * After given story.
	 */
	@AfterStory(uponGivenStory = true)
	public void afterGivenStory() {
	}

	/**
	 * After stories.
	 */
	@AfterStories
	public void afterStories() {
	}

	/**
	 * After story.
	 */
	@AfterStory
	// equivalent to @AfterStory(uponGivenStory=false)
	public void afterStory() {
	}

	/**
	 * After successful scenario.
	 */
	@AfterScenario(uponOutcome = AfterScenario.Outcome.SUCCESS)
	public void afterSuccessfulScenario() {
	}

	/**
	 * Before each example scenario.
	 */
	@BeforeScenario(uponType = ScenarioType.EXAMPLE)
	public void beforeEachExampleScenario() {
	}

	/**
	 * Before each scenario.
	 */
	@BeforeScenario
	public void beforeEachScenario() {
	}

	/**
	 * Before given story.
	 */
	@BeforeStory(uponGivenStory = true)
	public void beforeGivenStory() {
	}

	/**
	 * Before stories.
	 */
	@BeforeStories
	public void beforeStories() {
	}

	/**
	 * Before story.
	 */
	@BeforeStory
	// equivalent to @BeforeStory(uponGivenStory=false)
	public void beforeStory() {
	}

}
