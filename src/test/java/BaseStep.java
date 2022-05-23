import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import java.time.Duration;
import java.util.List;
import java.util.Random;



public class BaseStep extends BaseTest{

    @Step("<second> saniye kadar bekle")
    public void waitBySecond(int second) throws InterruptedException {
        Thread.sleep(1000*second);
    }

    @Step("<key> Xpath'ine sahip elementi bul ve tıkla")
    public void clickElementByXpath(String key){
        appiumDriver.findElement(By.xpath(key)).click();

    }

    @Step("<id> Id'sine sahip elementi bul ve tıkla")
    public void clickElementById(String id){
        appiumDriver.findElement(By.id(id)).click();

    }
    @Step("<key> Id'sine sahip elemente <keyword> değerini yaz")
    public void sendKeyElementById(String key, String keyword){
        appiumDriver.findElement(By.id(key)).sendKeys(keyword);

    }

    @Step("<id> ve <textid> Id elementlerinin değerlerini bul ve içeriklerini kontrol et")
    public void textControlId(String id, String textid){
        Assert.assertTrue("Element bulunamadi",appiumDriver.findElement(By.id(id))
                .getText().equals(textid));
        System.out.println("Karsilastirma basarili");
    }

    @Step("<key> ve <keyword> Xpath elementlerinin değerlerini bul ve içeriklerini kontrol et")
    public void textControlXpath(String key, String keyword){
        Assert.assertTrue("Element bulunamadi",appiumDriver.findElement(By.xpath(key))
                .getText().equals(keyword));
        System.out.println("Karsilastirma basarili");
    }


    @Step("Sayfayı yukarı kaydır")
    public void swipeUp(){
        Dimension dims = appiumDriver.manage().window().getSize();
        PointOption pointOptionStart, pointOptionEnd;
        int edgeBorder = 10;
        final int PRESS_TIME = 200;
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
        new TouchAction(appiumDriver)
                .press(pointOptionStart)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();

    }

    @Step("Rastgele ürün seçilir")
    public void randomGeneratorAndRandomItem(){

        List<MobileElement> elements = appiumDriver.findElements(By.xpath("//*[@class='androidx.cardview.widget.CardView']"));
        Random rnd = new Random();
        int rndInt = rnd.nextInt(elements.size());
        elements.get(rndInt).click();
    }





}
