package com.gorest.goresttestsuite;

import com.gorest.gorestinfo.UsersSteps;
import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class GoRestCURDTest extends TestBase {
    static String name = "Manan";
    static String email = "shah" + getRandomValue() + "@gmail.com";
    static String gender = "male";
    static String status = "active";

    static int id;


    @Steps
    UsersSteps usersSteps;

    @Title("This method will create a new users record and verify it by its ID")
    @Test
    public void test002() {
        ValidatableResponse getId = usersSteps.updateUser(id, name, email, gender, status);
        id = getId.extract().path("id");
    }

    @Title("This method will update the existing record")
    @Test
    public void test003() {
        status = "inactive";
        usersSteps.updateUser(id, name, email, gender, status);
        ValidatableResponse response = usersSteps.getUserById(id).statusCode(200);
        HashMap<String, ?> userRecord = response.extract().path("");
        Assert.assertThat(userRecord, hasValue(status));
    }

    @Title("This method will delete the existing record")
    @Test
    public void test004() {
        usersSteps.deleteUser(id).statusCode(204);
        usersSteps.getUserById(id).statusCode(404);
    }
}
