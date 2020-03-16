package org.maven.build;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class autoBuild {
    public static void main(String[] args) throws Exception {
//        ChromeOptions options = new ChromeOptions();
//
//        options.addArguments("--headless");//无界面参数
//        options.addArguments("--disable-gpu");//禁用沙盒 就是被这个参数搞了一天
        ChromeOptions chromeOptions=new ChromeOptions();
      //  设置 chrome 的无头模式
        chromeOptions.setHeadless(Boolean.TRUE);
        System.setProperty("chromedriver", "../chromedriver");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://jktb.haedu.gov.cn/?ext=fX93MD81Pi82fXV7OSQ=&rn=1194639372");
        driver.findElement(By.xpath("/html/body/ul/li[1]")).click();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"my-form\"]/div[1]/div/button")).click();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        WebElement mobile = driver.findElement(By.name("mobile"));
        mobile.sendKeys("18790088123");
        WebElement idCard = driver.findElement(By.name("idCard"));
        idCard.sendKeys("681X");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"my-form\"]/div[4]/div/div/div/button")).click();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/ul/li[1]")).click();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
      //  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div[2]")).click();
      //  Thread.sleep(1000);
        /*
        选择相应省份
         */
        for(int i=1;i<=21;i++){
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[2]/div/div[2]/div[1]/ul/li["+i+"]")).click();
        }
        /*
        选择相应市
         */
        for(int i=1;i<=5;i++){
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[2]/div/div[2]/div[2]/ul/li["+i+"]")).click();
        }
        /*
        选择区或着县
         */
        for(int i=1;i<=1;i++){
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[2]/div/div[2]/div[3]/ul/li["+i+"]")).click();
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[2]/div/div[1]/button[2]")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div[2]/span")).getText());
        Thread.sleep(1000);
       // Thread.sleep(10000000);
    //    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[16]/button")).click();
        driver.close();
//        WebClient webClient = new WebClient(BrowserVersion.CHROME);
//        webClient.getOptions().setCssEnabled(false);
//        webClient.getOptions().setJavaScriptEnabled(false);
//        HtmlPage page = webClient.getPage("https://gitee.com/login");
//       // System.out.println(page.asText());
//        HtmlForm form = (HtmlForm) page.getForms().get(0);
//        HtmlInput user = (HtmlInput) form.getByXPath("//input[@id='user_login']").get(0);
//        user.setValueAttribute("531238678@qq.com");
//        HtmlInput pass = (HtmlInput) form.getByXPath("//input[@id='user_password']").get(0);
//        pass.setValueAttribute("Snail666888");
//        HtmlInput btn = (HtmlInput) form.getInputByName("commit");
//        HtmlPage page2 = btn.click();
//        HtmlPage page3 = webClient.getPage("https://gitee.com/srcrs/srcrs/pages");
//        System.out.println(page3.asText());
//      //  Page build = webClient.getPage("https://gitee.com/srcrs/srcrs/pages/rebuild");
//        WebResponseData data;
//        WebResponse rep = new WebResponse(new URL("https://gitee.com/srcrs/srcrs/pages/rebuild"),HttpMethod.POST,100);
    }
}

