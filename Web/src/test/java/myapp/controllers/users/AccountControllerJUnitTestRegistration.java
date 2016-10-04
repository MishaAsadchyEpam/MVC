package myapp.controllers.users;

import myapp.entities.Users;
import myapp.serviceContracts.IUserService;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mail.MailSendException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.sql.SQLException;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerJUnitTestRegistration {

    // tested object
    @InjectMocks
    private AccountController controller;

    // testing data (lists, specified objects etc)

    // mockito
    @Mock
    private IUserService service;

    private MockMvc mockMvc;

    // test case values

    private void verifyCorrect()
    {
        verifyMethodsCalls(1, 1, 1);
    }

    private void verifyInCorrect()
    {
        verifyMethodsCalls(0, 0, 0);
    }

    private void verifyMethodsCalls(int save, int generate, int send)
    {
        verify(service, times(save)).save(any(Users.class));
        verify(service, times(generate)).generateFormToUser(anyString());
        verify(service, times(send)).sendEmail(any(Users.class), anyString(), anyString());
    }

    public void initTest()
    {

    }

    @Before
    public void setUp() throws Exception
    {

        // initialize tested object

        // initialize testing data
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(viewResolver()).build();
//        mockMvc = webAppContextSetup(ctx).build();

        // create mockito objects


        // add shared behavior to mockito objects


        // reflections to real (tested) object
    }


    @Test
    public void testRegisterNoValidField() throws Exception
    {

        // local vars

        // init test

        // use testing data

        // add specified behavior for mocks

        // tested method call
        mockMvc.perform(post("/account/register")
                        .param("nickName", "Misha")
                        .param("username", "p_ami@mail.by")
                        .param("password", "123451234512345123451234512345123451234512345123451234512345")
                        .param("passwordConfirm", "123456")
                        .header("host", "hhh")
        ).andDo(print())
                .andExpect(model().attributeExists("users"))
                .andExpect(model().hasErrors())
                .andExpect(view().name("/account/register"))
                .andExpect(status().isOk());

        // verify stage
        verifyInCorrect();

        // asserts

    }

    @Test
    public void testRegisterSaveIncorrect() throws Exception
    {

        // local vars

        // init test

        // use testing data

        // add specified behavior for mocks
        doThrow(new ConstraintViolationException("", new SQLException(), "")).when(service).save(any(Users.class));

        // tested method call

        mockMvc.perform(post("/account/register")
                        .param("nickName", "Misha")
                        .param("username", "p_ami@mail.by")
                        .param("password", "123456")
                        .param("passwordConfirm", "123456")
                        .header("host", "hhh")
        ).andDo(print())
                .andExpect(model().attributeExists("users"))
                .andExpect(model().attributeHasFieldErrors("users", "username"))
                .andExpect(view().name("/account/register"))
                .andExpect(status().isOk());

        // verify stage
        verifyMethodsCalls(1, 0, 0);

        // asserts

    }

    @Test
    public void testRegisterFailSendEmail() throws Exception
    {

        // local vars

        // init test

        // use testing data

        // add specified behavior for mocks
        doThrow(new MailSendException("")).when(service).sendEmail(any(Users.class), anyString(), anyString());

        // tested method call
        mockMvc.perform(post("/account/register")
                        .param("nickName", "Misha")
                        .param("username", "p_ami@mail.by")
                        .param("password", "123456")
                        .param("passwordConfirm", "123456")
                        .header("host", "hhh")
        ).andDo(print())
                .andExpect(model().attributeExists("users"))
                .andExpect(model().hasNoErrors())
                .andExpect(view().name("/account/register"))
                .andExpect(status().isOk());

        // verify stage
        verifyCorrect();

        // asserts

    }

    @Test
    public void testRegisterCorrect() throws Exception
    {

        // local vars

        // init test

        // use testing data

        // add specified behavior for mocks

        // tested method call
        mockMvc.perform(post("/account/register")
                        .param("nickName", "Misha")
                        .param("username", "p_ami@mail.by")
                        .param("password", "123456")
                        .param("passwordConfirm", "123456")
                        .header("host", "hhh")
        ).andDo(print())
                .andExpect(model().attributeExists("users"))
                .andExpect(model().hasNoErrors())
                .andExpect(view().name("/account/registrationSuccess"))
                .andExpect(status().isOk());

        // verify stage
        verifyCorrect();

        // asserts

    }


    // private stubs methods
    private ViewResolver viewResolver()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/pages/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
}
