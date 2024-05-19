package l.strong.opalstwentythree.design.code;

public class Principle {
    /**
    //构造函数传递依赖对象
    public interface IDriver {
        public void drive();
    }
    public interface ICar {
        public void run();
    }

    public class Driver implements IDriver {
        private ICar car;
        public Driver(ICar car) {
            this.car = car;
        }
        @Override
        public void drive() {
            this.car.run();
        }
    }
     **/
    /**
    public interface ICar {
        public void run();
    }
    //setter方法传递依赖对象
    public interface IDriver {
        // 接口or抽象类不应该依赖于实现类  所以接口只定义方法
        public void setCar(ICar car);
        public void drive();
    }

    public class Driver implements IDriver {
        //实现类应该依赖接口or抽象类 即细节应该依赖于抽象
        private ICar car;

        @Override
        public void setCar(ICar car) {
            this.car = car;
        }

        @Override
        public void drive() {
            this.car.run();
        }
    }
        **/
    public interface ICar {
        public void run();
    }
    //setter方法传递依赖对象
    public interface IDriver {
        // 接口or抽象类不应该依赖于实现类  所以接口只定义方法
        public void drive(ICar car);
    }

    public class Driver implements IDriver {

        @Override
        public void drive(ICar car) {
            car.run();
        }
    }

}
