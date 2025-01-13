
public class SysComSsmFieSnd {
	public static void main(String[] args) {
		StoreSender storeSender = new StoreSender("store.setting");
		storeSender.start();
	}
}
