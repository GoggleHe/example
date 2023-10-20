package org.example.mockito;

import org.example.unittest.Calculator;
import org.example.unittest.Person;
import org.example.unittest.Storage;
import org.example.unittest.Villa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.delegatesTo;
import static org.mockito.Mockito.*;


class MockitoDemo {

    /**
     * 验证执行次数
     */
    @Test
    void testVerifyTimes() {
        //mock实例
        List mockList = mock(List.class);

        //调用方法
        mockList.add(1);
        mockList.clear();
        //验证是否调用了一次
        verify(mockList).add(1);
        verify(mockList).clear();
        //至多1次
        verify(mockList, atMostOnce()).add(1);
        //至少1次
        verify(mockList, atLeastOnce()).add(1);

        //调用方法
        mockList.add(2);
        mockList.add(2);
        //验证多次调用
        verify(mockList, times(2)).add(2);
        //至少2次
        verify(mockList, atLeast(2)).add(2);
        //至多2次
        verify(mockList, atMost(2)).add(2);

        //从未被调用
        verify(mockList, never()).add(3);

    }

    /**
     * 测试桩
     */
    @Test
    void testStub() {
        // 可以 mock 具体的类型，不仅只是接口
        LinkedList mockedList = mock(LinkedList.class);

        //测试桩
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //验证测试桩结果
        assertEquals("first", mockedList.get(0));
        assertThrows(RuntimeException.class, () -> mockedList.get(1));

        //get(100)未打桩，返回null
        assertNull(mockedList.get(100));

        verify(mockedList).get(0);

        //doReturn方法实现
        doReturn("haha").doThrow(RuntimeException.class).when(mockedList).get(0);

        assertEquals("haha", mockedList.get(0));
        assertThrows(RuntimeException.class, () -> mockedList.get(0));
    }


    /**
     * 参数匹配：验证调用时传入的参数是否符合要求
     */
    @Test
    void testArgumentMatcher() {
        List mockedList = mock(LinkedList.class);
        // 使用内置的 anyInt() 参数匹配器
        when(mockedList.get(anyInt())).thenReturn("element");

        // 使用自定义的参数匹配器( 在isValid() 函数中返回你自己的匹配器实现 )

        when(mockedList.contains(argThat(new ArgumentMatcher<Object>() {
            @Override
            public boolean matches(Object o) {
                return o instanceof Integer;
            }
        }))).thenReturn(false);

        assertEquals("element", mockedList.get(2342432));
        assertTrue(mockedList.contains(234324));

        //参数匹配Integer，实际输入String，未mock方法返回默认值false(若返回值非基本类型，返回null)
        assertFalse(mockedList.contains("1.1"));
    }

    /**
     * mock返回值为void的方法，调用时抛出异常
     */
    @Test
    void testVoidMethod() {
        LinkedList mockedList = mock(LinkedList.class);
        doThrow(new RuntimeException()).when(mockedList).clear();

        assertThrows(RuntimeException.class, mockedList::clear);
    }

    @Test
    void testInOrder() {
        // A. 验证 mock 一个对象的函数执行顺序
        List singleMock = mock(List.class);

        // 使用 singleMock
        singleMock.add("was added first");
        singleMock.add("was added second");

        // 为该 mock 对象创建一个 inOrder 对象
        InOrder inOrder = inOrder(singleMock);

        // 确保 add 函数首先执行的是 add("was added first")，然后才是 add("was added second")
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        // B. 验证多个 mock 对象的函数执行顺序
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        // 使用 mock
        firstMock.add("was called first");
        firstMock.add("was called first");
        firstMock.add("was called first");
        secondMock.add("was called second");

        // 为这两个 mock 对象创建 inOrder 对象
        InOrder inOrder2 = inOrder(firstMock, secondMock);

        // 验证它们的执行顺序
        inOrder2.verify(firstMock, calls(2)).add("was called first");
        inOrder2.verify(secondMock).add("was called second");

        //PS:calls(2)方法返回的验证模式表示至少2次，该方法仅用于顺序验证
    }

    /**
     * 验证mock对象没有未被verify的操作
     */
    @Test
    void testNoInteraction() {
        List mockOne = mock(List.class);
        List mockTwo = mock(List.class);
        List mockThree = mock(List.class);
        // 使用 Mock 对象
        mockOne.add("one");
        mockOne.add(1);

        // 普通验证
        verify(mockOne).add("one");

        // 验证某个交互是否从未被执行
        verify(mockOne, never()).add("two");


    }

    @Test
    void testFindRedundant() {
        List mockedList = mock(List.class);
        // 使用 mock
        mockedList.add("one");
        mockedList.add("two");

        verify(mockedList).add("one");

        // 下面的验证将会失败
        verifyNoMoreInteractions(mockedList);
        // 验证 mock 对象没有交互过
        verifyZeroInteractions(mockedList);//过期方法
    }

    @Mock
    private List mockList;

