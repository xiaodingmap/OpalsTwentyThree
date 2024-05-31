# JAVA知识点
## Iterator迭代器
```java
import java.util.*;

public class IteratorSetExample {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        
        Iterator<Integer> iterator = set.iterator();
        
        while(iterator.hasNext()) {
            if (condition) {
                iterator.remove(); // 安全地删除当前元素
            }
        }
    }
}
```
Iterator遍历集合时，入股在遍历过程中对集合修改（如添加、删除元素），可能导致CocurrentModificationException异常。因此，建议在使用Iterator遍历
集合时，不要在循环中直接改变元素结果，而是通过迭代器的remove方法进行安全删除操作。
## 正则表达式
常用规则及说明：
1. 匹配单个字符
    - `.`: 匹配任意单个字符（除换行符）
    - `[abc]`: 匹配中括号中任意字符
    - `[^abc]`: 匹配除中括号中字符之外的任意字符
2. 匹配字符集合：
    - `\d`：匹配一个数字字符，等价于`[0-9]`
    - `\D`：匹配一个非数字字符，等价于`[^0-9]`
    - `\w`: 匹配一个单词字符，包含字母、数字及下划线，等价于`[a-zA-Z0-9_]`
    - `\W`: 匹配一个非单词字符，等价于`[^a-zA-Z0-9_]`
    - `\s`: 匹配一个空白字符吗，包含空格、制表符和换行符
    - `\S`: 匹配一个非空白字符
3. 重复匹配：
    - `*`: 匹配前一个字符的零次or多次
    - `+`: 匹配前一个字符的一次or多次
    - `?`: 匹配前一个字符的零次or一次
    - `{n}`: 匹配前一个字符恰好n次
    - `{n,}`: 匹配前一个字符至少n次
    - `{n,m}`: 匹配前一个字符至少n次，但不超过m次
4. 定位符：
   - `^`：匹配输入字符串的开始位置
   - `$`: 匹配输入字符串的结束位置
   - `\b`: 匹配单词的边界，即单词和非单词字符之间的位置
5. 分组和引用：
   - `()`: 将其中的表达式分组，可以在后续中引用
   - `\n`: 引用分组号为n的匹配结果
6. 转移字符：
   - `\`: 用于转义下一个字符，使其具有特殊意义
7. 其他常用：
   - `|`: 表示或，匹配两个表达式之一。
   - `?=`: 正向肯定预查，在匹配到该位置时，向前检查是否符合子表达式的规则
   - `?!`: 负向否定预查，在匹配到该位置时，向前检查是否不符合子表达式的规则
   
## UML类图
`+`：表示public

`-`：表示private

`#`：表示protected

`继承关系`：空心三角形+实线

`实现接口`：空心三角形+虚线

`聚合`：空心菱形+实线箭头  表示一种弱拥有关系，A对象可以包含B对象，但是B对象不是A对象的一部分

`组合`：实心菱形+实线箭头 表示一种强拥有关系，体现严格部分

`关联`：关联关系，用实线箭头表示，表述的是 一个类知道另一个类

`依赖`：依赖关系，用虚线箭头表示，表述的是，一个类依赖另一个类

## 数据库
操作流程：
1. 加载数据库驱动程序
2. 建立数据库连接 DriverManager类中的getConnction方法
3. 创建sql语句 使用`statement`、`preparedStatement`或`CallableStatement`来创建和执行sql语句

   | name              | 用途               |                              优点                               |                                       缺点 |
   |-------------------|------------------|:-------------------------------------------------------------:|-----------------------------------------:|
   | Statement         | 用于执行简单sql语句，不带参数 |                 简单直接，适合执行静态、不带参数和一次性执行的sql语句                  |      每次执行sql，数据库需要对语句编译解析，效率低，且易受sql注入攻击 |
   | PreparedStatement | 用于执行带参数的sql语句，   | 可以预编译sql，执行效率高，尤其是在重复执行相同sql时；也可防止sql注入攻击，因为参数被自动转义；代码清晰，可读性好 | 编写相对复杂，需要提前准备sql语句和参数；占用资源略多于`Statement` |
   | CallableStatement | 用于调用存储过程和存储函数    |         可以调用复杂存储过程和函数，适合执行批处理或复杂数据库操作；提高代码复用性和数据库可维护性         |      编写和调试较为复杂；依赖于数据库的存储过程实现，降低程序的数据库移植性 |
   - `statement`简单直接，适合执行静态、不带参数和一次性执行的sql语句，缺点是
