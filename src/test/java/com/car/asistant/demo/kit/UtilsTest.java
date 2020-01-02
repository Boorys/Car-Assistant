package com.car.asistant.demo.kit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class UtilsTest {


    Utils utils;
    @Before
    public void init()
    {
        utils = spy(new Utils());
    }

    @Test
    public void generateUserIdTest()
    {
        Assert.assertEquals(utils.generateAddressId(10).length(),10);
    }

    public void generateAddressIdTest()
    {
        Assert.assertEquals(utils.generateAddressId(10).length(),10);
    }


}
