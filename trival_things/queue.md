# Queue:

用法:

```java
Queue<String> queue = new LinkedList<String>();
```

链表实现了queue接口，所以可以当作queue来用:

方法以及区别:

## offer 和 add的区别:

offer和add都是在队尾添加元素，一些队列有元素数量限制。offer返回的是布尔值，如果添加失败为false，但是add会抛出异常。

## poll和remove区别：

和上面的类似，在空队列使用poll的时候不会抛出异常，只是返回null

## peek 和 element的区别：

都是查看队首位元素，空队列的时候，peek返回null而element会抛出异常。

## 注意(多线程)：

LinkedList线程不安全，解决方案为换成ConcurrentLinkedQueue即可。