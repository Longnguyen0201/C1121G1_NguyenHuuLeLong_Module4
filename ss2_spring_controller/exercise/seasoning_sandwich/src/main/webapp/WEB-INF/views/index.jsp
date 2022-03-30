<%--
  Created by IntelliJ IDEA.
  User: nhll0
  Date: 3/30/2022
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<style>
  /* The container */
  .container {
    display: block;
    position: relative;
    padding-left: 35px;
    margin-bottom: 12px;
    cursor: pointer;
    font-size: 22px;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
  }

  /* Hide the browser's default checkbox */
  .container input {
    position: absolute;
    opacity: 0;
    cursor: pointer;
    height: 0;
    width: 0;
  }

  /* Create a custom checkbox */
  .checkmark {
    position: absolute;
    top: 0;
    left: 0;
    height: 25px;
    width: 25px;
    background-color: #eee;
  }

  /* On mouse-over, add a grey background color */
  .container:hover input ~ .checkmark {
    background-color: #ccc;
  }

  /* When the checkbox is checked, add a blue background */
  .container input:checked ~ .checkmark {
    background-color: #2196F3;
  }

  /* Create the checkmark/indicator (hidden when not checked) */
  .checkmark:after {
    content: "";
    position: absolute;
    display: none;
  }

  /* Show the checkmark when checked */
  .container input:checked ~ .checkmark:after {
    display: block;
  }

  /* Style the checkmark/indicator */
  .container .checkmark:after {
    left: 9px;
    top: 5px;
    width: 5px;
    height: 10px;
    border: solid white;
    border-width: 0 3px 3px 0;
    -webkit-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    transform: rotate(45deg);
  }
</style>
<body>

<h1>Sandwich Condiments</h1>
<form method="post" action="/save" >
<label class="container">Lettuce
  <input type="checkbox" name="condiment" value="Lettuce">
  <span class="checkmark"></span>
</label>
<label class="container">Tomato
  <input type="checkbox" name="condiment" value="Tomato">
  <span class="checkmark"></span>
</label>
<label class="container">Mustard
  <input type="checkbox" name="condiment" value="Mustard">
  <span class="checkmark"></span>
</label>
<label class="container">Sprouts
  <input type="checkbox" name="condiment" value="Sprouts">
  <span class="checkmark"></span>
</label>
  <input type="submit" value="Save">
</form>
</body>
</html>
