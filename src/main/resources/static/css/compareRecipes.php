<?php

// We need 8 rows for: picture, rating, name, time, calories, difficulty, ingredients, preparation
// Column number is dependent from number of recipes to compare, plus 1 for column description
$rowTitle = ["Picture", "Rating", "Name", "Preparation time", "Calories", "Difficulty", "Ingredients", "Preparation"];
$rowCount = sizeof(rowTitle);
$ recipeNumber = 5;

for ($colindex = 1; $colindex <= recipeNumber; $colindex++) {
	echo "<tr>";
		for ($rowIndex = 1; $rowIndex <= rowCount; $rowIndex++) {
		echo "<td align = right>$colindex/$rowIndex</td>";
		}
	echo "</tr>";
}