package cn.dm.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class PrintUtil {
	//打印日志
	static Logger logger=Logger.getLogger(PrintUtil.class);

	public HttpServletResponse response;
	public PrintUtil(HttpServletResponse response, String contentType){
		this.response=response;
		this.response.setContentType(contentType);
	}
	public PrintUtil(HttpServletResponse response){
		this.response=response;
	}
	public void print(Object msg){
        PrintWriter writer=null;
		try {
            if(null != response){
				//如果系统打开了outputStream 那么将其关闭
                writer=new PrintWriter(response.getOutputStream());
				logger.info("PrintUtil>>>>>>>received>>>>>>>>>>"+msg);
				String temp=new String(String.valueOf(msg));
                writer.write(temp);
                writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
				writer.close();
		}
    }
}
