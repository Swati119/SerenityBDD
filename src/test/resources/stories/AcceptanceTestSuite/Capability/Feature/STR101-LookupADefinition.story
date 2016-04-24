Lookup a definition
Meta:
@author xyz

Narrative:
In order to talk better
As an English student
I want to look up word definitions

Scenario: TC101 - Lookup the definition of a word (Single Test Data)
Meta:
@author xyz
@tags Priority: 1, Defect: DE123
Given the user is on the Wiktionary home page
When the user looks up the definition of the word 'pear'
Then they should see the definition 'An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.'

Scenario: TC102 - Looking up abbreviations (Multiple Test Data)
Given the user is on the Wiktionary home page
When the user looks up the definition of the word '<word>'
Then they should see the definition '<definition>'
Examples:
|word		|definition					|
|USA		|United States of America	|
|HTML		|Hyper Text Markup Language	|
|CSS		|Cascading Style Sheets		|