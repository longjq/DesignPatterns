package main

import (
	"sync"
	"fmt"
)

var once sync.Once
type Tool struct{
	name string
}
var instance *Tool

func GetInstance() *Tool{
	fmt.Println(&instance)
	once.Do(func(){
		instance = &Tool{
			name:"helo",
		}
	})
	return instance
}

func main(){
	s := GetInstance()
	fmt.Println(s)
	s1 := GetInstance()
	fmt.Println(s1)

}