4. 执行sql语句
5. 处理结果集 `ResultSet`
6. 关闭资源 关闭`ResultSet`、`Statement`和`Connection`，释放数据库资源
代码举例：
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseExample {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String JDBC_USER = "your_username";
    private static final String JDBC_PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 1. 加载数据库驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 建立数据库连接
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // 3. 创建SQL语句
            String sql = "SELECT * FROM your_table WHERE your_column = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "your_value");

            // 4. 执行SQL语句
            resultSet = preparedStatement.executeQuery();

            // 5. 处理结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (ClassNotFoundException e) {
            System.err.println("数据库驱动程序未找到: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("数据库操作错误: " + e.getMessage());
        } finally {
            // 6. 关闭资源
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("关闭资源时出错: " + e.getMessage());
            }
        }
    }
}
```
## Set集合
Set 集合的基本概念
1. 无序性:

   除了LinkedHashSet和TreeSet外，大多数Set实现类不保证元素的顺序。
2. 不重复性:

   Set集合不允许包含重复的元素。如果试图添加重复元素，添加操作将失败。
3. 允许包含null元素:

   大多数Set实现类允许包含一个null元素，但TreeSet**不允许**包含null元素。

常用的 Set 实现类
1. HashSet:
基于哈希表实现，元素无序，允许包含一个null元素。
插入、删除和查找操作的时间复杂度为O(1)。
2. LinkedHashSet:
基于哈希表和链表实现，维护元素的插入顺序。
允许包含一个null元素。
3. TreeSet:
基于红黑树实现，元素有序，不允许包含null元素。
插入、删除和查找操作的时间复杂度为O(log n)。

注意事项
1. 不允许重复元素:

   Set集合不允许重复元素，如果试图添加重复元素，添加操作将返回false。
2. 线程安全性:

   默认情况下，Set集合不是线程安全的。如果需要在多线程环境中使用，可以使用Collections.synchronizedSet方法来获得线程安全的Set。

3. 性能差异:

   根据具体需求选择合适的Set实现类。HashSet在大多数情况下性能较好，但如果需要有序集合，LinkedHashSet和TreeSet是更好的选择。
4. null 元素处理:

   注意TreeSet不允许包含null元素，而HashSet和LinkedHashSet允许包含一个null元素。
## java线程实现方式
1. 继承Thread类
```java
class MyThread extends Thread {
    @Override
   public void run() {
       System.out.println("Thread is running...");
    }

   public static void main(String[] args) {
      MyThread thread = new MyThread();
      thread.start();//启动线程
   }
}
```
      优点：简单直接，适合快速创建线程

      缺点：
         Java单继承类限制，无法再继承其他类
         不适合共享资源


2. 实现runnable接口
```java
class MyRunnable extends Runnable {
    @Override
   public void run() {
       System.out.println("Runnable is running...");
    }

   public static void main(String[] args) {
      MyRunnable runnable = new MyRunnable();  
      Thread thread = new Thread(runnable);
      thread.start();//启动线程
   }
}
```
      优点：适合共享资源
            适合继承其他类
            更符合面向对象设计
      缺点：
         相比thread略复杂
3. 实现callable接口，并使用future
```java
import java.util.concurrent.Callable;

class MyCallable implements Callable<String> {
   @Override
   public String call() throws Exception {
      return "Callable result";
   }

