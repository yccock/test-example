迭代器模式(Iterator Pattern)：
提供一种方法来访问聚合对象，而不用暴露这个对象的内部表示，其别名为游标(Cursor)

迭代器模式的结构
    抽象容器：一般是一个接口，提供一个iterator()方法，例如java中的Collection接口，List接口，Set接口等。
    具体容器：就是抽象容器的具体实现类，比如List接口的有序列表实现ArrayList，List接口的链表实现LinkList，Set接口的哈希列表的实现HashSet等。
    抽象迭代器：定义遍历元素所需要的方法，一般来说会有这么三个方法：取得第一个元素的方法first()，取得下一个元素的方法next()，判断是否遍历结束的方法isDone()（或者叫hasNext()），移出当前对象的方法remove(),
    迭代器实现：实现迭代器接口中定义的方法，完成集合的迭代。
