package rtti;

public class Toy extends AbstractToy {

	private String name;

	public String color;

	protected int size;

	public static final int price = 10;

	static {
		System.out.println("Loading");
	}

	public Toy() {// 构造方法一定要声明为public类型，不然用getConstructors无法得到
		System.out.println("Initialing");
		setName("myToy");
		color = "red";
		size = 5;
	}

	public Toy(String name, String color, int size) {
		this.setName(name);
		this.color = color;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String playToy(String player) throws Exception {
		String msg = buildMsg(player);
		System.out.println(msg);
		return msg;
	}

	private String buildMsg(String player) {
		String msg = player + " plays " + name;
		return msg;
	}
}
