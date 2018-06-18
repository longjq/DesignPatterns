<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2018-6-18
 * Time: 22:28
 */

namespace Behavioral\Strategy;


class Context
{
    private $strategy = null;

    public function __construct(Action $action)
    {
        $this->strategy = $action;
    }

    public function doNow()
    {
        return $this->strategy->doAction();
    }
}