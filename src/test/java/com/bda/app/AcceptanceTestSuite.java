package com.bda.app;

import net.serenitybdd.jbehave.SerenityStories;

public class AcceptanceTestSuite extends SerenityStories {
	
	/**
	 * Instantiates a new acceptance test suite.
	 */
	public AcceptanceTestSuite() {
		findStoriesIn("**//*Acceptance*");
	}
}
