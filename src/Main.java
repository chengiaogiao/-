//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        int num=runtime.availableProcessors();
        System.out.println(num);

        Cat cat = new Cat();
        Cat1 cat1 = new Cat1();

        Thread thread = new Thread(cat1);
        cat.start();
        thread.start();
        for (int i = 0; i < 4; i++) {
            Thread.sleep(100);
            cat.stop();
            cat.interrupt();
//            cat.setPriority();
//             cat.setDaemon();
        }
    }
}

class Cat extends Thread{

    int num=0;
    @Override
    public void run() {
//        super.run();
        while (true){
            num++;
            if(num>=10){
                break;
            }
            System.out.println("猫咪"+num+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Cat1 implements Runnable{
    int num=0;
    @Override
    public void run() {
//        super.run();
        while (true){
            num++;
            if(num>=10){
                break;
            }
            System.out.println("猫咪"+num+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}