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

![image-20200501182232765](/Users/zihaowang/Library/Application Support/typora-user-images/image-20200501182232765.png)

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

![image-20200428165314783](/Users/zihaowang/Desktop/github/java/core_java_volume_I/figures/image-20200428165314783.png)

![image-20200428165329089](/Users/zihaowang/Desktop/github/java/core_java_volume_I/figures/image-20200428165329089.png)

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

![image-20200428170028785](/Users/zihaowang/Desktop/github/java/core_java_volume_I/figures/image-20200428170028785.png)

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

