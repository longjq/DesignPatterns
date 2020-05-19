interface Observer{
    name: string
    sendMsg(msg:string)
    receiveMsg(sender:Observer, msg:string)
}

interface Subject{
    register(observer: Observer)
    unregiser(observer: Observer)
    sendMsg(sender: Observer, msg: string)
}


class User implements Observer{
    constructor(public name:string,private subject:Subject){
        this.subject.register(this)
    }

    sendMsg(msg: string){
        console.log(`${this.name} 发送 ${msg}`);
        this.subject.sendMsg(this, msg)
    }

    receiveMsg(sender: Observer, msg: string){
        console.log(`${this.name}收到了${sender.name}的消息:${msg}`)
    }
}

class Group implements Subject{
    private userList: Array<Observer> = [];

    register(observer: Observer){
        this.userList.push(observer)
    }

    unregiser(observer: Observer){
        var index = this.userList.indexOf(observer);
        if (index > -1) {
            this.userList.splice(index, 1);
        }
    }

    sendMsg(sender: Observer, msg:string){
        console.log(`群收到了${sender.name}发消息：${msg}给所有人`)
        this.notify(sender, msg)
    }

    private notify(sender: Observer, msg: string){
        this.userList.forEach(user=>user.receiveMsg(sender,msg))
    }
}

// group是subject主题
let group = new Group();
// user是观察者
let jim = new User('jim', group);
let brook = new User('brook', group);
let lucy = new User('lucy', group);

// 观察者发送一个消息出去
jim.sendMsg('hello');
lucy.sendMsg('well done!');