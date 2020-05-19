package main

import (
	"fmt"
)

type (
	Event struct{
		Data int64
	}
	Observer interface{
		OnNotify(*Event)
	}
	Notifier interface{
		Register(Observer)

		Degister(Observer)

		Notify(*Event)
	}
)



type Subject struct{
	observers []Observer
}

func (self *Subject) Notify(event *Event){
	for _, v := range self.observers{
		v.OnNotify(event)
	}
}

func (self *Subject) Register(o Observer){
	self.observers = append(self.observers, o)
}

func (self *Subject) Degister(o Observer){
	for i:=0;i<len(self.observers);i++{
		if self.observers[i] == o {
			self.observers = append(self.observers[:i], self.observers[i+1:]...)
			break
		}
	}
}

func NewSubject() *Subject{
	sub := &Subject{
		observers: make([]Observer,0),
	}

	return sub
}

type Obs struct{
	name string
}

func (self *Obs) OnNotify(event *Event){
	fmt.Println("Obs Notify",self,event)
}



func main(){
	// 主题
	sub := NewSubject()

	// 观察者
	ob1 := &Obs{name:"a"}
	ob2 := &Obs{name:"b"}

	// 注册
	sub.Register(ob1)
	sub.Register(ob2)

	evt := &Event{Data:1000}

	// 通知
	sub.Notify(evt)

	sub.Degister(ob1)

	sub.Notify(evt)
}