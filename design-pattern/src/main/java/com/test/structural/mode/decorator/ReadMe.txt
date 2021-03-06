装饰模式是一种用于替代继承的技术，它通过一种无须定义子类的方式来给对象动态增加职
责，使用对象之间的关联关系取代类之间的继承关系。在装饰模式中引入了装饰类，在装饰
类中既可以调用待装饰的原有类的方法，还可以增加新的方法，以扩充原有类的功能。

实现细节：
    – Component抽象构件角色：
        • 真实对象和装饰对象有相同的接口。这样，客户端对象就能够以与真实对象相同的方式同装饰对象交互。
    – ConcreteComponent 具体构件角色(真实对象)：
    – Decorator装饰角色：
        • 持有一个抽象构件的引用。装饰对象接受所有客户端的请求，并把这些请求转发给真实的对象
          这样，就能在真实对象调用前后增加新的功能。
    – ConcreteDecorator具体装饰角色：
        • 负责给构件对象增加新的责任。
        
何时使用：
    1）需要扩展一个类的功能，或给一个类增加附加责任。
    2）需要动态的给一个对象增加功能，这些功能可以再动态地撤销。
    3）需要增加一些基本功能的排列组合而产生的非常大量的功能，从而使继承变得    不现实。