Feature: Entering product data for Automobile

Scenario Outline: Entering valid product data for Automobile
Given when user is in Tricentis Enter Product Data page
When he enters valid product data for automobile from "<SheetName>" and <RowNumber>
Then he can click on next to select price option

Examples:

|SheetName|RowNumber|
|AutomobileProductData(Valid)|0|
