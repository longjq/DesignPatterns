<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2018-6-18
 * Time: 22:27
 */

namespace Behavioral\Strategy;


class MulAction implements Action
{

    public function doAction()
    {
        return 'do Mul';
    }
}