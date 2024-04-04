package com.connect_group.pages.financecalculator;

import com.connect_group.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModelSelectPage extends BasePage {

  public ModelSelectPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(css = "[data-test-id = 'nameplate-fbmp-disabled']")
  public List<WebElement> nameplates;
  @FindBy(css = "[aria-label = 'MONTHLY PAYMENT']")
  public WebElement monthlyPaymentBtn;
  @FindBy(css = "[style*= 'display'] [id = 'truste-consent-buttons'] [id = 'truste-consent-button']")
  public WebElement acceptAllCookiesBtn;
  @FindBy(css = "[id = 'psyma_layer'][style*= 'visible']")
  public WebElement popUpWithQuestion;
  @FindBy(css = "[style*= 'visible'] [id = 'psyma_close_button_link']")
  public WebElement popUpCross;
  @FindBy(id = "handle_max")
  public WebElement handleMax;
  @FindBy(css = "input[id = 'deposit']")
  public WebElement depositField;

  @FindBy(css = "button[class='fc-cta__cta fc-cta__cta--primary']")
  public WebElement acceptValuesBtn;



  private WebElement getModelSelectNameplateContainer() {
    return until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fc-nameplates__nameplateContainer")));
  }

  private WebElement getAcceptAllCookiesBtn() {
    return until(ExpectedConditions.visibilityOf(acceptAllCookiesBtn));
  }
  private WebElement getAcceptValuesBtn() {
    return until(ExpectedConditions.elementToBeClickable(acceptValuesBtn));
  }
  public WebElement getMonthlyPaymentBtn() {
    return until(ExpectedConditions.visibilityOf(monthlyPaymentBtn));
  }

  public WebElement getPopUpWithQuestion() {
    return until(ExpectedConditions.visibilityOf(popUpWithQuestion));
  }

  public List<WebElement> getAllNameplatesContainer() {
    return until(ExpectedConditions.visibilityOfAllElements(nameplates));
  }

  public List<WebElement> getAllNameplates() {
    return until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".fc-nameplates__nameplateContainer .fc-cta__cta--size-primary")));
  }

  public boolean nameplateContainerIsInit() {
    return getModelSelectNameplateContainer().isDisplayed();
  }

  public boolean monthlyPaymentBtnIsInit() {
    return getMonthlyPaymentBtn().isDisplayed();
  }
  public boolean acceptValuesBtnInit() {
    return getAcceptValuesBtn().isDisplayed();
  }
  private boolean acceptAllCookiesBtnIsInit() {
    return getAcceptAllCookiesBtn().isDisplayed();
  }

  private boolean popUpWithQuestionInit() {
    return getPopUpWithQuestion().isDisplayed();
  }

  // TODO: Add methods in to support interacting with the model selection page.

  public void cookieManagement(){
    assertTrue(acceptAllCookiesBtnIsInit());
    acceptAllCookiesBtn.click();
    assertTrue(popUpWithQuestionInit());
    popUpCross.click();
  }

  public void changeDeposit(String depositSum){
    depositField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
    depositField.sendKeys(depositSum);
  }

  public void monthPaymentScrollTo(int sumTo){
    int currentMax = Integer.parseInt(handleMax.getAttribute("aria-valuenow"));
    while (currentMax!=sumTo){
      if(currentMax > sumTo){
        act.moveToElement(handleMax)
                .clickAndHold()
                .moveByOffset(-6, 0)
                .release()
                .build().perform();
      }else {
        act.moveToElement(handleMax)
                .clickAndHold()
                .moveByOffset(6, 0)
                .release()
                .build().perform();
      }
      currentMax = Integer.parseInt(handleMax.getAttribute("aria-valuenow"));
    }

  }
}