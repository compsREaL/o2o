package com.real.o2o.util;

/**
 * @author: mabin
 * @create: 2019/4/13 9:41
 */
public class PathUtil {

    private static String separator = System.getProperty("file.separator");

    //返回图片根路径
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")){
            basePath = "C:/project/image";
        } else {
            basePath = "/home/work/image";
        }
        basePath = basePath.replace("/",separator);
        return basePath;
    }

    //返回图片相对路径
    public static String getShopImagePath(long shopId){
        String imagePath = "/upload/item/shop/"+ shopId +"/";
        return imagePath.replace("/",separator);
    }
}
