<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2018-6-18
 * Time: 22:29
 */

namespace Behavioral\Strategy;

spl_autoload_register(function ($name){
    include dirname(__FILE__) . '\\' . explode('\\', $name)[2] . '.php';
});

$strategy = new Context(new AddAction());
print_r($strategy->doNow());

$strategy = new Context(new MulAction());
print_r($strategy->doNow());