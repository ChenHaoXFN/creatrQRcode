package com.create.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
/**
 * Created by ch on 2017-12-06
 */
public class CreateQRcode {

  public static void main(String[] args) {
    //图片大小.
    int width = 300;
    int height = 300;
    //图片格式.
    String format = "png";
    //想输出的内容.
    String content = "你好，张金！";

    //定义二维码的参数.
    HashMap hints = new HashMap();
    //设置中文.
    hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
    //设置纠错等级，H最高 但是存储内容最少.
    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
    //设置边距.
    hints.put(EncodeHintType.MARGIN, 2);

    try {
      BitMatrix bitMatrix = new MultiFormatWriter()
          .encode(content, BarcodeFormat.QR_CODE, width, height, hints);
      //文件位置，目录不存在会抛出异常.
      Path file = new File("/home/ch/公共的/img.png").toPath();
      MatrixToImageWriter.writeToPath(bitMatrix, format, file);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
