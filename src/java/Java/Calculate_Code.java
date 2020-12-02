package Java;

import Database.DB_Connction;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calculate_Code {

    String[] monthNumber = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
    int[] DaysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int selectedTaxMonth;
    String cumlativelyORnon;
    String fristName = "";
    String lastName = "";
    String code;
    String nationality;
    float grossPay;
    String selectedPer;
    int selectedDate;
    String selectedMonth = "";

    int selectedYear;
    float previousPay;
    float hourlyRate;
    float hoursPerWeek;
    float totalTaxDue;
    String knowORnot;

    public String getKnowORnot() {
        return knowORnot;
    }

    public void setKnowORnot(String knowORnot) {
        this.knowORnot = knowORnot;
    }

    public String getCumlativelyORnon() {
        return cumlativelyORnon;
    }

    public void setCumlativelyORnon(String cumlativelyORnon) {
        this.cumlativelyORnon = cumlativelyORnon;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public float getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(float grossPay) {

        if (getKnowORnot().equals("2")) {
            if (getSelectedPer().equals("year")) {
                this.grossPay = ((float) (getHourlyRate() * getHoursPerWeek() * 52.0));
            } else if (getSelectedPer().equals("month")) {
                this.grossPay = ((float) (getHourlyRate() * getHoursPerWeek() * 4.0));
            } //(getSelectedPer().equals("week")) 
            else {
                this.grossPay = ((float) (getHourlyRate() * getHoursPerWeek()));
            }
        } else {
            this.grossPay = grossPay;
        }
    }

    public String getSelectedPer() {
        return selectedPer;
    }

    public void setSelectedPer(String selectedPer) {
        this.selectedPer = selectedPer;
    }

    public int getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(int selectedDate) {
        this.selectedDate = selectedDate;
    }

    public String getSelectedMonth() {
        return selectedMonth;
    }

    public int getMonth(String SM) {
        int x = 0;
        String[] monthNumber1 = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int i = 0; i < 12; i++) {
            if (SM.equals(monthNumber1[i])) {
                x = i + 1;
            }
        }
        return x;
    }

    public void setSelectedMonth(String selectedMonth) {
        this.selectedMonth = selectedMonth;
    }

    public void setSelectedYear(int selectedYear) {
        this.selectedYear = selectedYear;
    }

    public int getSelectedYear() {
        return selectedYear;
    }

    public float getPreviousPay() {
        return previousPay;
    }

    public void setPreviousPay(float previousPay) {
        this.previousPay = previousPay;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(float hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getSelectedTaxMonth() {

        if (getCumlativelyORnon().equals("1")) {

            int month = 1;
            int date = getSelectedDate();
            int taxMonth = 1;
            String sm = getSelectedMonth();
            for (int n = 0; n < monthNumber.length - 1; n++) {
                if (sm.equals(monthNumber[n])) {
                    month = n + 1;
                    break;
                }
            }
            if (month >= 4) {
                if (date >= 6) {
                    taxMonth = month - 3;
                } else {
                    taxMonth = month - 4;
                }
            } else {
                if (date >= 6) {
                    taxMonth = (month + 12) - 3;
                } else {
                    taxMonth = (month + 12) - 4;
                }
            }
            System.out.println("Tax Month >> " + taxMonth);
            return taxMonth;
        } else {
            return 1;
        }
    }

    public int getSelectedTaxWeek() {
        if (getCumlativelyORnon().equals("1")) {

            int[] DaysOfMonth1 = {30, 31, 30, 31, 31, 30, 31, 30, 31, 31, 28, 31};
            String[] monthNumber1 = {"Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan", "Feb", "Mar",};

            int totalDays = 0;
            String month = getSelectedMonth();
            int day = getSelectedDate();

            for (int i = 0; i < monthNumber1.length; i++) {
                totalDays += DaysOfMonth1[i];
                if (monthNumber1[i].equals(month)) {
                    totalDays -= (DaysOfMonth1[i] + 5);
                    totalDays += day;
                    break;
                }
            }
            if (totalDays < 0) {
                totalDays = 364;
            }
            int week = (totalDays / 7);
            if (((totalDays % 7) != 0)) {
                week++;
            }
            System.out.println("Tax Week >> " + week);
            return week;
        } else {
            return 1;
        }

    }

    // Table A Month
    public float calculateMonthTotalFreePay(int monthCode, int TaxMonth) {

        float TotalFreePay = 0;

        if (monthCode > 500) {

            float pay = 0;
            float x = 0;
            int count = monthCode / 500;
            int rest = monthCode % 500;
            float s1 = (float) (5000.0 / 12.0);
            BigDecimal l = new BigDecimal(s1).setScale(2, RoundingMode.UP);
            float f1 = l.floatValue();

            f1 = f1 * TaxMonth;
            System.out.println("Code more than 500 (End of the Table ) >>" + f1);

            if (rest > 0) {
                try {
                    DB_Connction db_connction = new DB_Connction();
                    ResultSet resultSet = db_connction.getMonthCode(TaxMonth);

                    while (resultSet.next()) {
                        if (resultSet.getFloat(1) == rest) {
                            TotalFreePay = resultSet.getFloat(2);
                        }
                    }
                    BigDecimal l2 = new BigDecimal(TotalFreePay).setScale(2, RoundingMode.DOWN);
                    float f2 = l2.floatValue();
                    System.out.println("Code From Databse >>> " + f2);

                    TotalFreePay = f2 + (f1 * count);
                    System.out.println("Total Free Pay >> " + TotalFreePay);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Calculate_Code.class
                            .getName()).log(Level.SEVERE, null, ex);

                } catch (SQLException ex) {
                    Logger.getLogger(Calculate_Code.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            } // res = 0 ;
            else {
                try {
                    DB_Connction db_connction = new DB_Connction();
                    ResultSet resultSet = db_connction.getMonthCode(TaxMonth);

                    while (resultSet.next()) {
                        if (resultSet.getFloat(1) == 500) {
                            TotalFreePay = resultSet.getFloat(2);
                        }
                    }
                    BigDecimal l2 = new BigDecimal(TotalFreePay).setScale(2, RoundingMode.DOWN);
                    float f2 = l2.floatValue();
                    System.out.println("Code From Databse >> " + f2);

                    TotalFreePay = f2 + (f1 * (count - 1));
                    System.out.println("Total Free Pay >> " + TotalFreePay);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Calculate_Code.class
                            .getName()).log(Level.SEVERE, null, ex);

                } catch (SQLException ex) {
                    Logger.getLogger(Calculate_Code.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }// Code < 500 
        else {
            try {
                float d = 0;
                DB_Connction db_connction = new DB_Connction();
                ResultSet resultSet = db_connction.getMonthCode(TaxMonth);

                while (resultSet.next()) {
                    if (resultSet.getFloat(1) == monthCode) {
                        TotalFreePay = resultSet.getFloat(2);
                        d = resultSet.getFloat(2);
                    }
                }
                BigDecimal l2 = new BigDecimal(TotalFreePay).setScale(2, RoundingMode.DOWN);
                float f2 = l2.floatValue();
                System.out.println("Code From Database >> " + f2);
                TotalFreePay = f2;
                System.out.println("Total Free Pay >> " + TotalFreePay);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Calculate_Code.class
                        .getName()).log(Level.SEVERE, null, ex);

            } catch (SQLException ex) {
                Logger.getLogger(Calculate_Code.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

        return TotalFreePay;
    }

    // Table A Week 
    public float calculateWeekTotalFreePay(int weekCode, int TaxWeek) {

        float TotalFreePay = 0;

        if (weekCode > 500) {

            float pay = 0;
            float x = 0;
            int count = weekCode / 500;
            int rest = weekCode % 500;

            float s1 = (float) (5000.0 / 52.0);
            BigDecimal l = new BigDecimal(s1).setScale(2, RoundingMode.UP);
            float f1 = l.floatValue();

            f1 = f1 * TaxWeek;
            System.out.println("Code more than 500 (End of the Table ) >> " + f1);

            if (rest > 0) {
                try {
                    DB_Connction db_connction = new DB_Connction();
                    ResultSet resultSet = db_connction.getWeekCode(TaxWeek);

                    while (resultSet.next()) {
                        if (resultSet.getFloat(1) == rest) {
                            TotalFreePay = resultSet.getFloat(2);
                            System.out.println("Code From Databse >> " + TotalFreePay);
                        }
                    }
                    BigDecimal l2 = new BigDecimal(TotalFreePay).setScale(2, RoundingMode.DOWN);
                    float f2 = l2.floatValue();

                    TotalFreePay = f2 + (f1 * count);
                    System.out.println("Total Free Pay >> " + TotalFreePay);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Calculate_Code.class
                            .getName()).log(Level.SEVERE, null, ex);

                } catch (SQLException ex) {
                    Logger.getLogger(Calculate_Code.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            } // res = 0 ;
            else {
                try {
                    DB_Connction db_connction = new DB_Connction();
                    ResultSet resultSet = db_connction.getWeekCode(TaxWeek);

                    while (resultSet.next()) {
                        if (resultSet.getFloat(1) == 500) {
                            TotalFreePay = resultSet.getFloat(2);
                            System.out.println("Code From Databse >> " + TotalFreePay);
                        }
                    }

                    BigDecimal l2 = new BigDecimal(TotalFreePay).setScale(2, RoundingMode.DOWN);
                    float f2 = l2.floatValue();
                    TotalFreePay = f2 + (f1 * count - 1);
                    System.out.println("Total Free Pay >> " + TotalFreePay);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Calculate_Code.class
                            .getName()).log(Level.SEVERE, null, ex);

                } catch (SQLException ex) {
                    Logger.getLogger(Calculate_Code.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }// Code < 500 
        else {
            try {
                DB_Connction db_connction = new DB_Connction();
                ResultSet resultSet = db_connction.getWeekCode(TaxWeek);

                while (resultSet.next()) {
                    if (resultSet.getFloat(1) == weekCode) {
                        TotalFreePay = resultSet.getFloat(2);
                        System.out.println("Code From Database >> " + TotalFreePay);
                    }
                }
                BigDecimal l2 = new BigDecimal(TotalFreePay).setScale(2, RoundingMode.DOWN);
                float f2 = l2.floatValue();
                TotalFreePay = f2;
                System.out.println("Total Free Pay >> " + TotalFreePay);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Calculate_Code.class
                        .getName()).log(Level.SEVERE, null, ex);

            } catch (SQLException ex) {
                Logger.getLogger(Calculate_Code.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

        return TotalFreePay;
    }

    public float CodeCalculate() throws ClassNotFoundException {

        String c = getCode();
        int codeLength = c.length();
        String codeCalculate = c.toUpperCase();
        float f = 0;

        if (getNationality().equals("UK")) {
            if (Objects.equals(codeCalculate.charAt(codeLength - 1), 'L')) {

                codeCalculate = codeCalculate.substring(0, codeLength - 1);
                int CalCode = Integer.parseInt(codeCalculate);

                System.out.println("Code Interger >> " + CalCode);

                if (getSelectedPer().equals("month")) {
                    int m = getSelectedTaxMonth();
                    f = calculateMonthTotalFreePay(CalCode, m);
                } else {
                    int w = getSelectedTaxWeek();
                    f = calculateWeekTotalFreePay(CalCode, w);
                }
            } else if (Objects.equals(codeCalculate.charAt(0), 'K')) {

            } else {
                //totalTaxDue();
            }

        } else {

            int CalCode;
            if (codeCalculate.equals("SBR")) {
                CalCode = 0;
            } else if (codeCalculate.equals("SD0")) {
                CalCode = 0;
            } else if (codeCalculate.equals("SD1")) {
                CalCode = 0;
            } else {
                codeCalculate = codeCalculate.substring(1, codeLength - 1);
                CalCode = Integer.parseInt(codeCalculate);

                System.out.println("Code Interger >> " + CalCode);

                if (getSelectedPer().equals("month")) {
                    int m = getSelectedTaxMonth();
                    f = calculateMonthTotalFreePay(CalCode, m);
                } else {
                    int w = getSelectedTaxWeek();
                    f = calculateWeekTotalFreePay(CalCode, w);
                }
            }
        }

        return f;
    }

    public float totalPayToDate() {

        if (getCumlativelyORnon().equals("1")) {
            float totalPay = getPreviousPay() + getGrossPay();
            BigDecimal l2 = new BigDecimal(totalPay).setScale(2, RoundingMode.DOWN);
            float f2 = l2.floatValue();
            totalPay = f2;
            System.out.println("Total Pay To Date >> " + totalPay);

            return totalPay;
        } else {
            float totalPay = getGrossPay();
            BigDecimal l2 = new BigDecimal(totalPay).setScale(2, RoundingMode.DOWN);
            float f2 = l2.floatValue();
            totalPay = f2;
            System.out.println("Total Pay To Date >> " + totalPay);

            return totalPay;
        }
    }

    public float totaltaxablePayToDate() throws ClassNotFoundException {

        float taxablePay = totalPayToDate() - CodeCalculate();
        BigDecimal l2 = new BigDecimal(taxablePay).setScale(2, RoundingMode.UP);
        float f2 = l2.floatValue();
        taxablePay = f2;
        System.out.println("Total taxable Pay To Date >> " + taxablePay);

        return taxablePay;
    }

    public float totalTaxDue() throws ClassNotFoundException {
        float x = (float) 0.0;

        if (getNationality().equals("UK")) {
            if (getCode().equals("BR")) {
                return ((float) ((getPreviousPay() + getGrossPay()) * 0.20));
            } else if (getCode().equals("D0")) {
                return ((float) ((getPreviousPay() + getGrossPay()) * 0.40));
            } else if (getCode().equals("D1")) {
                return ((float) ((getPreviousPay() + getGrossPay()) * 0.45));
            } else {
                BigDecimal l2 = new BigDecimal(totaltaxablePayToDate()).setScale(0, RoundingMode.DOWN);
                int payroll = l2.intValue();
                //int payroll = 18900;
                //int payroll = 57500;

                int month = getSelectedTaxMonth();
                float f = 0;
                try {
                    DB_Connction db_Connction = new DB_Connction();
                    ResultSet resultSet = db_Connction.getUkMonth();

                    while (resultSet.next()) {
                        if (resultSet.getFloat(1) == month) {
                            if (payroll <= resultSet.getFloat(2)) {
                                f = (float) (payroll * 0.20);
                            } else if (payroll < resultSet.getFloat(3)) {
                                f = payroll - resultSet.getFloat(2);
                                f = (float) (f * 0.40);
                                f = f + resultSet.getFloat(4);
                            } // payroll > resultSet.getFloat(5)
                            else {
                                f = payroll - resultSet.getFloat(5);
                                f = (float) (f * 0.45);
                                f = f + resultSet.getFloat(6);

                            }
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Calculate_Code.class.getName()).log(Level.SEVERE, null, ex);

                } catch (SQLException ex) {
                    Logger.getLogger(Calculate_Code.class.getName()).log(Level.SEVERE, null, ex);
                }
                BigDecimal l3 = new BigDecimal(f).setScale(2, RoundingMode.DOWN);
                f = l3.floatValue();
                System.out.println("Total Tax Due >> " + f);

                return f;
            }

        } else {
            if (getCode().equals("SBR")) {
                return ((float) ((getPreviousPay() + getGrossPay()) * 0.20));
            } else if (getCode().equals("SD0")) {
                return ((float) ((getPreviousPay() + getGrossPay()) * 0.40));
            } else if (getCode().equals("SD1")) {
                return ((float) ((getPreviousPay() + getGrossPay()) * 0.45));
            } else {

                BigDecimal l2 = new BigDecimal(totaltaxablePayToDate()).setScale(0, RoundingMode.DOWN);
                int payroll = l2.intValue();
                //int payroll = 18900;
                //int payroll = 57500;
                int month = getSelectedTaxMonth();
                float f = 0;
                try {
                    DB_Connction db_Connction = new DB_Connction();
                    ResultSet resultSet = db_Connction.getScottishMonth();

                    while (resultSet.next()) {
                        if (resultSet.getFloat(1) == month) {
                            if (payroll <= resultSet.getFloat(2)) {
                                f = (float) (payroll * 0.20);
                            } else if (payroll < resultSet.getFloat(3)) {
                                f = payroll - resultSet.getFloat(2);
                                f = (float) (f * 0.40);
                                f = f + resultSet.getFloat(4);
                            } // payroll > resultSet.getFloat(5)
                            else {
                                f = payroll - resultSet.getFloat(5);
                                f = (float) (f * 0.45);
                                f = f + resultSet.getFloat(6);

                            }
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Calculate_Code.class.getName()).log(Level.SEVERE, null, ex);

                } catch (SQLException ex) {
                    Logger.getLogger(Calculate_Code.class.getName()).log(Level.SEVERE, null, ex);
                }

                BigDecimal l3 = new BigDecimal(f).setScale(2, RoundingMode.DOWN);
                f = l3.floatValue();
                System.out.println("Total Tax Due >> " + f);

                return f;
            }
        }

    }

    public String printCodeType() {

        if (getCode().toUpperCase().equals("BR")) {
            return "The Tax Deduction at The Basic Rate";
        } else if (getCode().toUpperCase().equals("D0")) {
            return "The Tax Deduction at The Higher Rate";

        } else if (getCode().toUpperCase().equals("D1")) {
            return "The Tax Deduction at The Additional Rate";

        } else if (getCode().toUpperCase().equals("SBR")) {
            return "The Tax Deduction at The Scottish Basic Rate";

        } else if (getCode().toUpperCase().equals("SD0")) {
            return "The Tax Deduction at The Scottish Higher Rate";

        } else if (getCode().toUpperCase().equals("SD1")) {
            return "The Tax Deduction at The Scottish Additional Rate";

        }

        return "";
    }

}
