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

Wrapper classes have obvious name: Integer, Long, Float, Double, Short, Byte, Character, and 

Boolean.

First six inherit from the common superclass "Number". The wrapper classes are immutable, they are also "final".

An example:

```java
var list = ArrayList<Integer>();
```

The autoboxing specification requires that boolean, byte, char <= 127, short, and int between -128 and 127 are wrapped into fixed objects

## 5.5 Methods with variable Numbers of Parameters:

```java
public class PrintStream
{
  public PrintStream printf(String fmt, Object... args)
  {
    return format(fmt,args);
  }
}
```

Here, the "..." is part of java code. The printf receives two parameters: format string and objects[] holds all other parameters.

An Example of computing largest number:

```java
public static double max_max(double... values)
{
  double largest = Double.NEGATIVE_INFINITY;
  for(double v:values) if (v>largest) largest = v;
  return largest;
}
```

call it like this:

```java
double m = max_max(3.1, 40.4, -5);
```

## 5.6 Enumeration Classes:

```java
public enum Size(S, M, L, XL, XXL);
```

The constructor of an enumeration is always private.

All enumerated types are subclasses of the class Enum. They inherit a number of methods 

from that class:

toString(), valueOf();

```java
Size s = Enum.valueOf(size.class, "SMALL");
Size[] values = Size.values(); //returns and array of all values of the enumeration
```

## 5.7 Reflection：

This library is able to manipulate java code dynamically.

A program that can analyze the capabilities of classes is called reflective. We can use it to:

1. Analyze the capabilities of classes at runtime.
2. Inspect objects at run time.
3. Implement generic array manipulation code.
4. Take advantage of Method objects that work just like function mounters in C++

This is a tool and useless for programming applications. So maybe later to continue this chapter.

# Chapter 6: Interfaces, lambda, Inner classes:

## 6.1 Interfaces:

All methods of an interface are automatically public. 

Interfaces never have instance fields but constants are allowed and always static final.

To declare that a class implements an interface, use the implements keyword:

```java
class Employee implements Comparable<type>
public int compareTo(Object otherObject)
{
  Employee other = (Employee) otherObject;
  return Double.compare(slalry, other.salary);
}
//compareTo method is required to do sort
```

```java
package interfaces;
public class Employee implements Comparable<Employee>
{
//.......
	public int compareTo(Employee other)
	{
		return Double.compare(salary, other.salary);
	}
}
```

If there is a common algorithm for comparing subclass objects, simply provide a single compareTo method in the superclass and declared as final.

Why interfaces but not abstract class?

```java
//Since in java, there is no multiple ineritance. However, multiple interfaces is ok which is more flexible and more effective!!!
```

Default methods clash:

1. Superclass win
2. Interface clash. Java throws an exception.

You can never make a default method that redefines one of the methods in the Object class. For example, you can’t define a default method for toString or equals, even though that might be attractive for interfaces such as List. As a consequence of the “class wins” rule, such a method could never win against Object.toString or Objects.equals. 

### 6.1.8 Comparator:

Lets say we want to compare strings in terms of their length. Obviously we can not modify String class.

```java
class LengthComparator implements Comparator<String>
{
  public int compare(String first, String second)
  {
    return first.length() - second.length();
  }
}
//to actually do the comparison:
var comp = new LengthComparator();
if (comp.compare(words[i],words[j]) > 0) //.......
 //we need an instance to call this method since it is not static
-------------------------------
  //sort an array:
String[] friends = {"PatricStart","SpongeBob","SquidWard"};
Arrays.sort(friends,new LengthComparator);
```

### 6.1.9 Object Cloning:

The clone method is a protected method of Object. It is shallow copy by default.

```java
int [] arr = {1,2,3,4,5};
int [] new_arr = arr.clone();
new_arr[1] = 33333; //arr does not change
```

## 6.2 Lambda Expressions:

Use the above example of comparing strings:

```java
Comparator<String> comp = (first,second) -> first.length() - second.length();
```

We never specify the result type of a lambda expression. It is always referred from context.

