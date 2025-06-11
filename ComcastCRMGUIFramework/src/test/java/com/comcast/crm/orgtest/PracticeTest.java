package com.comcast.crm.orgtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
@Listeners(com.comcast.crm.listenerutility.ListenerImplementationClass.class)
public class PracticeTest extends BaseClass{
@Test
public void prTest() {
	Assert.assertEquals("VIVEK","vivek");
}
}
