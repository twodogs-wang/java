# List vs ArrayList:

List类继承了IList接口，ArrayList是一个类，List不可以被构造。

使用List的原因是它是某种意义上的泛型：

```java
List list = new ArrayList<Integer>;
```

List包含了不止ArrayList，也有vector和LinkedList等，这样如果以后改了类，其余的地方代码不需要改动，因为都是用的List的方法。

同时，List还解决了ArrayList的类型不安全问题，免去了装箱操作。因为ArrayList都是把数据作为object处理，也就是说不是类型安全的。List就避免了这个问题。