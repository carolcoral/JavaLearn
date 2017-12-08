今日内容：
1.File 类
2.I/O 流
3.

1.File 类（重点）
1.1 基本概念
	java.io.File 类用于描述文件和目录的路径信息，可以获取文件的名称、大小等信息。

1.2常用方法
	File(String pathname) — 根据参数指定的路径信息来构造对象
	boolean exists() — 用于判断文件是否存在
	String getName() — 用于获取文件或目录的名称
	long length() — 用于获取文件的长度（大小）
	long lastModified() — 获取文件的最后一次修改的时间；
			— 返回距离标准时间的毫秒数，于 Date 类的有参构造方法搭配使用（Date(参数)）
	String getAbsolutePath() — 获取文件的绝对路径信息
			绝对路径：主要指以根目录开始的路径信息，如:  c:/  d:/
			相对路径：主要指以当前工作目录开始的路径信息，如：  ./  ../
			在以后的开发中相对路径是主流方式。
	boolean delete() — 用于删除文件或目录
	boolean createNewFile() — 用于创建新的空文件

	boolean mkdir() — 用于创建调用对象指定的目录
	boolean mkdirs() —— 用于创建多级目录

	File[]  listFiles[] — 用于获取当前目录下的所有内容并记录到数组中并返回
	boolean  isFile() — 判断是否为文件
	boolean  isDirectory() — 判断是否为目录

2.I/O 流
2.1 基本概念
	I/O 就是 Input/Output的简写，也就是输入/输出。
	I/O 流就是指在输入输出时像流水一样不间断进行的过程。

2.2 基本分类
	根据读写数据的单位不同分为：字节流 和 字符流。
	其中字节流就是指以字节为单位进行读写的流，可以读写任意文件。
	其中字符流就是指以字符（2个字节）为单位进行读写的流，只能读写文本文件。

	根据读写数据的方向不同分为：输入流  和  输出流（站在程序的角度）。
	其中输入流就是指将数据从文件中读出输入到程序中的流，就是读文件。
	其中输出流就是指将数据从程序中输出到文件中的流，也就是写文件。

2.3 基本框架
	字节流的顶层父类：InputStream 和 OutputStream  — 抽象类
	其中 InputStream 类的主要子类有：
		FileInputStream 类、DataInputStream 类（间接子类）、ObjectInputStream 类
	其中 OutputStream 类的主要子类有：
		FileOutputStream 类、DataOutputStream 类（间接子类）、ObjectOutputStream 类

	字符流的顶层父类：Reader 和  Writer  — 抽象类
	其中 Reader 类的主要子类有：
		BufferedReader 类、InputStreamReader 类、StringReader 类
	其中 Writer 类的主要子类有：
		BufferedWriter 类、OutputStreamWriter 类、StringWriter 类
补充：
	PrintStream 类是 OutputStream 类的间接子类。

2.4 FileOutputStream 类（重中之重）
（1）基本概念
	java.io.FileOutputStream 类用于将图像之类的字节数据写入到输出流中。
（2）常用方法：
	FileOutputStream(String name) — 根据参数指定的名称构造对象
	FileOutputStream(String name , boolean append) — 以追加的方式构造对象
	void write(int b) — 用于将参数 b 指定的单个字节数据写入输出流
	void write(byte[] b, int off, int len )
				— 用于将数组 b 中从 off 位置开始的 len 个字节写入到输出流
	void write(byte[] b) — 用于将整个数组的内容写入输出流
	void close() — 关闭流并释放资源

2.5 FileInputStream 类（重中之重）
（1） 基本概念
	java.io.FileInputStream 类用于从输入流中读取图像之类的原始字节流。
（2）常用方法
	FileInputStream(String name) — 根据参数指定的文件名构造对象
	int read() — 用于读取一个字节的数据并返回
	int read(byte[] b, int off, int len) — 用于获取 len 个字节放入数组 b 中 off 的位置
			— 该方法返回实际读取到的字节数，若读取到文件末尾则返回-1.
	int read(byte[] b) — 用于读满整个数组
	int available() — 获取该输入流对应文件的大小并返回


















