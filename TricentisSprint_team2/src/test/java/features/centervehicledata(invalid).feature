Feature: Entering vehicle data for Automobile

Scenario Outline: Entering invalid vehicle data for Automobile
Given when user is in Tricentis the Home page
When he enters invalid vehicle data for automobile from "<SheetName>" and <RowNumber>
Then he gets error message


Examples:

|SheetName|RowNumber|
|AutomobileVehicleData(Invalid)|0|
|AutomobileVehicleData(Invalid)|1|