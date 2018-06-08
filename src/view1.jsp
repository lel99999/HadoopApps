<html>
<head><title>Test Interface</head></head>
<body>
<%
    double num = Math.random();
    if (num > 0.95) {
  %>
      <h2>The lucky number is: !</h2><p>(<%= num %>)</p>
  <%
    } else {
  %>
      <h2>The number that is smaller than < 0.95 is:n ... </h2><p>(<%= num %>)</p>
  <%
    }
%>
</body>
</html>
