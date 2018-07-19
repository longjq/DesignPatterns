
class foo:
    def f1(self):
        print('foo->f1')

    def f2(self):
        print('foo->f2')

class foo_decorator:
    def __init__(self, deco):
        self._deco = deco
    
    # 对外提供的方法，内部其实执行的是被装饰类的方法
    def f1(self):
        # 此处可以执行装饰函数，下面再去执行被装饰的函数
        print('--run f1--')
        self._deco.f1() # 被装饰的函数

    # 魔术方法，当发现没有被装饰的函数时，直接调用被装饰类的方法
    def __getattr__(self, name):
        return getattr(self._deco, name)

u = foo() # 构建一个实例
v = foo_decorator(u) # 将实例传入装饰类中
v.f1() # 调用装饰类的方法f1
v.f2() # 调用装饰类的方法f2