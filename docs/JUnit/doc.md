# JUnit

JUnit – это фреймворк, разработанный для тестирования программ, написанных с
использованием технологии Java. Он лежит в основе TDD (Test-Driven Development)
и входит в семейство фрейморков для тестирования xUnit.

Главная идея данного фреймворка – “сначала тесты, потом код”. Это означает, что
сначала мы определяем, что должно получиться в результате работы того или иного
куска кода и пишем тесты, которые проверяют идентичность результата с требуемым,
после чего пишем сам кусок кода, который и будем тестировать. Данный подход
увеличивает эффективность работы разработчика и позволяет писать более
стабильный код. В результате этого мы получаем меньшее количество времени,
которое затрачивается на отладку программы.

## Свойства JUnit

Фреймворк с открытым исходным кодом, который используется для написания и
выполнения тестов.
Позволяет писать код более быстро и качественно.
Крайне прост в использовании.
Поддерживает аннотации для идентификации методов.
Поддерживает утверждения для тестирования получаемых результатов.
Тесты могут быть организованы в связки тестов (test suites).
Имеет визуальную индикацию состояния тестов (красные – не пройдены, зелёные –
пройдены).

## Тестовый случай

Тестовый случай (Test Case) в юнит тестировании – это часть кода, которая
проверяет ,что другая часть кода  (в частности – метод) работает в соответствии
с определёнными требованиями.

Формально описанный тестовый случай характеризуется известными входными данными
и ожидаемым выводом программы, который известен до начала выполнения теста.

Необходимо создавать, как минимум, два тестовых случая для каждого требования –
положительный и отрицательный. Если требование имеет под требования, каждое из
них должно тестироваться отдельно.

Зависимость:

```xml
    <!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.11.3</version>
    <scope>test</scope>
</dependency>
```

```java
public class ArrayHolder {
    private int[] integers;

    public ArrayHolder() {
        this.integers = new int[]{1, 2, 3, 4, 5};
    }

    public int[] getIntegers() {
        return integers;
    }

    public void setIntegers(int[] integers) {
        this.integers = integers;
    }

    @Override
    public String toString() {
        return Arrays.toString(integers);
    }
}

class ArrayHolderTest {
    ArrayHolder arrayHolder = new ArrayHolder();

    @Test
    public void shouldCreateDefaultArrayTest() {
        assertEquals(arrayHolder.toString(), "[1, 2, 3, 4, 5]");
    }
}

```

## Архитектура JUnit

**_Фреймворка JUnit состоит из следующих ключевых групп:_**

Fixtures (каркас)
Test Suites (группа тестов)
Test runners (сущности, которые выполняют тесты)
Классы JUnit

### Fixtures

Это фиксированное состояние множества (набора) объектов, которые служат базисом
для выполнения тестов. Их цель – гарантировать, что существует хорошо известное
и фиксированное окружение в котором тесты выполняются таким образом, что
результаты повторяемы. Он включает в себя следующие методы:

- setUp() Выполняется перед каждым запуском тестов
- tearDown() Выполняется после каждого тестового метода

### Test Suite

Это группа, состоящая из нескольких тестов, которые запускаются вместе. Для
запуска групповых тестов используются аннотации @RunWith и @Suite.

### Test Runners

Используются для выполнения тестовых случаев.

### Классы JUnit

Классы JUnit играют огромную роль и используются для написания тестов и их
выполнения. Наиболее важные классы указаны ниже:

### Assert

Содержит множество методов утверждений.
TestCase
Содержит тестовые случаи, который определяют каркас для выполнения нескольких
тестов.
TestResult
Содержит методы для хранения данных, полученных в результате выполнения тестовых
случаев.

## API

Базовый функционал фреймворка JUnit содержится в классах пакета junit.framework,
который содержит все базовые классы, наиболее важные из которых:

**Assert** - Набор методов-утверждений
**TestCase** - Определяет каркас для выполнения тестов (fixtures)
**TestResult** - Хранит результаты выполнения тестовых случаев
**TestSuite** - Набор тестов

### Класс Assert

