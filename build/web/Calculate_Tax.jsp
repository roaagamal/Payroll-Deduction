<%--
  Created by IntelliJ IDEA.
  User: Roa'a
  Date: 04-Apr-19
  Time: 10:12 PM
  To change this template use File | Settings | File Templates.
--%>

<%@page import="java.util.Date"%>
<%@page import="Java.insertData"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="Error.jsp"%>

<jsp:useBean id = "cal" scope = "session" class= "Java.Calculate_Code"></jsp:useBean>

    <html>
        <head>
            <title>Title</title>
        </head>
        <body>

        <%

            if (request.getParameter("fistName") != null) {
                cal.setFristName(request.getParameter("fistName"));
            }
            if (request.getParameter("lastName") != null) {
                cal.setLastName(request.getParameter("lastName"));
            }

            if (request.getParameter("cumlativelyORnon").equals("1")) {
                cal.setSelectedDate(Integer.parseInt(request.getParameter("date")));
                cal.setSelectedMonth(request.getParameter("month"));
                System.out.println(request.getParameter("month"));
                cal.setSelectedYear(Integer.parseInt(request.getParameter("year")));
                cal.setPreviousPay(Float.parseFloat(request.getParameter("previous")));
            }
            cal.setKnowORnot(request.getParameter("knowORnot"));
            if (request.getParameter("knowORnot").equals("2")) {
                cal.setHourlyRate(Float.parseFloat(request.getParameter("hourlyRate")));
                cal.setHoursPerWeek(Float.parseFloat(request.getParameter("hoursPerWeek")));
            }

            cal.setSelectedPer(request.getParameter("payPeriod"));
            cal.setCode(request.getParameter("code"));
            cal.setGrossPay(Float.parseFloat(request.getParameter("grossPay")));
            cal.setNationality(request.getParameter("nationality"));
            cal.setCumlativelyORnon(request.getParameter("cumlativelyORnon"));

            insertData obj = new insertData(cal);
            response.sendRedirect("Result.jsp");

        %>


    </body>
</html>
