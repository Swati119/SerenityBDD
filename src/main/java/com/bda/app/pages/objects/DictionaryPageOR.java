package com.bda.app.pages.objects;

import org.openqa.selenium.By;

import com.bda.app.html.elements.Button;
import com.bda.app.html.elements.InputText;

public interface DictionaryPageOR {

	InputText	txtSearchTerms	= new InputText(By.name("search"));
	Button		btnLookup		= new Button(By.name("go"));

}
