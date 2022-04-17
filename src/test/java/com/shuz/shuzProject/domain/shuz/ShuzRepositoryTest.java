package com.shuz.shuzProject.domain.shuz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ShuzRepositoryTest {

    @Autowired
    ShuzRepository shuzRepository;

    @AfterEach
    public void cleanup() {
        shuzRepository.deleteAll();
    }

}
