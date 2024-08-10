package org.ascending.training.service;


import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.ascending.training.ApplicationBootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootstrap.class)
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;
    @Autowired
    private AmazonSQS sqs;
    @Mock
    private GetQueueUrlResult getQueueUrlResult;

    @Test
    public void sendMessageTest() {
        // prepare required attribute/values/stubs
        when(sqs.getQueueUrl(anyString())).thenReturn(getQueueUrlResult);

        // call the test function
        messageService.sendMessage("abc", "123", 1);

        // check the test is right. meet expectation <assert, verify>
        verify(sqs, times(1)).sendMessage(any(SendMessageRequest.class));
    }
}