Данный класс содержит набор методов-утверждений, которые крайне помогают
разработчикам при написании тестов. Записываются только те утверждения, которые
оказываются ложными (false). Ниже приведён список наиболее важных методов
данного класса:

**_Метод и описание_**

- _**void assertEquals(boolean expected, boolean actual)**_ - Проверяет,
  равенство
  значений двух примитивных типов данных.
- _**void assertFalse(boolean condition)**_ - Проверяет, является ли утверждение
  ложным.
- _**void assertNotNull(Object object)**_ - Проверяет, что объект не является
  null
- _**void assertNull(Object object)**_ - Проверяет, что данный объект не
  является
  типом null
- _**void assertTrue(boolean condition)_** - Проверяет, что указанное выражение
  является истинным (true)
- _**void fail()**_ - Проваливает тест без вывода сообщений.

Откроем наш проект JUnitTutorial и создадим простой класс Calculator, который
только считает сумму двух чисел:

```java
public class Calculator {
    private int firstNumber;
    private int secondNumber;

    public Calculator() {
    }

    public Calculator(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int calculateSum() {
        return (firstNumber + secondNumber);
    }
}

class CalculatorTest {
    private Calculator calculator = new Calculator(10, 20);

    @Test
    public void shouldCreateCalculatorInstance() {
        assertNotNull(calculator);
    }

    @Test
    public void shouldReturnCorrectSum() {
        assertEquals(30, calculator.calculateSum());
    }
}

```

## Утверждения

При написании тестов практически всегда используются утверждения, большинство
из которых находятся в классе Assert.

Данный класс содержит набор утверждений, которые крайне облегчают процесс
тестирования. Записываются только те утверждения, которые не прошли.

**Наиболее важные методы класса Assert:**

**void assertTrue(boolean expected, boolean actual)** - Проверяет истинность
утверждения

- **void assertFalse(boolean condition)** - Проверяет ложность утверждения
- **void assertNotNull(Object object)** - Проверяет, что объект не является null
- **void assertNull(Object object)** - Проверяет, является ли объект null
- **void assertSame(boolean condition)** - Проверяет, ссылаются ли ссылки двух
  объектов на один и тот же объект.
- **void assertNotSame(boolean condition)** - Проверяет, не ссылаются ли ссылки
  двух объектов на один и тот же объект.

```java
public class AssertionTests {
    @Test
    public void shouldDemonstrateAssertionsTest() {
        Integer first = 1;
        Integer second = 2;
        Integer repeatFirst = 1;

        Integer[] expectedIntegerArray = {1, 2, 3, 4, 5};
        Integer[] resultIntegerArray = {1, 2, 3, 4, 5};

        assertEquals(first,repeatFirst);

        assertNotNull(second);

        assertSame(first, repeatFirst);

        assertArrayEquals(expectedIntegerArray, resultIntegerArray);
    }

}
```


**_Аннотации_**

Аннотации представляют собой, своего рода, теги, которые мы добавляем в код и 
применяем их к классам и методам. По назначению мы можем их разделить на 
следующие группы:

- игнорируют методы и классы
- запускаются перед и после всех методов
- запускаются до и после всех тестовых методов

**@Test**  
Указывает, что данный метод (public void) может быть запущен, как тестовый случай.

**@Before**  
Методы с данной аннотацией запускаются перед каждым тестом.

**@After**  
Методы с данной аннотацией запускаются после каждого теста.

**@BeforeClass**  
Запускается один раз перед запуском любого тестового метода в классе (метод 
должен быть статическим).

**@AfterClass**  
Запускается один раз после запуска любого тестового метода в классе (метод 
должен быть статическим).

**@Ignore**
Тестовые методы с данной аннотацией не будут выполнены.


```java
public class AnnotationTests {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("This method has been executed first...");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("This method has been executed last...");
    }

    @Before
    public void before(){
        System.out.println("Before each test");
    }

    @After
    public void after(){
        System.out.println("After each test");
    }

    @Test
    public void simpleTest(){
        System.out.println("This is simple test");
    }

    @Ignore
    @Test
    public void ignoreTest(){
        System.out.println("This test will be ignored");
    }
}
```