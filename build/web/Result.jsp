<%-- 
    Document   : Result
    Created on : Apr 14, 2019, 1:11:55 AM
    Author     : Roa'a
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id = "cal" scope = "session" class= "Java.Calculate_Code"></jsp:useBean>


    <!DOCTYPE html>
    <html>

        <head>
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <meta name="description" content="">
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

            <title>Money & Tax</title>
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

        <body id="page-top">

            <!-- Navigation -->
            <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
                <div class="container">
                    <a class="navbar-brand js-scroll-trigger" href="#page-top">Payroll Deductions</a>
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
<!--                            <li class="nav-item">
                                <a class="nav-link js-scroll-trigger" href="Report.jsp">Report</a>
                            </li>-->
                        </ul>
                    </div>
                </div>
            </nav>

            <section id="result">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <h2 class="section-heading">Result</h2>
                            <hr class="my-4">
                        </div>
                    </div>
                </div>

                <div class="col-8 container">

                    <dl class="dl-horizontal dl-horizontal-cra mrgn-tp-lg dl-label-value-pair-rhpd-md">
                        <dt>Name:</dt>
                        <dd style="color:#99003d;" >
                    <%= cal.getFristName()%> <%= cal.getLastName()%>
                    </dd>

                    <dt>Pay Period Frequency:</dt>
                    <dd style="color:#99003d;"> 
                        <%= cal.getSelectedPer()%>
                    </dd>

                    <dt>Tax Code:</dt>
                    <dd style="color:#99003d;"> 
                        <%= cal.getCode()%>
                    </dd>

                    <dt>Nationality:</dt>
                    <dd style="color:#99003d;"> 
                        <%= cal.getNationality()%>
                    </dd>
                </dl>


                <table role="presentation" class="table table-condensed table-striped ">
                    <tbody>
                        <tr>
                            <td>Gross Pay</td>
                            <td class="text-right"></td>
                            <td class="text-right" style="color:#99003d;">
                                <%= cal.getGrossPay()%>
                            </td>
                            <td class="text-right"></td>
                        </tr>

                        <tr>
                            <td>Total Free Pay</td>
                            <td class="text-right"></td>
                            <td class="text-right" style="color:#99003d;">
                                <%= cal.CodeCalculate()%>
                            </td>
                            <td class="text-right"></td>
                        </tr>

                        <tr>
                            <td><strong>Total pay to date</strong></td>
                            <td class="text-right"></td>
                            <td class="text-right"></td>
                            <td class="text-right" style="color:#99003d;">
                                <strong>
                                    <%= cal.totalPayToDate()%>
                                </strong>
                            </td>
                        </tr>
                        <tr>
                            <td>Total taxable pay to date</td>
                            <td class="text-right"></td>
                            <td class="text-right" style="color:#99003d;">
                                <%= cal.totaltaxablePayToDate()%> 
                            </td>
                            <td class="text-right"></td>
                        </tr>

                        <tr>
                            <td><strong>Total tax due</strong></td>
                            <td class="text-right"></td>
                            <td class="text-right"></td>
                            <td class="text-right" style="color:#99003d;">
                                <strong>
                                    <%= cal.totalTaxDue()%>
                                </strong>
                            </td>
                            <%--        
                                    <td class="text-right" style="color:#99003d;">
                                        <%= cal.totalTaxDue() %>
                                    </td>
                                    <td class="text-right"></td>
                                    <td class="text-right"></td>
                            --%>

                        </tr>

                        <tr>
                            <td></td>
                            <td class="text-right"></td>
                            <td class="text-right" style="color:#99003d;">
                                <strong>
                                    <%= cal.printCodeType()%>
                                </strong>
                            </td>
                    </tbody>
                </table>


            </div>
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
