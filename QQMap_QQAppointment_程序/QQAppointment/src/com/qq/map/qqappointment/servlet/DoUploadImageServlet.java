/*
 * Copyright (c) 2011 by Daniel Zhang, all rights reserved.
 */

package com.qq.map.qqappointment.servlet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jspsmart.upload.SmartUpload;
import com.qq.map.qqappointment.util.JSON;
import com.qq.map.qqappointment.util.NameGenerater;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 *
 * @author 张广
 */
public class DoUploadImageServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String uploadType = request.getParameter("type");
        String width = request.getParameter("width");
        String height = request.getParameter("height");
        SmartUpload su = new SmartUpload();
        long maxFileSize = 524288;
        String ext = "";
        String url = "files/" + uploadType + "s/"; //应保证在根目录中有此目录的存在
        PrintWriter out = response.getWriter();//获得一个向客户端写东西的对象
        response.setContentType("text/html");//设置返回内容为文本html
        JSONObject json = new JSONObject();
        try {
            //初始化
            su.initialize(this.getServletConfig(), request, response);
            //只允许上载此类文件
            //su.setAllowedFilesList("jpg,gif,JPG,GIF");

            //上载文件
            su.upload();

            com.jspsmart.upload.File icon = su.getFiles().getFile(0);
            if (icon.isMissing()) {
                JSON.put(json, "error", "请先选择要上传的文件");
            } else {
                String iconName = icon.getFileName(); //取得上载的文件的文件名
                ext = icon.getFileExt(); //取得后缀名
                int fileSize = icon.getSize(); //取得文件的大小
                String saveUrl = request.getSession().getServletContext().getRealPath("/");
                if (fileSize < maxFileSize) {
                    //更改文件名，取得当前上传时间的毫秒数值
                    String filename = NameGenerater.generate(iconName, ext);
                    if (!(new java.io.File(saveUrl + url)).isDirectory()) {//如果指定目录不存在，创建该目录
                        (new java.io.File(saveUrl + url)).mkdirs();
                    }
                    url += filename;
                    saveUrl += url;
                    icon.saveAs(saveUrl, SmartUpload.SAVE_PHYSICAL);
                    //上传完成，开始生成缩略图
                    java.io.File file = new java.io.File(saveUrl); //读入刚才上传的文件
                    Image src = javax.imageio.ImageIO.read(file); //构造Image对象
                    int newWidth = width == null ? 50 : Integer.parseInt(width);
                    int newHeight = height == null ? 50 : Integer.parseInt(height);

                    BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);//创建一个BufferedImage来作为图像*作容器
                    Graphics g = image.getGraphics(); //创建一个绘图环境来进行绘制图象
                    g.drawImage(src, 0, 0, newWidth, newHeight, null); //将原图像数据流载入这个BufferedImage

                    FileOutputStream newImage = new FileOutputStream(file); //输出到文件流
                    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newImage);
                    encoder.encode(image); //近JPEG编码
                    newImage.close();
                    JSON.put(json, "msg", "/" + url);
                } else {
                    JSON.put(json, "error", "上传文件大小不能超过" + (maxFileSize / 1024) + "K");
                }
            }
        } catch (Exception e) {
            JSON.put(json, "error", e.getLocalizedMessage());
        } finally {
            out.println(json.toString());
            out.flush();//刷新out流的缓冲
            out.close();//关闭输出流
        }
    }
}
