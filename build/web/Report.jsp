<%-- 
    Document   : report
    Created on : 17-Apr-2019, 11:43:39
    Author     : samar
--%>

<%@page import="Database.DB_Connction"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ResultSet rs = new DB_Connction().getReport(); %>
<!DOCTYPE html>
<html>
    <head> 
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Report</title>
        <link href="/img/favicon.ico" rel="icon" type="image/x-icon" />

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts -->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

        <!-- Custom styles -->
        <link rel="stylesheet" href="css/jquery.steps.css">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/cal.css" rel="stylesheet">
    </head>

    <body>
        <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="#page-top">Payroll Deductions Report</a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="index.html">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="index.html#calculations">Calculations</a>
                        </li> 
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="index.html#contact">Contact</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="Report.jsp">Report</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


        <section id="calculations">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading">Report</h2>
                        <hr class="my-4">
                    </div>
                </div>
            </div>

            <div class="container">
                <div class="row justify-content-center">
                    <form id="filter" action="Filter.jsp" class="col-8" method="get">
                        <h3></h3>
                        <fieldset> 
                            <legend>User Data</legend>
                            <div class="form-group row">

                                <div class="col-12">
                                    <label for="fistName">From :</label>
                                </div>
                                <div class="col-12">
                                    <input class="form-control col-12" type="date" name="f"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-12">
                                    <label for="lastName">To :</label>
                                </div>
                                <div class="col-12">
                                    <input class="form-control col-12" type="date" name="l"/>
                                </div>
                            </div>

                            <div class="col-lg-3 mx-auto"> 
                                <button class="btn btn-primary btn-xl text-center" type="submit" value="filter">Filter</button>
                            </div>
<!--                            <br><input type="submit" value="filter"  style="   text-align: center; transition: 0.3s; margin: 4px 2px; background-color:  #99003d;color: white; border: none;border-radius: 15px;width: 80px;height: 40px;cursor: pointer;"/>-->
                            <br>
                        </fieldset>
                    </form>
                </div>
            </div>



            <table role="presentation" class="table table-condensed table-striped ">
                <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Code</th>
                        <th>Gross Pay</th>
                        <th>Date</th>
                        <th>Total Pay To Date</th>
                        <th>total tax due</th>
                        <th>SelectedPer</th>
                        <th>Nationality</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody style="color:#99003d;">
                    <%while (rs.next()) {%>
                    <tr  >
                        <td>
                            <%out.print(rs.getString(1)); %>
                        </td>
                        <td>
                            <% out.print(rs.getString(2)); %>
                        </td>
                        <td>
                            <% out.print(rs.getString(3)); %> 
                        </td>
                        <td>
                            <% out.print(rs.getFloat(4)); %>
                        </td>
                        <td>
                            <% out.print(rs.getString(5)); %>
                        </td>
                        <td>
                            <% out.print(rs.getFloat(6)); %>

                        </td>
                        <td>
                            <% out.print(rs.getFloat(7)); %>
                        </td>
                        <td>
                            <% out.print(rs.getString(9)); %>
                        </td>
                        <td>
                            <% out.print(rs.getString(10)); %> 
                        </td>

                    </tr>
                    <%}%> 
                </tbody>
            </table>






        </section>
        <!-- Footer -->
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <span class="copyright">Copyright &copy; X-Team 2018</span>
                    </div>
                </div>
            </div>
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
        <script src="vendor/scrollreveal/scrollreveal.min.js"></script>
        <script src="vendor/jquery-validation/jquery.validate.min.js"></script>
        <script src="js/modernizr-2.6.2.min.js"></script>
        <script src="js/jquery.cookie-1.3.1.js"></script>
        <script src="js/jquery.steps.min.js"></script>
        <!-- Custom scripts for this template -->
        <script src="js/app.js"></script>
        <script src="js/enable.js"></script>

    </body>
</html>
