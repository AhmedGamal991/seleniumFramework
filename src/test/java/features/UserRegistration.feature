Feature: User Registration
I want to check that user can register in our website "e-commerc" . 

Scenario Outline: User Rigistration 

Given the user in home page
When he click on register link
And  he entered "<firstname>","<lastname>","<email>","<password>"
Then the registration page displayed successfuly 
 Examples:

| firstname | | lastname| | email | | password|
| ahmed | | gamal| | ahaah11@test.com | | 12345678|
| ahmed | | gamal| | ahaa33h1@test.com | | 12345678|