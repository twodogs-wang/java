# Chapter 1

## 1.1

## 1.2 some terminology

### simple:

Java is relative simple compare to c++. It has no header files, no pointer, structures, unions, operator overloading, virtual bases classes, and so on.

### object oriented:

The main difference between Java and c++ lies in multiple inheritance, which Java has replace with a simpler concept of interfaces.

### distributed:

### robust:

Java puts a lot of emphasis on early checking for possible problems, later dynamic(runtime) checking.  Java also has a pointer model that eliminates the possibility of overwriting memory and corrupting data.

### secure:

### architecture-neutral

### portable:

This is important. As in c++, the size of certain data type is platform dependent. But in Java, sizes are specified.

### interpreted:

Until Java 9 that the "jshell" tool supported program like python(interpreted).

### high-performance:

### multi-threaded:

### dynamic：

# Chapter 2: Java programming envirnment

## 2.1: JDK

## 2.2: cmd

## 2.3: IDE

## 2.4: Jsehll

Jshell runs like python, you can type one line in this shell and run it, then input the next line

# Chapter 3: fundamental staffs:

## 3.1 A simple java program:

```java
public class Firstsample
{
  public static void main(string[] args)
  {
    System.out.println("we will not use hello world")
  }
}
//java is case sensitive
//everything in java must live in a class
```

A java source file has up to one public class and the file's name must be the same as the public class' name(if it has).

### C++ Notes:

In java, all funcitons are methods of classes, even main function. This is why we use a shell class to cover it as above. In addition, main method is always static in Java. 

However, in Java, the main method does not return an "exit code" to the OS like C++. The prorgam has the exit code 0. Use "System.exit" to terminate the program if you want to exit it with a different exit code.

Comments is the same as C++, // and /* */

## 3.3 Data types:

#### Integer:

##### Java Integer types:

| Type  | Storage | Range(inclusive)          |
| ----- | ------- | ------------------------- |
| int   | 4 bytes | -2147483648 to 2147483647 |
| short | 2 bytes | -32768 to 32767           |
| long  | 8 bytes | ---                       |
| byte  | 1 byte  | ---                       |

Java has no unsigned version of integer.

#### floating point types:

| Type   | Storage requirement | range |
| ------ | ------------------- | ----- |
| float  | 4 bytes             | ---   |
| double | 8 bytes             | ---   |

Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY and Double.NaN are three constants. But they can not be used directly. Use Double.isNaN instead.

In addition, financial calculations are not suitable to use these because of random. Use BigDecimal class instead.

#### char type:

#### boolean:

In Java, int numbers can not be converted to boolean values.

#### Variables and constants:

In Java, "final" is used for constants. In addition, const is also a reversed word but it used for nothing.

#### Enumerated:

```
enum Size{small,medium,large,extra_large};
Size s = Size.medium;
```

#### Operators:

#### Math functions and constants:

System.out.println() operats on System.out object but Math.sqrt() operates on no objects. Such a method is called static method.

