<?php

class Singleton
{

    private function __construct(){}

    // 使用静态变量来保存唯一的单例实例
    private static $instance;

    public static function getInstance(){
        if (null == self::$instance) {
            self::$instance = new static;
        }

        return self::$instance;
    }
}

$s1 = Singleton::getInstance();
var_dump($s1);    
$s2 = Singleton::getInstance();
var_dump($s2);    // s1 和 s2 获取的对象实例都是同一个