### 6.2.3 Functional Interfaces:

An interface with a single abstract method is called functional interfaces. 

e.g.: Arrays.sort()

### 6.2.4 Method references:

:: operator is used instead of .

### 6.2.5 Constructor reference:

Constructor references are just like method references.

### 6.2.6:

change variable in a lambda expression is not safe. Every captured variable in a lambda expression must be final.

## 6.3: Inner class:

Reason for using Inner class:

1. Inner classes can be hidden from other classes in the samepackage
2. Inner classes methods can access the data from the scope in which they are defined

Static Inner class:

Inner classes that are not able to access the outer scope.

Inner classes declared inside an interface are automatically static and public

# Chapter 7: Exceptions, Assertions and logging

## 7.1: Dealing with errors:

```java
public FileInputStream(String name) throws FileNotFoundException
```

### 7.1.4 Creating Exception Class:

```java
class FileFormatException extends IOException
{
  public FileFormatException(){}
  public FileFormatException(String gripe)
  {
    super(gripe);
  }
}
```

## 7.2 Catching exceptions

```java
try
{
//......
}
catch (ExceptionType e)
{
//...
}
```

### 7.2.4 Finally:

1. no exceptions throw:  try block -> finally block
2. throws an exception and caught right: try block but up to the throwing point -> catch block -> finally, but if an exception happens during catch block, then exception is thrown back to the caller of this method.
3. The code throws an exception and not caught: try block(part of it) -> finally block

## 7.4 Assertions:

Two forms:

```java
assert condition;
assert condtion: expression;//the only purpose of expression is to generate a error message string
```

Both statements evaluate the condition and throw an AssertionError if it is false. In the second statement, the expression is passed to the constructor of the AssertionError object and turned into a message string. 

## 7.5 Logging

# Chapter 8: Generic Programming

## 8.2 Defining a Simple Generic Class

```java
public class pair<T>
{
  private T first;
  private T second;
  public pair(){first = null; second=null;}
  public pair(T first, T second){this.first = first; this.second = second;}
  //...and so on
}
//separate types is also fine
public class pair<T, U>
{
  //.......
}
```

## 8.3 Generic methods:

```java
class arrayalg
{
	public static <T> T get_Middle(T... a) //hint: array ...
  {
    return a[a.length/2];
  }
}
```

How to call????

```java
String middle = arrayalg.get_Middle("SpongeBob","PatricStar","SquidWord");
```

## 8.4 Bounds for Type Variables:

```java
public static <T extends Comparable> T min()....
//this is a restriction of T that T must be comparable.
```

## 8.5 Generic and virtual machine

JVM does not have generic types and here are the steps how JVM process it:

1. Type Erase: Each time a generic type is defined, a corresponding **raw** type is provided.
2. Translating Generic Expression: the complier inserts casts when the return type been erased
3. Translating Generic Methods: 
4. Calling legacy code: 

## 8.7.8 You can not throw or catch instances of a generic class

## 8.7 Inheritance rules for generic types:

# Chapter 9: Collections:

## 9.1 Interfaces:

### 9.1.3 Iterators:

The iterator has four methods:

```java
public interface Iterator<E>
{
    E next();
    boolean hasNext();
    void remove();
    default void forEachRemaining(Consumer<? super E> action);
}
```

The Collection interface extends the iterable interface. Therefore, you can use the "for each" loop for any collection with the standard library.

Instead of using a loop, we can call the forEachRemaining method with a lambda expression that consumes an element.

```java
iterator.forEachRemaububf(element -> do something);
```

```java
it.remove();
it.remove();//error
----------------------------
it.remove();
it.next();
it.remove();//OK
```

### 9.1.4 Generic Utility Methods

```java
public static <E> boolean contains(Collection<E> c, Object obj)
{
    for (E element:c)
        if(element.equals(obj))
            return true;
    return false;
}
```

Classes in the collections framework:

![figure.PNG](https://github.com/twodogs-wang/java/blob/master/core_java_volume_I/figures/figure.PNG)