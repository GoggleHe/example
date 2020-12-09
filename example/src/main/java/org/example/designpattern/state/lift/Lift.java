package org.example.designpattern.state.lift;

/**
 *
 **/
public class Lift implements ILift{

    public static final int OPEN = 0;
    public static final int CLOSE = 1;
    public static final int RUN = 2;
    public static final int STOP = 3;

    private int state = STOP;

    @Override
    public void open() {
        switch (state) {
            case OPEN:
                System.out.println("电梯已开启");
                break;
            case CLOSE:
            case STOP:
                System.out.println("正在开门");
                state = OPEN;
                break;
            case RUN:
                System.out.println("电梯运行中,不能开门");
                break;
            default:
                break;
        }
    }

    @Override
    public void close() {
        switch (state) {
            case OPEN:
                System.out.println("正在关门");
                state = CLOSE;
                break;
            case CLOSE:
                System.out.println("电梯已关闭");
                break;
            case STOP:
                System.out.println("正在开门");
                state = CLOSE;
                break;
            case RUN:
                System.out.println("电梯运行中,不能关门");
                break;
            default:
                break;
        }
    }

    @Override
    public void run() {
        switch (state) {
            case OPEN:
                System.out.println("开门时电梯不能运行");
                break;
            case CLOSE:
                System.out.println("运行中");
                break;
            case STOP:
                System.out.println("正在停止");
                state = STOP;
                break;
            case RUN:
                System.out.println("电梯运行中");
                break;
            default:
                break;
        }
    }

    @Override
    public void stop() {
        switch (state) {
            case OPEN:
                System.out.println("电梯已开门,不能停止");
                break;
            case CLOSE:
                System.out.println("电梯已关门,不能停止");
                break;
            case STOP:
                System.out.println("正在停止");
                state = STOP;
                break;
            case RUN:
                System.out.println("电梯运行中");
                break;
            default:
                break;
        }
    }
}
