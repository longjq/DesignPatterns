class Subject:
    observers = []
    def attach(self, observer):
        self.observers.append(observer)

    def detach(self, observer):
        self.observers.remove(observer)

    def notify(self):
        for ob in self.observers:
            ob.update(self)

class Observer:
    def __init__(self, name):
        self.name = name
    def update(self, subject):
        print(self.name,"----update --->",subject)

# 主题
sub = Subject()

# 订阅者
ob1 = Observer("helo1")
sub.attach(ob1)
ob2 = Observer("helo2")
sub.attach(ob2)

# 通知定义者
sub.notify()
