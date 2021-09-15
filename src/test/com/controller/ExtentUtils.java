package test.com.controller;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExtentUtils {
    private ThreadLocal<ExtentReports> reports=new ThreadLocal<>();

    public ExtentReports getReports() {
        return reports.get();
    }

    public void setReports() {
        SimpleDateFormat format = new SimpleDateFormat("MMddyyyy_HHmmss");

        String time =format.format(Calendar.getInstance().getTime());
        ExtentReports reporter = new ExtentReports(System.getProperty("user.dir")+"//reports//+"+time+"//ExtentReports.html",false, NetworkMode.ONLINE);
        reports.set(reporter);
    }

    public ExtentTest getTest() {
        return test.get();
    }

    public void setTest(String testName) {
        this.test.set(getReports().startTest(testName));

    }

    private ThreadLocal<ExtentTest> test=new ThreadLocal<>();
    private ExtentUtils(){}
    public static ExtentUtils instance;

    public static ExtentUtils getInstance(){
        if(instance==null){
            instance=new ExtentUtils();
        }
        return instance;
    }

    public void reportPass(String message){
        getTest().log(LogStatus.PASS,message);
    }

    public void reportFail(String message){
        getTest().log(LogStatus.FAIL,message);
    }

    public void reportInfo(String message){
        getTest().log(LogStatus.INFO,message);
    }
}
