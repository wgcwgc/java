public class Test{
	public static void main(String[] args){
		Shape c1 = new Circle(10.0);
		Shape c2 = new Rectangle(2.0 , 2.0);
		Shape c3 = new Triangle(3.0 , 4.0 , 5.0);
		System.out.println(c1.toString() + c2.toString() + c3.toString());
	}
}
abstract class  Shape{
	private String color = "white";
	public Shape(){}
	public String getColor(){
		return color;
	}
	public void setColor(String color){
		this.color = color;
	}
	public abstract double area();
	public abstract double perimeter();
	public abstract String toString();
}
class Circle extends Shape{
	private double radius;
	public Circle(){
		super();
	}
	public Circle(double radius){
		super();
		this.radius = radius;
	}
	public double getRadius(){
		return radius;
	}
	public void setRadius(double radius){
		this.radius = radius;
	}
	public double area(){
		return radius * radius * Math.PI;
	}
	public double perimeter(){
		return 2 * radius * Math.PI;
	}		
	public String toString(){
		return "圆形的面积为：" + area() + "  ,  周长为：" + perimeter() + "\n";
	}
}
class Rectangle extends Shape{
	private double width;
	private double height;
	public Rectangle(){}
	public Rectangle(double width, double height){
		this.width = width;
		this.height = height;
	}
	public double getWidth(){
		return width;
	}
	public void setWidth(double width){
		this.width = width;
	}
	public double getHeight(){
		return height;
	}
	public void setHeight(double height){
		this.height = height;
	}
	public double area(){
		System.out.println();
		return width * height;
	}
	public double perimeter(){
		return 2 * (width + height);
	}
	public String toString(){
		return "矩形的面积为：" + area() + "  ,  周长为：" + perimeter() + "\n";
	}
}
class Triangle extends Shape{
	double bian1,bian2,bian3;
	public Triangle(){}
	public Triangle(double bian1, double bian2,double bian3){
		this.bian1 = bian1;
		this.bian2 = bian2;
		this.bian3 = bian3;
	}
	public double area(){
		double s = (bian1 + bian2 + bian3) / 2.0;
		return Math.sqrt( s * (s - bian1) * (s - bian2) * (s - bian3) );
	}
	public double perimeter(){
		return bian1 + bian2 + bian3;
	}
	public String toString(){
		return "三角形的面积为：" + area() + "  ,  周长为：" + perimeter() + "\n";
	}
}