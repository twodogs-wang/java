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

#### Conversion between numeric types:

![image-20200428162843659](/Users/zihaowang/Library/Application Support/typora-user-images/image-20200428162843659.png)

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

![image-20200428165314783](/Users/zihaowang/Library/Application Support/typora-user-images/image-20200428165314783.png)

![image-20200428165329089](/Users/zihaowang/Library/Application Support/typora-user-images/image-20200428165329089.png)

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

![image-20200428170028785](/Users/zihaowang/Library/Application Support/typora-user-images/image-20200428170028785.png)

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
```

#### Input and output:

##### Reading Input:

```java
import java.util.*; //Scanner class is defined in this package
Scanner in = new Scanner(System.in);
System.out.print("Hi SpongeBob\n");
String name = in.nextLine(); //nextInt for single word
```



