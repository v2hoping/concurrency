package com.owl.BlockingQueue;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by houping wang on 2018/10/11
 *
 * @author houping wang
 */
public class IndexingExample {

    private static final String FILE_JPG_ENDS = "jpg";

    private static final String FILE_PNG_ENDS = "png";

    public static void main(String[] args) {
        File file = new File("/Users/wanghouping/Desktop");
        IndexingService indexingExample = new IndexingService(file, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(FILE_JPG_ENDS);
            }
        });
        indexingExample.start();
        try {
            indexingExample.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