    @Test
    //注解方式
    @ExtendWith(MockitoExtension.class)
    void testMock() {
        //MockitoAnnotations.initMocks(this); 编程方式
        when(mockList.get(0)).thenReturn("haha");

        assertEquals("haha", mockList.get(0));
        verify(mockList).get(0);
    }

    /**
     * 连续调用打桩
     */
    @Test
    void stubConsecutiveCall() {
        TmpMock mock = mock(TmpMock.class);
        //连续调用mock方式一
        when(mock.someMethod("some arg"))
                .thenThrow(new RuntimeException())
                .thenReturn("foo");

        // 第一次调用 : 抛出运行时异常
        assertThrows(RuntimeException.class, () -> mock.someMethod("some arg"));

        // 第二次调用 : 输出 "foo"
        assertEquals("foo", mock.someMethod("some arg"));

        // 后续调用 : 也是输出 "foo"
        assertEquals("foo", mock.someMethod("some arg"));

        //连续调用mock方式二
        // 第一次调用时返回 "one"，第二次返回 "two"，第三次返回 "three"
        when(mock.someMethod("some arg"))
                .thenReturn("one", "two", "three");

        assertEquals("one", mock.someMethod("some arg"));
        assertEquals("two", mock.someMethod("some arg"));
        assertEquals("three", mock.someMethod("some arg"));
    }


    class TmpMock {
        public String someMethod(String some_arg) {
            return null;
        }


