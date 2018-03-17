
import com.freebitcoin.app.control.TwoCaptchaFreeBTC;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eduardo
 */
public class NewClass {

    static String[] correos = {"roger1981h@hotmail.com", "sambuchheit@hotmail.com",
        "scotty1988b@outlook.com", "james1990m@yahoo.com", "scottp.z@outlook.com", "scottpzimmerman@hotmail.com",
        "adamkhare@hotmail.com", "adamkhare@outlook.com", "harraya8@gmail.com", "charles1992j@yahoo.com",
        "ethack3578@gmail.com", "KristiCDixon@gmail.com", "AnneDDelatte@gmail.com",
        "BarbaraJPerkins2018@gmail.com", "AnnJJohnson2018@gmail.com", "tulio2018marco@gmail.com",
        "totemsanti@gmail.com", "jasontil2018@gmail.com", "janemarie1111@mail.com",
        "jhonnieves1111@yahoo.com", "davidovls@yahoo.com", "gallardojuancho@yahoo.com",
        "tonytino1111@yahoo.com"};

    public void registrar() throws FileNotFoundException, InterruptedException {

        int f = 5;
        for (int i = 0; i < correos.length; i++) {

            System.setProperty("webdriver.gecko.driver", "C:\\Program Files (x86)\\GT Tools\\geckodriver.exe");
            System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            ProfilesIni profile = new ProfilesIni();
            FirefoxProfile myprofile = profile.getProfile("Prueba" + f);

            FirefoxOptions options = new FirefoxOptions().setProfile(myprofile);
            options.addPreference("signon.autologin.proxy", true);
            WebDriver driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            driver.get("https://freebitco.in/?r=6845864");
            driver.findElement(By.id("signup_form_email")).sendKeys(correos[0]);
            driver.findElement(By.id("signup_form_password")).sendKeys("eduardo706");
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            Thread.sleep(5000);
            TwoCaptchaFreeBTC prueba = new TwoCaptchaFreeBTC("0.0.0.0", "0000");
            System.out.println(prueba.Tokenizer());
            //jse.executeScript("document.getElementById('recaptcha-token')[0].setAttribute('type', 'text');");
            Thread.sleep(20000);
            //driver.findElement(By.id("recaptcha-token"));
            //  driver.findElement(By.id("g-recaptcha-response")).sendKeys(responseToken);
            // Thread.sleep(5000);

            Thread.sleep(3000);
            driver.quit();
            f++;
        }
    }

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        NewClass w = new NewClass();
        w.registrar();
        System.out.println(correos.length);

    }
}
