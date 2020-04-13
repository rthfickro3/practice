package com.webapp.smt;

import com.webapp.Dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "com.webapp.smt")
class SmtApplicationTests {

    @Test
    public void password_Equals_Check() {
        UserDto userDto = new UserDto(1, "윤창환", "rthfi", "asdasdasd123", "asdasdasd123");

        assertEquals(userDto.getPassword(), userDto.getPassword_Check());
    }

}
