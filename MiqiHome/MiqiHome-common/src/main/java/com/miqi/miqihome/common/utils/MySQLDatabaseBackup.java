package com.miqi.miqihome.common.utils;

import java.io.*;

/**
 * MySQL数据库备份
 *
 * @author GaoHuanjie
 */
public class MySQLDatabaseBackup {
    /**
     * Java代码实现MySQL数据库导出
     *
     * @author GaoHuanjie
     * @param hostIP MySQL数据库所在服务器地址IP
     * @param userName 进入数据库所需要的用户名
     * @param userName 进入数据库所需要的用户名
     * @param password 进入数据库所需要的密码
     * @param savePath 数据库导出文件保存路径
     * @param fileName 数据库导出文件文件名
     * @param databaseName 要导出的数据库名
     * @return 返回true表示导出成功，否则返回false。
     */
    public static boolean backup(String hostIP, String userName, String password, String savePath, String fileName, String databaseName) throws InterruptedException {
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if(!savePath.endsWith(File.separator)){
            savePath = savePath + File.separator;
        }

        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), "utf8"));
            Process process = Runtime.getRuntime().exec(" mysqldump -h" + hostIP + " -u" + userName + " -p" + password + " --set-charset=UTF8 " + databaseName);
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while((line = bufferedReader.readLine())!= null){
                printWriter.println(line);
            }
            printWriter.flush();
            if(process.waitFor() == 0){//0 表示线程正常终止。
                return true;
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void main(String[] args){
       try {
            if (backup("127.0.0.1", "root", "caoyu3520563253", "D:\\mysqlBackup", "test10.sql", "homedb")) {
                System.out.println("数据库成功备份！！！");
            } else {
                System.out.println("数据库备份失败！！！");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*try {
            recover("E:\\mysqlBackup\\test10.sql");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    /*
    * 還原
    * */
    public static void recover(String path) throws IOException{
        Runtime runtime = Runtime.getRuntime();
        //-u后面是用户名，-p是密码-p后面最好不要有空格，-family是数据库的名字，--default-character-set=utf8，这句话一定的加
        //我就是因为这句话没加导致程序运行成功，但是数据库里面的内容还是以前的内容，最好写上完成的sql放到cmd中一运行才知道报错了
        //错误信息：
        //mysql: Character set 'utf-8' is not a compiled character set and is not specified in the '
        //C:\Program Files\MySQL\MySQL Server 5.5\share\charsets\Index.xml' file ERROR 2019 (HY000): Can't
        // initialize character set utf-8 (path: C:\Program Files\MySQL\MySQL Server 5.5\share\charsets\)，
        //又是讨人厌的编码问题，在恢复的时候设置一下默认的编码就可以了。
        Process process = runtime.exec("mysql -u root -pcaoyu3520563253 --default-character-set=utf8 CakeDB1");
        OutputStream outputStream = process.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String str = null;
        StringBuffer sb = new StringBuffer();
        while((str = br.readLine()) != null){
            sb.append(str+"\r\n");
        }
        str = sb.toString();
        System.out.println(str);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream,"utf-8");
        writer.write(str);
        writer.flush();
        outputStream.close();
        br.close();
        writer.close();
    }
}