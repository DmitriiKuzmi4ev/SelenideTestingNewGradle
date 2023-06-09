package ui.test.fdmPesronalAreaTest.fdmRegistrationTests;

import core.BaseTest;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.registration.FdmRegistrationPage;

@Tag("Smoke")
@Feature("Блок регистрации пользователя")
public class FdmRegistrationTest extends BaseTest {
    private FdmRegistrationPage fdmRegistrationPage;
    @BeforeEach
    public void setUp(){
        fdmRegistrationPage = new FdmRegistrationPage(); //инициализация страницы регистрации
        fdmRegistrationPage.clickOnApplyCity();
    }

    @Test
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
    @DisplayName("Тест - Регистрация -  проверка ссылок на документы соглашений")
    public void registrationLinksTest() {
        fdmRegistrationPage.openRegistration()
                .checkedLinkOnAgreeTerms()
                .checkedLinkOnAgreeTermsPolitics();
    }

    @Test
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
    @DisplayName("Тест - Регистрация -  Ввод уже зарегестрированного номера телефона")
    public void registrationTryRegisteredNumberTest() {
        fdmRegistrationPage.openRegistration()
                .insertNumber()
                .clickOnRegistrationBtn()
                .checkedRegisteredNumberError();
    }

    @Test
    @DisplayName("Тест - Регистрация -  Ввод уже зарегестрированной электронной почты")
    public void registrationTryRegisteredEmailTest() {
        fdmRegistrationPage.openRegistration()
                .insertRegisteredEmail()
                .clickOnRegistrationBtn()
                .checkedRegisteredEmailError();
    }


    @Test
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


}
