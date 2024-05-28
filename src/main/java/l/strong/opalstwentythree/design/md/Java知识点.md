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

