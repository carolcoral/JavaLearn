package com.xdl.servlet.web;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
@WebServlet("/checkCode.do")
public class CheckCode extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		// 图片的内存映像
		BufferedImage image = 
			new BufferedImage(60, 20,
				BufferedImage.TYPE_INT_RGB);
		// 获得画笔对象
		Graphics g = image.getGraphics();
		
		Random r = new Random();
		g.setColor(
				new Color(r.nextInt(255), 
						r.nextInt(255), 
						r.nextInt(255)));
		g.fillRect(0, 0, 60, 20);
		g.setColor(new Color(0,0,0));
		String number = String.valueOf(
				r.nextInt(99999)); 
		HttpSession session = request.getSession();
		session.setAttribute("number", number);
		g.drawString(number, 5, 15);
		g.setColor(
				new Color(r.nextInt(255), 
						r.nextInt(255), 
						r.nextInt(255)));
		g.drawLine(r.nextInt(60), r.nextInt(20), 
				r.nextInt(60), r.nextInt(20));
		// 压缩成jpeg格式
		OutputStream os = 
			response.getOutputStream();
		JPEGImageEncoder encoder = 
			JPEGCodec.createJPEGEncoder(os);
		// 把BufferedImage对象中的图像信息编码后
		// 向创建该对象(encoder)时指定的输出流输出
		encoder.encode(image);
		
	}

}
