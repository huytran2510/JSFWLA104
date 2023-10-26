const menuLink = document.querySelector(".menu-link");
const employeeList = document.getElementById("employee-list");
const addEmployee = document.getElementById("add-employee");
employeeList.style.display = "none";
addEmployee.style.display = "none";
menuLink.addEventListener("click", function (event) {
    event.preventDefault(); // Prevent the default link behavior
    // Toggle the display of content divs
    employeeList.style.display = "block";
    addEmployee.style.display = "block";
});
