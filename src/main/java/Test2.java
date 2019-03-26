import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Test2 {
    public static void main(String[] args) throws Exception {
        //成功，但不断开连接
//        getInfoBySocket();
//        System.out.println("ok");
//        System.out.println(Integer.toBinaryString(-1));
        System.out.println( System.getProperty("user.dir"));
        FileInputStream fileInputStream=new FileInputStream("test.txt");
    //默认在user.dir 目录下 即当前项目路径下
        InputStreamReader reader=new InputStreamReader(new FileInputStream("test.txt"),"utf-8");
        int len=0;
       while( (len=reader.read()) != -1){
           System.out.print((char)len);
       }

       //使用PrintWriter 输出文本
        PrintWriter out=new PrintWriter(new FileOutputStream("test2.txt"),true);
       out.print("chiana");
       //行分隔符
       out.print(System.getProperty("line.separator"));
       out.print("你好啊");
       out.println("wn 随");
//        out.flush();
        System.out.println("---"+System.getProperty("line.separator"));

        String content=new String(Files.readAllBytes(Paths.get("test3.txt")),"utf-8");
        System.out.println("content: "+content);
       List<String> lines= Files.readAllLines(Paths.get("test3.txt"));
       for(String str:lines){
           System.out.print(lines);
       }


    }


    /**
     * 通过Socket访问
     * @throws Exception
     */
    public static void getInfoBySocket() throws Exception{
        Socket socket = new Socket("proxy7.bj.petrochina", 8080);//这里若是要代理就设置，若无，可以不传参数
        socket.setSoTimeout(5000);//设置读操作超时时间5s,防止长连接
        socket.getOutputStream().write(new String("GET https://www.baidu.com HTTP/1.1\r\n\r\n").getBytes());
        InputStream is = socket.getInputStream();
        //设置UTF-8，防止乱码，但是这种方式，个别中文还是会乱码
        /*
        byte[] bs = new byte[1024];
		int i;
		StringBuilder str = new StringBuilder();
		while ((i = is.read(bs)) > 0) {
		    System.out.println(new String(bs, 0, i,"utf-8"));
			//str.append(new String(bs,0,1,"utf-8"));
		}
        */
        //解决乱码和个别中文乱码
        StringBuilder str = new StringBuilder("");
        InputStreamReader isr = new InputStreamReader(is,"UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        while ((line = br.readLine()) != null) {
            str.append(line + "\n");
            //这里必须自行判断跳出，因为socket是不会断开访问的
            if(line.contains("</html>")){
                break;
            }
        }
        br.close();
        isr.close();
        is.close();
    }


}
