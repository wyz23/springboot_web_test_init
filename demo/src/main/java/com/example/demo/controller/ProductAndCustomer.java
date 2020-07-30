package test;

class Info {
	private String title;
	private String content;
	private  boolean flag = true;
	//flag = true, 表示可以生产，但是不可以取走
	//flag = false, 表示可以取走， 但是不可以生产
	public synchronized void set(String title, String content) {
		//重复进入到了set()方法里面， 发现不能够生产，所以要等待
		if (this.flag == false) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.title = title;
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.content = content;
		this.flag = false; //修改生产标记
		super.notify(); //唤醒其他等待线程
		super.notifyAll();
	}

	public synchronized void get() {
		if (this.flag = true) {	//还没生产呢
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.title + " - " + this.content);
		this.flag = true;
		super.notify(); //唤醒其他的等待
		super.notifyAll();
	}
}

class Productor implements Runnable {
	private Info info;

	public Productor(Info info) {
		this.info = info;
	}

	@Override
	public void run() {
		for (int x = 0; x < 100; x++) {
			if (x % 2 == 0) {
				this.info.set("真人", "一个好人");
			} else {
				this.info.set("动物", "不是好狗");
			}
		}
	}
}

class Customer implements Runnable {
	private Info info;
	public Customer(Info info) {
		this.info = info;
	}
	@Override
	public void run() {
		for (int x = 0; x < 100; x++) {
			this.info.get();
		}
	}
}

public class ProductAndCustomer {
	public static void main(String[] args) {
		Info info = new Info();
		new Thread(new Productor(info)).start();
		new Thread(new Customer(info)).start();
	}
}
