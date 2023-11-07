package edmozer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Brincadeira2 extends Hooks {

    By inputEmail = By.id("email");
    By inputNome = By.id("nome");
    By inputPassword = By.id("senha");
    By btnPesquisa = By.cssSelector("body > div.jumbotron.col-lg-4 > form > button");
    By successMessage = By.className("alert-success");

    By btnCadastro = By.cssSelector("input[type='submit'].btn.btn-primary[value='Cadastrar']");
    By errorMessage = By.className("alert-danger");



    public void verifyPage() {
        driver.get("https://seubarriga.wcaquino.me/cadastro");
    }
    public void setEmail(String _email) {
        driver.findElement(inputEmail).sendKeys(_email);
    }
    public void setPassword(String _password) {
        driver.findElement(inputPassword).sendKeys(_password);
    }
    public void clickBtn() throws InterruptedException { driver.findElement(btnPesquisa).click();}
    public void clickCadastro() throws InterruptedException { driver.findElement(btnCadastro).click();}
    public void setNomeValido(String _email) {
        driver.findElement(inputNome).sendKeys(_email);
    }

    @Test
    @DisplayName("1 - Cenário: Cadastrar usuario com sucesso/Email ja cadastrado")
    public void testCadastroSucesso() throws InterruptedException {
        this.verifyPage();
        this.setNomeValido("Edmozer");
        this.setEmail("edmozer.qa@gmail.com");
        this.setPassword("Leaodatuf");
        this.clickCadastro();
        WebElement errorAlert = driver.findElement(errorMessage);
        String errorMessageText = errorAlert.getText();
        Assertions.assertTrue(errorMessageText.contains("Endereço de email já utilizado"));


    }
    @Test
    @DisplayName("2 - Cenário: Cadastrar - nome excede")
    public void testCadNomeExcede() throws InterruptedException {
        this.verifyPage();
        this.setNomeValido("Edmozerrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        this.setEmail("edmozer.qa@gmail.com");
        this.setPassword("Leaodatuf");
        this.clickCadastro();
        WebElement errorAlert = driver.findElement(errorMessage);
        String errorMessageText = errorAlert.getText();
       Assertions.assertTrue(errorMessageText.contains("Nome excede quantidade maxima de caracteres"));

        //Thread.sleep(50000);
    }
    @Test
    @DisplayName("3 - Cenário: Cadastrar - nome excede")
    public void testCadEmailExcede() throws InterruptedException {
        this.verifyPage();
        this.setNomeValido("Edmozer");
        this.setEmail("edmozerrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr.qa@gmail.com");
        this.setPassword("Leaodatuf");
        this.clickCadastro();
        WebElement errorAlert = driver.findElement(errorMessage);
        String errorMessageText = errorAlert.getText();
        Assertions.assertTrue(errorMessageText.contains("Email excede quantidade maxima de caracteres"));

    }
    @Test
    @DisplayName("4 - Cenário: Cadastrar - nome em branco")
    public void testCadNomeBranco() throws InterruptedException {
        this.verifyPage();
        this.setEmail("edmozer.qa@gmail.com");
        this.setPassword("Leaodatuf");
        this.clickCadastro();
        WebElement errorAlert = driver.findElement(errorMessage);
        String errorMessageText = errorAlert.getText();
        Assertions.assertTrue(errorMessageText.contains("O campo nome deve ser preenchido"));
    }
    @Test
    @DisplayName("5 - Cenário: Cadastrar - nome com caractere especial")
    public void testCadNomeCaracEspecial() throws InterruptedException {
        this.verifyPage();
        this.setNomeValido("Edmozer$%√");
        this.setEmail("edmozer.qa@gmail.com");
        this.setPassword("Leaodatuf");
        this.clickCadastro();
        WebElement errorAlert = driver.findElement(errorMessage);
        String errorMessageText = errorAlert.getText();
        Assertions.assertTrue(errorMessageText.contains("O campo nome nao deve conter caracteres especiais"));
    }
}