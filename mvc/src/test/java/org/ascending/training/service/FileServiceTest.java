package org.ascending.training.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.ascending.training.ApplicationBootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootstrap.class)
public class FileServiceTest {
//    @Autowired
//    FileService fileService;
//
//    @Autowired
//    private AmazonS3 s3Client;
//
//    @Mock
//    private File file;
//
//    @Test
//    public void uploadFileTest_happyPath() {
//        File file = new File("/file.txt");
//        fileService.uploadFile(file);
//        verify(s3Client, times(1)).putObject(any(PutObjectRequest.class));
//    }
//
//    @Test
//    public void uploadFileTest_fileIsNull() {
//
//
//    }
}
