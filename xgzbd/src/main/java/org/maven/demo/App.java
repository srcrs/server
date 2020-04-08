package org.maven.demo;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.File;

public class App {
    static Sheet sheet;
    static Cell cell_1, cell_2, cell_3, cell_4, cell_5;

    public static void main(String[] args) {

        try {
            Workbook book = Workbook.getWorkbook(new File("test.xls"));
            sheet = book.getSheet(0);
            for (int i = 1; i <= 9; i++) {

                cell_1 = sheet.getCell(8, i);
                cell_2 = sheet.getCell(9, i);
                cell_3 = sheet.getCell(10, i);
                cell_4 = sheet.getCell(11, i);
                cell_5 = sheet.getCell(12, i);
                run();
            }
            String json = "{\"content\":[{\"type\":0,\"data\":\"本次成功:"+(10-flag)+",失败："+(flag-1)+"\"}]}";
            Connection.Response res = Jsoup.connect("https://app.qun.qq.com/cgi-bin/api/hookrobot_send?key=c71ac5abdc79b809dfd121bd6266b15bf4df206b")
                    .ignoreHttpErrors(true)
                    .requestBody(json)
                    .method(Connection.Method.POST).execute();
            if(res.statusCode()==500){
                System.out.println("发送成功！");
            }
        } catch (Exception e) {

        }
    }

    static int n = 1;
    static int flag = 1;

    public static void run() {
        WebDriver driver = null;
        try {
            // 设置无头模式
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setHeadless(Boolean.TRUE);
            // 指定chromedriver的位置
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            // 如果不采用无界面模式则不需要使用chromeOptions参数
            // 这句话相当于创建了一个窗口
            driver = new ChromeDriver(chromeOptions);
            // 访问链接
            driver.get("http://jktb.haedu.gov.cn/?ext=fX93MD81Pi82fXV7OSQ=&rn=1194639372");
            // 寻找界面元素然后点击
            driver.findElement(By.xpath("/html/body/ul/li[1]")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//*[@id=\"my-form\"]/div[1]/div/button")).click();
            Thread.sleep(4000);
            WebElement mobile = driver.findElement(By.name("mobile"));
            mobile.sendKeys(cell_1.getContents().trim());
            WebElement idCard = driver.findElement(By.name("idCard"));
            idCard.sendKeys(cell_2.getContents().trim());
            Thread.sleep(4000);
            driver.findElement(By.xpath("//*[@id=\"my-form\"]/div[4]/div/div/div/button")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("/html/body/ul/li[1]")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div[2]")).click();
            /*
             * 选择相应省份
             */
            String s = "";
            Thread.sleep(4000);
            n = 1;
            do {
                driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[2]/div/div[2]/div[1]/ul/li[" + n + "]"))
                        .click();
                s = driver
                        .findElement(
                                By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[2]/div/div[2]/div[1]/ul/li[" + n + "]"))
                        .getText();
                n++;
            } while (!cell_3.getContents().trim().equals(s));
            /*
             * 选择相应市
             */
            n = 1;
            Thread.sleep(4000);
            s = "";
            do {
                driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[2]/div/div[2]/div[2]/ul/li[" + n + "]"))
                        .click();
                s = driver
                        .findElement(
                                By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[2]/div/div[2]/div[2]/ul/li[" + n + "]"))
                        .getText();
                n++;
            } while (!cell_4.getContents().trim().equals(s));
            /*
             * 选择区或者县
             */
            s = "";
            Thread.sleep(4000);
            n = 1;
            do {
                driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[2]/div/div[2]/div[3]/ul/li[" + n + "]"))
                        .click();
                s = driver
                        .findElement(
                                By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[2]/div/div[2]/div[3]/ul/li[" + n + "]"))
                        .getText();
                n++;
            } while (!cell_5.getContents().trim().equals(s));
            Thread.sleep(4000);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[2]/div/div[1]/button[2]")).click();
            Thread.sleep(4000);
            // System.out.println(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/span")).getText());
            Thread.sleep(4000);
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[16]/button")).click();
            driver.close();
        } catch (Exception e) {
            System.out.println((flag++) + "------->" + cell_1.getContents().trim());
            driver.close();
        }
    }
}
