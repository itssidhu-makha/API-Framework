package test.com.controller;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExtentUtils {
    private ThreadLocal<ExtentReports> reports=new ThreadLocal<>();
    private ThreadLocal<ExtentTest> test=new ThreadLocal<>();
    public  ExtentReports getReports() {
        return reports.get();
    }

    public  synchronized void  setReports() {
        SimpleDateFormat format = new SimpleDateFormat("MMddyyyy_HHmmss");

        String time =format.format(Calendar.getInstance().getTime());
        ExtentReports reporter = new ExtentReports(System.getProperty("user.dir")+"//reports//+"+time+"//ExtentReports.html",false, NetworkMode.ONLINE);
        reports.set(reporter);
    }

    public  ExtentTest getTest() {
        return test.get();
    }

    public   void setTest(String testName) {
        test.set(getReports().startTest(testName));

    }


    private ExtentUtils(){}
    public static ExtentUtils instance;

    public static ExtentUtils getInstance(){
        if(instance==null){
            instance=new ExtentUtils();
        }
        return instance;
    }
    public void removeThreadLocals(){
        test.remove();
        reports.remove();
    }

    public  void reportPass(String message){

        ExtentUtils.getInstance().getTest().log(LogStatus.PASS,message);
    }

    public  void reportFail(String message){

        ExtentUtils.getInstance().getTest().log(LogStatus.FAIL,message);
    }

    public  void reportInfo(String message){
        ExtentUtils.getInstance().getTest().log(LogStatus.INFO,message);
    }
}
