var User = /** @class */ (function () {
    function User(name, subject) {
        this.name = name;
        this.subject = subject;
        this.subject.register(this);
    }
    User.prototype.sendMsg = function (msg) {
        console.log(this.name + " \u53D1\u9001 " + msg);
        this.subject.sendMsg(this, msg);
    };
    User.prototype.receiveMsg = function (sender, msg) {
        console.log(this.name + "\u6536\u5230\u4E86" + sender.name + "\u7684\u6D88\u606F:" + msg);
    };
    return User;
}());
var Group = /** @class */ (function () {
    function Group() {
        this.userList = [];
    }
    Group.prototype.register = function (observer) {
        this.userList.push(observer);
    };
    Group.prototype.unregiser = function (observer) {
        var index = this.userList.indexOf(observer);
        if (index > -1) {
            this.userList.splice(index, 1);
        }
    };
    Group.prototype.sendMsg = function (sender, msg) {
        console.log("\u7FA4\u6536\u5230\u4E86" + sender.name + "\u53D1\u6D88\u606F\uFF1A" + msg + "\u7ED9\u6240\u6709\u4EBA");
        this.notify(sender, msg);
    };
    Group.prototype.notify = function (sender, msg) {
        this.userList.forEach(function (user) { return user.receiveMsg(sender, msg); });
    };
    return Group;
}());
var group = new Group();
var jim = new User('jim', group);
var brook = new User('brook', group);
var lucy = new User('lucy', group);
jim.sendMsg('hello');
lucy.sendMsg('well done!');
