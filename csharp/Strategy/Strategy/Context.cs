using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Strategy
{
    class Context
    {
        Action act = null;

        public Context(Action action)
        {
            this.act = action;
        }

        public string action()
        {
            return this.act.doAction();
        }

       
    }
}
