def Singleton(cls):
    # 使用一个字典保存类型，多次创建进行是否已有判断，有就直接返回了，没有的话，新创建
    _instance = {}
    def _singleton(*args, **kwargs):
        if cls not in _instance:
            _instance[cls] = cls(*args, **kwargs)
        return _instance[cls]
    return _singleton

# 装饰器模式创建单例
@Singleton
class A:
    a = 1

    def __init__(self, x = 0):
        self.x = x

a1 = A(2)
a2 = A(3)
a3 = A(2)

print(a1.x)
print(a2.x)
print(a3.x)
