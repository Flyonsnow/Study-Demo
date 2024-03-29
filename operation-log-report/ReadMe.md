# 操作记录上报

## 背景
在日常工作中，遇到线上业务bug，商诉客诉等问题时，很多时候都需要研发通过查询系统日志来排查。但是这样做的效率实际上时非常低的，具体原因有以下几点：
* 查询系统日志要求研发人发人员，有一定的技术要求；
* 是否记录日志，完全看研发人员的个人能力；
* 在分布式集群部署的环境下，系统日志分散在各集群各个节点中，当出现问题时，很难快速定位日志所在节点位置；
* 商诉客诉的解决，完全依赖于研发人员，处理链路，要经过客服——>运营——>产品——>研发，四个岗位的人员，问题处理效率低下。

## 业务目标
从上述的背景问题中，总结出如下待解决的问题：
* 将系统日志，统一设计为操作记录，以标准化的格式上报，集中存储；
* 日志要以操作记录这种业务形式保存，使非技术人员页可以自助查询；
通过上述手段，处理问题人效低的问题。

## 技术目标
* 由于要做到各个业务模型的操作操作记录统一格式上报，所以系统设计必须成对外黑盒的统一上报模式；
* 操作记录系统的接入开发，不能过多侵入业务系统；
* 要实现非技术人员可用，必须有产品化交互；
* 当上报模型中有新字段出现时，要做到降低研发成本；
* 能否实现修改前后的对比



## 架构设计

客户端SDK： 暴露接口/注解API、diff分析、异步上报
服务端： 

## 概要设计

为了降低对应用程序的侵入性，不应该让用户在业务编码中插入我们的代码，所以考虑通过AOP+注解方式实现让用户可控的自动记录上报。
具体的注解设计随着各模块的分析逐步记录



### diff分析

#### 获取对象
如果想要进行修改前后对象的对比， 首先要获取到修改前后的对象<br>
a、获取修改后对象的方式存在3种情况<br>
- 1、在方法参数种可以直接获取到
- 2、在方法返回值中可以获取到
- 3、无法直接获取，需要通过主键获取

b、获取修改前对象一般在方法中很难获取，所以只能在方法执行前，通过主键查询获取

因此在注解中需要有:<br>
1、获取修改后对象的方式的配置
2、若在参数中获取对象，需要标记是哪个参数

c、根据主键获取对象
理论上讲，如果使用的ORM框架相同，可以做到全自动化，但是不太灵活，如果用户选择不同的orm框架时会产生问题

需要用户实现Interface， SDK通过反射调用，实现主键获取对象

````java

public interface OperationLogDao<T> {

    <T> getById(Serializable id);
}

````

#### 比较对象

比较两个对象时，为了支持用户模型的字段修改, 需要通过反射，动态获取字段
需要输出原值和修改后的值

- 1、当对象的属性都为简单类型(基本类型或包装类和String)时，直接对比值
- 2、当属性类型为List时<br>
  - a、List<包装类或String>, 对比值，展示增加了xx，减少了xx
  - b、List<引用对象>, 显示增加了xx，减少了xx，修改了xx，具体修改值，逻辑相同
  - c、需要考虑循环引用问题
- 3、当属性为引用对象时，根据是否为null，显示新增xx，值为xx， 删除xx，值为xx； 修改x为y，及值的对比
- 4、需要在需上报的对象模型中标记主键或唯一key的注解


### 注解设计
````java
@EnableOperationLogReport(
        
)

@OperationLongReport(
// 获取修改后对象的方式, PARAM、RETURN、PRIMARY_KEY        
postType = "",
// 使用PARAM获取修改后对象时， 参数的名称
postParamName = ""
        
)
````
