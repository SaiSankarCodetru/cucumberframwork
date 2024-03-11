Feature: Search and Place the order for products
Scenario: Search experience for product in both home and offer page

Given User is on GreenCart Landing page
When USer searched with shortname "Tom" and extracted actual name of product
Then user searched for "Tom" shortname in offers page 
And validate product name in offers page mateches with Landing Page