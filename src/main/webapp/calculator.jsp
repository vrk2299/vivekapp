<%@ page import="com.vivek.app.CalculatorService" %>
<html>
<head>
<title>Calculator</title>
<style>
body{
    background:#0f2027;
    font-family:Arial;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}
.calculator{
    background:#1c1c1c;
    padding:20px;
    border-radius:15px;
}
input{
    width:100%;
    padding:10px;
    font-size:20px;
    margin-bottom:10px;
}
button{
    width:60px;
    height:60px;
    margin:5px;
    font-size:18px;
    border:none;
    border-radius:10px;
}
</style>
'''
<script>
function add(val){
    document.getElementById("expr").value += val;
}
function clearAll(){
    document.getElementById("expr").value="";
}
</script>
</head>
<body>

<div class="calculator">
<form method="post">
<input id="expr" name="expr" readonly/>

<br>

<button type="button" onclick="add('7')">7</button>
<button type="button" onclick="add('8')">8</button>
<button type="button" onclick="add('9')">9</button>
<button type="button" onclick="add('/')">/</button><br>

<button type="button" onclick="add('4')">4</button>
<button type="button" onclick="add('5')">5</button>
<button type="button" onclick="add('6')">6</button>
<button type="button" onclick="add('*')">*</button><br>

<button type="button" onclick="add('1')">1</button>
<button type="button" onclick="add('2')">2</button>
<button type="button" onclick="add('3')">3</button>
<button type="button" onclick="add('-')">-</button><br>

<button type="button" onclick="add('0')">0</button>
<button type="button" onclick="add('**')">^</button>
<button type="submit">=</button>
<button type="button" onclick="add('+')">+</button><br>

<button type="button" onclick="clearAll()">C</button>

</form>

<%
String expr = request.getParameter("expr");
if(expr!=null){
    CalculatorService calc = new CalculatorService();
    try{
        out.println("<h3 style='color:white'>"+calc.evaluate(expr)+"</h3>");
    }catch(Exception e){
        out.println("<h3 style='color:red'>Error</h3>");
    }
}
%>
'''
<br><a href="index.jsp" style="color:white;">Back</a>

</div>
</body>
</html>
