Feature: Entering vehicle data for Automobile

Scenario Outline: Entering valid vehicle data for Automobile
Given when user is in Tricentis Home page
When he enters vehicle data for automobile from "<SheetName>" and <RowNumber>
Then he can click on next to enter insurant data

Examples:

|SheetName|RowNumber|
|AutomobileVehicleData|0|
|AutomobileVehicleData|1|