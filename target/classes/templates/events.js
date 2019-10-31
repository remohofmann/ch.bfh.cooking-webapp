function init() {
    // Add eventhandlers to dropdownbuttons
    var el = document.getElementById("cuisineDropdownFunction");
    el.addEventListener("click", toggleDropdownContent);
    var el = document.getElementById("courseDropdownFunction");
    el.addEventListener("click", toggleDropdownContent);
    var el = document.getElementById("ingredientDropdownFunction");
    el.addEventListener("click", toggleDropdownContent);

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
