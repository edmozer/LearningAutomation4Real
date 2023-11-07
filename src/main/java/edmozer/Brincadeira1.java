package edmozer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Brincadeira1 extends Hooks {

    By inputEmail = By.id("email");
    By inputPassword = By.id("senha");
    By pathBtnPesquisa = By.cssSelector("body > div.jumbotron.col-lg-4 > form > button");
    By successMessage = By.className("alert-success");

    public void verifyPage() {
        driver.get("https://seubarriga.wcaquino.me/login");
    }
    public void setEmail(String _email) {
        driver.findElement(inputEmail).sendKeys(_email);
    }
    public void setPassword(String _password) {
        driver.findElement(inputPassword).sendKeys(_password);
    }
    public void clickBtn() throws InterruptedException { driver.findElement(pathBtnPesquisa).click();}

    @Test
    @DisplayName("Cenário: Login com sucesso")
    public void testLogin() throws InterruptedException {
        this.verifyPage();
        this.setEmail("edmozer.qa@gmail.com");
        this.setPassword("Leaodatuf");
        this.clickBtn();
        WebElement successAlert = driver.findElement(successMessage);
        String successMessageText = successAlert.getText();
        Assertions.assertTrue(successMessageText.contains("Bem vindo"));
        Thread.sleep(2000);
    }

}