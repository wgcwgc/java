package lamp.TEST.Homework;

/**
 * ��ϵ��
 */
public class Contact {
	private String name;
	private String phoneNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Contact(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public Contact() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}
	

}
