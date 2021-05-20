Feature: Fill contact information

Scenario Outline: Positive test, send values to firstname and lastname area 
Given Initialize the browser with chrome
And Navigate to "https://www.amdocs.com/" Site
And User accept cookies
When Click on Contact page
Then User enters firstname as "Mustafa" and lastname as "Aras"
And close browsers

Examples:
|firstname			|lastname	|
|Mustafa			|Aras		|