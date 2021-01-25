<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<body>
<h2>Hello World!</h2>

<%
    List<Map<String, Object>> data = (List<Map<String, Object>>) request.getAttribute("data");
    out.println("");
    out.println("<table border=1px>");
    for (Map<String, Object> item : data) {
        Set<Map.Entry<String, Object>> entries = item.entrySet();
        out.println("<tr>");
        for (Map.Entry<String, Object> entry : entries) {
            out.println("<th>");
            out.println(entry.getKey());
            out.println("</th>");
        }
        out.println("</tr>");
        break;
    }

    for (Map<String, Object> item : data) {
        Set<Map.Entry<String, Object>> entries = item.entrySet();
        out.println("<tr>");
        for (Map.Entry<String, Object> entry : entries) {
            out.println("<td>");
            out.println(entry.getValue());
            out.println("</td>");
        }
        out.println("</tr>");
    }

    out.println("</table>");
%>
</body>
</html>
