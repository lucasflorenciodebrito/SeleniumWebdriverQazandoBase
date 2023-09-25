package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import runner.RunCucumber;

import static support.Commands.*;

public class LoginPage extends RunCucumber {

    // elementos
    private final String URL = "http://automationpratice.com.br/";
    private final By botaoAcessarLogin = By.cssSelector(".right_list_fix > li > a > .fa-user");
    private final By campoEmail = By.id("user");
    private final By campoSenha = By.id("password");
    private final By botaoFazerLogin = By.id("btnLogin");
    private final By botaoAcessarCadastro = By.cssSelector(".right_list_fix > li > a > .fa-lock");

    // ações / funções / métodos
    public void acessarAplicao() {
        getDriver(System.getProperty("browser")).get(URL);
    }

    public void acessarTelaLogin() {
        clickElement(botaoAcessarLogin);
    }

    public void preencheEmail(String email) {
        fillField(campoEmail, email);
    }

    public void preencherSenha(String senha) {
        fillField(campoSenha, senha);
    }

    public void clicarLogin() {
        clickElement(botaoFazerLogin);
    }

    public void verificaLoginSucesso() {
        checkMessage(By.id("swal2-title"), "Login realizado");
    }

    public void verificaCampoVazio(String message) {
        String textError = getDriver().findElement(By.className("invalid_input")).getText();
        Assert.assertEquals(message, textError);
    }

    public void acessarTelaCadastro() {
        clickElement(botaoAcessarCadastro);
    }

}
