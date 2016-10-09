package myapp.controllers.users;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring/mvc-dispatcher-servlet.xml",
        "classpath:spring/application-security.xml",
        "classpath:spring/applicationContext.xml"
})
@WebAppConfiguration
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
public class AccountControllerIntegrationTestConfirmation {

    // @Autowired
    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    // testing data (lists, specified objects etc)

    // mockito

    // test case values

    public void verifyCorrect()
    {

    }

    public void verifyInCorrect()
    {

    }

    public void initTest()
    {

    }

    @Before
    public void setUp() throws Exception
    {

        // initialize tested object

        // create mockito objects
        mockMvc = webAppContextSetup(ctx).build();


        // add shared behavior to mockito objects

        // reflections to real (tested) object


    }

    @Test
    public void testConfirmation() throws Exception
    {
        // local vars

        // init test

        // use testing data

        // add specified behavior for mocks

        // tested method call
        mockMvc.perform(get("/account/confirmation/2/ct"))
                .andExpect(view().name("/account/confirmationFail"));

        // verify stage

        // asserts
    }


    // private stubs methods
}