        public void someMethod() {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用Answer接口回调打桩
     */
    @Test
    void stubWithCallBack() {
        TmpMock mock = mock(TmpMock.class);
        //匿名内部类
        when(mock.someMethod(anyString())).thenAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                Object mock = invocation.getMock();
                return "called with arguments: " + args[0];
            }
        });
        //lambda表达式
        when(mock.someMethod(anyString())).thenAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            Object mock1 = invocation.getMock();
            return "called with arguments: " + args[0];
        });

        // 输出 : "called with arguments: foo"
        assertEquals("called with arguments: foo", mock.someMethod("foo"));
    }

    /**
     * 给void方法打桩
     */
    @Test
    void stubVoidMock() {
        List mockedList = mock(ArrayList.class);

        doThrow(new RuntimeException()).when(mockedList).clear();
        assertThrows(RuntimeException.class, mockedList::clear);

        doNothing().when(mockedList).clear();
        mockedList.clear();

        doCallRealMethod().when(mockedList).clear();
        mockedList.clear();
    }

    /**
     * 监控真实对象
     */
    @Test
    void testSpy() {
        List list = new LinkedList();
        List spy = spy(list);

        // 你可以为某些函数打桩
        when(spy.size()).thenReturn(100);

        // 通过spy对象调用真实对象的函数
        spy.add("one");
        spy.add("two");

        // 输出第一个元素
        assertEquals("one", spy.get(0));

        // 因为size()函数被打桩了,因此这里返回的是100
        assertEquals(100, spy.size());

        // 交互验证
        verify(spy).add("one");
        verify(spy).add("two");

        // 不可能 : 因为当调用spy.get(0)时会调用真实对象的get(0)函数,此时会发生IndexOutOfBoundsException异常，因为真实List对象是空的
        when(spy.get(0)).thenReturn("foo");

        // 你需要使用doReturn()来打桩
        doReturn("foo").when(spy).get(0);
    }

    /**
     * 真实对象打桩注意事项
     */
    @Test
    void testSpyStub() {
        List list = new LinkedList();
        List spy = spy(list);

        // 不可能 : 因为当调用spy.get(0)时会调用真实对象的get(0)函数,此时会发生IndexOutOfBoundsException异常，因为真实List对象是空的
        when(spy.get(0)).thenReturn("foo");

        // 你需要使用doReturn()来打桩
        doReturn("foo").when(spy).get(0);
        assertEquals("foo", spy.get(0));
    }

    /**
     * 修改未打桩调用的默认返回值
     */
    @Test
    void modifyUnStubDefaultReturnValue() {
        List mock = mock(List.class, Mockito.RETURNS_SMART_NULLS);
        List mockTwo = mock(List.class, new YourOwnAnswer());


        assertEquals(0, mock.size());
        assertNull(mock.get(0));

        assertEquals(0, mockTwo.size());
        assertEquals("default value", mockTwo.get(0));
    }

    private static class YourOwnAnswer implements Answer<Object> {
        @Override
        public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
            Method method = invocationOnMock.getMethod();
            Class<?> returnType = method.getReturnType();
            Object res = null;
            switch (returnType.getName()) {
                case "java.lang.Object":
                    res = "default value";
                    break;
                default:
                    res = 0;
                    break;
            }
            return res;
        }
    }

    @Captor
    private ArgumentCaptor<Person> argument;

    /**
     * 参数捕获
     */
    @Test
    void captureArguments() {
        List spy = spy(List.class);
        ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);

        //调用方法
        spy.remove(new Person("John"));
        // 参数捕获
        verify(spy).remove(argument.capture());
        // 使用equal断言
        assertEquals("John", argument.getValue().getName());
    }

    /**
     * 真实局部mock
     */
    @Test
    void realPartialMock() {
        //you can create partial mock with spy() method:
        //使用spy创建真实局部mock对象
        List list = spy(new LinkedList());

        //you can enable partial mock capabilities selectively on mocks:
        //使用mock实现真实局部mock功能
        Person mock = mock(Person.class);

        //打真实调用桩
        doCallRealMethod().when(mock).setName("Bob");
        when(mock.getName()).thenCallRealMethod();

        //验证
        mock.setName("Bob");
        assertEquals("Bob", mock.getName());
    }


    /**
     * 重置mocks对象:普通用户不推荐使用，容易引入代码以为，提供该方法主要是为了容器测试，而非提供给使用者
     */
    @Test
    void testReset() {
        List mock = mock(List.class);
        when(mock.size()).thenReturn(10);
        mock.add(1);

        //重置并清空mock对象所有交互（即调用）和打桩
        reset(mock);
    }


    @Spy
    private List<Person> spyList = new ArrayList<>();

    @Mock
    private Person person;
    @InjectMocks
    private Villa villa;

    @Test
    @ExtendWith(MockitoExtension.class)
    void newAnnotation() {
        //@Spy注解
        spyList.add(new Person("Rick"));
        assertEquals("Rick", spyList.get(0).getName());

        doReturn(new Person("World")).when(spyList).get(0);
        assertEquals("World", spyList.get(0).getName());

        ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);

        //@Capture注解
        spyList.remove(new Person("John"));
        // 参数捕获
        verify(spyList).remove(argument.capture());
        // 使用equal断言
        assertEquals("John", argument.getValue().getName());

        //验证@InjectMock注入效果
        when(person.getName()).thenReturn("Stark");
        assertEquals("Stark", villa.ownerName());
    }

    /**
     * 单行测试桩
     */
    @Test
    void inLineStub() {
        Person mock = when(mock(Person.class).getName())
                .thenReturn("ABC").getMock();
        assertEquals("ABC", mock.getName());
    }

    /**
     * 委托调用真实实例
     */
    @Test
    void testDelegatesTo() {
        CustomMockedList awesomeList = new CustomMockedList();

        List<String> mock = mock(List.class, delegatesTo(awesomeList));

        doReturn("String").when(mock).get(0);

        assertEquals("String", mock.get(0));

        verify(mock).get(0);

        assertEquals("null", awesomeList.get(0));
    }

    static final class CustomMockedList extends AbstractList<String> {

        public String get(int index) {
            return "null";
        }

        public int size() {
            return 0;
        }
    }

    /**
     * mock spy 抽象类
     */
    @Test
    void testMockOrSpyAbstract() {
        //重载的spy方法
        SomeAbstract spy = spy(SomeAbstract.class);

        //设置生成器
        OtherAbstract mock = mock(OtherAbstract.class, withSettings()
                .useConstructor().defaultAnswer(CALLS_REAL_METHODS));

        //mock一个非静态内部类
        OuterAbstract outerAbstract = new OuterAbstract();
        OuterAbstract.InnerAbstract innerMock = mock(OuterAbstract.InnerAbstract.class, withSettings()
                .useConstructor().outerInstance(outerAbstract).defaultAnswer(CALLS_REAL_METHODS));

    }

    private abstract static class SomeAbstract {
        public SomeAbstract() {
        }
    }

    private abstract static class OtherAbstract {
        public OtherAbstract() {
        }
    }

    private static class OuterAbstract {
        private abstract class InnerAbstract {
            public InnerAbstract() {
            }
        }
    }

    /**
     * 深度打桩
     */
    @Test
    void deepStub() {
        //普通方式给链式调用打桩
        City city = when(mock(City.class).getName()).thenReturn("Door").getMock();
        Address address = when(mock(Address.class).getCity()).thenReturn(city).getMock();
        User user = when(mock(User.class).getAddress()).thenReturn(address).getMock();

        assertEquals("Door", user.getAddress().getCity().getName());
        verify(city).getName();
        verify(address).getCity();
        verify(user).getAddress();

        // 使用RETURNS_DEEP_STUBS为链式调用打桩
        User mockUser = mock(User.class, RETURNS_DEEP_STUBS);
        when(mockUser.getAddress().getCity().getName()).thenReturn("Garden");

        // 现在，当你调用mockUser.getAddress().getCity().getName()时，应该返回"mockCity"
        assertEquals("Garden", mockUser.getAddress().getCity().getName());
    }

    class User {
        private Address address;

        // constructor, getters and setters...

        public Address getAddress() {
            return address;
        }
    }

    class Address {
        private City city;

        // constructor, getters and setters...

        public City getCity() {
            return city;
        }
    }

    class City {
        private String name;

        // constructor, getters and setters...

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}


