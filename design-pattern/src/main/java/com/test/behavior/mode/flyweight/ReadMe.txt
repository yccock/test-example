享元模式(Flyweight	Pattern)：运用共享技术有效地支持大量细粒度对象的复用。系统只使
用少量的对象，而这些对象都很相似，状态变化很小，可以实现对象的多次复用。由于
享元模式要求能够共享的对象必须是细粒度对象，因此它又称为轻量级模式，它是一种
对象结构型模式。


享元模式的主要优点如下：
(1)	可以极大减少内存中对象的数量，使得相同或相似对象在内存中只保存一份，从而可以节
    约系统资源，提高系统性能。
(2)	享元模式的外部状态相对独立，而且不会影响其内部状态，从而使得享元对象可以在不同
    的环境中被共享。

适用场景
在以下情况下可以考虑使用享元模式：
(1)	一个系统有大量相同或者相似的对象，造成内存的大量耗费。
(2)	对象的大部分状态都可以外部化，可以将这些外部状态传入对象中。
(3)	在使用享元模式时需要维护一个存储享元对象的享元池，而这需要耗费一定的系统资源，
因此，应当在需要多次重复使用享元对象时才值得使用享元模式。
