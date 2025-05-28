package io.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

public class BufferTest {
    @Test
    public void test01() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.position());  // 0
        System.out.println(buffer.limit());     // 10
        System.out.println(buffer.capacity());  // 10

        System.out.println("-----------------");
        // 缓冲去中添加数据
        String name = "jack";
        buffer.put(name.getBytes());
        System.out.println(buffer.position());  // 4
        System.out.println(buffer.limit());     // 10
        System.out.println(buffer.capacity());  // 10

        System.out.println("-----------------");
        // 转换为读模式，limit -> position, position -> 0
        buffer.flip();
        System.out.println(buffer.position());  // 0
        System.out.println(buffer.limit());     // 4
        System.out.println(buffer.capacity());  // 10

        System.out.println("-----------------");
        // 使用 get 进行数据的读取
        char ch = (char) buffer.get();
        System.out.println(ch);

        System.out.println(buffer.position());  // 1
        System.out.println(buffer.limit());     // 4
        System.out.println(buffer.capacity());  // 10
    }

    @Test
    public void test02() {

        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.position());  // 0
        System.out.println(buffer.limit());     // 10
        System.out.println(buffer.capacity());  // 10

        System.out.println("-----------------");
        // 缓冲去中添加数据
        String name = "jack";
        buffer.put(name.getBytes());
        System.out.println(buffer.position());  // 4
        System.out.println(buffer.limit());     // 10
        System.out.println(buffer.capacity());  // 10

        // clear 清除缓冲区中的数据
        System.out.println("-----------------");
        buffer.clear();
        System.out.println(buffer.position());  // 0
        System.out.println(buffer.limit());     // 10
        System.out.println(buffer.capacity());  // 10


        System.out.println("-----------------");
        // 定义一个新的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(10);
        String n = "rosejack";
        buf.put(n.getBytes());

        buf.flip();

        byte[] b = new byte[2];
        buf.get(b);
        String rs = new String(b);
        System.out.println(rs);

        System.out.println(buf.position());  // 2
        System.out.println(buf.limit());     // 8
        System.out.println(buf.capacity());  // 10

        System.out.println("-----------------");
        buf.mark();  // 标记当前位置
        byte[] b2 = new byte[3];
        buf.get(b2);
        System.out.println(new String(b2));
        System.out.println(buf.position());  // 5
        System.out.println(buf.limit());     // 8
        System.out.println(buf.capacity());  // 10

        buf.reset();  // 回到标记位
        if (buf.hasRemaining()) {
            System.out.println(buf.remaining());
        }
    }
}
