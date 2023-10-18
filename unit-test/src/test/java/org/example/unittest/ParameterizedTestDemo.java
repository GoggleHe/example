package org.example.unittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;
import static org.junit.jupiter.params.provider.EnumSource.Mode.MATCH_ALL;

class ParameterizedTestDemo {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testIsPositiveTrue(Integer value) {
        assertTrue(NumberHelper.isPositive(value), value + " is not positive");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -3, -4, -5})
    void testIsPositiveFalse(Integer value) {
        assertFalse(NumberHelper.isPositive(value), value + " is positive");
    }

    @DisplayName("test is positive number")
    @ParameterizedTest(name = "actual {0}, expected {1}")
    @CsvSource({"1,true", "-2,false", "3,true", "-4,false", "0,false", "6,true"})
    void testCsvIsPositiveFalse(Integer value, Boolean expected, TestReporter testReporter) {
        assertEquals(expected, NumberHelper.isPositive(value));
        testReporter.publishEntry("hello", "world");
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    //@NullAndEmptySource
    @ValueSource(strings = {" ", " ", "\t", "\n"})
    void nullEmptyAndBlankStrings(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }


    @Nested
    class EnumSourceDemo {
        @ParameterizedTest
        @EnumSource(value = TimeUnit.class, names = {"DAYS", "HOURS"})
        void testWithEnumSourceInclude(TimeUnit timeUnit) {
            assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
        }

        //mode匹配
        @ParameterizedTest
        @EnumSource(value = TimeUnit.class, mode = EXCLUDE, names = {"DAYS", "HOURS"})
        void testWithEnumSourceExclude(TimeUnit timeUnit) {
            assertFalse(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
            assertTrue(timeUnit.name().length() > 5);
        }

        //mode匹配
        @ParameterizedTest
        @EnumSource(value = TimeUnit.class, mode = MATCH_ALL, names = "^(M|N).+SECONDS$")
        void testWithEnumSourceRegex(TimeUnit timeUnit) {
            String name = timeUnit.name();
            assertTrue(name.startsWith("M") || name.startsWith("N"));
            assertTrue(name.endsWith("SECONDS"));
        }
    }


    @Nested
    class MethodSourceDemo {
        //默认搜索与当前方法同名的工厂方法
        @ParameterizedTest
        @MethodSource("org.example.unittest.ParameterizedTestDemo#stringProvider")
        void testWithSimpleMethodSource(String argument) {
            assertNotNull(argument);
        }

        //多参数示例
        @ParameterizedTest
        @MethodSource("org.example.unittest.ParameterizedTestDemo#stringIntAndListProvider")
        void testWithMultiArgMethodSource(String str, int num, List<String> list) {
            assertEquals(3, str.length());
            assertTrue(num >= 1 && num <= 2);
            assertEquals(2, list.size());
        }

    }

    static Stream<String> stringProvider() {
        return Stream.of("foo", "bar");
    }

    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                Arguments.of("foo", 1, Arrays.asList("a", "b")),
                Arguments.of("bar", 2, Arrays.asList("x", "y"))
        );

    }

    @Nested
    class CsvSourceDemo {
        @ParameterizedTest
        @CsvSource({"foo, 1", "bar, 2", "'baz, qux', 3"})
        void testWithCsvSource(String first, int second) {
            assertNotNull(first);
            assertNotEquals(0, second);
        }
    }

    @Nested
    class CsvFileSourceDemo {
        @ParameterizedTest
        @CsvFileSource(resources = "/two-column.csv")
        void testWithCsvFileSource(String first, int second) {
            assertNotNull(first);
            assertNotEquals(0, second);
        }
    }

    @Nested
    class ArgumentsSourceDemo {
        @ParameterizedTest
        @ArgumentsSource(MyArgumentsProvider.class)
        void testWithArgumentsSource(String argument) {
            assertNotNull(argument);
        }
    }

    static class MyArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of("apple", "banana").map(Arguments::of);
        }
    }

    @Nested
    class ParamCovertDemo {
        @ParameterizedTest
        @EnumSource(TimeUnit.class)
        void testWithExplicitArgumentConversion(@ConvertWith(ToStringArgumentConverter.class) String argument) {
            assertNotNull(TimeUnit.valueOf(argument));
        }

        @ParameterizedTest
        @ValueSource(strings = {"01.01.2017", "31.12.2017"})
        void testWithExplicitJavaTimeConverter(@JavaTimeConversionPattern("dd.MM.yyyy") LocalDate argument) {
            assertEquals(2017, argument.getYear());
        }
    }

    static class ToStringArgumentConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) {
            assertEquals(String.class, targetType, "Can only convert to String");
            return String.valueOf(source);
        }
    }

    /**
     * 参数聚合
     */
    @Nested
    class ArgumentsAccessorDemo {
        //参数访问器
        @ParameterizedTest
        @CsvSource({
                "Jane, Doe, F, 1990-05-20",
                "John, Doe, M, 1990-10-22"
        })
        void testWithArgumentsAccessor(ArgumentsAccessor arguments) {
            Person person = new Person(arguments.getString(0),
                    arguments.getString(1),
                    arguments.get(2, Gender.class),
                    arguments.get(3, LocalDate.class));
            if (person.getFirstName().equals("Jane")) {
                assertEquals(Gender.F, person.getGender());
            } else {
                assertEquals(Gender.M, person.getGender());
            }
            assertEquals("Doe", person.getLastName());
            assertEquals(1990, person.getDateOfBirth().getYear());
        }

        //自定义聚合
        @ParameterizedTest
        @CsvSource({
                "Jane, Doe, F, 1990-05-20",
                "John, Doe, M, 1990-10-22"
        })
        void testWithArgumentsAggregator(@AggregateWith(PersonAggregator.class) Person person) {
            assertEquals("Doe", person.getLastName());
            assertEquals(1990, person.getDateOfBirth().getYear());
        }

        //自定义注解
        @ParameterizedTest
        @CsvSource({
                "Jane, Doe, F, 1990-05-20",
                "John, Doe, M, 1990-10-22"
        })
        void testWithArgumentsAnnotation(@CsvToPerson Person person) {
            assertEquals("Doe", person.getLastName());
            assertEquals(1990, person.getDateOfBirth().getYear());
        }

        //自定义显示名称
        @DisplayName("Display name of container")
        @ParameterizedTest(name = "{index} ==> fruit=''{0}'', rank={1}")
        @CsvSource({"apple, 1", "banana, 2", "'lemon, lime', 3"})
        void testWithCustomDisplayNames(String fruit, int rank) {
        }

        //⽣命周期和互通性
        @ParameterizedTest
        @ValueSource(strings = "foo")
        void testWithRegularParameterResolver(String argument, TestReporter testReporter) {
            testReporter.publishEntry("argument", argument);
        }
    }
}