package demoHDFSReader;

import java.io.*;
import java.util.*;
import java.net.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;

public class CatFile {

	public String viewCatHDFS(){
		StringBuilder sb = new StringBuilder();
		
		try{
	        //Path pt = new Path("hdfs://192.168.10.90:8020/user/inov/results/part-00000");
			Path pt = new Path("/user/inov/results/part-00000");
	        Configuration conf = new Configuration();
	        conf.set("fs.default.name", "hdfs://192.168.10.90:8020");
	        FileSystem fs = FileSystem.get(conf);
	        
	        BufferedReader br=new BufferedReader(new InputStreamReader(fs.open(pt)));
	        String line;
	        line=br.readLine();
	        while (line != null){
	                //System.out.println(line);
	                line=br.readLine();
	                sb.append(line + "\n");
	        }
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CatFile cf = new CatFile();
		String szblock = cf.viewCatHDFS();
		String[] sb1 = szblock.split("\n");
		String[] sb2 = null;
		
		System.out.println("Results: <br/>");
		//System.out.println(cf.viewCatHDFS());
		System.out.println(szblock);
		System.out.println("");
		for(String s:sb1){
			System.out.println("String: " + s);
			sb2 = s.split(",");
			for(String s1:sb2){
				System.out.println("Split String: " + s1);
			}
		}
		
	}

}
