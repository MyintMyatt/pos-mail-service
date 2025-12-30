//package com.oroin.mail_service;
//
//import java.io.File;
//import java.net.http.HttpClient;
//
//public class ClientMultipartFormPost {
//
//
//    public static void main(String[] args) throws Exception {
//        if (args.length != 1) {
////System.out.println("File path not given");
////System.exit(1);
//        }
//        CloseableHttpClient httpclient = HttpClient.createDefault();
//        try {
//            HttpPost httppost = new HttpPost("http://192.168.0.105:5000/webapi/entry.cgi?api=SYNO.FileStation.Upload&method=upload&version=2");
//
//            httppost.addHeader("Cookie","id=eNfL.iMPUCwX.1780NNN555507");
//
//
//            FileBody fileBody = new FileBody(new File("C:\\Users\\libing\\Desktop\\1-160P4230Q1311.jpg"), ContentType.DEFAULT_BINARY, "1-160P4230Q1311.jpg");
//
//            HttpEntity reqEntity = MultipartEntityBuilder.create()
//                    .addPart("overwrite", new StringBody("false", ContentType.TEXT_PLAIN))
//                    .addPart("path", new StringBody("/video/v15/v124", ContentType.TEXT_PLAIN))
//                    .addPart("create_parents", new StringBody("true", ContentType.TEXT_PLAIN))
//                    .addPart("filename", fileBody)
//                    .setLaxMode()
//                    .build();
//
//            httppost.setEntity(reqEntity);
//
//            System.out.println("executing request " + httppost.getRequestLine());
//            CloseableHttpResponse response = httpclient.execute(httppost);
//            try {
//                System.out.println("----------------------------------------");
//                System.out.println(response.getStatusLine());
//                HttpEntity resEntity = response.getEntity();
//                if (resEntity != null) {
//                    System.out.println("Response content length: " + resEntity.getContentLength());
//                    System.out.println(EntityUtils.toString(resEntity));
//                }
//                EntityUtils.consume(resEntity);
//            } finally {
//                response.close();
//            }
//        } finally {
//            httpclient.close();
//        }
//    }
//}
