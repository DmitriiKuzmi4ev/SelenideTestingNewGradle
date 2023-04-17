package ui.test.RegLogNavFormTests;

import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.registration.FdmRegistrationPage;

public class FdmRegistrationTest extends BaseTest {

    private FdmRegistrationPage fdmRegistrationPage;
    @BeforeEach
    public void setUp(){
        fdmRegistrationPage = new FdmRegistrationPage(); //инициализация страницы регистрации
        fdmRegistrationPage.clickOnApplyCity();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Тест - Регистрация -  ввод валидных значений, заполнение всех полей")
    public void registrationPositiveTest() {
        fdmRegistrationPage.openRegistration()
                .insertLastName()
                .insertName()
                .insertPatronymic()
                .insertNumber()
                .insertEmail()
                .checkedPromocodeField()
                .clickOnAgreeTerms()
                .checkedAgreeTermsCheckbox()
                .clickOnAgreeTermsPolitics()
                .checkedAgreeTermsPoliticsCheckbox()
                .checkedRegistrationBtn();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Тест - Регистрация -  проверка ссылок на документы соглашений")
    public void registrationLinksTest() {
        fdmRegistrationPage.openRegistration()
                .checkedLinkOnAgreeTerms()
                .checkedLinkOnAgreeTermsPolitics();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Тест - Регистрация -  пропуск обязательных полей")
    public void registrationVoidFieldTest() {
        fdmRegistrationPage.openRegistration()
                .clickOnRegistrationBtn()
                .checkedLastNameError()
                .checkedNameError()
                .checkedPatronymicError()
                .checkedNumberError()
                .checkedEmailError()
                .checkedAgreeTermsError()
                .checkedAgreeTermsPoliticsError();

    }

    @Test
    @Tag("Smoke")
    @DisplayName("Тест - Регистрация -  Ввод уже зарегестрированного номера телефона")
    public void registrationTryRegisteredNumberTest() {
        fdmRegistrationPage.openRegistration()
                .insertNumber()
                .clickOnRegistrationBtn()
                .checkedRegisteredNumberError();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Тест - Регистрация -  Ввод уже зарегестрированной электронной почты")
    public void registrationTryRegisteredEmailTest() {
        fdmRegistrationPage.openRegistration()
                .insertRegisteredEmail()
                .clickOnRegistrationBtn()
                .checkedRegisteredEmailError();
    }


    @Test
    @Tag("Smoke")
    @DisplayName("Тест - Регистрация -  ввод не валидных значений")
    public void registrationInvalidValueTest() {
        fdmRegistrationPage.openRegistration()
                .insertInvalidLastName()
                .insertInvalidName()
                .insertInvalidPatronymic()
                .clickOnRegistrationBtn()
                .checkedInvalidLastNameError()
                .checkedInvalidNameError()
                .checkedInvalidPatronymicError();
    }
//
//    @Test
//    @DisplayName("Тест - Регистрация -  ввод спец.символов и цифр в строоковые поля")
//    public void registrationSpecialSymbolTest() {
//        fdmRegistrationPage.openCatalog()
//                .openStandartFabric()
//                .openFacadePvh()
//                .setStraightFacade() //выбор Фасады прямые
//                .setRandomDecor()
//                .continue1Click();
//
//        fdmRegistrationPage.setRandomEdge();
//        fdmRegistrationPage.continue2Click();
//        fdmRegistrationPage.setHeight();
//        fdmRegistrationPage.setWidth();
//
//        fdmRegistrationPage.calculateClick();
//        fdmRegistrationPage.addToBasketClick();
//        fdmRegistrationPage.goToBasketClick();
//        fdmRegistrationPage.goToCheckOutClick();
//        fdmRegistrationPage.qrCodeClick();
//        fdmRegistrationPage.deliveryCityClick();
//        fdmRegistrationPage.checkedPaymentBtn();
//    }
//

//
//    @Test
//    @DisplayName("Тест - Регистрация -  ввод электронной почты без символа -@-")
//    public void registrationMailFieldTest() {
//        fdmRegistrationPage.openCatalog()
//                .openStandartFabric()
//                .openFacadePvh()
//                .setStraightFacade() //выбор Фасады прямые
//                .setRandomDecor()
//                .continue1Click();
//
//        fdmRegistrationPage.setRandomEdge();
//        fdmRegistrationPage.continue2Click();
//        fdmRegistrationPage.setHeight();
//        fdmRegistrationPage.setWidth();
//
//        fdmRegistrationPage.calculateClick();
//        fdmRegistrationPage.addToBasketClick();
//        fdmRegistrationPage.goToBasketClick();
//        fdmRegistrationPage.goToCheckOutClick();
//        fdmRegistrationPage.qrCodeClick();
//        fdmRegistrationPage.deliveryCityClick();
//        fdmRegistrationPage.checkedPaymentBtn();
//    }

}