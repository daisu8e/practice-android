package com.example.android.SimpleCalc;

import android.content.Context;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
@SmallTest
public class UserInterfaceTest {

  private UserInterface userInterface;

  @Mock
  private Context context;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    userInterface = new UserInterface(context);
  }

  @Test
  public void calcButton() {
    when(context.getString(R.string.app_name)).thenReturn("Calc Button Test");
    String result = userInterface.calcButton();
    assertThat(result, is("Calc Button Test"));
  }
}
