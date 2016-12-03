##synchronized和volatile比较
* a. volatile不需要同步操作，所以效率更高，不会阻塞线程，但是适用情况比较窄
* b. volatile读变量相当于加锁（即进入synchronized代码块），而写变量相当于解锁（退出synchronized代码块）
* c. synchronized既能保证共享变量可见性，也可以保证锁内操作的原子性；volatile只能保证可见性

synchronized	Reentrantlock	AtomicInteger

##Java多线程共享变量控制(强烈推荐必读)
http://www.cnblogs.com/soaringEveryday/p/4418604.html

##产生死锁的四个必要条件：
* 1) 互斥条件：一个资源一次只能被一个进程访问。
* 2) 请求与保持： 一个进程因请求资源而阻塞时，对已获得的资源保持不放。
* 3) 不可剥夺：进程已获得的资源，在未使用完之前，不得强行剥夺。
* 4) 循环等待：若干进程之间形成一种头尾相接的循环等待资源关系。

##代理模式
>在软件设计中，使用代理模式的意图也很多，比如因为安全原因需要屏蔽客户端直接访问真实对象，或者在远程调用中需要使用代理类处理远程方法调用的技术细节 (如 RMI)，也可能为了提升系统性能，对真实对象进行封装，从而达到延迟加载的目的。

##Hibernate一级二级缓存
一级缓存为session级别的缓存,二级缓存是sessionFactory的缓存,支持第三方实现.ehCache,osCache

##Hibernate与Mybatis的区别

##Mybatis实现一对一关系
resultMap:
嵌套查询:

##Hibernate中java对象的几种状态
* 临时态(Transient)
* 持久态(Persistent)
* 游离态(Detached)

##java内存模型
工作内存 物理内存
堆栈 新生代 老生代 持久代
stop-and-copy
mark-and-sweep

##Spring MVC 对异步请求的处理
async-support开关
Callable
AsyncWebTask
DefferedResult 
##inner join、outer join(left join,right join,full join)、 cross join
* 1.INNER JOIN 产生的结果是AB的交集
* 2.LEFT [OUTER] JOIN 产生表A的完全集，而B表中匹配的则有值，没有匹配的则以null值取代。
* 3.RIGHT [OUTER] JOIN 产生表B的完全集，而A表中匹配的则有值，没有匹配的则以null值取代。
* 4.FULL [OUTER] JOIN 产生A和B的并集。对于没有匹配的记录，则会以null做为值。
* 5. CROSS JOIN 把表A和表B的数据进行一个N*M的组合，即笛卡尔积。

##java线程的四个状态
new runnable not runnable/blocked dead

##happens-before
>多两项操作偏序关系的描述,与执行时间实际没有多大关系.可以通过volatile synchronized等来保证happens-before原则.
>具有传递性if A happens-before B and B happens-before C then A happens-before C.

##集合与Map

###Collection 系列
* Collection：它是一个根接口，JDK没有它的实现类,内部仅仅做 add()，remove()，contains()，size() 等方法的声明。
* List：它继承于 Collection，增加了可以对每个元素插入的位置进行精确的控制的方法，另外，插入的值允许为空，也允许有重复的值。
>实现类		实现方式	是否同步	是否支持插入空值	元素是否支持重复
ArrayList	数组		不同步	支持			支持
Vector		数组		同步		支持			支持
LinkedList	链表		不同步	支持			支持

###Map
HashMap：最常用的 Map，非同步，不保证顺序。允许有空值和空键。 采用链表法解决哈希冲突，并且在发生哈希冲突的时候，新的 Node 会加入到链表的最下端；在 JDK8 中哈希冲突过多的情况下链表会变成红黑树从而保证效率；
LinkedHashMap：继承HashMap，Iterator下 能保证插入的先后顺序，原理是在LinkedHashMap中加入了链表，并且该链表还是一个双向链表。
ConcurrentHashMap：也是HashMap的线程安全版本，并且使用了分段加锁机制，所以效率上要比HashTable要好很多。
TreeMap：能够根据 key 值来有序插入 (也就是键值对会根据key排序好)，原理使用了红黑树，每次插入都会对树进行调整。
HashTable：HashMap的线程安全版本，内部的实现几乎和 HashMap 一模一样。但是由于其同步是使用了 synchronized，效率较低。

参考:https://segmentfault.com/a/1190000005948183

###红黑树
http://www.cnblogs.com/skywang12345/p/3624343.html

##单例模式
懒汉 饿汉

参考:
http://www.cnblogs.com/java-my-life/archive/2012/03/31/2425631.html