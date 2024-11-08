package dev.folomkin;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHolderTest {
    @BeforeAll
    public static void beforeClass(){
        System.out.println("This method has been executed first...");
    }

    @AfterAll
    public static void afterClass(){
        System.out.println("This method has been executed last...");
    }

    @BeforeEach
    public void before(){
        System.out.println("Before each test");
    }

    @AfterEach
    public void after(){
        System.out.println("After each test");
    }

    @Test
    public void simpleTest(){
        System.out.println("This is simple test");
    }

    @Disabled
    @Test
    public void ignoreTest(){
        System.out.println("This test will be ignored");
    }
}