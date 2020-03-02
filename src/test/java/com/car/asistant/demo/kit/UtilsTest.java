package com.car.asistant.demo.kit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.mockito.Mockito.spy;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
public class UtilsTest {


    Utils utils = new Utils();

    @Test
    public void generateUserIdShouldGenerateTest() {

        //given
        //when
        String firstUserId = utils.generateUserId(10);
        String nextUserId = utils.generateUserId(10);
        //then
        assertThat(firstUserId .length(), equalTo(10));
        assertThat(firstUserId,not(nextUserId));

    }

    @Test
    public void generateAddressIdTest()
    {
        //given
        //when
        String firstAdressId = utils.generateAddressId(10);
        String nextAdressId = utils.generateAddressId(10);
        //then
        assertThat(firstAdressId .length(), equalTo(10));
        assertThat(firstAdressId,not(nextAdressId));


    }


}
