<?php
class User implements \SplSubject
{
    public $data = [];

    protected $observers;

    public function __construct(){
        $this->observers = new \SplObjectStorage();
    }

    // 附加观察者
    public function attach(\SplObserver $observer){
        $this->observers->attach($observer);
    }

    // 移除观察者
    public function detach(\SplObserver $observer){
        $this->observers->detach($observer);
    }

    // 通知观察者
    public function notify(){
        foreach ($this->observers as $observer) {
            $observer->update($this);
        }
    }

    public function __set($name, $value){
        $this->data[$name] = $value;

        $this->notify();
    }
}


// 观察者对象
class UserObserver implements \SplObserver
{
    public function update(\SplSubject $subject){
        var_dump($subject->data);
        echo get_class($subject) . "has been updated\n";
    }
}

// 创建观察者
$ob1 = new UserObserver();
$ob2 = new UserObserver();

// 创建主题
$subject = new User();
// 主题上挂载观察者
$subject->attach($ob1);
$subject->attach($ob2);

// 触发主题变更事件，导致通知到观察者
$subject->name = 100;