package Singleton

import (
	"sync"
)

var once sync.Once
type Tool struct{}
var instance *Tool

func GetInstance() *Tool{
	once.Do(func(){
		instance = new(Tool)
	})
	return instance
}