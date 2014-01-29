<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="pinball" class="mwave.PinballSim" />

<html>
<head>
    <meta http-equiv="refresh" content="1">
</head>
<body>

<h3>pinball simulator on google app engine</h3>

<code>

    <%= pinball.getString().replaceAll("\n", "<br/>") %>

</code>

</body>
</html>
