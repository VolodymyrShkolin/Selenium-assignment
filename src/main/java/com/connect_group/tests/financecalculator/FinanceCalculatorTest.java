package com.connect_group.tests.financecalculator;

import com.connect_group.pages.financecalculator.FilterByPage;
import com.connect_group.pages.financecalculator.ModelSelectPage;
import com.connect_group.pages.financecalculator.PersonalisedQuotePage;
import com.connect_group.tests.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FinanceCalculatorTest extends BaseTest {

  private ModelSelectPage modelSelectPage;
  private FilterByPage filterByPage;
  private PersonalisedQuotePage personalisedQuotePage;

  @BeforeEach
  void setupAndNavigateToUrl() {
    modelSelectPage = new ModelSelectPage(driver);
    filterByPage = new FilterByPage(driver);
    personalisedQuotePage = new PersonalisedQuotePage(driver);

    open("https://www.landrover.co.uk/offers-and-finance/finance-calculator.html");
  }



  // TODO: Complete the each of the tests under the "Tasks to Complete" section of the README.md

  @Test
  void task1(){
    //There are currently 7 signs on the site.
    Assertions.assertEquals(7, modelSelectPage.getAllNameplatesContainer().size());
  }

  @Test
  void task2(){
    modelSelectPage.cookieManagement();
    assertTrue(modelSelectPage.monthlyPaymentBtnIsInit());
    modelSelectPage.monthlyPaymentBtn.click();
    modelSelectPage.monthPaymentScrollTo(750);
    modelSelectPage.changeDeposit("20000");
    assertTrue(modelSelectPage.acceptValuesBtnInit());
    modelSelectPage.acceptValuesBtn.click();
    Assertions.assertFalse(modelSelectPage.getAllNameplatesContainer().isEmpty());
  }

}