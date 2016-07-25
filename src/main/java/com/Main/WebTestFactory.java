package com.Main;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.Tests.Tests;

public class WebTestFactory {
	  @Factory
	  public Object[] createInstances() {
		  return new Object[] { new Tests(1,999), new Tests(2,888), new Tests(3,888), new Tests(4,888), new Tests(5,888)};
	  }
	}

