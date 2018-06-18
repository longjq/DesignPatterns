using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Strategy
{
    class MulAction :Action
    {
        string Action.doAction()
        {
            return "Mul Action";
        }
    }
}
