责任链模式，顾名思义，就是一条链。这个链到底是怎么运行的呢？它主要是将能够处理同一类请求的对象连成一条链，所提交的请求沿着链传递，
链上的对象逐个判断是否有能力处理该请求，如果能则处理，如果不能则传递给链上的下一个对象进行处理，以此类推。

比如说公司请假需要审批，举个不恰当的例子，如果请假小于3天，主管审批；3-10天的，经理审批；10-30天的，总经理审批；超过30天的，
不批准等等。这就得一步步去判断，如果撇开设计模式不看的话，那么我们可以使用if…else…把它解决了，但是问题可想而知，实际中的复杂程度
时远远超过这个例子的

角色
抽象处理者角色(Handler)：定义出一个处理请求的接口。如果需要，接口可以定义 出一个方法以设定和返回对下家的引用。这个角色通常由一个Java抽象类或者Java接口实现。
具体处理者角色(ConcreteHandler)：具体处理者接到请求后，可以选择将请求处理掉，或者将请求传给下家。由于具体处理者持有对下家的引用，因此，如果需要，具体处理者可以访问下家。

责任链模式的优缺点
责任链模式与if…else…相比，他的耦合性要低一些，因为它把条件判定都分散到了各个处理类中，并且这些处理类的优先处理顺序可以随意设定。
责任链模式也有缺点，这与if…else…语句的缺点是一样的，那就是在找到正确的处理类之前，所有的判定条件都要被执行一遍，当责任链比较长时，性能问题比较严重。

责任链模式的适用场景
就像开始的例子那样，假如使用if…else…语句来组织一个责任链时感到力不从心，代码看上去很糟糕时，就可以使用责任链模式来进行重构。

https://blog.csdn.net/eson_15/article/details/52126811