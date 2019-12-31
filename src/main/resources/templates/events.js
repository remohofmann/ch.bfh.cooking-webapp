function init() {
    // Add eventhandlers to dropdownbuttons
    var cuisineElement = document.getElementById("cuisineDropdownFunction");
    cuisineElement.addEventListener("click", cuisineDropdownFunction);
    var courseElement = document.getElementById("courseDropdownFunction");
    courseElement.addEventListener("click", courseDropdownFunction);
    var ingredientElement = document.getElementById("ingredientDropdownFunction");
    ingredientElement.addEventListener("click", ingredientDropdownFunction);

    // Close the dropdown if the user clicks outside of it
    window.onclick = function(e) {
        if (!e.target.matches('.dropbtn')) {
            var myDropdown = document.getElementById("myDropdown");
            if (myDropdown.classList.contains('show')) {
                myDropdown.classList.remove('show');
            }
        }
    }
}

    function cuisineDropdownFunction() {
      document.getElementById("cuisineDropdownContent").classList.toggle("show");
    }
    function courseDropdownFunction() {
      document.getElementById("courseDropdownContent").classList.toggle("show");
    }
    function ingredientDropdownFunction() {
      document.getElementById("ingredientDropdownContent").classList.toggle("show");
    }