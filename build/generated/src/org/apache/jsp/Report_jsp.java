package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Database.DB_Connction;
import java.sql.ResultSet;

public final class Report_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
ResultSet rs = new DB_Connction().getReport(); 
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head> \n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <title>Report</title>\n");
      out.write("        <link href=\"/img/favicon.ico\" rel=\"icon\" type=\"image/x-icon\" />\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom fonts -->\n");
      out.write("        <link href=\"vendor/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>\n");
      out.write("\n");
      out.write("        <!-- Custom styles -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/jquery.steps.css\">\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/cal.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light fixed-top\" id=\"mainNav\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <a class=\"navbar-brand js-scroll-trigger\" href=\"#page-top\">Payroll Deductions Report</a>\n");
      out.write("                <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\n");
      out.write("                    <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link js-scroll-trigger\" href=\"index.html\">Home</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link js-scroll-trigger\" href=\"index.html#calculations\">Calculations</a>\n");
      out.write("                        </li> \n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link js-scroll-trigger\" href=\"index.html#contact\">Contact</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link js-scroll-trigger\" href=\"Report.jsp\">Report</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <section id=\"calculations\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12 text-center\">\n");
      out.write("                        <h2 class=\"section-heading\">Report</h2>\n");
      out.write("                        <hr class=\"my-4\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row justify-content-center\">\n");
      out.write("                    <form id=\"filter\" action=\"Filter.jsp\" class=\"col-8\" method=\"get\">\n");
      out.write("                        <h3></h3>\n");
      out.write("                        <fieldset> \n");
      out.write("                            <legend>User Data</legend>\n");
      out.write("                            <div class=\"form-group row\">\n");
      out.write("\n");
      out.write("                                <div class=\"col-12\">\n");
      out.write("                                    <label for=\"fistName\">From :</label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-12\">\n");
      out.write("                                    <input class=\"form-control col-12\" type=\"date\" name=\"f\"/>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group row\">\n");
      out.write("                                <div class=\"col-12\">\n");
      out.write("                                    <label for=\"lastName\">To :</label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-12\">\n");
      out.write("                                    <input class=\"form-control col-12\" type=\"date\" name=\"l\"/>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-lg-3 mx-auto\"> \n");
      out.write("                                <button class=\"btn btn-primary btn-xl text-center\" type=\"submit\" value=\"filter\">Filter</button>\n");
      out.write("                            </div>\n");
      out.write("<!--                            <br><input type=\"submit\" value=\"filter\"  style=\"   text-align: center; transition: 0.3s; margin: 4px 2px; background-color:  #99003d;color: white; border: none;border-radius: 15px;width: 80px;height: 40px;cursor: pointer;\"/>-->\n");
      out.write("                            <br>\n");
      out.write("                        </fieldset>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <table role=\"presentation\" class=\"table table-condensed table-striped \">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>First Name</th>\n");
      out.write("                        <th>Last Name</th>\n");
      out.write("                        <th>Code</th>\n");
      out.write("                        <th>Gross Pay</th>\n");
      out.write("                        <th>Date</th>\n");
      out.write("                        <th>Total Pay To Date</th>\n");
      out.write("                        <th>total tax due</th>\n");
      out.write("                        <th>SelectedPer</th>\n");
      out.write("                        <th>Nationality</th>\n");
      out.write("                        <th></th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody style=\"color:#99003d;\">\n");
      out.write("                    ");
while (rs.next()) {
      out.write("\n");
      out.write("                    <tr  >\n");
      out.write("                        <td>\n");
      out.write("                            ");
out.print(rs.getString(1)); 
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            ");
 out.print(rs.getString(2)); 
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            ");
 out.print(rs.getString(3)); 
      out.write(" \n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            ");
 out.print(rs.getFloat(4)); 
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            ");
 out.print(rs.getString(5)); 
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            ");
 out.print(rs.getFloat(6)); 
      out.write("\n");
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            ");
 out.print(rs.getFloat(7)); 
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            ");
 out.print(rs.getString(9)); 
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            ");
 out.print(rs.getString(10)); 
      out.write(" \n");
      out.write("                        </td>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
      out.write(" \n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </section>\n");
      out.write("        <!-- Footer -->\n");
      out.write("        <footer>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("                        <span class=\"copyright\">Copyright &copy; X-Team 2018</span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core JavaScript -->\n");
      out.write("        <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Plugin JavaScript -->\n");
      out.write("        <script src=\"vendor/jquery-easing/jquery.easing.min.js\"></script>\n");
      out.write("        <script src=\"vendor/scrollreveal/scrollreveal.min.js\"></script>\n");
      out.write("        <script src=\"vendor/jquery-validation/jquery.validate.min.js\"></script>\n");
      out.write("        <script src=\"js/modernizr-2.6.2.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.cookie-1.3.1.js\"></script>\n");
      out.write("        <script src=\"js/jquery.steps.min.js\"></script>\n");
      out.write("        <!-- Custom scripts for this template -->\n");
      out.write("        <script src=\"js/app.js\"></script>\n");
      out.write("        <script src=\"js/enable.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
