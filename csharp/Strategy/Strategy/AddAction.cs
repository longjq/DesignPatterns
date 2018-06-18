using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Strategy
{
    class AddAction : Action
    {
        string Action.doAction()
        {
            return "Add Action";
        }
    }
}