   public static void main(String[] args) {
      ExecutorService executor = Executors.newSingleThreadExecutor();
      MyCallable callable = new MyCallable();
      Future<String> future = executor.submit(callable);
      try {
         String result = future.get();
         System.out.println("Result: " + result);
      } catch (InterruptedException | ExecutionException e) {
         e.printStackTrace();
      } finally {
         executor.shutdown();
      }
   }
}
```
      优点：可以返回结果或抛出异常
            适合需要返回计算结果的场景
      缺点：
         更复杂，需要处理异常
4. 使用excutor框架
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyRunnable implements Runnable {
   @Override
   public void run() {
      System.out.println("Executor is running...");
   }

   public static void main(String[] args) {
      ExecutorService executor = Executors.newFixedThreadPool(2);
      MyRunnable myRunnable = new MyRunnable();

      executor.execute(myRunnable);
      executor.execute(myRunnable);

      executor.shutdown();
   }
}

```
      优点：提供线程池管理，避免手动创建和管理线程
            提高资源利用率，适合大规模并发任务
      缺点：
         需要理解和掌握excutor框架

## 限流
Java中，限流是一种用于控制资源访问速率的方法，以防止系统过载或滥用资源，限流的实现方式有很多种，常见的限流算法和工具包括：
- 计数器算法 （维护一个计数器在固定时间窗口内记录请求数量）
- 滑动窗口算法（计数器算法改进版本，通过维护多个小窗口的请求计数来更精确控制请求速率）
- 漏桶算法（通过一个固定容量的桶来控制请求速率，请求以恒定速率从桶中漏出）
- 令牌桶算法 （通过一个固定容量的桶来存储令牌，请求必须获取到令牌才能通过，令牌以固定速率添加到桶中）
- 使用现成的限流库，如Guava、RateLimiter或Resilience4j
## 资源关闭
资源关闭是为了确保在使用完资源（如文件、数据库连接、网络连接等）后，正确释放它们，以防止资源泄露，java提供了几种方法来确保资源的正确关闭，最常用的是
`try-with-resources`语句和显式在`finally`中关闭资源
1. try-with-resources
  `try-with-resources`语句是Java 7引入的一种自动管理资源的方式。它可以确保任何实现了AutoCloseable接口的资源在语句结束时自动关闭。
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```
在上面的示例中，BufferedReader和FileReader在try块结束时会自动关闭，无需显式调用close方法。

2. 显示关闭资源（在finally块中）
   在Java 7之前，通常在finally块中显式地关闭资源。这样可以确保资源在try块中出现异常时也能正确关闭。
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FinallyBlockExample {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("test.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

```
## 内部类
在Java中，内部类是定义在另一个类内部的类，可以帮助组织代码，使代码更具有可读性和可维护性，同时也提供封装和隐藏的功能，内部类主要分为以下几种类型：
1. 成员内部类  
成员内部类是在类内部定义的类，并且没有使用`static`修饰，是外部类的一个成员，可以访问外部类的成员变量和方法。

```java
public class OuterClass {
   private String outerField = "Outer Field";

   class InnerClass {
      public void display() {
         System.out.println("Accessing outer field:" + outerField);
      }
   }

   public static void main(String[] args) {
      OuterClass outer = new OuterClass();
      InnerClass innerClass = outer.new InnerClass();
      innerClass.display();
   }
}
```
2. 局部内部类  
 在方法或者代码块内部定义的类，作用范围仅限于定义它的方法或代码块中
