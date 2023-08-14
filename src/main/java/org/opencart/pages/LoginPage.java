package org.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

public class LoginPage {

    private WebDriver driver;
    @FindBy(name = "email")
    private WebElement textfield_username_name;
    @FindBy(css = "input#input-password")
    private WebElement textfield_password_css;
    @FindBy(css = "input[value='Login']")
    private WebElement button_login_css;
    @FindBy(linkText = "Forgotten Password")
    WebElement link_forgotpwd_link;
    @FindBy(linkText = "Logout")
    WebElement link_logout_link;
    @FindBy(css = "div.alert")
    WebElement text_error_css;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enter_username(String email){
        textfield_username_name.sendKeys(email);
    }

    public void enter_password(String password){
        textfield_password_css.sendKeys(password);
    }

    public void click_login_button(){
        button_login_css.click();
    }

    public void login(String name, String pwd){
        enter_username(name);
        enter_password(pwd);
        click_login_button();
    }

    public WebElement validate_error_msg(){
        return text_error_css;
    }
    public boolean check_logout_link(){
        return link_logout_link.isDisplayed();
    }

    public void click_on_forgotten_pwd(){
        link_forgotpwd_link.click();
    }
}