![figure1](https://github.com/twodogs-wang/java/blob/master/core_java_volume_I/figures/figure1.jpg)

In this picture: 

Three dotted arrows denote conversions that may lose precision.

operation:

if: double + x = double

elif: float + x = float

elif: long + x = long

else: all int 

Casts:

```java
double x = 9.997;
int nx = (int) x;
//now nx = 9
int super_duper = (int) Math.round(x);
//now super_duper is 10, (int) is used since the return type of //Math.round is long
```

#### Boolean operation:

```java
//condition?expression1:expression2
  x < y? x:y
//gives the smaller of x and y
```

#### Bitwise operations:

Bitwise can only operates on integer:

![image-20200428165314783](https://github.com/twodogs-wang/java/blob/master/core_java_volume_I/figures/figure2.png)

![image-20200428165329089](https://github.com/twodogs-wang/java/blob/master/core_java_volume_I/figures/figure3.png)

second picture gives a 1 if the fourth bit from the right in the binary repressentation of n is 1, and 0 otherwise.

#### Strings:

##### Substrings:

```java
String greeting = "hello";
String s = greeting.substring(0,3);
//now s is "hel"
```

##### Concatenation:

```java
//+ is supported
System.out.println("hello"+" world");
```

![image-20200428170028785](https://github.com/twodogs-wang/java/blob/master/core_java_volume_I/figures/figure4.png)

```java
String re = "fuck".repeat(3);
//re is "fuckfuckfuck"
```

##### Strings are immutable:

Just like python

##### Testing if equals or null or empty:

Do not use "==", use str.equals(s) instead. In addition, str.compareTo(s) can be used as well and it returns 0 if str equals s.

```java
String str = "hello";
if (str.length()==0)
{
  //check if empty
}
if (str==null)
{
  //check if null
}
if(str!=null && str.length()!=0)
{
  //neither null nor empty
  //test null first!!!!!
}
```

##### The String api:

##### Building Strings:

```java
StringBuilder builder = new StringBuilder();
builder.append(ch); //append a single character
builder.append(str); //append a string
Sting my_string = builder.toString();
//In java, strings are almost constants. The "price" will be super expensive if we use 
//a lot string+="xxxx". Therefore StringBuilder is a better choice.
```

#### Input and output:

##### Reading Input:

```java
import java.util.*; //Scanner class is defined in this package
Scanner in = new Scanner(System.in);
System.out.print("Hi SpongeBob\n");
String name = in.nextLine(); //nextInt for single word
```

Scanner can not be used for reading password since it is invisible. Console was introduced since Java 6 and it was designed specifically for this purpose.

```java
Console cons = System.console();
String username = cons.readLine("User name: ");
char[] passwd = cons.readPassword("Password: ");
//the reason we use char rather than string here: string is a constant, which means it //may not be safe under certain conditions. Since it would be stored in heap over a //period of time if we use String to store it. But if we use char[], we can destory it //immediately after we hashed it.
```

##### Formatting output:

```java
System.out.printf("%.2f",10000.0/3.0);
```

#### File input and output:

```java
Scanner in = new Scanner(Path.of("myfile.txt"),StandardCharsets.UTF_8);//read file
//write path like this: "c:\\xxxx\\xxx.txt"
PrintWriter out = new PrintWriter("myfile.txt",standardCharsets.UTF_8);
```

#### Control flow:

loops & if else staffs

##### Swicth:

```java
switch(choice)
{
    case 1:
        //
        break;
    case 2:
        //
        break;
    default:
        //
        break;
}
// a case label can be char,byte,short or int
```

#### Big numbers:

```java
BigInteger a = BigInteger.valueOf(100);
BigInteger c = a.add(b);// c = a + b
//Java has no operator overloading
```

#### Arrays:

```java
int[] a = new int[100]; //or var a = new int[100];
//or:
int[] a;
```

##### for each loop:

```java
//for (var:collection) statement
for (int elem:arr)
    System.out.println(elem);
```

##### Array copy:

```java
int[] second = Arrays.copyOf(first, 2*first.length);
//length is the length of new array, this is commonly used for increase the size of array
```

##### Command line parameters:

```java
//"java Message -g cruel world"
args[0] = "-g"
args[1] = "cruel"
args[2] = "world"
//in java, the name of the program is not stored in args[]
```

##### Array sorting:

```java
int[] a = new int[1000];
Arrays.sort(a);
```

# Chapter 4: Objects and Classes

## 4.1 Introduction to OOP:

Java has null reference.

## 4.2 Using predefined class

All Java objects live on the heap. When an object contains another object variable, it contains just a pointer.

## 4.3 Defining your own class

```java
Employee[] staff = new Employee[3];
staff[0] = new Employee("xxxx");
staff[1] = new Employee("xxxx");
staff[2] = new Employee("xxxx");
//objects array
```

```java
//In java, only one public class is allowed in each file and its name must be same as the file's name.
```

Keyword "public":

public means that any method in any class can call the method.

Private means that the only methods that can access these fields are the methods of the class itself.

### Constructor:

A constructor can only be called in conjunction with the new operator.

A class can have more than one constructor.

```java
class Employee //classic example LOL
{
  private String name;
  private double salary;
  private LocalDate hireDay;
  
  public Employee(String n, double e, int year, int month, int day) // constructor
  {
    name = n;
    salary = s;
    hireDay = LocalDate.of(year, month ,day);
    double salary = s; //wrong, do not use local variable same name as fields
    var harry = new Employee(xxxxxxxxx);//new feature in java 10
  }
}
```

### Null reference:

```java
//in java9 this was introduced:
name = Objects.requireNonNullElse(n, "unknown");
//this would gurantee that name will never be null
```

### Implicit and Explicit parameters:

```java
public void func(double percent)
{
	double raise = this.salary * percent/100;
	this.salary += raise;
}
// "this" refers to the implict parameter
//percent is the Explicit parameter
```

### **Hints on Encapsulation:**

```java
Class Employee
{
 private Date hireDay;
 public String getdate()
 {
   return hireDay;//bad
   return (Date) hireDay.clone();//ok
 }
}
```

###  Private methods:

some helper functions could be private.

### Final Instance fields:

Means these fields can not be modified again.

## 4.4 Static fields and Methods:

### 4.4.1 Static fields:

The fields that shared by all objects. It belongs to the class but does not belong to any objects.

### 4.4.3 Static Methods:

Methods that do not operate on objects. They can access to static fields but not object fields.

Notice: It is legal to call a static method by an object. But we do not recommand this since it is confusing.

### 4.4.4 Factory Methods:

### 4.4.5: The main methods:

Each class can have a main method and this can be used to do unit test.

## 4.5 Method parameters:

There are two kinds of parameters:

Primitive types : numbers, bool...

Object references

Java is always call by value.

```java
public static void swap(Employee x, Employee y)  //does not work
{
  Employee temp = x;
  x = y;
  y = temp;
}
//this demonstrates that Java is not call by reference. Object references are passed by value.
```

Summary:

![Xnip2020-05-05_19-00-43.jpg](https://github.com/twodogs-wang/java/blob/master/core_java_volume_I/figures/Xnip2020-05-05_19-00-43.jpg)

## 4.6 Object construction:

### 4.6.1 Overloading

### 4.6.2 Default Field Initialization:

Bool -> false

Numbers -> 0

Objects -> null

### 4.6.5 parameter names:

```java
//good way
public Employee(String name, double salary)
{
  this.name = name;
  this.salary = salary;
}
//In C++, it is common to prefix instance fields with an underscore or a fixed letter. (The letters m and x are common choices.) For example, the salary field might be called _salary, mSalary, or xSalary. Java programmers don’t usually do that.
```

### 4.6.6 Calling another constructor:

```java
public Employee(double s)
{
  //calls Employee(String, double)
  this("name",s)
    nextId++;
}
```

### 4.6.7 Initialization Blocks:

Means blocks of code that will be executed whenever an object is constructed.

```java
class Employee
{
  //fields
  
  
  
  //object initialization blocks
  {
    id = nextId;
    nextId ++;
  }
  
  //constructors
}
```

## 4.7 Packages:

### 4.7.3 Static imports:

```java
import static java.lang.System.*;
//with above line of code, this line will work:
out.println("bye");
```

## 4.8 JAR files:

This is designed to package many java files into one file.

```java
jar cvf jarFileName file1 file2.......
```

You can use the e option of the jar command to specify the entry of the entire program.

# Chapter 5: Inheritance

## 5.1 Classes, Superclasses and Subclasses

```java
public class Manager extends Employee
{
  //added methods and fields
}
```

All inheritance in java is public inheritance.

### 5.1.2 Overriding Methods:

```java
//example of get salary
public double getSalary()
{
  double base = super.getSalary();
  return bonus + base;
}
```

Inheritance can never take away any fields or methods.

### 5.1.3 Subclass Constructors:

```java
public Manager(String name, double Salary, int year, int month, int day)
{
  super(name, salary, year, month, day); //parents constructor, must come first
  bonus = 0;
}
```

In java, dynamic binding is default behavior.

### 5.1.4 Inheritance Hierarchies:

### 5.1.5 Polymorphism:

### 5.1.6 Understanding Method Calls:

1. complier looks at method name and declared type.

2. check arguments to find the best match, called overloading resolution

3. if "private", "static", "final" then static binding else dynamic binding.

4. when dynamic binding, the virtual machine calls the right version

   

### 5.1.7 Preventing Inheritance: Final Classes and Methods:

```java
public final class Executive extends Manager
{
  //.....
  public final String getName()
  {
    return "I am SpongeBob";
  }
}
//"final" here prevents this class from being inheritance
//The method getName() here can not be override.
```

### 5.1.8 Casting:

```java
Manager BOSS = (Manager) staff[0];
//There is only one reason why you would want to make a cast—to use an object in its full capacity after its actual type has been temporarily forgotten
```

```java
x instanceof C;
//does not generate an exception if x is null. It simply returns false. That makes sense: null refers to no object, so it certainly doesn’t refer to an object of type C.
```

### 5.1.9 Abstract Classes:

Just like pure virtual class in C++.

```java
public abstract String getDescription();
{
  //no code needed
}

public abstract class Person()
{
  //...
  private String name;
  public String(String name)
  {
    this.name = name;
  }
  public abstract String getDescription();
  public String getName()
  {
    return Name;
  }
}
```

### 5.1.10 Proetceted access

As already mentioned, protected features in Java are accessible to all subclasses as well as to all other classes in the same package. This is slightly different from the C++ meaning of protected, and it makes the notion of protected in Java even less safe than in C++.

![Xnip2020-05-07_15-07-27.jpg](https://github.com/twodogs-wang/java/blob/master/core_java_volume_I/figures/Xnip2020-05-07_15-07-27.jpg)

## 5.2 Object: The Cosmic Superclass

Every class in Java extends Object.

### 5.2.1 varibales of type object:

```java
Object obj = new Employee("SpongeBob", 35000);
```

### 5.2.2 The equals method:

### 5.2.3 Equality Testing and Inheritance:

```java
if (!(otherobject instanceof Employee ) )
{
  return false;
}
```

### 5.2.4 The hashcode Method:

### 5.2.5 The toString Method:

## 5.3 Generic Array Lists:

In Java, we can set the size of an array at runtime.

A java class called ArrayList, it automatically adjusts its capacity without any additional code.

```java
ArrayList<Employee> staff = new ArrayList<Employee>();
ArrayList<Employee> staff = new ArrayList<>(); //called "diamond" syntax
//Both are ok
```

Methods:

```java
staff.add(new Employee("SpongeBob", 35000));
staff.ensureCapacity(100); //allocate 100 places.
```

```java
new ArrayList<>(100);
new Employee[100];
//these two are different, second one allocate 100 slots ready for use.
//But the first one, has the potential of holding 100 elememys, but the begining holds nothing.
```

Accessing:

```java
staff.set(i,harry); //since it has not operator overloading
Employee e = staff.get(i);
staff.size();
//call by reference, in C++, vector call by number
```

Notice:

The complier translates all typed array into raw ArrayList objects after checking the type rules were not violated. So even we use cast to transfrom the type, the situations are still the same and generates the same warnings. Use below code if we guarantee  actions are safe:

```java
@SuppressWarnings("unchecked") xxxxxxxxx;
```

## 5.4 Object Wrappers and AutoBoxing