```java
public class OuterClass {
    
    public void display() {
        class LocalInnerClass {
            void print() {
                System.out.println("This is a local inner class." );
            }
        }
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.print();
    }


    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.display();
    }
}
```
3. 匿名内部类  
是一种没有名字的类，通常用来简化代码，用于实现接口或继承类的场景，匿名内部类必须实现一个接口或继承一个类
```java
public class OuterClass {

    public void display() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("This is an anonymous inner class." );
            }
        };
        runnable.run();
    }


    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.display();
    }
}
```
4. 静态内部类  
使用static关键字修饰，可以直接访问外部类的静态成员，但不能直接访问外部类的非静态成员，静态内部类的创建不依赖于外部类的实例
```java
public class OuterClass {
    private static String staticOuterField = "Static outer field";
    
    static class StaticNestedClass {
        public void display() {
            System.out.println("Accessing static outer field: " + staticOuterField);
        }
    }

    
    public static void main(String[] args) {
        // 创建不依赖于OuterClass的实例
       StaticNestedClass nestedClass = new OuterClass.StaticNestedClass();
        nestedClass.display();
    }
}
```
### 注意事项
1. 访问权限
   - 内部类可以访问其外部类的所有成员变量和方法，包括私有成员
   - 外部类不能直接访问内部类的成员，必须通过内部类的实例来访问
2. 创建实例
   - 成员内部类的实例必须通过外部类的实例创建
   - 静态内部类的实例可以直接创建，不依赖外部类的实例
3. 作用域
   - 局部内部类和匿名内部类的作用域仅限于定义它们的方法or代码块
4. 内存管理
   - 内部类持有外部类的引用，可能会导致内存泄漏，设计时需要避免长生命周期的内部类持有短生命周期的外部类引用
5. 可读性和维护性
   - 使用内部类可以提高代码的可读性和维护性，但是滥用内部类可能会导致代码复杂化
## 反射与Class类
在Java中，Class类和反射提供了在运行时检查和操作类的能力，反射使java具有高度的动态性，可以在运行时获取类的结构（包括类的字段、方法、构造函数等）并
进行相应操作。
### Class类
`Class`类使反射的核心类之一，它表示正在运行的Java程序的类或接口，每个类或接口都会有与之对应的Class对象，通过Class对象，可以获取类的元数据
获取`Class`对象的三种方式
1. 通过类名获取
```java
Class<?> clazz = String.class; 
```
2. 通过对象实例获取
```java
String str = "Hello";
Class<?> clazz = str.getClass(); 
```
3. 通过全限定类名获取
```java
try {
        Class<?> clazz = Class.forName("java.lang.String");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

```
## 泛型
是一种提供类型安全和代码重用性的方法，允许类、接口、和方法操作具有指定类型的对象，而无需指定具体的对象类型。泛型的引入增强了Java语言的灵活性和类型安全
性，避免许多类型转换为题和潜在的运行时错误。

泛型的主要特性

1. 类型参数化：泛型允许在定义类、接口和方法时使用类型参数，具体类型在使用时指定
2. 类型安全：在编译时进行类型检查，防止类型转换错误
3. 代码重用：可以编写更通用代码，提高代码的可重用性。

类型通配符
- 无界通配符：`？`，表示可以持有任何类型对象
- 有界通配符：`? extends T`表示类型必须是T或T的子类
- 下界通配符：`? super T`,表示类型必须是T或者T的父类

泛型的限制
1. 基本类型不能作为类型参数：不能直接使用基本类型（如`int` `char`）作为泛型参数，需要使用包装类（`Integer`,`Character`）。
2. 运行时类型擦除：泛型信息在编译后会被擦除，导致在运行时无法获取具体的类型信息。
3. 静态成员不能使用类型参数：在泛型类中，静态成员不能使用类的类型参数。
```java
package l.strong.opalstwentythree.generics;

import java.util.ArrayList;
import java.util.List;

public class TypeErasureExample {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();

        System.out.println("String list class: " + stringList.getClass());
        System.out.println("Integer list class: " + intList.getClass());

        if (stringList.getClass() == intList.getClass()) {
            System.out.println("Both lists are of the same class due to type erasure.");
        }
    }
}
```
String和Integer都是List的泛型具体类型，在运行时，上述打印的：
```java
String list class: class java.util.ArrayList
Integer list class: class java.util.ArrayList
```
都是擦除泛型之后的运行时结果，所以泛型在运行时，会做类型擦除。
