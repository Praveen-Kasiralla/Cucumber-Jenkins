Feature: product page

Scenario: click on footer link
Given Initialize the "firefox"  browser
Then navigate to "https://www.gillette.co.in/en-in"  website
When clicking on styling link in footer
Then verify if "Facial Hair Styles: The Anchor Beard" is present in articals
And exit the  browser