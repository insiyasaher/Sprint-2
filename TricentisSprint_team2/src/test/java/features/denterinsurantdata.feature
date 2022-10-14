Feature: Entering insurant data for Automobile

Scenario Outline: Entering valid insurant data for Automobile
Given when user is in Tricentis Enter Insurant Data page
When he enters valid insurant data for automobile from "<SheetName>" and <RowNumber>
Then he can click on next to enter product data

Examples:

|SheetName|RowNumber|
|AutomobileInsurantData(Valid)|0|
|AutomobileInsurantData(Valid)|1|