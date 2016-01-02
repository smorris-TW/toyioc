package com.toyioc.support;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class simpleConfigurationTest {

    @Test
    public void ShouldSupportStream() {

        List<String> list = new ArrayList<>();
        list.stream();
    }

    @Test
    public void ShouldSupportAssertJ() {

        assertThat(1).isEqualTo(1);
    }
}

