class Singleton {
    private constructor() {}

    private static singleton: Singleton

    /**
     * 
     */
    public static getInstance(): Singleton {
        if (!Singleton.singleton) {
            Singleton.singleton = new Singleton()
        }
        return Singleton.singleton
    }
}

const singleton1 = Singleton.getInstance();
const singleton2 = Singleton.getInstance();

if (singleton1 === singleton2) {
    console.log("two singletons are equivalent");
} else {
    console.log("two singletons are not equivalent");
}