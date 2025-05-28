package io.nio;

import org.junit.Test;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class ChannelTest {
    @Test
    public void write() {
        try {
            // 1. 字节输出流通向目标文件
            FileOutputStream fos = new FileOutputStream("data01.txt");
            // 2. 得到字节输出流对应的通道 Channel
            FileChannel channel = fos.getChannel();
            // 3. 分配缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("hello nio".getBytes());
            // 4. 把缓冲区切换成读取模式
            buffer.flip();
            channel.write(buffer);
            channel.close();
            System.out.println("写数据到文件中.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void read() {
        try {
            // 1. 定义一个文件字节输入流与源文件连通
            FileInputStream fis = new FileInputStream("data01.txt");
            // 2. 需要得到文件字节输入流的文件通道
            FileChannel channel = fis.getChannel();
            // 3. 定义一个缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // 4. 读取数据到缓冲区
            channel.read(buffer);
            buffer.flip();
            String rs = new String(buffer.array(), 0, buffer.remaining());
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void copy() throws Exception{
        // 文件地址
        File srcFile = new File("data01.txt");
        File destFile = new File("data01Copy.txt");

        // 获取一个字节输入流
        FileInputStream fis = new FileInputStream(srcFile);
        // 获取一个字节输出流
        FileOutputStream fos = new FileOutputStream(destFile);
        // 获得文件的通道
        FileChannel isChannel = fis.getChannel();
        FileChannel osChannel = fos.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            // 必须现清空缓冲区，再写数据
            buffer.clear();
            // 开始读取一次数据
            int flag = isChannel.read(buffer);
            if (flag == -1) {
                break;
            }
            // 已经读取了数据，把缓冲区写模式切换到读模式
            buffer.flip();
            osChannel.write(buffer);
        }

        // 关闭通道
        isChannel.close();
        osChannel.close();
        System.out.println("复制完成");
    }

    @Test
    public void buffers() throws Exception {
        // 使用多个缓冲区，进行数据的读和写
        FileInputStream fis = new FileInputStream("data01.txt");
        FileChannel isChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream("data03.txt");
        FileChannel osChannel = fos.getChannel();

        ByteBuffer buffer1 = ByteBuffer.allocate(3);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);
        ByteBuffer[] buffers = {buffer1, buffer2};

        isChannel.read(buffers);
        for (ByteBuffer buffer : buffers) {
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, buffer.remaining()));
        }

        osChannel.write(buffers);
        isChannel.close();
        osChannel.close();
        System.out.println("文件复制完成。");
    }

    /**
     * 从目标通道中复制数据，到原通道中
     * @throws Exception
     */
    @Test
    public void transferFrom() throws Exception{
        // 1. 字节输入通道
        FileInputStream fis = new FileInputStream("data01.txt");
        FileChannel isChannel = fis.getChannel();
        // 2. 字节输出管道
        FileOutputStream fos = new FileOutputStream("data04.txt");
        FileChannel osChannel = fos.getChannel();
        // 3. 复制
        osChannel.transferFrom(isChannel, isChannel.position(), isChannel.size());
        isChannel.close();
        osChannel.close();
    }

    /**
     * 将原通道中的数据，复制到目标通道中
     * @throws Exception
     */
    @Test
    public void transferTo() throws Exception{
        // 1. 字节输入通道
        FileInputStream fis = new FileInputStream("data01.txt");
        FileChannel isChannel = fis.getChannel();
        // 2. 字节输出管道
        FileOutputStream fos = new FileOutputStream("data04.txt");
        FileChannel osChannel = fos.getChannel();
        // 3. 复制
        isChannel.transferTo(isChannel.position(), isChannel.size(), osChannel);
        isChannel.close();
        osChannel.close();
    }
}
