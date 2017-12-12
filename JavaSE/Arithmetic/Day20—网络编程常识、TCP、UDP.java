今日内容：
	1.网络编程常识
	2.基于 TCP 协议的编程模型
	3.TCP 协议和 UDP 协议的比较
	4.基于 UDP 协议的编程模型

1.网络编程的常识（尽量记住）
	目前主流的网络通讯软件有：QQ、微信、YY、陌陌、飞信、飞秋、阿里旺旺、支付宝等
1.1 七层协议模型
	ISO(国际标准委员会组织)将数据的传递从逻辑上划分为以下七层：
		应用层、表示层、会话层、传输层、网络层、数据链路层、物理层
	当发送数据时需要按照上述七层协议从左向右一层层进行加包处理，然后发送出去；
	当接收到数据时需要按照上述七层协议从右向左一层层拆包，然后解析出来；

1.2 常用协议
	HTTP    — 超文本传输协议，用于浏览网页的场合
	FTP      — 文件传输协议，主要用于上传和下载文件的场合
	TCP      — 传输控制协议，主要用于网络通信的场合中
	UDP      — 用户数据报协议，主要用于网络童鞋的场合中
	IP         — 互联网协议，是上述协议的底层协议

	协议 — 本质上就是一种约定/规则，约束了双方通信的具体规则

1.3 IP 地址（重点）
	IP 地址 — 本质上就是在互联网中的唯一标识
	IP 地址本质上是由32位二进制组成的整数，叫做 IPV4，当然也有128位二进制组成的整数，叫做 IPV6，目前主流的还是 IPV4.
	日常生活中采用的是点分十进制表示法来进行 IP 地址的描述，也就是将每个字节的二进制转换为一个十进制整数，不同的十进制整数采用小数点分割。

1.4 端口号（重点）
	IP 地址 — 可以定位到具体的某一台设备
	端口号 — 可以定位到该设备中具体的某一个进程
	网络编程中需要提供：IP 地址+ 端口号

	端口号是由16位二进制组成的整数，范围是：0 ~ 65535，其中 0 ~ 1024 之间的端口通常由系统占用，因此编程从 1025 开始使用。

2. 基于 TCP 协议的编程模型（重点）
2.1 编程模型
服务器：
	（1）创建 ServerSocket 类型的对象，并提供端口号。
	（2）等待客户端的连接请求，使用 accept() 方法。
	（3）使用输入输出流进行通信。
	（4）关闭 Socket 并释放有关资源。
客户端：
	（1）创建 Socket 类型的对象，并提供服务器的 IP 地址和端口号。
	（2）使用输入输出流进行通信。
	（3）关闭 Socket 并释放有关资源。

2.2 相关类和方法的解析
（1）ServerSocket 类
	java.net.ServerSocket 类用于实现服务器的套接字（插座）。

	ServerSocket(int port) — 根据参数指定的端口创建对象并绑定。
	Socket accept() — 用于监听并等待客户端的连接请求。
	void close()

（2）Socket 类
	java.net.Socket 类用于实现客户端套接字，也就是两台机器通信的端点。

	Socket(String host, int port) — 根据参数指定 IP 和端口号构造对象。
	InputStream getInputStream() — 获取当前套接字的输入流并返回。
	OutputStream getOutputStream() — 获取当前套接字的输出流并返回。
	void close()

3. TCP 协议和 UDP 协议的比较（笔试题）
3.1 TCP 协议
	TCP — 传输控制协议，是一种面向连接的协议，类似打电话。
		 — 建立连接 => 进行通信 => 断开连接
		 — 在通信的整个过程中全程保持连接 
		 — 保证了数据传输的可靠性和有序性
		 — 是一种全双工的字节流通信方式
		 — 服务器资源消耗比较大，发送数据的效率相对比较低

3.2 UDP 协议
	UDP — 用户数据报协议，是一种非面向连接的协议，类似写信
		 — 在通信的过程中不需要保持连接
		 — 不保证数据传递的可靠性和有序性
		 — 是一种全双工的数据报通信方式
		 — 服务器资源消耗比较小，发送数据的效率相对比较高

4. 基于 UDP 协议的编程模型（重点）
4.1 编程模型
	主机 A（接收方）：
		（1）创建 DatagramSocket 类型的对象，并提供指定的端口号；
		（2）创建 DatagramPacket 类型的对象，负责接收数据；
		（3）接收数据，调用 receive() 方法；
		（4）关闭 Socket 并释放有关的资源；
	主机 B（发送方）：
		（1）创建 DatagramSocket 类型的对象；
		（2）创建 DatagramPacket 类型的对象，并提供接收方的 IP 地址和端口号；
		（3）发送数据，调用 send() 方法；
		（4）关闭 Socket 并释放有关资源；

4.2 相关类和方法的解析
（1）DatagramSocket 类
		java.net.DatagramSocket 类用于描述发送/接收数据报的套接字（码头）。
		DatagramSocket() — 构造对象绑定到任意可用端口；
		DatagramSocket(int port) — 构造对象绑定到参数指定的端口；
		void send(DatagramPacket p) — 将参数指定的数据报发送出去；
		void receive(DatagramPacket p) — 将接收到数据保存到参数指定的数据报中；
		void close()

（2）DatagramPacket 类
		DatagramPacket(byte[] buf , int length) — 用于接收数据并保存到 buf 数组中；
		DatagramPacket(byte[] buf , int length , InetAddress address , int port) — 用于将 buf 中的数据发送到 address 上的 port 端口处；
		InetAddress getAddress() — 用于获取发件人的 Address（IP）地址信息；
		int getPort() — 用于获取发件人的端口号信息；
		int getLength() — 用于获取数据的大小/长度；

（3）InetAddress 类
		java.net.InetAddress 类用于描述互联网协议地址信息。
		static InetAddress getLocalHost() — 用于获取本地主机的 IP 地址信息
		static InetAddress getByName(String host) — 用于获取指定主机的 IP 地址信息
		String getHostName() — 用于获取主机名并以字符串返回
		String getHostAddress() — 用于获取 IP 地址

