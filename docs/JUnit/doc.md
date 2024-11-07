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

- _**void assertEquals(boolean expected, boolean actual)**_ - Проверяет, равенство
  значений двух примитивных типов данных.
- _**void assertFalse(boolean condition)**_ - Проверяет, является ли утверждение
  ложным.
- _**void assertNotNull(Object object)**_ - Проверяет, что объект не является null
- _**void assertNull(Object object)**_ - Проверяет, что данный объект не является
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